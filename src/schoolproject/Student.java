package schoolproject;

import java.util.ArrayList;
import java.util.Locale;

public class Student {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double tuitionFees;
    private ArrayList<Course>courses;
    private ArrayList<Assignment> assignments;
    
    
    public Student(String firstName, String lastName, String dateOfBirth, double tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public Student(ArrayList<Course> courses, ArrayList<Assignment> assignments) {
        this.courses = courses;
        this.assignments = assignments;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    
    
    
    Student(String name) {
        
    }

    Student(String firstName, String lastName, Locale dateOfBirth, double touitionFees) {
       
    }
  
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName:" + firstName + ", lastName:" + lastName + ", dateOfBirth:" + dateOfBirth + ", tuitionFees:" + tuitionFees + '}';
    }

}
