package p4m.loader.ManagerDAO;

/**
 * Created by soart on 21.04.2015.
 */
public class ManagerUserDailyDAO extends ManagerDAO {
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
        return "from D2UserDaily tt where tt.account_id = '"+super.object_id+"'";
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
