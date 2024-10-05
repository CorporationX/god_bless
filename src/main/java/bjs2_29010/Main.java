package bjs2_29010;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentSubjectGrades = new HashMap<>();
    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Subject math = new Subject(0, "Math");
        Subject acos = new Subject(1, "ACOS");
        Subject machineLearning = new Subject(2, "ML");
        Subject calculus = new Subject(3, "Calculus");
        Subject english = new Subject(5, "English");
        Subject law = new Subject(6, "Law");

        Student studentJohn = new Student(0, "John");
        Map<Subject, Integer> johnGrades = new HashMap<>() {{
            put(math, 10);
            put(acos, 8);
            put(machineLearning, 9);
        }};

        Student studentJack = new Student(1, "Jack");
        Map<Subject, Integer> jackGrades = new HashMap<>() {{
            put(math, 10);
            put(english, 6);
            put(law, 5);
            put(machineLearning, 6);
        }};

        addStudent(studentJohn, johnGrades);
        addStudent(studentJack, jackGrades);
        addSubjectForStudent(studentJohn, calculus, 7);
        printAllStudentGrades();
        System.out.println();

        removeStudent(studentJack);
        printAllStudentGrades();
        System.out.println();

        addSubject(acos, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(machineLearning, new ArrayList<Student>() {{
            add(studentJohn);
            add(studentJack);
        }});
        addSubject(math, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(calculus, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(english, new ArrayList<Student>() {{
            add(studentJohn);
            add(studentJack);
        }});
        addSubject(law, new ArrayList<Student>() {{
            add(studentJack);
        }});
        addStudentToSubject(math, studentJack);
        removeStudentFromSubject(english, studentJohn);
        printAllSubjectsStudents();
    }

    public static void addStudent(Student student, Map<Subject, Integer> subjectGrades) {
        studentSubjectGrades.put(student, subjectGrades);

        for (Subject subject : subjectGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public static void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentSubjectGrades.computeIfAbsent(student, k -> new HashMap<Subject, Integer>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        if (studentSubjectGrades.containsKey(student)) {
            Map<Subject, Integer> grades = studentSubjectGrades.remove(student);

            for (Subject subject : grades.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
        } else {
            System.out.println("Please make sure that the student exists");
        }
    }

    public static void printAllStudentGrades() {
        for (var entry : studentSubjectGrades.entrySet()) {
            System.out.printf("Student: %s -> Grades: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);

        for (Student student : students) {
            studentSubjectGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentSubjectGrades.computeIfAbsent(student, k -> new HashMap<Subject, Integer>()).put(subject, null);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectStudents.containsKey(subject) && studentSubjectGrades.containsKey(student)) {
            subjectStudents.get(subject).remove(student);
            studentSubjectGrades.get(student).remove(subject);
        } else {
            System.out.println("Something went wrong. Please make sure that both subject and user exist");
        }
    }

    public static void printAllSubjectsStudents() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.printf("Subject: %s -> Students: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
