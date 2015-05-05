package p4m.loader.ManagerDAO;

import p4m.loader.D2Tables.D2StatsDaily;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail.Players;
import p4m.loader.WebDAO.WebMatchDetailDAO;

/**
 * Created by soart on 16.04.2015.
 */
public class ManagerStatsDailyDAO extends ManagerDAO {
    ManagerUserDailyDAO userDaily = new ManagerUserDailyDAO();

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
        D2StatsDaily[] d2StatsDaily = new D2StatsDaily[objarr.length];
        int i = 0;
        for (Players players: (Players[])objarr)
        {
            if(isUserRegistered(players.getAccount_id())) {
                d2StatsDaily[i] = players.toD2StatsDaily();
                d2StatsDaily[i].setMatch_id(super.object_id);
                i++;
            }
        }
        return d2StatsDaily;
    }

    @Override
    protected Object[] getWeb() throws Exception {
        WebMatchDetailDAO web = new WebMatchDetailDAO();
        return web.getJsonTargetObject(super.object_id);
    }

    private Boolean isUserRegistered(String acc_id)
    {
        int uCount = userDaily.getQueryList(acc_id).size();
        if(uCount==0) {
            return false;
        }
        else {
            return true;
        }
    }
}
