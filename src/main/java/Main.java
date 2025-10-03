import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // singleton instance
        DatabaseConnection db = DatabaseConnection.getInstance();


        //  JDBC connection
        try {
            Connection conn = db.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection is active!");
            } else {
                System.out.println(" Database connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}


