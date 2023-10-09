package task2;
import java.util.ArrayList;

public abstract class Member {
    
    String name;
    String memberType;
    ArrayList<Booking> bookings;

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBooking(Booking booking) {
        bookings.add(booking);
    }
}
