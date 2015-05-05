package p4m.loader.ManagerDAO;

import p4m.loader.D2Tables.D2Match;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatch.Matches;
import p4m.loader.WebDAO.WebMatchDAO;

import java.util.List;

/**
 * Created by soart on 09.04.2015.
 */
public class ManagerMatchDAO extends ManagerDAO {
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
            d2m[i] = jsonher.toD2Match();
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
