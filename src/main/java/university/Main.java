package university;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final StudentDatabase studentDatabase = new StudentDatabase();

        final Student harry = new Student("Harry Potter");
        final Student hermione = new Student("Hermione Granger");
        final Student ron = new Student("Ron Weasley");
        final Student draco = new Student("Draco Malfoy");

        final Subject charms = new Subject("Charms");
        final Subject transfiguration = new Subject("Transfiguration");
        final Subject potions = new Subject("Potions");
        final Subject defense = new Subject("Defense Against the Dark Arts");

        Map<Subject, Integer> harrySubjectsAndGrades = new HashMap<>();
        harrySubjectsAndGrades.put(charms, 5);
        harrySubjectsAndGrades.put(transfiguration, 4);
        harrySubjectsAndGrades.put(potions, 3);
        studentDatabase.addStudent(harry, harrySubjectsAndGrades);

        Map<Subject, Integer> hermioneSubjectsAndGrades = new HashMap<>();
        hermioneSubjectsAndGrades.put(charms, 5);
        hermioneSubjectsAndGrades.put(transfiguration, 5);
        hermioneSubjectsAndGrades.put(defense, 5);
        studentDatabase.addStudent(hermione, hermioneSubjectsAndGrades);

        Map<Subject, Integer> ronSubjectsAndGrades = new HashMap<>();
        ronSubjectsAndGrades.put(potions, 3);
        ronSubjectsAndGrades.put(defense, 3);
        studentDatabase.addStudent(ron, ronSubjectsAndGrades);

        System.out.println("All students and their grades:");
        studentDatabase.printAllStudentsAndSubjects();

        System.out.println("\nAdding new subject for Harry: Defense Against the Dark Arts");
        studentDatabase.addSubjectForStudent(harry, defense, 4);

        System.out.println("\nAll students after update");
        studentDatabase.printAllStudentsAndSubjects();

        System.out.println("\nEnrolling Draco in Potions");
        studentDatabase.addStudentToSubject(draco, potions);
        studentDatabase.addSubjectForStudent(draco, potions, 4);

        System.out.println("\nAll students after update");
        studentDatabase.printAllStudentsAndSubjects();

        System.out.println("\nAll subjects and students:");
        studentDatabase.printAllSubjectsAndStudents();

        System.out.println("\nRemoving Ron from Potions");
        studentDatabase.removeStudentFromSubject(ron, potions);

        System.out.println("\nAll subjects and students after update");
        studentDatabase.printAllSubjectsAndStudents();

        System.out.println("\nRemoving Harry from the database");
        studentDatabase.deleteStudent(harry);

        System.out.println("\nAll students after update");
        studentDatabase.printAllStudentsAndSubjects();
    }
}


