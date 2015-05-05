package p4m.loader.D2Tables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by soart on 09.04.2015.
 */
@Entity
@Table(name = "d2_match")
public class D2Match {
    @Id
    @Column(name = "match_id")
    private String match_id;

    @Column(name = "match_seq_num")
    private String match_seq_num;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "lobby_type")
    private int lobby_type;

    @Column(name = "start_time_dt")
    private Date dt;

    @Column(name = "loaded")
    private String loaded = "N";

    public D2Match()
    {}
    public D2Match(String mat_id, String mat_seq, String st, int lt)
    {
        this.match_id = mat_id;
        this.match_seq_num = mat_seq;
        this.start_time = st;
        this.lobby_type = lt;
        Date date = new Date(Long.parseLong(st)*1000);
        this.dt = date;
    }

    public void SetMatchId(String mi)
    {
        this.match_id = mi;
    }
    public void SetMatchSeq(String ms)
    {
        this.match_seq_num = ms;
    }
    public  void SetStartTime(String st)
    {
        this.start_time = st;
    }
    public void SetLobbyType(int lt)
    {
        this.lobby_type = lt;
    }
    public String GetMatchId()
    {
        return this.match_id;
    }
    public String GetMatchSeq()
    {
        return this.match_seq_num;
    }
    public String GetStartTime()
    {
        return this.start_time;
    }
    public int GetLobbyType()
    {
        return this.lobby_type;
    }
    public String GetLoaded(){return this.loaded;}
    public void SetLoaded(String inLoaded){
        this.loaded = inLoaded;
    }
    public String toString()
    {
        return "Match Id = '"+this.match_id+"'";
    }
}
