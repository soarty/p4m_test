package p4m.loader.WebDAO;

import p4m.loader.JsonPack.JsonHeroPack.JsonHero.Heroes;
import p4m.loader.JsonPack.JsonHeroPack.JsonHero.JsonHero;
import p4m.loader.JsonPack.JsonHeroPack.JsonHero.Result;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by soart on 08.04.2015.
 */
public class WebHeroDAO extends WebDAO {
    @Override
    protected URL getURL() throws MalformedURLException {
        String url = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key="+key+"&language=en_us";
        URL webObject = new URL(url);
        return webObject;
    }

    @Override
    public Heroes[] getJsonTargetObject() throws IOException {
        Result res = getJsonFullStructure(JsonHero.class).getResult();
        return res.getHeroes();
    }

    @Override
    protected Object[] getJsonTargetObject(String account_id) throws IOException {
        return new Object[0];
    }
}
