import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance
        DatabaseConnection db = DatabaseConnection.getInstance();


        // Get the actual JDBC connection
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
        StudentDAO studentDAO = new StudentDAO();



        // Read all students
        System.out.println("\nAll students:");
        studentDAO.getAllStudents();



    }
}


