/**
 * Write a description of class RecyclingCentre here.
 *
 * @author Muhammed Keeka
 * @version 2024.02.28
 */
public class RecyclingCentre
{
    private String name;
    private int streetNo;
    private String streetName;
    private String town;
    private String postcode;

    /**
     * Constructor for objects of class RecyclingCentre
     */
    public RecyclingCentre(String name, int streetNo, String streetName, String town, String postcode)
    {
        // initialise instance variables
        this.name = name;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.town = town;
        this.postcode = postcode;
    }

    public String getName()
    {
        return name;
    }

    public int getStreetNo()
    {
        return streetNo;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getTown()
    {
        return town;
    }

    public String getPostcode()
    {
        return postcode;
    }
}
