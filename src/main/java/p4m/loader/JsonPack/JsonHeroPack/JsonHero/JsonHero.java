package p4m.loader.JsonPack.JsonHeroPack.JsonHero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 30.03.2015.
 */
public class JsonHero {
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
