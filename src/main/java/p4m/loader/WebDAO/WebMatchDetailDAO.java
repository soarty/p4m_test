package p4m.loader.WebDAO;

import p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail.*;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by soart on 14.04.2015.
 */
public class WebMatchDetailDAO extends WebDAO {
    @Override
    protected URL getURL() throws MalformedURLException {
        String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?key="+key+"&match_id="+super.obj_id;
        URL webObject = new URL(url);
        return webObject;
    }

    @Override
    protected Object[] getJsonTargetObject() throws IOException {
        return new Object[0];
    }

    @Override
    public Object[] getJsonTargetObject(String object_id) throws IOException, ServiceUnavailableException {
        super.obj_id = object_id;
        Result res = getJsonFullStructure(JsonMatchDetail.class).getResult();
        return res.getPlayers();
    }

    private void clearObjects(Players[] AllPlayers)
    {
        for (Players player:AllPlayers)
        {

        }
    }
}
