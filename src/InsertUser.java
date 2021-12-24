import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

class InsertUser extends DBConnection {
    public InsertUser() {
        try {
            Statement stmt = con.createStatement();
            // create a new table
            stmt.execute(
                  "CREATE TABLE IF NOT EXISTS login ("
                + "	username text, "
                + "	password text"
                + ")"
	);
stmt.execute(
                  "CREATE TABLE IF NOT EXISTS employee ("
+ "name text, id String, age text, post text, birth text, gender text, address text, mobile text, email text, education text, joindate text, salary text, experience text"
                + ")"
        );
	System.out.println("Table created");
	PreparedStatement pstmt = con.prepareStatement("INSERT INTO login (username, password) VALUES (?, ?)");
            pstmt.setString(1, "shiva");
            pstmt.setString(2, "shiv");
//            pstmt.executeUpdate();
	System.out.println("Inserted User");
con.close();
new Login();
        } catch (Exception e) {
            System.out.println("Insert Error : "+e.getMessage());
        }
    }
}
