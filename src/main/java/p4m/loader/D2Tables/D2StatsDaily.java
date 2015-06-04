package p4m.loader.D2Tables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by soart on 15.04.2015.
 */
@Entity
@Table(name = "d2_stats_daily")
public class D2StatsDaily {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    public void setId(int inId)
    {
        this.Id = inId;
    }
    public int getId()
    {
        return this.Id;
    }*/

    /*@EmbeddedId
    D2StatsDailyId statsId;
    public void setPrimaryKey(D2StatsDailyId primaryKey)
    {
        statsId = primaryKey;
    }
    public D2StatsDailyId getStatsId()
    {
        return statsId;
    }

    public D2StatsDaily()
    {
        statsId = new D2StatsDailyId();
    }

    public void setAccount_id(String inAcc_id)
    {
        this.statsId.setAccount_id(inAcc_id);
        this.id = this.statsId.getAccount_id()+"_"+this.statsId.getMatch_id();
    }
    public String getAccount_id()
    {
        return this.statsId.getAccount_id();
    }

    public void setMatch_id(String inMatch_id)
    {
        this.statsId.setMatch_id(inMatch_id);
        this.id = this.statsId.getAccount_id()+"_"+this.statsId.getMatch_id();
    }
    public String getMatch_id()
    {
        return this.statsId.getMatch_id();
    }*/
    @Id
    @Column(name = "id", unique = true)
    private String id;
    public void setId(String in_id)
    {this.id = in_id;}
    public String getId()
    {return this.id;}
    /*public void setId()
    {
        this.id = this.getAccount_id()+ "_" + this.getMatch_id();
    }*/

    @Column(name = "match_id")
    private String match_id;
    public void setMatch_id(String inMatchId)
    {
        this.match_id = inMatchId;
        this.id = this.account_id+"_"+this.match_id;
    }
    public String getMatch_id()
    {
        return this.match_id;
    }

    @Column(name = "account_id")
    private String account_id;
    public void setAccount_id(String inAccId)
    {
        this.account_id = inAccId;
        this.id = this.account_id+"_"+this.match_id;
    }
    public String getAccount_id()
    {
        return this.account_id;
    }

    @Column(name = "start_date_match")
    private Date start_date_match;
    public void setStart_date_match(Date date)
    {
        this.start_date_match = date;
    }
    public Date getStart_date_match()
    {return this.start_date_match;}

    @Column(name = "player_slot")
    private int player_slot;
    public void setPlayer_slot(int inPL)
    {
        this.player_slot = inPL;
    }
    public int getPlayer_slot()
    {
        return this.player_slot;
    }

    @Column(name = "hero_id")
    private int hero_id;
    public void setHero_id(int inHI)
    {
        this.hero_id = inHI;
    }
    public int getHero_id()
    {
        return this.hero_id;
    }

    @Column(name = "item_0")
    private int item_0;
    public void setItem_0(int inItem0)
    {
        this.item_0 = inItem0;
    }
    public int getItem_0()
    {
        return this.item_0;
    }

    @Column(name = "item_1")
    private int item_1;
    public void setItem_1(int inItem1)
    {
        this.item_1 = inItem1;
    }
    public int getItem_1()
    {
        return this.item_1;
    }

    @Column(name = "item_2")
    private int item_2;
    public void setItem_2(int inItem2)
    {
        this.item_2 = inItem2;
    }
    public int getItem_2()
    {
        return this.item_2;
    }

    @Column(name = "item_3")
    private int item_3;
    public void setItem_3(int inItem3)
    {
        this.item_3 = inItem3;
    }
    public int getItem_3()
    {
        return this.item_3;
    }

    @Column(name = "item_4")
    private int item_4;
    public void setItem_4(int inItem4)
    {
        this.item_4 = inItem4;
    }
    public int getItem_4()
    {
        return this.item_4;
    }

    @Column(name = "item_5")
    private int item_5;
    public void setItem_5(int inItem5)
    {
        this.item_5 = inItem5;
    }
    public int getItem_5()
    {
        return this.item_5;
    }

    @Column(name = "kills")
    private int kills;
    public void setKills(int inKills)
    {
        this.kills = inKills;
    }
    public int getKills()
    {
        return this.kills;
    }

    @Column(name = "deaths")
    private int deaths;
    public void setDeaths(int inDeaths)
    {
        this.deaths = deaths;
    }
    public int getDeaths()
    {
        return this.deaths;
    }

    @Column(name = "assists")
    private int assists;
    public void setAssists(int inAssists)
    {
        this.assists = inAssists;
    }
    public int getAssists()
    {
        return this.assists;
    }

    @Column(name = "leaver_status")
    private int leaver_status;
    public void setLeaver_status(int inLS)
    {
        this.leaver_status = inLS;
    }
    public int getLeaver_status()
    {
        return this.leaver_status;
    }

    @Column(name = "gold")
    private int gold;
    public void setGold(int inGold)
    {
        this.gold = inGold;
    }
    public int getGold()
    {
        return this.gold;
    }

    @Column(name = "last_hits")
    private int last_hits;
    public void setLast_hits(int inLH)
    {
        this.last_hits = inLH;
    }
    public int getLast_hits()
    {
        return this.last_hits;
    }

    @Column(name = "denies")
    private int denies;
    public void setDenies(int inDenies)
    {
        this.denies = inDenies;
    }
    public int getDenies()
    {
        return this.denies;
    }

    @Column(name = "gold_per_min")
    private int gold_per_min;
    public void setGold_per_min(int inGPM)
    {
        this.gold_per_min = inGPM;
    }
    public int getGold_per_min()
    {
        return this.gold_per_min;
    }

    @Column(name = "xp_per_min")
    private int xp_per_min;
    public void setXp_per_min(int inXPM)
    {
        this.xp_per_min = inXPM;
    }
    public int getXp_per_min()
    {
        return this.xp_per_min;
    }

    @Column(name = "gold_spent")
    private int gold_spent;
    public void setGold_spent(int inGS)
    {
        this.gold_spent = inGS;
    }
    public int getGold_spent()
    {
        return this.gold_spent;
    }

    @Column(name = "hero_damage")
    private int hero_damage;
    public void setHero_damage(int inHD)
    {
        this.hero_damage = inHD;
    }
    public int getHero_damage()
    {
        return this.hero_damage;
    }

    @Column(name = "tower_damage")
    private int tower_damage;
    public void setTower_damage(int inTD)
    {
        this.tower_damage = inTD;
    }
    public int getTower_damage()
    {
        return this.tower_damage;
    }

    @Column(name = "hero_healing")
    private int hero_healing;
    public void setHero_healing(int inHH)
    {
        this.hero_healing = inHH;
    }
    public int getHero_healing()
    {
        return this.hero_healing;
    }

    @Column(name = "level")
    private int level;
    public void setLevel(int inLevel)
    {
        this.level = inLevel;
    }
    public int getLevel()
    {
        return this.level;
    }

    @ManyToOne()
    @JoinColumn(name = "match_id",referencedColumnName = "match_id",insertable = false,updatable = false)
    private D2Match d2m;
    public void setD2m(D2Match inD2m)
    {
        this.d2m = inD2m;
    }
    public D2Match getD2m()
    {
        return this.d2m;
    }

}
