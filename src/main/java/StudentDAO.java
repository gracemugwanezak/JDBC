import java.sql.*;

public class StudentDAO {

    private Connection conn;

    public StudentDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    // Create a new student
    public void addStudent(String name, String email, int age) {
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all students
    public void getAllStudents() {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | Age: " +
                                rs.getInt("age")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update student
    public void updateStudent(int id, String name, String email, int age) {
        String sql = "UPDATE students SET name=?, email=?, age=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated!");
            else System.out.println("No student found with ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted!");
            else System.out.println("No student found with ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
