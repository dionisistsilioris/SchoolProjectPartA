package schoolproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentList {

    private ArrayList<Assignment> allAssignments;

    public AssignmentList() {
        allAssignments = new ArrayList<>();
    }

    public AssignmentList(ArrayList<Assignment> allAssignments) {
        this.allAssignments = allAssignments;
    }

    public void loadSampleData(CourseList Courses) {
        allAssignments.add(new Assignment("private school", "java10", "30-04-2020", 15 / 100, 80 / 100));
        allAssignments.add(new Assignment("bank app", "java10", "01-05-2020", 20 / 100, 75 / 100));
        allAssignments.add(new Assignment("maps app", "java10", "15-05-2020", 25 / 100, 65 / 100));
        allAssignments.add(new Assignment("super market", "c#", "29-05-2020", 20 / 100, 80 / 100));
        allAssignments.add(new Assignment("online shop", "c#", "10-06-2020", 12 / 100, 74 / 100));
        allAssignments.add(new Assignment("delivery app", "c#", "17-06-2020", 18 / 100, 72 / 100));

    }

    public void printAll() {
        System.out.println("ALL ASSIGNMENTS");
        for (Assignment a : allAssignments) {
            System.out.println(a.toString());
        }
    }

    public Assignment find(String title) {
        for (Assignment a : allAssignments) {
            if (a.getTitle().equals(title)) {
                return a;
            }
        }
        return null;
    }

    public void addAssignment() {
        Scanner scan = new Scanner(System.in);

        String title;
        String description;
        String subDateTime;
        double oralMark;
        double totalMark;
        String answer;

        do {
            
                System.out.println("please enter the title of assignment");
                title = scan.nextLine();
            
            
                System.out.println("please enter the description of assignment");
                description = scan.nextLine();
            
            do {
                System.out.println("please enter the sub date time");
                subDateTime = scan.nextLine();
            } while (!validDate(subDateTime));
            do {
                System.out.println("please enter the oral mark");
                oralMark = scan.nextDouble();
                scan.nextLine();
            } while (!validMark(oralMark));
            do {
                System.out.println("please enter the total mark");
                totalMark = scan.nextDouble();
                scan.nextLine();
            } while (!validMark(totalMark));

            Assignment a = new Assignment(title, description, subDateTime, oralMark, totalMark);
            allAssignments.add(a);

            System.out.println("do you want to continue yes or no");
            answer = scan.nextLine();
        } while (!validQuestion(answer));
    }

    public boolean validQuestion(String answer) {

        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Assignment addition completed.");
            return false;
        }
    }

    public boolean validName(String name) {
        if (name.length() > 1 && name.matches("[a-zA-Z]*")) {
            return true;
        } else {
            System.out.println("wrong!please enter again assignment's data");
            return false;
        }
    }

    public boolean validDate(String date) {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("wrong date!please enter again the sub date time");
            return false;
        }
    }

    public boolean validMark(double mark) {
        if (mark < 0) {
            System.out.println("wrong mark!please enter again mark");
            return false;
        } else {
            return true;
        }
    }


}
