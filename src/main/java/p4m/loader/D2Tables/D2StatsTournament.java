package p4m.loader.D2Tables;

import javax.persistence.*;

/**
 * Created by soart on 15.05.2015.
 */
@Entity
@Table(name = "d2_stats_tournaments")
public class D2StatsTournament {
    @Id
    @Column(name = "id", unique = true)
    private String id;

    public void setId()
    {
        this.id = this.stats_id+"_"+this.tournament_id;
    }
    public String getId()
    {
        return this.id;
    }

    @Column(name = "stats_id")
    private String stats_id;

    public void setStats_id(String inStatsId)
    {
        this.stats_id = inStatsId;
        this.setId();
    }
    public String getStats_id()
    {
        return this.stats_id;
    }

    @Column(name = "tournament_id")
    private int tournament_id;

    public void setTournament_id(int in_TournamentId)
    {
        this.tournament_id = in_TournamentId;
        this.setId();
    }
    public int getTournament_id()
    {
        return this.tournament_id;
    }

}
