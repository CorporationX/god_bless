package faang.school.godbless.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        university.setStudentGrades(prepareStudentsWithDefaultGrades(List.of(
                new Student(1L, "Trevor"),
                new Student(2L, "Marco"),
                new Student(3L, "Nate")
        )));
        university.printStudentGrades();
        System.out.println("=========================");
        university.setStudentsBySubjects(prepareSubjectsWithStudents());
        university.printAllSubjects();
    }

    private static Map<Subject, Integer> prepareDefaultGrades() {
        Map<Subject, Integer> subjectIntegerMap = Map.of(
                new Subject(1L, "Math"), 5,
                new Subject(2L, "Physics"), 4,
                new Subject(3L, "English"), 5,
                new Subject(4L, "PE"), 4
        );
        return new HashMap<>(subjectIntegerMap);
    }

    private static Map<Student, Map<Subject, Integer>> prepareStudentsWithDefaultGrades(List<Student> students) {
        Map<Student, Map<Subject, Integer>> studentsWithDefaultGrades = new HashMap<>();
        for (Student student : students) {
            studentsWithDefaultGrades.put(student, prepareDefaultGrades());
        }
        return new HashMap<>(studentsWithDefaultGrades);
    }

    private static Map<Subject, List<Student>> prepareSubjectsWithStudents() {
        List<Student> students = List.of(
                new Student(1L, "Trevor"),
                new Student(2L, "Marco"),
                new Student(3L, "Nate")
        );

        Subject math = new Subject(1L, "Math");
        Subject physics = new Subject(2L, "Physics");
        Subject english = new Subject(3L, "English");
        return new HashMap<>(Map.of(
                math, new ArrayList<>(students),
                physics, new ArrayList<>(students),
                english, new ArrayList<>(students)
        ));
    }
}
