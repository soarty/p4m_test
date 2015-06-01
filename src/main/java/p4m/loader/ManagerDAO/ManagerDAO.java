package p4m.loader.ManagerDAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.*;
import p4m.loader.D2Tables.*;

import java.lang.Object;
import java.util.List;

/**
 * Created by soart on 07.04.2015.
 */
public abstract class ManagerDAO {
    private static final SessionFactory factory;
    static
    {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(D2Hero.class);
        cfg.addAnnotatedClass(D2User.class);
        cfg.addAnnotatedClass(D2Match.class);
        cfg.addAnnotatedClass(D2StatsDaily.class);
        cfg.addAnnotatedClass(D2UserDaily.class);
        cfg.addAnnotatedClass(D2StatsTournament.class);
        cfg.setProperty("hibernate.connection.url", System.getenv("p4m.url"));
        cfg.setProperty("hibernate.connection.password",System.getenv("p4m.password"));
        cfg.setProperty("hibernate.connection.username",System.getenv("p4m.username"));
        factory = cfg.configure().buildSessionFactory();
    }
    private Session Sess;
    protected String object_id = "";
    Transaction tr;

    public void saveOrUpdate(Object obj) {
        if (!isReadOnly(obj)) {
            Sess = factory.openSession();
            tr = Sess.beginTransaction();
            Sess.merge(obj);
            tr.commit();
            Sess.flush();
            Sess.close();
        }
        else
            System.err.println("Is Private: "+ obj.toString());
    }

    public void saveOrUpdateArray() throws Exception {
        Object[] objWeb = new Object[0];
        try {
            objWeb = JsonToDBObject(getWeb());
        }
        catch (NullPointerException ex)
        {
            System.err.println("Не удалось получить JsonObject");
            ex.printStackTrace();
            return;
        }
        for (Object obj : objWeb) {
            if (obj != null) {
                saveOrUpdate(obj);
            }
            else
                System.err.println("saveOrUpdate не вызван. Web запрос не вернул объектов, obj = null. Для класса = "+this.getClass());
        }

    }

    public void saveOrUpdateArray(String obj_id) throws Exception {
        this.object_id = obj_id;
        saveOrUpdateArray();
    }

    protected abstract void saveOrUpdateArray(Object[] array) throws Exception;

    public java.util.List<Object> getQueryList()
    {
        Sess = factory.openSession();
        Query query = Sess.createQuery(getSQLQuery());
        java.util.List<Object> list = query.list();
        Sess.close();
        return list;
    }
    public List<Object> getQueryList(String obj_id)
    {
        this.object_id = obj_id;
        return  getQueryList();
    }

    public List<Object> getObjectByCondition(String whereCondition)
    {
        Sess = factory.openSession();
        Query query = Sess.createQuery(getSQLQueryByCondition(whereCondition));
        List<Object> list = query.list();
        Sess.close();
        return list;
    }

    public <T> List<T> getQuerySQL(String queryString, Class<T> inClass)
    {
        Sess = factory.openSession();
        Query query = Sess.createQuery(queryString);
        List<T> list = query.list();
        Sess.close();
        return list;
    }

    public void closeFactory()
    {
        factory.close();
    }
    protected abstract String getSQLQueryByCondition(String cond);

    protected abstract  boolean isReadOnly(Object obj);

    protected abstract String getSQLQuery();

    protected abstract Object[] JsonToDBObject(Object[] objarr);

    protected abstract Object[] getWeb() throws Exception;
}

