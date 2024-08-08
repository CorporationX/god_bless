package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentsAndGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectsAndStudents = new HashMap<>();

    public static void main(String[] args) {
        Student Alice = new Student(1, "Alice");
        Student Bob = new Student(2, "Bob");
        Student Charlie = new Student(3, "Charlie");

        Subject maths = new Subject(101, "Mathematics");
        Subject physics = new Subject(102, "Physics");
        Subject biology = new Subject(103, "Biology");
        Subject science = new Subject(104, "Science");

        addStudentAndSubject(Alice, maths, 5);
        addStudentAndSubject(Bob, maths, 4);
        addStudentAndSubject(Charlie, physics, 3);
        addStudentAndSubject(Alice, biology, 2);
        addStudentAndSubject(Bob, physics, 4);
        addStudentAndSubject(Charlie, biology, 3);

        printStudentsAndGrades();
        printSubjectsAndStudents();

        addSubjectToStudent(Bob, science, 4);
        addSubjectToStudent(Alice, science, 5);
        addSubjectToStudent(Charlie, science, 3);

        printStudentsAndGrades();
        printSubjectsAndStudents();

        removeStudent(Bob);

        printStudentsAndGrades();
        printSubjectsAndStudents();

        List<Student> newStudents = new ArrayList<>(List.of(
                new Student(5, "David"),
                new Student(6, "Eve"),
                Alice)
        );

        Subject sports = new Subject(105, "Sports");

        addSubjectAndStudents(sports, newStudents);

        System.out.println("All students have been added.\n");
        printStudentsAndGrades();
        printSubjectsAndStudents();

        addStudentToExistingSubject(Alice, physics, 4);

        System.out.println("All students have been added.\n");
        printStudentsAndGrades();
        printSubjectsAndStudents();

        removeStudentFromSubject(Alice, maths);

        System.out.println("After Alice has been removed.\n");
        printStudentsAndGrades();
        printSubjectsAndStudents();
    }

    public static void addStudentAndSubject(Student student, Subject subject, int grade) {
        studentsAndGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentsAndGrades.get(student).put(subject, grade);
        subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentsAndGrades.remove(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                subjectsAndStudents.get(subject).remove(student);
            }
        }
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        subjectsAndStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentsAndGrades.putIfAbsent(student, new HashMap<>());
            studentsAndGrades.get(student).put(subject, 0); // Отметка 0 по умолчанию
        }
    }

    public static void addStudentToExistingSubject(Student student, Subject subject, int grade) {
        subjectsAndStudents.get(subject).add(student);
        studentsAndGrades.putIfAbsent(student, new HashMap<>());
        studentsAndGrades.get(student).put(subject, grade);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectsAndStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectsAndStudents.remove(subject);
            }
        }
        Map<Subject, Integer> subjects = studentsAndGrades.get(student);
        if (subjects != null) {
            subjects.remove(subject);
            if (subjects.isEmpty()) {
                studentsAndGrades.remove(student);
            }
        }
    }

    public static void printStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsAndGrades.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Subject, Integer> grades : entry.getValue().entrySet()) {
                System.out.println("  " + grades.getKey() + ": " + grades.getValue());
            }
        }
    }

    public static void printSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectsAndStudents.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }
}
