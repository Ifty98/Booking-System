package task2;
import java.util.ArrayList;

public class PGAInstructor {

    String name;
    int coachingLevel;
    ArrayList<Booking> bookings;

    public PGAInstructor (String name, int coachingLevel) {
         this.name = name;
         this.coachingLevel = coachingLevel;
         bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCoachingLevel() {
        return coachingLevel; 
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBooking(Booking booking) {
        bookings.add(booking);
    }
}
