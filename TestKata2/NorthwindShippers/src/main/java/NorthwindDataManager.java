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
        String query = "SELECT ShipperID, CompanyName, Phone  FROM shippers";

        try (Connection connection = DriverManager.getConnection(Url); Statement stmt = connection.createStatement(); ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ShipperID");
                String name = resultSet.getString("CompanyName");
                String phone = resultSet.getString("Phone");
                if (name != null && !name.isBlank() && phone != null && !phone.isBlank()) {
                    shippers.add(new Shippers(id,name, phone));
                } else {
                    System.out.printf("Skipping invalid shipper: ID=%d, Name='%s', Phone= '%s'%n", id, name, phone);
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch users", e);
        }

        return shippers;
    }

    public void add(String companyName, String phone) {
        String SQL = "INSERT INTO shippers (companyName, Phone) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(Url)) {
            PreparedStatement stmt = connection.prepareStatement(SQL);

            stmt.setString(1,companyName);
            stmt.setString(2, phone);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try(ResultSet generateKey = stmt.getGeneratedKeys()) {
                    if (generateKey.next()) {
                        int id = generateKey.getInt(1);
                        new Shippers(id, companyName, phone);
                    }
                }
            }


        } catch (SQLException e) {
            logger.log(Level.SEVERE, "ERROR INSERTING SHIPPER!" + e);
        }

    }

    public void update(String newPhone) {
        String sql = "UPDATE shippers SET phone =" + newPhone + "WHERE ShipperID = ?";
        try (Connection connection = DriverManager.getConnection(Url)) {
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setString(2, newPhone);
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




