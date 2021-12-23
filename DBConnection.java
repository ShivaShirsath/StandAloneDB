import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
    public Connection con;

    public DBConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(
                    "jdbc:sqlite:sqlite.db"
            );
            System.out.println("Successfully Connected");
        } catch (Exception e) {
            System.out.println("Connection Error : "+e.getMessage());
        }
    }
}
