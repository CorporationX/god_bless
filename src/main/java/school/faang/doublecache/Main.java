package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        final Subject math = new Subject("Math");
        final Subject english = new Subject("English");

        final Student john = new Student("John");
        final Student jane = new Student("Jane");
        final Student mike = new Student("Mike");

        StudentDatabase studentDatabase = new StudentDatabase();

        Map<Subject, Integer> johnGrades = new HashMap<>();
        johnGrades.put(math, 4);
        johnGrades.put(english, 5);
        studentDatabase.addStudentWithGrades(john, johnGrades);

        Map<Subject, Integer> janeGrades = new HashMap<>();
        janeGrades.put(english, 4);
        janeGrades.put(new Subject("History"), 3);
        studentDatabase.addStudentWithGrades(jane, janeGrades);

        System.out.println("Все студенты с оценками:");
        studentDatabase.printAllStudentsWithGrades();

        studentDatabase.addSubjectForStudent(mike, math, 4);

        studentDatabase.addStudentToSubject(mike, english);

        final Subject history = new Subject("History");
        List<Student> studentsForHistory = List.of(john, jane);
        studentDatabase.addSubjectWithStudents(history, studentsForHistory);

        System.out.println("Все предметы с их студентами:");
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudentFromSubject(john, english);

        System.out.println("Все предметы с их студентами после удаления:");
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.removeStudent(john);

        System.out.println("Все студенты с оценками после удаления:");
        studentDatabase.printAllStudentsWithGrades();
    }
}