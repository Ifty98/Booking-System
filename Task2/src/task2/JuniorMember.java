package task2;
import java.util.ArrayList;

public class JuniorMember extends Member {

     public JuniorMember (String name) {
         this.name = name;
         this.memberType = "Junior member";
         bookings = new ArrayList<>();
     }
    
     public String getMemberType() {
        return memberType;
     }

     public String getName() {
        return name;
     }

     public ArrayList<Booking> getBookings() {
        return bookings;
     }

     public void setBooking(Booking booking) {
        bookings.add(booking);
     }
}
