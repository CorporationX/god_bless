package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        final StudentDatabase database = new StudentDatabase();
        final Student ivan = new Student("Ivan Ivanov");
        final Student mary = new Student("Mary Smith");
        final Student john = new Student("John Smith");
        final Student james = new Student("James Smith");

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");

        Map<Subject, Integer> subjectsForIvan = new HashMap<>();
        subjectsForIvan.put(math, 5);
        subjectsForIvan.put(physics, 4);
        subjectsForIvan.put(chemistry, 5);
        database.addStudentWithGrades(ivan, subjectsForIvan);

        Map<Subject, Integer> subjectsForMary = new HashMap<>();
        subjectsForMary.put(math, 3);
        database.addStudentWithGrades(mary, subjectsForMary);
        database.addSubjectToStudent(mary, physics, 5);

        List<Student> students = List.of(john, james, mary);
        Subject biology = new Subject("Biology");
        database.addSubject(biology, students);

        database.printAllSubjects();
        database.printAllStudentGrades();

        database.removeStudent(ivan);
    }
}
