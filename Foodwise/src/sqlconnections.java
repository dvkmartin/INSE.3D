
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnections {

    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String Database_Path = "jdbc:mysql://77.95.179.45:3306/new?verifyServerCertificate=false&useSSL=true";
    static final String DBUsername = "inse";
    static final String DBPassword = "inse3d";

    public static void main(String[] args) {

        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(Database_Path, DBUsername, DBPassword);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
