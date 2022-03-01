// project to show table data
import java.sql.*;
public class pract4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/practice";
            String username="root";
            String password="";
            Connection con=DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            ResultSet res= stmt.executeQuery("select* from table1");
            while (res.next()) {
                System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
            }
            con.close();
        } catch (Exception e) {
            // handle exception
            System.out.println("Error Occured "+e);
        }
    }
}
