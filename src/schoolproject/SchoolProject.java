package schoolproject;
//Dionisis Tsilioris
//first project cb10 part time java
//private school part A


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolProject {

    private StudentList students;
    private CourseList courses;
    private AssignmentList assignments;
    private TrainerList trainers;

    public SchoolProject() {

        students = new StudentList();
        courses = new CourseList();
        assignments = new AssignmentList();
        trainers = new TrainerList();
    }

    public void loadSampleData() {
        students.loadSampleData(assignments);
        assignments.loadSampleData(courses);
        trainers.loadSampleData();
        courses.loadSampleData(students, trainers, assignments);
    }

    public void enterDataFromUser() {
        courses.addCourse();
        students.addStudent();
        assignments.addAssignment();
        trainers.addTrainer();
    }

    public void displayMenu() {
        System.out.println("1. if you want to see the students list");
        System.out.println("2. if you want to see the courses list");
        System.out.println("3. if you wantto see the assignments list");
        System.out.println("4. if you wantto see the trainers list");
        System.out.println("5. if you want to see students per course");
        System.out.println("6. if you want to see assignments per course");
        System.out.println("7. if you want to see trainers per course");
        System.out.println("8.if you want to see coures per student");
        System.out.println("9. if you want to see pending assignments");
        System.out.println("0. EXIT");
        System.out.print("-> ");

    }

    public void menu() {
        int choice=0;
        Scanner scan = new Scanner(System.in);
        do {
            displayMenu();
            try{
            choice = scan.nextInt();
            }
            catch(InputMismatchException ie)
            {
            scan.nextLine();
            choice=100;
            }
            switch (choice) {
                case (1):
                    students.printAll();
                    break;
                case (2):
                    courses.printAll();
                    break;
                case (3):
                    assignments.printAll();
                    break;
                case (4):
                    trainers.printAll();
                    break;
                case (5):
                    scan.nextLine(); // clean any existing new line
                    System.out.println("Student per course");
                    String title = scan.nextLine();
                    Course c = courses.find(title);
                    if (c == null) {
                        System.out.println("Course not found");
                    } else {
                        c.printStudents();
                    }

                    break;
                case (6):
                    scan.nextLine();
                    System.out.println("Assignment per course");
                    title = scan.nextLine();
                    Course co = courses.find(title);
                    if (co == null) {
                        System.out.println("Course not found");
                    } else {
                        co.printAssignments();
                    }

                    break;
                case (7):
                    scan.nextLine();
                    System.out.println("Trainers per course");
                    title= scan.nextLine();
                    Course cou = courses.find(title);
                    if (cou == null) {
                        System.out.println("Course not found");
                    } else {
                        cou.printTrainers();
                    }
                    break;
                case (8):
                    scan.nextLine();
                    System.out.println("Courses per student");
                    String firstName= scan.nextLine();
                    String lastName= scan.nextLine();
                    Student s =students.find(firstName, lastName);
                    if (s == null) {
                        System.out.println("Course not found");
                    } else {
                        courses.printStudentCourses(s);
                    }
                    break;
                      case 9:
                    scan.nextLine();
                    System.out.println("Give a date (dd-mm-yyyy)");
                    String d = scan.nextLine();
                    if(!students.validDate(d)) {
                        System.out.println("Invalid date");
                    }
                    else {
                        courses.printWeekAssignments(d);
                    }
                    break;
                case 100:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        SchoolProject school = new SchoolProject();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello welcome to our school");
        System.out.println("");
        System.out.println("please select one of the below category");
        System.out.println("1.sing up to our school;");
        System.out.println("2.information for our students ");
        int choise = scan.nextInt();
        if (choise == 1) {
            school.enterDataFromUser();
        } else {
            school.loadSampleData();
        }

        school.menu();

    }

}
