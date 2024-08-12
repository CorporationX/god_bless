package faang.school.godbless.BJS2_19882;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Student, Map<Subject, Integer>> studentAndGrades = new HashMap<>();
    private static Map<Subject, List<Student>> subjectsToStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(0, "Vasya");
        Student student2 = new Student(1, "Petya");
        Student student3 = new Student(2, "Lesha");

        Subject math = new Subject(0, "Math");
        Subject english = new Subject(1, "English");
        Subject chemistry = new Subject(2, "Chemistry");


        // studentAndGrades map
        addStudentAndGrades(student1, new HashMap<>(Map.of(math, 2, chemistry, 4)));
        addSubjectAndGradeFor(student1, english, 5);

        printStudentAndGrades();
        System.out.println();

        deleteStudentAndGrades(student1);

        // subjectsToStudents map

        addSubjectToStudents(math, new ArrayList<>(List.of(student1, student2)));
        addSubjectToStudents(chemistry, new ArrayList<>(List.of(student1, student3)));
        addStudentToSubject(student3, math);

        printSubjectToStudents();

        deleteStudentFromSubject(student3, math);


    }

    // for studentAndGrades map

    private static void addStudentAndGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null) {
            System.out.println("student is null, parameters was not added");
            return;
        }
        studentAndGrades.computeIfAbsent(student, k -> new HashMap<>(grades));
    }

    private static void addSubjectAndGradeFor(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("student or subject is null, parameters adding failed");
        }
        if (!studentAndGrades.containsKey(student)) {
            throw new RuntimeException("student does not exist, parameters was not added");
        }
        if (studentAndGrades.get(student).containsKey(subject)) {
            throw new RuntimeException("subject grades are already exist for this student, parameters was not added");
        }

        studentAndGrades.get(student).put(subject, grade);
    }

    private static void deleteStudentAndGrades(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student is null, student was not deleted");
        }
        if (!studentAndGrades.containsKey(student)) {
            throw new RuntimeException("student does not exist, student was not deleted");
        }

        studentAndGrades.remove(student);
    }

    private static void printStudentAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentAndGrades.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println("  - " + entry1.getKey() + ": " + entry1.getValue());
            }
        }
    }

    // for subjectsToStudents map

    private static void addSubjectToStudents(Subject subject, List<Student> studentList) {
        if (subject == null || studentList == null) {
            throw new IllegalArgumentException("subject or studentList is null, parameters adding failed");
        }
        if (subjectsToStudents.containsKey(subject)) {
            throw new RuntimeException("Subject is already exists, parameters adding failed");
        }

        subjectsToStudents.put(subject, studentList);
    }

    private static void addStudentToSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("student or subject is null, parameters adding failed");
        }
        if (subjectsToStudents.get(subject).contains(student)) {
            throw new RuntimeException("student for this subject is already exists, parameters adding failed");
        }
        subjectsToStudents.get(subject).add(student);
    }

    private static void deleteStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("student or subject is null, parameters adding failed");
        }
        if (!subjectsToStudents.get(subject).contains(student)) {
            throw new RuntimeException("student for this subject does not exist, student was not deleted");
        }

        subjectsToStudents.get(subject).remove(student);
    }

    private static void printSubjectToStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectsToStudents.entrySet()) {
            System.out.println(entry.getKey().getName() + "--------");
            entry.getValue().forEach(System.out::println);
        }
    }
}
