package school.faang.double_cash_cash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Student alice = new Student("Alice");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");

        Map<Subject, Integer> aliceSubjects = new HashMap<>();
        aliceSubjects.put(math, 90);
        aliceSubjects.put(physics, 85);
        db.addStudentWithSubjects(alice, aliceSubjects);

        Student bob = new Student("Bob");
        Map<Subject, Integer> bobSubjects = new HashMap<>();
        bobSubjects.put(math, 75);
        db.addStudentWithSubjects(bob, bobSubjects);

        Subject chemistry = new Subject("Chemistry");
        db.addSubjectForStudent(bob, chemistry, 80);

        Student charlie = new Student("Charlie");
        List<Student> chemStudents = new ArrayList<>();
        chemStudents.add(alice);
        chemStudents.add(charlie);
        db.addSubjectWithStudents(chemistry, chemStudents);

        db.addStudentToSubject(math, charlie, 70);

        db.removeStudentFromSubject(chemistry, alice);

        db.removeStudent(bob);

        System.out.println("Список студентов и их оценки:");
        db.printAllStudents();

        System.out.println("\nСписок предметов и студентов:");
        db.printAllSubjects();
    }
}
