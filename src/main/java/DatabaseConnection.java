import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singleton class
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;




    // Private constructor
    private DatabaseConnection() {
        try {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("URL");
            String username = dotenv.get("USERNAME");
            String password = dotenv.get("PASSWORD");
            // Register PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed");
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
