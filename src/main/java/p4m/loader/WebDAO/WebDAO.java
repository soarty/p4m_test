package p4m.loader.WebDAO;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by soart on 08.04.2015.
 */
public abstract class WebDAO {
    protected String obj_id = "";
    protected String key = "691ECE9B5791CB26E7BBDDB192E5EB99";

    protected abstract URL getURL() throws MalformedURLException;

    protected InputStream getInputStream(URL inUrl) throws IOException {
        HttpURLConnection con = (HttpURLConnection) inUrl.openConnection();
        con.setRequestMethod("GET");
        try {
            return con.getInputStream();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            if(ex.getMessage().contains("Server returned HTTP response code: 503 for URL")) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getInputStream(inUrl);
            }
            else
                throw new IOException(ex);
        }
    }

    protected  <T extends Object> T getJsonFullStructure(Class<T> clazz) throws IOException{
        ObjectMapper objMap = new ObjectMapper();
        return (T) objMap.readValue(getInputStream(getURL()), clazz);
    }

    protected abstract Object[] getJsonTargetObject() throws IOException;
    protected abstract Object[] getJsonTargetObject(String object_id) throws IOException, ServiceUnavailableException;
}
