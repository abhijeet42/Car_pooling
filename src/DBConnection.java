    import java.sql.*;
    public class DBConnection {

        public static Connection getConnection() {
            Connection con = null;

            try {
                // Load PostgreSQL Driver
                Class.forName("org.postgresql.Driver");

                // Create connection
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rideapp", "postgres", "abhi");
//                System.out.println("Database connected successfully!");

            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL Driver not found");
            } catch (SQLException e) {
                System.out.println("Database connection failed");
                e.printStackTrace();
            }

            return con;
        }
    }
