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

            pstmt.setInt(1,4);
            pstmt.setInt(2,3);
            pstmt.setFloat(3,70);
            pstmt.executeUpdate();

            pstmt.setInt(1,3);
            pstmt.setInt(2,5);
            pstmt.setFloat(3,50);
            pstmt.executeUpdate();

            pstmt.setInt(1,1);
            pstmt.setInt(2,2);
            pstmt.setFloat(3,70);
            pstmt.executeUpdate();







            System.out.println("Marks inserted");
            pstmt.close();
        }
        catch(Exception e){
            System.out.println("Database connection failed.");
        }
    }
}
