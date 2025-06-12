import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NorthwindDataManager {
    private static final Logger logger = Logger.getLogger(NorthwindDataManager.class.getName());
    private static final String Url = "jdbc:mysql://localhost:3306/northwind?user=root&password=yearup";

    public NorthwindDataManager(DataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Datasource cant be null");
        }
    }

    public List<Shippers> getAllShippers() {
        List<Shippers> shippers = new ArrayList<>();
        String query = "SELECT * FROM shippers";

        try (Connection connection = DriverManager.getConnection(Url); Statement stmt = connection.createStatement(); ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                shippers.add(new Shippers(resultSet.getInt("ShipperID"), resultSet.getString("CompanyName"), resultSet.getString("Phone")));
            }


        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch users", e);
        }

        return shippers;
    }

    public Shippers add(String companyName, String phone) {
        String SQL = "INSERT INTO shippers (" + companyName + ", " + phone + ");";
        try (Connection connection = DriverManager.getConnection(Url)) {

            PreparedStatement stmt = connection.prepareStatement(SQL);


        } catch (SQLException e) {
            logger.log(Level.SEVERE, "ERROR FETCHING DATA!" + e);
        }

        return null;
    }

    public void update(int shipperId, String newCompanyName, String newPhone) {
        String sql = "UPDATE shippers SET name =" + newCompanyName + ", " + newPhone + "WHERE ShipperID = ?";
        try (Connection connection = DriverManager.getConnection(Url)) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, newCompanyName);
            statement.setString(2, newPhone);
            statement.setInt(3, shipperId);
            statement.executeQuery();


        } catch (Exception e) {
            logger.log(Level.SEVERE, "ERROR Updating query.");
        }
    }

    public void delete(int shipperId) {
        String sql = "DELETE FROM shippers WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(Url)) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, shipperId);
            statement.executeQuery();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Deleting Data.");
        }

    }
}




