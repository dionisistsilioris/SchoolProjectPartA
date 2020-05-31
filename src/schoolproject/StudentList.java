package schoolproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> allStudents;

    public StudentList() {
        allStudents = new ArrayList<>();
    }

    public StudentList(ArrayList<Student> allStudents) {
        this.allStudents = allStudents;
    }

    // a list from sample students
    public void loadSampleData(AssignmentList assignments) {
        allStudents.add(new Student("Dionisis", "Tsilioris", "10/08/1987", 2500));
        allStudents.add(new Student("Dimitris", "Tselios", "12/01/1986", 2500));
        allStudents.add(new Student("Despoina", "Marouli", "20/06/1987", 2500));
        allStudents.add(new Student("George", "Lappas", "28/07/1988", 2500));
        allStudents.add(new Student("Philipos", "Kontekas", "03/12/1986", 2500));
        allStudents.add(new Student("Dionisia", "Vikatou", "25/04/1987", 2200));
        allStudents.add(new Student("Vaggelis", "Skandalis", "24/04/1986", 2200));
        allStudents.add(new Student("Kostas", "Augeros", "19/03/1987", 2200));
        allStudents.add(new Student("Antonis", "Karras", "26/10/1986", 2200));
        allStudents.add(new Student("Ioanna", "Lerataki", "17/02/1987", 2200));
        allStudents.add(new Student("Panos", "Vgenopoulos", "15/11/1987", 2200));
    }

    // to print all the students
    public void printAll() {
        System.out.println("ALL STUDENTS");
        for (Student s : allStudents) {
            System.out.println(s.toString());
        }
    }

    public Student find(String firstName, String lastName) {
        for (Student s : allStudents) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public void addStudent() {
        Scanner scan = new Scanner(System.in);
        String firstName;
        String lastName;
        String dateOfBirth;
        double touitionFees;
        String answer;

        do {
            do {
                System.out.print("please enter your first name: ");
                firstName = scan.nextLine();
            } while (!validName(firstName));

            do {
                System.out.println("please enter your last name: ");
                lastName = scan.nextLine();
            } while (!validName(lastName));
            do {
                System.out.println("please enter your birth date");
                System.out.println("the date must be such day-Month-year");
                dateOfBirth = scan.nextLine();
            } while (!validDate(dateOfBirth));
            do {
                System.out.println("please enter the touition fees");
                touitionFees = scan.nextDouble();
                scan.nextLine();
            } while (!validFee(touitionFees));

            Student s = new Student(firstName, lastName, dateOfBirth, touitionFees);
            allStudents.add(s);

             System.out.println("do you want to continue yes or no");
            answer = scan.nextLine();
        } while (!validQuestion(answer));
    }

    public boolean validQuestion(String answer) {

        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } 
        else {
            System.out.println("student addition completed.");
            return false;
        }
    }

    public boolean validName(String name) {
        if (name.length() > 1 && name.matches("[a-zA-Z]*")) {
            return true;
        } else {
            System.out.println("wrong!please enter again your data");
            return false;
        }
    }

    public boolean validFee(double fee) {
        if (fee < 0) {
            System.out.println("wrong touition fees!please enter again touition fees");
            return false;
        } else {
            return true;
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
            System.out.println("wrong date!please enter again date of birth");
            return false;
        }
    }

      public Course find(String title) {
        Iterable<Course> allCourses = null;
        for (Course c : allCourses) {
            if (c.getTitle().equals(title)) {
                return c;
            }
        }
        return null;
    }

}
