package task2;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    //creates some PGAInstructor objects and some bookings to them
    public static PGAInstructor[] generatePGA() {
      PGAInstructor instructor1 = new PGAInstructor("David", 4);
      PGAInstructor instructor2 = new PGAInstructor("Sam", 4);

      PGAInstructor instructor3 = new PGAInstructor("Mary", 3);
      PGAInstructor instructor4= new PGAInstructor("Sandy", 3);
      PGAInstructor instructor5= new PGAInstructor("Robert", 3);

      Member member1 = new JuniorMember("Mark");

      OneToOneLesson class1 = new OneToOneLesson();
      Booking booking1 = new Booking("Monday", "16", instructor3, class1);
      instructor3.setBooking(booking1);
      GroupLesson class2 = new GroupLesson();
      Booking booking2 = new Booking("Friday", "17", instructor3, class2);
      booking2.getTuition().setMembers(member1);
      booking2.getTuition().setSpacesAvailable();
      instructor3.setBooking(booking2);

      PGAInstructor[] PGAs = new PGAInstructor[5];

      PGAs[0] = instructor1;
      PGAs[1] = instructor2;
      PGAs[2] = instructor3;
      PGAs[3] = instructor4;
      PGAs[4] = instructor5;

      return PGAs;
    }
    //creates some member objects and add bookings to them
    public static Member[] generateMembers() {
      Member member1 = new JuniorMember("Rachel");
      Member member2 = new JuniorMember("Tom");

      Member member3 = new AdultMember("Harry");
      Member member4 = new AdultMember("Kayn");

      GroupLesson class2 = new GroupLesson();
      PGAInstructor instructor3 = new PGAInstructor("Mary", 3);
      Booking booking2 = new Booking("Friday", "17", instructor3, class2);
      booking2.getTuition().setMembers(member1);
      instructor3.setBooking(booking2);
      member1.setBooking(booking2);      

      Member[] members = new Member[4];

      members[0] = member1;
      members[1] = member2;
      members[2] = member3;
      members[3] = member4;

      return members;
    }
    //asks to the user to select one option and returns the input
    public static int optSelector(int number) {
      Scanner input = new Scanner(System.in);
      System.out.print("Select one option >> ");
      
      try {
        int selectedOpt = input.nextInt();
        if (selectedOpt >= 0 && selectedOpt <= number) {
         return selectedOpt;
        }
        else {
         System.out.println("Incorrect input. Please try again!!");
         return optSelector(number);
        }
      } catch (Exception e) {
      System.out.println("Incorrect input. Please try again!!");
      return optSelector(number);
      }         
    }
    //take a instructor object and checks if the selected has bookings in the following days and times 
    public static void oneToOneSchedule(PGAInstructor instructor) {
      ArrayList<Booking> getBookings = instructor.getBookings();
      Booking sltBooking;
      boolean booked = false;

      String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      String[] time = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
      int k, i, j;
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("|  %-10s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |  %-24s  |%n", "Day/Time", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      /*displays a table with the days and times of the week and displays avilable if the instructor does not have a booking on this day
      but if the instructor has a booking then displays booked and the tuition type*/    
      for (i = 0; i < day.length; i++) {
            System.out.printf("|  %-10s  |", day[i]);
            for (k = 0; k < time.length; k++) {
                if (getBookings.isEmpty()) {
                   System.out.printf("  %-24s  |", "Available");
                }
                else {
                for (j = 0; j < getBookings.size(); j++) {
                    sltBooking = getBookings.get(j);
                    if (sltBooking.getDay().equals(day[i]) && sltBooking.getTime().equals(time[k])) {
                       System.out.printf("  %-24s  |", "Booked/" + sltBooking.getTuition().getClassType());
                       booked = true;
                       break;
                    }
                }
                if (!booked) {
                   System.out.printf("  %-24s  |", "Available");
                }
                else {
                   booked = false;
                }
                }
            }
         System.out.printf("%n");
         System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
     }
    }
    //asks to user user to enter a day of the week
    public static String askDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of the week (first letter in capital) >> ");
        String userInput = scanner.nextLine();

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        boolean isValid = false;
        for (String day : daysOfWeek) {
            if (userInput.equals(day)) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            return userInput;
        } else {
            System.out.println("Incorrect input. Please try again!!");
            return askDay();
        }
    }
    //asks to the user to select a time
    public static String askTime() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the time >> ");
       int time;
       
       try {
        String userInput = scanner.nextLine();
        time = Integer.parseInt(userInput);
        if (time >= 9 && time <= 18) {
         return userInput;
        }
        else {
         System.out.println("Incorrect input. Please try again!!");
         return askTime();
        }
      } catch (Exception e) {
         System.out.println("Incorrect input. Please try again!!");
         return askTime();
      }
    }
    //checks if the selected instructor has a booking or not in the selected day and time
    public static boolean checkDate (String day, String time, PGAInstructor instructor) {
      ArrayList<Booking> getBookings = instructor.getBookings();
      Booking sltBooking;

      if (getBookings.isEmpty()) {
         return true; 
      }
      else {
         for (int i = 0; i < getBookings.size(); i++) {
            sltBooking = getBookings.get(i);
            if (sltBooking.getDay().equals(day) && sltBooking.getTime().equals(time)) {
               return false;
            }
         }
         return true;
      }
    }
    //takes an array of members and returns only the junior members
    public static Member[] juniorMembers(Member[] members) {
       int k = 0;
       int j = 0;
          for (int i = 0; i < members.length; i++) {
             if ("Junior member".equals(members[i].getMemberType())) {
                System.out.printf("|  %-5s  |  %-8s  |  %-14s  |%n", k += 1, members[i].getName(), members[i].getMemberType());
             }
          }
          Member[] juniorMembers = new Member[k]; 
          for (int i = 0; i < members.length; i++) {
             if ("Junior member".equals(members[i].getMemberType())) {
                juniorMembers[j] = members[i];
                j++;
             }
          }
       return juniorMembers; 
    }
    //takes an array of instructors and returns only the level 3 instructors
    public static PGAInstructor[] level3PGAs(PGAInstructor[] PGAs) {
       int k = 0;
       int j = 0;
          for (int i = 0; i < PGAs.length; i++) {
             if (PGAs[i].getCoachingLevel() == 3) {
                k += 1;
             }
          }
          PGAInstructor[] level3PGAs = new PGAInstructor[k]; 
          for (int i = 0; i < PGAs.length; i++) {
             if (PGAs[i].getCoachingLevel() == 3) {
                level3PGAs[j] = PGAs[i];
                j++;
             }
          }
       return level3PGAs;
    }
    //checks how many group lesson bookings has the selected member
    public static boolean memberGroupLessons (Member member) {
       ArrayList<Booking> getBookings = member.getBookings();
       int k = 0;
       for (int i = 0; i < getBookings.size(); i++) {
         if (getBookings.get(i).getTuition().getClassType() == "Group lesson") {
           k++;
         }
       }
       if (k >= 2) {
         return true;
       } else {
           return false;
       }
    }
    //checks if any of the junior members has a group lesson booked
    public static void groupSchedule (PGAInstructor[] level3PGAs) {
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("|  %-10s  |  %-50s  |  %-50s  |%n", "Day/Time", "16", "17");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
      String[] time = {"16", "17"};

      int k, i, j, z;
      boolean booked = false;
      for (i = 0; i < day.length; i++) {
            System.out.printf("|  %-10s  |", day[i]);
            for (k = 0; k < time.length; k++) {
                for (j = 0; j < level3PGAs.length; j++) {
                    PGAInstructor sltPGAs = level3PGAs[j];
                    ArrayList<Booking> getBookings = sltPGAs.getBookings();
                    if (getBookings.isEmpty()) {
                       
                    }
                    else {
                    for (z = 0; z < getBookings.size(); z++) {
                      //if any junior member has a group lesson then the program displays a table with day, time, instructor and spaces available of the group lesson
                      if (getBookings.get(z).getDay().equals(day[i]) && getBookings.get(z).getTime().equals(time[k]) && "Group lesson".equals(getBookings.get(z).getTuition().getClassType())) {
                         System.out.printf("  %-50s  |", "Booked with " + sltPGAs.getName() + "/Spaces: " + getBookings.get(z).getTuition().getSpaces());
                         booked = true;
                         break;
                      }
                    }
                    //if there is no group lesson booking then displays "No booking"
                    if (!booked) {
                      System.out.printf("  %-50s  |", "No booking");
                      break;
                    }
                    else {
                      booked = false;
                    }
                    }
                }
            }
         System.out.printf("%n");
         System.out.println("------------------------------------------------------------------------------------------------------------------------------");
     }
    }   
    //checks if any level 3 instructor has a group lesson in the selected day and time
    public static boolean checkDate2 (String day, String time, PGAInstructor[] level3PGAs) {
       for (int i = 0; i < level3PGAs.length; i++) {
         ArrayList<Booking> getBookings = level3PGAs[i].getBookings();
         for (int z = 0; z < getBookings.size(); z++) {
           if (getBookings.get(z).getDay().equals(day) && getBookings.get(z).getTime().equals(time) && "Group lesson".equals(getBookings.get(z).getTuition().getClassType())) {
               return getBookings.get(z).getTuition().getSpaces() >= 1;
           }
         }
         return false;
       }
       return false;   
    }  
    //if any level 3 instructor has bookign for a group lesson in the selected day and time then returns the booking object
    public static Booking groupBooking(String day, String time, PGAInstructor[] level3PGAs) {
      PGAInstructor instructor1 = new PGAInstructor("David", 4);
      OneToOneLesson class1 = new OneToOneLesson();
      Booking booking1 = new Booking("Monday", "16", instructor1, class1);

      for (int i = 0; i < level3PGAs.length; i++) {
         ArrayList<Booking> getBookings = level3PGAs[i].getBookings();
         for (int z = 0; z < getBookings.size(); z++) {
           if (getBookings.get(z).getDay().equals(day) && getBookings.get(z).getTime().equals(time) && "Group lesson".equals(getBookings.get(z).getTuition().getClassType())) {
              if (getBookings.get(z).getTuition().getSpaces() < 1) {
                 return booking1;
              }
              else {
                 return getBookings.get(z);
              }
           }
         }
         return booking1;
      }
      return booking1;
    }
    //if the selected instructor has any group lesson booked then display the day, time and names of the members taking this lesson
    public static void groupMembers (PGAInstructor instructor) {
      System.out.println("-------------------------------------------");
      System.out.println("Group lessons members");
      System.out.println("-------------------------------------------");
      ArrayList<Booking> getBookings = instructor.getBookings();
      for (int i = 0; i < getBookings.size(); i++) {
        if ("Group lesson".equals(getBookings.get(i).getTuition().getClassType())) {
          System.out.println("Day => " + getBookings.get(i).getDay() + " | Time => " + getBookings.get(i).getTime());
          System.out.println("-------------------------------------------");
          ArrayList<Member> getMembers = getBookings.get(i).getTuition().getMembers();
          for (int k = 0; k < getMembers.size(); k++) {
            System.out.println(getMembers.get(k).getName());
          }
          System.out.println("-------------------------------------------");
        } 
      }
    }
    //for the selected member the program displays a table with the day, time and bookings with the tuition type and the instructor name
    public static void memberBookings (Member member) {
      ArrayList<Booking> getBookings = member.getBookings();
      Booking sltBooking;
      boolean booked = false;

      String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      String[] time = {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
      int k, i, j;
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("|  %-10s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |  %-30s  |%n", "Day/Time", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      for (i = 0; i < day.length; i++) {
            System.out.printf("|  %-10s  |", day[i]);
            for (k = 0; k < time.length; k++) {
                if (getBookings.isEmpty()) {
                   System.out.printf("  %-30s  |", "No booking");
                }
                else {
                for (j = 0; j < getBookings.size(); j++) {
                    sltBooking = getBookings.get(j);
                    if (sltBooking.getDay().equals(day[i]) && sltBooking.getTime().equals(time[k])) {
                       System.out.printf("  %-30s  |", "Booked/" + sltBooking.getTuition().getClassType() + " with " + sltBooking.getInstructor().getName());
                       booked = true;
                       break;
                    }
                }
                if (!booked) {
                   System.out.printf("  %-30s  |", "No booking");
                }
                else {
                   booked = false;
                }
                }
            }
         System.out.printf("%n");
         System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
     }
    }
   
    public static void main(String[] args) {
      //calls the methods to generate members and instructors
      PGAInstructor[] PGAs  = generatePGA();
      Member[] members = generateMembers();
      //displays the main menu 
      System.out.println("-----------------------------------------");
      System.out.println("Golf Club System");
      System.out.println("-----------------------------------------");
      System.out.println("Book one to one tuition ................1");
      System.out.println("Book junior group tuition ..............2");
      System.out.println("List instructor bookings................3");
      System.out.println("List member bookings....................4");
      System.out.println("Exit....................................0");
      System.out.println("-----------------------------------------");
      //asks user to select one option
      int optNumber = optSelector(4);
      //based on user input the program do the following
      switch (optNumber) {
        //if the selected option is 0 then exits the program
        case 0:
          System.out.println("Golf club system exited successfuly!!");
          break;
        //if the selected option is 1 then display a list of members
        case 1:
          System.out.println("-------------------------------------------");
          System.out.println("List of members");
          System.out.println("-------------------------------------------");
          for (int i = 0; i < members.length; i++) {
             System.out.printf("|  %-5s  |  %-8s  |  %-14s  |%n", i + 1, members[i].getName(), members[i].getMemberType());
          }
          System.out.println("-------------------------------------------");
          //asks to select a member from the list
          optNumber = optSelector(members.length);
          if (optNumber == 0) {
             System.out.println("Golf club system exited successfuly!!");
             break;
          }
          Member selectedMember = members[optNumber - 1];
          //displays a list of instructors
          System.out.println("-------------------------------------------");
          System.out.println("List of PGA instructors");
          System.out.println("-------------------------------------------");          
          for (int j = 0; j < PGAs.length; j++) {
             System.out.printf("|  %-5s  |  %-8s  |  %-14s  |%n", j + 1, PGAs[j].getName(), "Level : " + PGAs[j].getCoachingLevel());
          }
          System.out.println("-------------------------------------------");
          //asks to choose an instructor
          optNumber = optSelector(PGAs.length);
          if (optNumber == 0) {
             System.out.println("Golf club system exited successfuly!!");
             break;
          }
          PGAInstructor selectedPGA = PGAs[optNumber - 1];
          //for the selected instructor displays his schedule for the week
          oneToOneSchedule(selectedPGA);
          //asks to enter a day
          String getDay = askDay();
          //asks to enter a time
          String getTime = askTime();
          //checks if in the selected day and time there is a booking
          boolean available = checkDate(getDay, getTime, selectedPGA);
          //if there is not a bookibng then makes one for the selected member and instructor
          if (available) {
             OneToOneLesson class1 = new OneToOneLesson();
             Booking booking1 = new Booking("Monday", "14", selectedPGA, class1);
             booking1.getTuition().setMembers(selectedMember);
             selectedPGA.setBooking(booking1);
             selectedMember.setBooking(booking1);
             System.out.println("Your lesson has been booked succesfully!!");
          }
          //if there is a booking then displays a message and exits the program
          else {
             System.out.println("There is already a booking in the selected date!!");
          }
          
          break;
        case 2:
          //displays a list of junior members
          System.out.println("-------------------------------------------");
          System.out.println("List of junior members");
          System.out.println("-------------------------------------------");
          Member[] juniorMembers = juniorMembers(members);
          System.out.println("-------------------------------------------"); 
          optNumber = optSelector(juniorMembers.length);
          if (optNumber == 0) {
             System.out.println("Golf club system exited successfuly!!");
             break;
          }
          //asks to choose a junior member
          selectedMember = juniorMembers[optNumber - 1];
          //checks if the selected member has more then one group lesson booked
          boolean checkBookings = memberGroupLessons(selectedMember);
          if (checkBookings) {
            System.out.println("The selected member already has two group lessons booked this week!!");
            break; 
          }
          PGAInstructor[] level3PGAs = level3PGAs(PGAs);
          //gets the level 3 instructors and checks they have any group lesson booking 
          groupSchedule(level3PGAs);    
          getDay = askDay();
          getTime = askTime();

          available = checkDate2(getDay, getTime, level3PGAs);
          //if there is group lesson in the selected day, time and with spaces available then books a group lesson for the junior member
          if (available) {
            Booking groupBooking = groupBooking(getDay, getTime, level3PGAs);
            groupBooking.getTuition().setMembers(selectedMember);
            groupBooking.getTuition().setSpacesAvailable();
            selectedMember.setBooking(groupBooking);
            System.out.println("Your group lesson has been booked succesfully!!");
          }
          //if not exits the program
          else {
            System.out.println("Unable to book a group lesson in the selected day!!");
          }                               
          break;
        case 3:
          //displays a list of instructors
          System.out.println("-------------------------------------------");
          System.out.println("List of PGA instructors");
          System.out.println("-------------------------------------------");          
          for (int j = 0; j < PGAs.length; j++) {
             System.out.printf("|  %-5s  |  %-8s  |  %-14s  |%n", j + 1, PGAs[j].getName(), "Level : " + PGAs[j].getCoachingLevel());
          }
          System.out.println("-------------------------------------------");
          //asks to select an instructor
          optNumber = optSelector(PGAs.length);
          if (optNumber == 0) {
             System.out.println("Golf club system exited successfuly!!");
             break;
          }
          //displays a table with all the bookings of the selected instructor 
          selectedPGA = PGAs[optNumber - 1];
          oneToOneSchedule(selectedPGA);
          //if the selected instructor is level 3 and has group lesson bookings then display the members taking these lessons
          if (selectedPGA.getCoachingLevel() == 3) {
             groupMembers(selectedPGA);
          }
          break;
        case 4:
          //displays a list of members
          System.out.println("-------------------------------------------");
          System.out.println("List of members");
          System.out.println("-------------------------------------------");
          for (int i = 0; i < members.length; i++) {
             System.out.printf("|  %-5s  |  %-8s  |  %-14s  |%n", i + 1, members[i].getName(), members[i].getMemberType());
          }
          System.out.println("-------------------------------------------");
          //asks to choose a member 
          optNumber = optSelector(members.length);
          if (optNumber == 0) {
             System.out.println("Golf club system exited successfuly!!");
             break;
          }
          selectedMember = members[optNumber - 1];
          //displays a table with all the bookings of the selected member
          memberBookings(selectedMember);
          break;
      }
    }

}
