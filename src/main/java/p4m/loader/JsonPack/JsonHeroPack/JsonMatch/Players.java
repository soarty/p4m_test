package p4m.loader.JsonPack.JsonHeroPack.JsonMatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 09.04.2015.
 */
public class Players
{
    private String player_slot;

    private String account_id;

    private String hero_id;

    public String getPlayer_slot ()
    {
        return player_slot;
    }

    public void setPlayer_slot (String player_slot)
    {
        this.player_slot = player_slot;
    }

    public String getAccount_id ()
    {
        return account_id;
    }

    public void setAccount_id (String account_id)
    {
        this.account_id = account_id;
    }

    public String getHero_id ()
    {
        return hero_id;
    }

    public void setHero_id (String hero_id)
    {
        this.hero_id = hero_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [player_slot = "+player_slot+", object_id = "+account_id+", hero_id = "+hero_id+"]";
    }
}
