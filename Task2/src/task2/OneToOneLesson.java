package task2;
import java.util.ArrayList;

public class OneToOneLesson extends Tuition {

      public OneToOneLesson () {
         this.classType = "One to one lesson";
         members = new ArrayList<>();
      }

      public String getClassType() {
         return classType;
      }

      public void setMembers(Member member) {
         members.add(member);
      }

      public ArrayList<Member> getMembers() {
        return members;
      }
}
