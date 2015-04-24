package p4m.loader.JsonPack.JsonHeroPack.JsonHero;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 30.03.2015.
 */
public class Result
{
    private Heroes[] heroes;

    private String count;

    private String status;

    public Heroes[] getHeroes ()
    {
        return heroes;
    }

    public void setHeroes (Heroes[] heroes)
    {
        this.heroes = heroes;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [heroes = "+heroes+", count = "+count+", status = "+status+"]";
    }
}
