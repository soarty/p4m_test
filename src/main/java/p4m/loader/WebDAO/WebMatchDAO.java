package p4m.loader.WebDAO;

import p4m.loader.JsonPack.JsonHeroPack.JsonHero.JsonHero;
import p4m.loader.JsonPack.JsonHeroPack.JsonHero.Result;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatch.JsonMatch;
import p4m.loader.JsonPack.JsonHeroPack.JsonMatch.Matches;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by soart on 09.04.2015.
 */
public class WebMatchDAO extends WebDAO {
    @Override
    protected URL getURL() throws MalformedURLException {
        String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?key="+key+"&account_id="+super.obj_id+"&min_players=10";
        URL webObject = new URL(url);
        return webObject;

    }

    @Override
    protected Object[] getJsonTargetObject() throws IOException {
        return new Object[0];
    }

    @Override
    public Matches[] getJsonTargetObject(String object_id) throws IOException, ServiceUnavailableException {
        super.obj_id = object_id;
        p4m.loader.JsonPack.JsonHeroPack.JsonMatch.Result res = getJsonFullStructure(JsonMatch.class).getResult();
        if(res.getStatus().equals("1")) {
            return res.getMatches();
        }
        else if (res.getStatus().equals("15")) {
            System.err.println("Cannot get match history for a user that hasn't allowed it. For SteamId = '"+object_id+"'");
            return null;
        }
        return null;
    }
}
