package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final StudentDatabase db = new StudentDatabase(new HashMap<>(), new HashMap<>());

        final Student alice = new Student("Alice");
        final Student bob = new Student("Bob");
        final Student charlie = new Student("Charlie");

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        final Subject history = new Subject("History");
        final Subject chemistry = new Subject("Chemistry");

        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 95);
        aliceGrades.put(physics, 88);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(math, 77);

        db.addStudentWithGrades(alice, aliceGrades);
        db.addStudentWithGrades(bob, bobGrades);

        db.addNewSubjectToStudent(alice, history, 90);

        db.addStudentToSubject(charlie, history);

        db.addNewSubjectAndStudents(chemistry, List.of(bob, charlie));

        db.deleteStudentFromSubject(history, alice);

        db.deleteStudent(bob);

        db.printAllStudentsWithGrades();
        db.printAllSubjectsWithStudents();
    }
}
