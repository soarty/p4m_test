package p4m.loader.ManagerDAO;

import p4m.loader.D2Tables.D2StatsDaily;
import p4m.loader.D2Tables.D2StatsTournament;
import p4m.loader.D2Tables.D2User;
import p4m.loader.D2Tables.D2UserDaily;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail.Players;
import p4m.loader.WebDAO.WebMatchDetailDAO;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by soart on 16.04.2015.
 */
public class ManagerStatsDailyDAO extends ManagerDAO {

    public Date startDate;

    @Override
    public void saveOrUpdateArray(Object[] array) throws Exception {
        super.object_id = (String)array[0];
        startDate = (Date)array[1];
        saveOrUpdateArray();
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

        D2StatsDaily[] d2StatsDaily = new D2StatsDaily[objarr.length];
        int i = 0;
        System.out.println(super.object_id);
        for (Players players: (Players[])objarr)
        {
            String queryString = "from D2UserDaily where account_id = '"+players.getAccount_id()
                    +"' AND registerOn < '"+startDate
                    +"' AND tournament_id is not null";
            ManagerUserDailyDAO userDaily = new ManagerUserDailyDAO();
            List<D2UserDaily> uList = userDaily.getQuerySQL(queryString, D2UserDaily.class);
            if(uList.size()>0 && players.getLeaver_status().equals("0")) {
                d2StatsDaily[i] = players.toD2StatsDaily();
                d2StatsDaily[i].setStart_date_match(startDate);
                d2StatsDaily[i].setMatch_id(super.object_id);

                for(D2UserDaily d2u:uList)
                {
                    createStatsTournament(d2StatsDaily[i].getId(), d2u.getTournament_id());
                }
                i++;
            }
            else
            {
                if(!players.getAccount_id().toString().equals("4294967295")) {
                    createUser(players.getAccount_id());
                    createUserDaily(players.getAccount_id());
                }
            }
            userDaily = null;
            System.gc();
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
        ManagerUserDailyDAO userDaily = new ManagerUserDailyDAO();
        int uCount = userDaily.getQueryList(acc_id).size();
        userDaily = null;
        System.gc();
        if(uCount==0) {
            return false;
        }
        else {
            return true;
        }
    }

    private void createUser(String account_id)
    {
        long Steam_Id = Long.parseLong(account_id) + Long.parseLong("76561197960265728");
        D2User d2User = new D2User();
        d2User.setAccount_id(account_id);
        d2User.SetSteamId(String.valueOf(Steam_Id));
        d2User.SetName(account_id);

        ManagerUserDAO managerUserDAO = new ManagerUserDAO();
        managerUserDAO.saveOrUpdate(d2User);
        managerUserDAO = null;
        System.gc();
    }

    private void createUserDaily(String account_id)
    {
        D2UserDaily d2UserDaily = new D2UserDaily();
        d2UserDaily.setAccount_id(account_id);
        d2UserDaily.setTournament_id(1);
        d2UserDaily.setRegisterOn(new Date());

        ManagerUserDailyDAO managerUserDailyDAO = new ManagerUserDailyDAO();
        managerUserDailyDAO.saveOrUpdate(d2UserDaily);
        managerUserDailyDAO = null;
        System.gc();
    }

    private void createStatsTournament(String stats_id, int tournament_id)
    {
        D2StatsTournament d2StatsTournament = new D2StatsTournament();
        d2StatsTournament.setStats_id(stats_id);
        d2StatsTournament.setTournament_id(tournament_id);

        ManagerStatsTournamentDAO managerSTDAO = new ManagerStatsTournamentDAO();
        managerSTDAO.saveOrUpdate(d2StatsTournament);
        System.out.println(d2StatsTournament.getId());
        managerSTDAO = null;
        System.gc();
    }
}
