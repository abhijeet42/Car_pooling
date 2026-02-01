import java.util.ArrayList;
import java.util.List;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();

            if (con != null) {
            System.out.println("Connection is ready to use");

            RideBookingSystem rideBookingSystem = new RideBookingSystem();
            rideBookingSystem.createRide(1, "jaipur", "delhi", 5, 1200);
            rideBookingSystem.createRide(2, "greaternoida", "agra", 5, 8000);
            rideBookingSystem.createRide(3, "noida", "delhi", 5, 1200);
            rideBookingSystem.createRide(4, "jaipur", "noida", 5, 1200);

            System.out.println(rideBookingSystem.showAllRide());
        }
    }
}