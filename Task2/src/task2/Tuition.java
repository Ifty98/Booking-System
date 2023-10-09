package task2;
import java.util.ArrayList;

public abstract class Tuition {
     String classType;
     ArrayList<Member> members;
     int spacesAvailable;

     public String getClassType() {
         return classType;
     }

     public void setMembers(Member member) {
         members.add(member);
     }

     public ArrayList<Member> getMembers() {
        return members;
     }
 
     public int getSpaces() {
       return spacesAvailable;
     }

     public void setSpacesAvailable() {
       int newSpaces = spacesAvailable - 1;
       spacesAvailable = newSpaces;
     }
}
