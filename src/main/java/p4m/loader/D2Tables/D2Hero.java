package p4m.loader.D2Tables;

import javax.persistence.*;

/**
 * Created by soart on 27.03.2015.
 */
@Entity
@Table(name =  "d2_hero")
public class D2Hero {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "localized_name")
    private String localized_name;

    public D2Hero(int inId, String inName, String inLN)
    {
        this.id = inId;
        this.name = inName;
        this.localized_name = inLN;
    }

    public D2Hero()
    {}

    public void SetId(int Id)
    {
        this.id = Id;
    }
    public int GetId()
    {
        return this.id;
    }

    public void SetName(String Name)
    {
        this.name = Name;
    }
    public String GetName()
    {
        return this.name;
    }

    public void SetLocalizedName(String LocName)
    {
        this.localized_name = LocName;
    }
    public String GetLocalizedName()
    {
        return this.localized_name;
    }
}
