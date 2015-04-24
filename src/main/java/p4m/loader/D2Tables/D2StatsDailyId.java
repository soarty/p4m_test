package p4m.loader.D2Tables;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by soart on 17.04.2015.
 */
@Embeddable
public class D2StatsDailyId implements Serializable{
    @Column(name = "account_id")
    private String account_id;

    @Column(name = "match_id")
    private String match_id;

    public void setAccount_id(String inAcc_id)
    {
        this.account_id = inAcc_id;
    }
    public String getAccount_id()
    {
        return this.account_id;
    }

    public void setMatch_id(String inMatch_id)
    {
        this.match_id = inMatch_id;
    }
    public String getMatch_id()
    {
        return this.match_id;
    }

}
