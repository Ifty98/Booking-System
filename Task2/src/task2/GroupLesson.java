package task2;
import java.util.ArrayList;

public class GroupLesson extends Tuition {

      public GroupLesson () {
         this.classType = "Group lesson";
         members = new ArrayList<>();
         this.spacesAvailable = 4;
      }

     public String getClassType() {
       return classType;
     }

     public void setSpacesAvailable() {
         int newSpaces = spacesAvailable - 1;
         spacesAvailable = newSpaces;
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
}
