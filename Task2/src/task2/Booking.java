package task2;

public class Booking {
    
    String day;
    String time;
    PGAInstructor instructor;
    Tuition tuition;

    public Booking (String day, String time, PGAInstructor instructor, Tuition tuition) {
        this.day = day;
        this.time = time;
        this.instructor = instructor;
        this.tuition = tuition;
    }

    public String getDay() {
       return day;
    }
     
    public String getTime() {
       return time;
    }

    public PGAInstructor getInstructor() {
       return instructor;
    } 
 
    public Tuition getTuition() {
       return tuition; 
    }

}
