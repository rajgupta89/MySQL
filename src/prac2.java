import java.sql.*;
public class prac2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/practice";
            String username="root";
            String password="";
            Connection con=DriverManager.getConnection(url, username, password);
            // create a query
            String q="create table table2(ID int(20) primary key auto_increment, name varchar(50), city varchar(50))";
            // create a statement
            Statement stmt= con.createStatement();
            stmt.executeUpdate(q); 
            System.out.println("Table created successfully");
        } catch (Exception e) {
            //handle exception
            System.out.println("Problem occured - Error : "+e);
        }
    }
}
