//->JDBC CONNECTIVITY
/* STEPS : 
 * 01 Register the driver 
 * 02 Create Connection 
 * 03 Create Statement
 * 04 Execute Query
 * 05 Close Connection
 */
 
import java.sql.*;
public class connection {
    Connection c;
    Statement s;
    public connection(){
//-> Handling Run Time Error
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "@Sushant1205");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
