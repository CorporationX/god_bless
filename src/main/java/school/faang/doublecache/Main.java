package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Subject math = new Subject("Math");
        Subject english = new Subject("English");
        Subject history = new Subject("History");

        Student john = new Student("John");
        Student jane = new Student("Jane");
        Student mike = new Student("Mike");

        StudentDatabase studentDatabase = new StudentDatabase();

        Map<Subject, Integer> johnGrades = new HashMap<>();
        johnGrades.put(math, 4);
        johnGrades.put(english, 5);
        studentDatabase.addStudentWithGrades(john, johnGrades);

        Map<Subject, Integer> janeGrades = new HashMap<>();
        janeGrades.put(english, 4);
        janeGrades.put(history, 3);
        studentDatabase.addStudentWithGrades(jane, janeGrades);

        System.out.println("All students with grades:");
        studentDatabase.printAllStudentsWithGrades();

        studentDatabase.addSubjectForStudent(mike, math, 4);

        studentDatabase.addStudentToSubject(mike, english);

        List<Student> studentsForHistory = List.of(john, jane);
        studentDatabase.addSubjectWithStudents(history, studentsForHistory);

        System.out.println("All subjects with students:");
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudentFromSubject(john, english);

        System.out.println("All subjects with students after removal:");
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudent(john);

        System.out.println("All students with grades after removal:");
        studentDatabase.printAllStudentsWithGrades();
    }
}