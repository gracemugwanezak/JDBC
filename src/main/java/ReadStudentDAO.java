public class ReadStudentDAO {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println("\nAll students:");
        studentDAO.getAllStudents();

    }
}