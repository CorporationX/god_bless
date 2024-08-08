package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Subject subject1 = new Subject(101, "Mathematics");
        Subject subject2 = new Subject(102, "Physics");

        addStudent(student1);
        addStudent(student2);

        addSubjectToStudent(student1, subject1, 90);
        addSubjectToStudent(student1, subject2, 85);
        addSubjectToStudent(student2, subject1, 80);

        addSubject(subject1, Arrays.asList(student1, student2));
        addSubject(subject2, Collections.singletonList(student1));

        System.out.println("Students and their grades:");
        printStudentsAndGrades();

        System.out.println("\nSubjects and their students:");
        printSubjectsAndStudents();
    }

    public static void addStudent(Student student) {
        studentGrades.putIfAbsent(student, new HashMap<>());
    }

    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentGrades.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentGrades.remove(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }

    public static void addSubject(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).putIfAbsent(subject, 0); // Initial grade as 0
        }
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).putIfAbsent(subject, 0); // Initial grade as 0
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
        Map<Subject, Integer> subjects = studentGrades.get(student);
        if (subjects != null) {
            subjects.remove(subject);
            if (subjects.isEmpty()) {
                studentGrades.remove(student);
            }
        }
    }

    public static void printStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Subject, Integer> grades : entry.getValue().entrySet()) {
                System.out.println("  " + grades.getKey() + ": " + grades.getValue());
            }
        }
    }

    public static void printSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }
}
