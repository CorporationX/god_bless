package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final StudentDatabase studentDatabase = new StudentDatabase(new HashMap<>(), new HashMap<>());

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

        studentDatabase.addStudentWithGrades(alice, aliceGrades);
        studentDatabase.addStudentWithGrades(bob, bobGrades);

        studentDatabase.addNewSubjectToStudent(alice, history, 90);

        studentDatabase.addStudentToSubject(charlie, history);

        studentDatabase.addNewSubjectAndStudents(chemistry, List.of(bob, charlie));

        studentDatabase.deleteStudentFromSubject(history, alice);

        studentDatabase.deleteStudent(bob);

        studentDatabase.printAllStudentsWithGrades();
        studentDatabase.printAllSubjectsWithStudents();
    }
}
