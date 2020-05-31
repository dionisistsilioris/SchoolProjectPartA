package schoolproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TrainerList {

    private ArrayList<Trainer> allTrainers;

    public TrainerList() {
        allTrainers = new ArrayList<>();
    }

    public void loadSampleData() {
        allTrainers.add(new Trainer("George", "Irakleidis", "java"));
        allTrainers.add(new Trainer("George", "Pasparakis", "java"));
        allTrainers.add(new Trainer("Nick", "Karapas", "c#"));
        allTrainers.add(new Trainer("Anastasios", "Lelakis", "c#"));
    }

    public void printAll() {
        System.out.println("ALL TRAINERS");
        for (Trainer t : allTrainers) {
            System.out.println(t.toString());
        }
    }

    public Trainer find(String firstName, String lastName) {
        for (Trainer t : allTrainers) {
            if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName)) {
                return t;
            }
        }
        return null;
    }

    public void addTrainer() {
        Scanner scan = new Scanner(System.in);
        String firstName;
        String lastName;
        String subject;
        String answer;

        do {
            do {
                System.out.println("please enter the first name of trainer");
                firstName = scan.nextLine();
            } while (!validName(firstName));
            do {
                System.out.println("please enter the last name of trainer");
                lastName = scan.nextLine();
            } while (!validName(lastName));
            do {
                System.out.println("please enter the subject");
                subject = scan.nextLine();
            } while (!validName(subject));

            Trainer t = new Trainer(firstName, lastName, subject);
            allTrainers.add(t);

            System.out.println("do you want to continue yes or no");
            answer = scan.nextLine();
        } while (!validQuestion(answer));
    }

    public boolean validQuestion(String answer) {

        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Trainer addition completed.");
            return false;
        }
    }

    public boolean validName(String name) {
        if (name.length() > 1 && name.matches("[a-zA-Z]*")) {
            return true;
        } else {
            System.out.println("wrong!please enter again trainer's data");
            return false;
        }
    }

}
