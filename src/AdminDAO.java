import java.sql.*;

public class AdminDAO {

    public boolean login(String username, String password) {
        String query = "SELECT * FROM admin WHERE username=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();  // true if found

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}