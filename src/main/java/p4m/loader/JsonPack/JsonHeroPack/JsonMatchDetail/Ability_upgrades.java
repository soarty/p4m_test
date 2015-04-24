package p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 14.04.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability_upgrades
{
    private String time;

    private String level;

    private String ability;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }

    public String getAbility ()
    {
        return ability;
    }

    public void setAbility (String ability)
    {
        this.ability = ability;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [time = "+time+", level = "+level+", ability = "+ability+"]";
    }
}
