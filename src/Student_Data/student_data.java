// it is a simple program using switch case to maintain student data
package Student_Data;
import java.sql.*;
import java.util.*;
public class student_data {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/practice";
            String user="root";
            String password="";
            Connection conn=DriverManager.getConnection(url, user, password);
            // Statement stmt=con.createStatement();
            // stmt.executeUpdate(q);
            String Fname, Lname, email, contact;
            
            while (true) {
                System.out.println("Enter 1 to enter new student data");
                System.out.println("Enter 2 to delete a student data");
                System.out.println("Enter 3 to display students data");
                System.out.println("Enter 4 to exit");
                int choice=in.nextInt();
            switch (choice) {
                    case 1:
                    String q="insert into student1(First_Name, Last_Name, Email, Contact_Number) values(?,?,?,?)";
                    PreparedStatement pstmt=conn.prepareStatement(q);
                    System.out.println("Enter First Name");
                    Fname=in.next();
                    System.out.println("Enter Last Name");
                    Lname=in.next();
                    System.out.println("Enter Email");
                    email=in.next();
                    System.out.println("Enter Contact Number");
                    contact=in.next();
                    pstmt.setString(1, Fname);
                    pstmt.setString(2, Lname);
                    pstmt.setString(3, email);
                    pstmt.setString(4, contact);
                    pstmt.executeUpdate();
                    System.out.println("Student data inserted");
                    break;
                    case 2:
                    System.out.println("Enter ID of student to delete data");
                    int id=in.nextInt();
                    String qu="delete from student1 where ID = "+id;
                    Statement stmt1=conn.createStatement();
                    stmt1.executeUpdate(qu);
                    System.out.println("Student data is deleted for ID : "+id);
                    break;
                    case 3:
                    // Statement stmt2=conn.createStatement();
                    // ResultSet res= stmt2.executeQuery("select* from student1");
                    // while (res.next()) {
                    // System.out.println("\t\t\t"+res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4)+"\t"+res.getString(5));
                    // }
		             	DBTablePrinter.printTable(conn, "student1");  // this is used to print the whole table
                        //  DBTablePrinter.printResultSet(res); // this is used to print the table with some conditions in the resultset
                    break;
                    case 4:
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Sorry! Wrong Choice");
                    break;
                }
            }
            // conn.close();
        } catch (Exception e) {
            //handle exception
            System.out.println("Error Occured : "+e);
        }
    }
}
