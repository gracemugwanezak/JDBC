public  class AddStudentDAO
{
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent("Grace Mugwaneza", "grace@example.com", 24);
        studentDAO.addStudent("John Doe", "john@example.com", 25);
    }
}