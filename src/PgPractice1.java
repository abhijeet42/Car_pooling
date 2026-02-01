// only created this file for learning how postgresql works ( will delete this file in future )

import java.sql.*;
import java.util.Scanner;

public class PgPractice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userinput=1;
        try{
            Class.forName("org.postgresql.Driver");
            Connection cn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbctest",
                    "postgres",
                    "abhi");

while(userinput!=0) {
    System.out.println("\n\nEnter 1 to insert element in emp database\n2 to delete the element\n3 to view elements\n---- ");
    userinput = sc.nextInt();

    if (userinput == 1) {
        PreparedStatement ps = cn.prepareStatement("INSERT INTO emp VALUES (?,?)");
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        }
    } else if (userinput == 2) {
        System.out.println("\nEnter id to delete in database : ");
        int idtodelete = sc.nextInt();

        PreparedStatement ps = cn.prepareStatement("DELETE FROM emp WHERE emp.eid=?");
        ps.setInt(1, idtodelete);
        ps.executeUpdate();

    } else if (userinput == 3) {

        ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM emp");
        while (rs.next()) {
            System.out.println(rs.getInt("eid") + " " + rs.getString("ename"));
        }
    }
}



            cn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
