package p4m.loader.ManagerDAO;

import p4m.loader.D2Tables.D2Match;
import p4m.loader.D2Tables.D2UserDaily;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatch.Matches;
import p4m.loader.WebDAO.WebMatchDAO;

import java.util.Date;
import java.util.List;

/**
 * Created by soart on 09.04.2015.
 */
public class ManagerMatchDAO extends ManagerDAO {
    @Override
    protected void saveOrUpdateArray(Object[] array) throws Exception {

    }

    @Override
    protected String getSQLQueryByCondition(String cond) {
        return "from D2Match "+cond;
    }

    @Override
    protected boolean isReadOnly(Object obj) {
        D2Match match = (D2Match)obj;
        ManagerMatchDAO matchDAO = new ManagerMatchDAO();
        List<Object> list = matchDAO.getObjectByCondition("where match_id = '"+match.GetMatchId()+"'");
        if (list.size()==0)
            return false;
        D2Match selectedMatch = (D2Match)list.get(0);
        if(selectedMatch.GetLoaded().equals("Y"))
            return true;
        return false;
    }

    @Override
    protected String getSQLQuery() {
        return "from D2Match where loaded <> 'Y'";
    }

    @Override
    protected D2Match[] JsonToDBObject(Object[] objarr)
    {
        D2Match[] d2m = new D2Match[objarr.length];
        int i = 0;
        for(Matches jsonher: (Matches[])objarr)
        {
            ManagerUserDailyDAO managerUserDailyDAO = new ManagerUserDailyDAO();
            List<D2UserDaily> udlist = managerUserDailyDAO.getQuerySQL("from D2UserDaily where user.steam_id = '" + super.object_id + "' order by registerOn", D2UserDaily.class);
            Date regDate = udlist.get(0).getRegisterOn();
            Date matchDate = new Date(Long.parseLong(jsonher.getStart_time())*1000);
            managerUserDailyDAO = null;
            System.gc();
            if(jsonher.getLobby_type() == 7 && matchDate.after(regDate)) {
                d2m[i] = jsonher.toD2Match();
            }
            i++;
        }
        return d2m;
    }

    @Override
    protected Object[] getWeb() throws Exception, NullPointerException {
        WebMatchDAO webDao = new WebMatchDAO();
        return webDao.getJsonTargetObject(super.object_id);
    }
}
