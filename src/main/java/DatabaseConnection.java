import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singleton class
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;


    private final String url = "jdbc:postgresql://localhost:5432/SchoolDatabase";
    private final String username= "postgres";
    private final String password= "Grace@1231";

    // Private constructor
    private DatabaseConnection() {
        try {
            // Register PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed! Check output console");
        }
    }

    // design pattern singleton instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
