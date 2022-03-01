// problem to insert data in database taking values from user
import java.sql.*;
import java.util.*;
public class prac3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/practice";
            String username="root";
            String password="";
            Connection con=DriverManager.getConnection(url, username, password);
            String q="insert into table1(name, city) values(?,?)"; // here ? is used when we have to take value from user
            // get PreparedStatement object
            PreparedStatement pstmt= con.prepareStatement(q);
            System.out.println("Enter name and city");
            String name=in.nextLine();
            String city=in.nextLine();
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println("Data Inserted in row 1");
            con.close();
        } catch (Exception e) {
            //handle exception
            System.out.println("Error Occurs "+e);
        }
    }
}
