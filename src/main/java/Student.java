import java.sql.*;
import java.util.*;
public class Student {
    public static void main(String[] args) {
        try{
            Connection conn= DatabaseConnection.getInstance().getConnection();

            String sql="insert into marks (student_id, course_id, marks) values (?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,2);
            pstmt.setInt(2,3);
            pstmt.setFloat(3,40);


            pstmt.executeUpdate();
            System.out.println("Marks inserted");
            pstmt.close();
        }
        catch(Exception e){
            System.out.println("Database connection failed.");
        }

    }
}
