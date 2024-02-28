import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Write a description of class LocalInfo here.
 *
 * @author Muhammed Keeka
 * @version 2024.02.28
 */
public class LocalInfo
{
    private Connection conn = null;

    /**
     * Constructor for objects of class LocalInfo
     */
    public LocalInfo()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");//Specify the SQLite Java driver
            conn = DriverManager.getConnection("jdbc:sqlite:CPMS.db");//Specify the database, since relative in the main project folder
            conn.setAutoCommit(false);// Important as I want control of when data is written
        }
        catch(Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void execute(String query)
    {
        Statement stmt;
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.commit();
        }
        catch (SQLException e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public int getInt(String query, String field)
    {//Executes the statement below and returns a single integer, of the field specified. This seems like an odd method but is useful when operating queries such as COUNT.
        Statement stmt;
        ResultSet rs;
        int temp = 0;
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            temp = rs.getInt(field);
            rs.close();
            stmt.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return temp;
    }

    public void close()
    {//Closes the connection to the database
        try
        {
            conn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(LocalInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
