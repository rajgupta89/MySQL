//first jdbc program to check connection of database
import java.sql.*; 
public class prac1 {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            // create a connection
            String url="jdbc:mysql://localhost:3306/practice";
            String user="root";
            String password="";
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("DataBase is connected");
            con.close();
        } catch (Exception e) {
            // handle exception
            System.out.println("Problem Connection to DataBase - Error : "+e);
        }
    }
}
