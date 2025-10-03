public class UpdateStudentDAO {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(1, "uwase", "uwase@example.com", 24);
    }
}