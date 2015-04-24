package p4m.loader.JsonPack.JsonHeroPack.JsonMatchDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 14.04.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result
{
    private String first_blood_time;

    private String radiant_win;

    private String match_id;

    private String negative_votes;

    private String human_players;

    private String tower_status_radiant;

    private String barracks_status_dire;

    private String duration;

    private Players[] players;

    private String barracks_status_radiant;

    private String game_mode;

    private String tower_status_dire;

    private String positive_votes;

    private String start_time;

    private String cluster;

    private String leagueid;

    private String lobby_type;

    private String match_seq_num;

    public String getFirst_blood_time ()
    {
        return first_blood_time;
    }

    public void setFirst_blood_time (String first_blood_time)
    {
        this.first_blood_time = first_blood_time;
    }

    public String getRadiant_win ()
    {
        return radiant_win;
    }

    public void setRadiant_win (String radiant_win)
    {
        this.radiant_win = radiant_win;
    }

    public String getMatch_id ()
    {
        return match_id;
    }

    public void setMatch_id (String match_id)
    {
        this.match_id = match_id;
    }

    public String getNegative_votes ()
    {
        return negative_votes;
    }

    public void setNegative_votes (String negative_votes)
    {
        this.negative_votes = negative_votes;
    }

    public String getHuman_players ()
    {
        return human_players;
    }

    public void setHuman_players (String human_players)
    {
        this.human_players = human_players;
    }

    public String getTower_status_radiant ()
    {
        return tower_status_radiant;
    }

    public void setTower_status_radiant (String tower_status_radiant)
    {
        this.tower_status_radiant = tower_status_radiant;
    }

    public String getBarracks_status_dire ()
    {
        return barracks_status_dire;
    }

    public void setBarracks_status_dire (String barracks_status_dire)
    {
        this.barracks_status_dire = barracks_status_dire;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public Players[] getPlayers ()
    {
        return players;
    }

    public void setPlayers (Players[] players)
    {
        this.players = players;
    }

    public String getBarracks_status_radiant ()
    {
        return barracks_status_radiant;
    }

    public void setBarracks_status_radiant (String barracks_status_radiant)
    {
        this.barracks_status_radiant = barracks_status_radiant;
    }

    public String getGame_mode ()
    {
        return game_mode;
    }

    public void setGame_mode (String game_mode)
    {
        this.game_mode = game_mode;
    }

    public String getTower_status_dire ()
    {
        return tower_status_dire;
    }

    public void setTower_status_dire (String tower_status_dire)
    {
        this.tower_status_dire = tower_status_dire;
    }

    public String getPositive_votes ()
    {
        return positive_votes;
    }

    public void setPositive_votes (String positive_votes)
    {
        this.positive_votes = positive_votes;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public String getCluster ()
    {
        return cluster;
    }

    public void setCluster (String cluster)
    {
        this.cluster = cluster;
    }

    public String getLeagueid ()
    {
        return leagueid;
    }

    public void setLeagueid (String leagueid)
    {
        this.leagueid = leagueid;
    }

    public String getLobby_type ()
    {
        return lobby_type;
    }

    public void setLobby_type (String lobby_type)
    {
        this.lobby_type = lobby_type;
    }

    public String getMatch_seq_num ()
    {
        return match_seq_num;
    }

    public void setMatch_seq_num (String match_seq_num)
    {
        this.match_seq_num = match_seq_num;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [first_blood_time = "+first_blood_time+", radiant_win = "+radiant_win+", match_id = "+match_id+", negative_votes = "+negative_votes+", human_players = "+human_players+", tower_status_radiant = "+tower_status_radiant+", barracks_status_dire = "+barracks_status_dire+", duration = "+duration+", players = "+players+", barracks_status_radiant = "+barracks_status_radiant+", game_mode = "+game_mode+", tower_status_dire = "+tower_status_dire+", positive_votes = "+positive_votes+", start_time = "+start_time+", cluster = "+cluster+", leagueid = "+leagueid+", lobby_type = "+lobby_type+", match_seq_num = "+match_seq_num+"]";
    }
}
