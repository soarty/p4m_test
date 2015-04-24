package p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 14.04.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonMatchDetail
{
    private Result result;

    public Result getResult ()
    {
        return result;
    }

    public void setResult (Result result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+"]";
    }
}
