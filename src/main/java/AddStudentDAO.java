public  class AddStudentDAO
{
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent("Gretta", "gretta@example.com", 24);
        studentDAO.addStudent("Mukiza", "Mukiza@example.com", 25);
    }
}