package schoolproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import java.util.Scanner;

public class CourseList {

    private ArrayList<Course> allCourses;

    public CourseList() {
        allCourses = new ArrayList<>();
    }

    public CourseList(ArrayList<Course> allCourses) {
        this.allCourses = allCourses;
    }

    public void loadSampleData(StudentList students, TrainerList trainers, AssignmentList assignments) {
        Course temp = new Course("java", "bootcamp", "part time", "17/02/2020", "17/09/2020");
        temp.addStudent(students.find("Dionisis", "Tsilioris"));
        temp.addStudent(students.find("Dimitris", "Tselios"));
        temp.addStudent(students.find("Despoina", "Marouli"));
        temp.addStudent(students.find("George", "Lappas"));
        temp.addStudent(students.find("Philipos", "Kontekas"));
        temp.addTrainer(trainers.find("George", "Irakleidis"));
        temp.addTrainer(trainers.find("George", "Pasparakis"));
        temp.addAssignment(assignments.find("private school"));
        temp.addAssignment(assignments.find("bank app"));
        temp.addAssignment(assignments.find("maps app"));
        allCourses.add(temp);
        temp = new Course("c#", "bootcamp", "full time", "17/02/2020", "18/05/2020");
        temp.addStudent(students.find("Vaggelis", "Skandalis"));
        temp.addStudent(students.find("Kostas", "Augeros"));
        temp.addStudent(students.find("Antonis", "Karras"));
        temp.addStudent(students.find("Ioanna", "Lerataki"));
        temp.addStudent(students.find("Panos", "Vgenopoulos"));
        temp.addTrainer(trainers.find("Nick", "Karapas"));
        temp.addTrainer(trainers.find("Anastasios", "Lelakis"));
        temp.addAssignment(assignments.find("super market"));
        temp.addAssignment(assignments.find("online shop"));
        temp.addAssignment(assignments.find("delivery app"));
        allCourses.add(temp);
    }

    public void printAll() {
        System.out.println("ALL COURSES");
        for (Course c : allCourses) {
            System.out.println(c.toString());
        }
    }

    public Course find(String title) {
        for (Course c : allCourses) {
            if (c.getTitle().equals(title)) {
                return c;
            }
        }
        return null;
    }

    public void addCourse() {
        Scanner scan = new Scanner(System.in);
        String title;
        String stream;
        String type;
        String startDate;
        String endDate;
        String answer;

        do {

            System.out.println("please enter the course title.");
            title = scan.nextLine();

            System.out.println("please enter the course stream.");
            stream = scan.nextLine();

            System.out.println("please enter the course type.");
            System.out.println("please choise between part time or full time");
            type = scan.nextLine();

            do {
                System.out.println("please enter start date.");
                startDate = scan.nextLine();
            } while (!validDate(startDate));
            do {
                System.out.println("please enter end date.");
                endDate = scan.nextLine();
            } while (!validDate(endDate));

            Course s = new Course(title, stream, type, startDate, endDate);
            allCourses.add(s);

            System.out.println("do you want to continue yes or no");
            answer = scan.nextLine();
        } while (!validQuestion(answer));
    }

    public boolean validQuestion(String answer) {

        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("course addition completed.");
            return false;
        }
    }

    public boolean validName(String name) {
        if (name.length() > 1 && name.matches("[a-zA-Z]*")) {
            return true;
        } else {
            System.out.println("wrong!please enter again course's data");
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
            System.out.println("wrong date!please enter date");
            return false;
        }
    }

    public void printStudentCourses(Student s) {
        for (Course c : allCourses) {
            if (c.hasStudent(s)) {
                System.out.println(c.getTitle());
            }
        }
    }

    public void printWeekAssignments(String d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(d, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format, please try again");
            return;
        }

        DayOfWeek day = DayOfWeek.of(localDate.get(ChronoField.DAY_OF_WEEK));
        LocalDate mon = localDate;
        if (day.equals(DayOfWeek.MONDAY)) {
            mon = localDate;
        } else {
            mon = localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }

        LocalDate fri = mon.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        for (Course c : allCourses) {
            for (Assignment a : c.getAssignments()) {
                LocalDate deadline = LocalDate.parse(a.getSubDateTime(), formatter);
                if (deadline.isBefore(mon) || deadline.isAfter(fri)) {
                } else {
                    for (Student s : c.getStudents()) {
                        System.out.println(s.getLastName() + " " + a.getTitle());
                    }
                }
            }
        }
    }

}
