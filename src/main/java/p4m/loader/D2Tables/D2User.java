package p4m.loader.D2Tables;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by soart on 08.04.2015.
 */
@Entity
@Table(name = "d2_users")
public class D2User implements Serializable{
    @Id
    @Column(name = "account_id")
    private String account_id;

    @Column(name = "steam_id")
    private String steam_id;

    @Column(name = "steam_name")
    private String steam_name;

    public D2User(String st_id, String st_name)
    {
        this.steam_id = st_id;
        this.steam_name = st_name;
    }
    public D2User()
    {}
    public void SetSteamId(String Id)
    {
        this.steam_id = Id;
    }
    public String GetName()
    {
        return this.steam_name;
    }

    public void SetName(String name)
    {
        this.steam_name = name;
    }
    public String GetSteamId()
    {
        return this.steam_id;
    }

    public void setAccount_id(String acc_id)
    {
        this.account_id = acc_id;
    }
    public String getAccount_id()
    {
        return this.account_id;
    }
}
