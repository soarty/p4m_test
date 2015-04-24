package p4m.loader.JsonPack.JsonHeroPack.JsonMatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by soart on 09.04.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result
{
    private Matches[] matches;

    private String status;

    private String num_results;

    private String results_remaining;

    private String total_results;

    public Matches[] getMatches ()
    {
        return matches;
    }

    public void setMatches (Matches[] matches)
    {
        this.matches = matches;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getNum_results ()
    {
        return num_results;
    }

    public void setNum_results (String num_results)
    {
        this.num_results = num_results;
    }

    public String getResults_remaining ()
    {
        return results_remaining;
    }

    public void setResults_remaining (String results_remaining)
    {
        this.results_remaining = results_remaining;
    }

    public String getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [matches = "+matches+", status = "+status+", num_results = "+num_results+", results_remaining = "+results_remaining+", total_results = "+total_results+"]";
    }
}
