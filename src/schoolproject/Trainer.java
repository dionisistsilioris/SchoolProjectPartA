package schoolproject;

import java.util.Locale;

public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;
    
    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
//
//  Trainer(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
//
//    Trainer() {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
    
    
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "firstName:" + firstName + ", lastName:" + lastName + ", subject:" + subject + '}';
    }

    
}
