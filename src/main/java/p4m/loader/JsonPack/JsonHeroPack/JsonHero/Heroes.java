package p4m.loader.JsonPack.JsonHeroPack.JsonHero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import p4m.loader.D2Tables.D2Hero;

/**
 * Created by soart on 30.03.2015.
 */
public class Heroes
{
    public D2Hero toD2Hero()
    {
        D2Hero d2h = new D2Hero(this.id, this.localized_name, this.name);
        return d2h;
    }

    private int id;

    private String localized_name;

    private String name;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getLocalized_name ()
    {
        return localized_name;
    }

    public void setLocalized_name (String localized_name)
    {
        this.localized_name = localized_name;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", localized_name = "+localized_name+", name = "+name+"]";
    }
}
