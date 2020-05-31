package schoolproject;

import java.util.Locale;
import java.util.ArrayList;

public class Course {

    private String title;
    private String stream;
    private String type;
    private String startDate;
    private String endDate;

    private ArrayList<Trainer> trainers;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> students;

    public Course(String title, String stream, String type, String startDate, String endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public Course(ArrayList<Trainer> trainers, ArrayList<Assignment> assignments, ArrayList<Student> students) {
        this.trainers = trainers;
        this.assignments = assignments;
        this.students = students;
    }

    
    
    
    
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" + "title:" + title + ", stream:" + stream + ", type:" + type + ", startDate:" + startDate + ", endDate:" + endDate + '}';
    }

    void addStudent(Student s) {
        students.add(s);
    }
    void addTrainer(Trainer t){
    trainers.add(t);
    }
    void addAssignment(Assignment a){
    assignments.add(a);
    }
   void printStudents(){
   for(Student s:students){
       System.out.println(s.getFirstName()+" " +s.getLastName());
   }
   }

   void printTrainers() {
    for(Trainer t:trainers){
       System.out.println(t.getFirstName()+" " +t.getLastName());
   }
   }
    void printAssignments() {
        for(Assignment a:assignments){
       System.out.println(a.getTitle());
    }
    }
       public boolean hasStudent(Student s){
        for (Student student:students){
          if(student==s){
          return true;
          }
        }
        return false;
       }
}
