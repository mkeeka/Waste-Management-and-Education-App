import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LocalInfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LocalInfoTest
{
    /**
     * Default constructor for test class LocalInfoTest
     */
    public LocalInfoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void databaseTest1() {
        LocalInfo li = new LocalInfo();
        RecyclingCentre centre = new RecyclingCentre("Caffe Nero", 77, "Kingsway", "London", "WC2B 6ST");
        li.addCentre(centre);
        String[] postcodes = {"WC2B 6ST"};
        List<RecyclingCentre> centres = li.getDetailsofNearbyCentres(postcodes);
        assertEquals(centres.get(0).getName(), "Caffe Nero");
        assertEquals(centres.get(0).getStreetNo(), 77);
        assertEquals(centres.get(0).getStreetName(), "Kingsway");
        assertEquals(centres.get(0).getTown(), "London");
        assertEquals(centres.get(0).getPostcode(), "WC2B 6ST");
        li.removeCentre(centre);
    }
    
    @Test
    public void databaseTest2() {
        LocalInfo li = new LocalInfo();
        RecyclingCentre centre = new RecyclingCentre("Caffe Nero", 77, "Kingsway", "London", "WC2B 6ST");
        li.addCentre(centre);
        String[] postcodes = {"WC2B 6SA"};
        List<RecyclingCentre> centres = li.getDetailsofNearbyCentres(postcodes);
        assertEquals(centres.size(), 0);
        li.removeCentre(centre);
    }
}

