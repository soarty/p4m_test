package p4m.loader.JsonPack.JsonHeroPack.JsonMatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 09.04.2015.
 */
public class JsonMatch
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