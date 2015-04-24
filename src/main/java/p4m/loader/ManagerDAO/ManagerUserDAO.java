package p4m.loader.ManagerDAO;

/**
 * Created by soart on 08.04.2015.
 */
public class ManagerUserDAO extends ManagerDAO {
    @Override
    protected String getSQLQuery() {
        return "from D2User";
    }

    @Override
    protected Object[] JsonToDBObject(Object[] objarr) {
        return new Object[0];
    }

    @Override
    protected Object[] getWeb() throws Exception {
        return new Object[0];
    }
}
