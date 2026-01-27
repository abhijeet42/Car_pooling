public class Ride {

    public int availableSeats;
    public int farePerSeat;
    int id;
    String source;
    String destination;
    int seats;
    double fare;
    User user;

    public Ride(int id, String source, String destination, int seats, double fare) {
        this.id=id;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", fare=" + fare +
                '}';
    }

    public void displayRide() {
        System.out.println("Id      : " + id);
        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
        System.out.println("Seats       : " + seats);
        System.out.println("Fare        : ₹" + fare);
    }
}
