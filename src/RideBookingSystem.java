import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    List<User> userList = new ArrayList<>();
    List<Ride> rideList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();

    User loggedInUser = null;
    int bookingCounter = 1;


    public void signup(int id, String name, String email, String password) {
        for (User u : userList) {
            if (u.email.equals(email)) {
                System.out.println("Email already registered!");
                return;
            }
        }
        userList.add(new User(id, name, email, password));
        System.out.println("Signup successful!");
    }

    public void login(String email, String password) {
        for (User u : userList) {
            if (u.email.equals(email) && u.password.equals(password)) {
                loggedInUser = u;
                System.out.println("Login successful. Welcome " + u.name);
                return;
            }
        }
        System.out.println("Invalid email or password.");
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out.");
    }

    public void createRide(int id, String source, String destination, int seats, double fare) {
        for (Ride r : rideList) {
            if (r.id == id) {
                System.out.println("Ride ID already exists!");
                return;
            }
        }
        rideList.add(new Ride(id, source, destination, seats, fare));
        System.out.println("Ride created.");
    }

    public List<Ride> showAllRide() {
        return rideList;
    }

    public List<Ride> searchRide(String source, String destination, int seats) {
        List<Ride> available = new ArrayList<>();
        for (Ride r : rideList) {
            if (r.source.equalsIgnoreCase(source) &&
                    r.destination.equalsIgnoreCase(destination) &&
                    r.availableSeats >= seats) {
                available.add(r);
            }
        }
        return available;
    }


    public void bookRide(int rideId, int seatsBooked) {
        if (loggedInUser == null) {
            System.out.println("Please login first!");
            return;
        }

        for (Ride r : rideList) {
            if (r.id == rideId) {

                if (r.availableSeats < seatsBooked) {
                    System.out.println("Not enough seats!");
                    return;
                }

//                double totalFare = seatsBooked * r.farePerSeat;
                Booking booking = new Booking(bookingCounter++, r, loggedInUser, seatsBooked);
                bookingList.add(booking);

                r.availableSeats -= seatsBooked;

                System.out.println("Booking successful!");
                System.out.println(booking);
                return;
            }
        }

        System.out.println("Ride not found.");
    }

    public void cancelBooking(int bookingId) {
        for (Booking b : bookingList) {
            if (b.booking_id == bookingId && b.user == loggedInUser) {
                b.ride.availableSeats += b.seats_booked;
                bookingList.remove(b);
                System.out.println("Booking cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void viewMyBookings() {
        for (Booking b : bookingList) {
            if (b.user == loggedInUser) {
                System.out.println(b);
            }
        }
    }
}
