package bjs2_32393;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    public static Map<Subject, List<Student>> groups = new HashMap<>();

    public static void main(String[] args) {
        Student st1 = new Student(1, "st1");
        Student st2 = new Student(2, "st2");
        Student st3 = new Student(3, "st3");
        Student st4 = new Student(4, "st4");

        Subject sub1 = new Subject(1, "sub1");
        Subject sub2 = new Subject(2, "sub2");
        Subject sub3 = new Subject(3, "sub3");

        addStudent(st1, new HashMap<>(Map.of(sub1, 4, sub2, 5, sub3, 5)));
        addStudent(st2, new HashMap<>(Map.of(sub1, 3, sub2, 4)));
        addStudent(st3, new HashMap<>(Map.of(sub1, 2, sub2, 3, sub3, 2)));

        printAllGrades();
        System.out.println("=============");
        deleteStudent(st3);
        printAllGrades();
        System.out.println("=============");
        addSubjectAndGrade(st2, sub3, 4);
        printAllGrades();
        System.out.println();
        System.out.println();

        addSubjectAndStudents(sub1, new ArrayList<>(List.of(st1, st2)));
        addSubjectAndStudents(sub2, new ArrayList<>(List.of(st1, st2, st3)));
        printAllGroups();
        System.out.println("=============");
        addStudentToSubject(sub2, st4);
        printAllGroups();
        System.out.println("=============");
        deleteStudentFromSubject(sub1, st1);
        printAllGroups();

    }

    public static void addStudent(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
    }

    public static void addSubjectAndGrade(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
        }
    }

    public static void deleteStudent(Student student) {
        studentGrades.remove(student);
    }

    public static void printAllGrades() {
        for (var entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        groups.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        List<Student> students = groups.get(subject);
        if (students != null) {
            students.add(student);
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student student) {
        List<Student> students = groups.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    public static void printAllGroups() {
        for (var entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
