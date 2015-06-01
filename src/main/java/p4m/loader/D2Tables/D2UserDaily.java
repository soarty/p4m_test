package p4m.loader.D2Tables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by soart on 21.04.2015.
 */
@Entity
@Table(name = "d2_users_daily")
public class D2UserDaily{
    @Id
    @Column(name = "account_id")
    private String account_id;

    @Column(name = "registerOn")
    private Date registerOn;

    @Column(name = "tournament_id")
    private int tournament_id;

    public void setAccount_id(String inSteamId)
    {
        this.account_id = inSteamId;
    }

    public String getAccount_id()
    {
        return this.account_id;
    }

    public void setRegisterOn(Date dt)
    {
        this.registerOn = dt;
    }
    public Date getRegisterOn()
    {
        return this.registerOn;
    }

    public void setTournament_id(int tor)
    {
        this.tournament_id = tor;
    }
    public int getTournament_id()
    {
        return this.tournament_id;
    }

    @OneToOne()
    @JoinColumn(name="account_id")
    private D2User user;
    public void setUser(D2User inUser)
    {
        this.user = inUser;
    }
    public D2User getUser()
    {
        return this.user;
    }
}
