import java.sql.Connection;
import java.sql.Statement;

public class Marks {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE marks (" +
                    "student_id INT, " +
                    "course_id INT, " +
                    "marks NUMERIC(5,2), " + // safer than FLOAT for scores
                    "CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE, " +
                    "CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE" +
                    ")";

            stmt.execute(sql);
            System.out.println("Table marks created successfully!");
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
