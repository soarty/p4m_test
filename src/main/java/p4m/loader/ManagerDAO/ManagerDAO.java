package p4m.loader.ManagerDAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import p4m.loader.D2Tables.*;

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
        cfg.setProperty("hibernate.connection.url",System.getenv("p4m.url"));
        cfg.setProperty("hibernate.connection.password",System.getenv("p4m.password"));
        cfg.setProperty("hibernate.connection.username",System.getenv("p4m.username"));
        factory = cfg.configure().buildSessionFactory();
    }
    private Session Sess;
    protected String object_id = "";
    Transaction tr;

    /*public ManagerDAO()
    {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(D2Hero.class);
        cfg.addAnnotatedClass(D2User.class);
        cfg.addAnnotatedClass(D2Match.class);
        cfg.addAnnotatedClass(D2StatsDaily.class);
        cfg.addAnnotatedClass(D2UserDaily.class);
        factory = cfg.configure().buildSessionFactory();
    }*/

    public void saveOrUpdate(Object obj) {
        Sess = factory.openSession();
        tr = Sess.beginTransaction();
        Sess.merge(obj);
        tr.commit();
        Sess.flush();
        Sess.close();
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
                System.err.println("saveOrUpdate не вызван так как obj = null");
        }

    }

    public void saveOrUpdateArray(String obj_id) throws Exception {
        this.object_id = obj_id;
        saveOrUpdateArray();
    }

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

    protected abstract String getSQLQuery();

    protected abstract Object[] JsonToDBObject(Object[] objarr);

    protected abstract Object[] getWeb() throws Exception;
}
