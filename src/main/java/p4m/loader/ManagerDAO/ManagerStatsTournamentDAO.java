package p4m.loader.ManagerDAO;

/**
 * Created by soart on 15.05.2015.
 */
public class ManagerStatsTournamentDAO extends ManagerDAO {
    @Override
    protected void saveOrUpdateArray(Object[] array) throws Exception {

    }

    @Override
    protected String getSQLQueryByCondition(String cond) {
        return null;
    }

    @Override
    protected boolean isReadOnly(Object obj) {
        return false;
    }

    @Override
    protected String getSQLQuery() {
        return null;
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
