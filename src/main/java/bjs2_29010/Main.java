package bjs2_29010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentSubjectGrades = new HashMap<>();
        Map<Subject, List<Student>> subjectStudents = new HashMap<>();

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

        addStudent(studentSubjectGrades, studentJohn, johnGrades);
        addStudent(studentSubjectGrades, studentJack, jackGrades);
        addSubjectForStudent(studentSubjectGrades, studentJohn, calculus, 7);
        printAllStudentGrades(studentSubjectGrades);
        System.out.println();

        removeStudent(studentSubjectGrades, studentJack);
        printAllStudentGrades(studentSubjectGrades);
        System.out.println();

        addSubject(subjectStudents, acos, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(subjectStudents, machineLearning, new ArrayList<Student>() {{
            add(studentJohn);
            add(studentJack);
        }});
        addSubject(subjectStudents, math, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(subjectStudents, calculus, new ArrayList<Student>() {{
            add(studentJohn);
        }});
        addSubject(subjectStudents, english, new ArrayList<Student>() {{
            add(studentJohn);
            add(studentJack);
        }});
        addSubject(subjectStudents, law, new ArrayList<Student>() {{
            add(studentJack);
        }});
        addStudentToSubject(subjectStudents, math, studentJack);
        removeStudentFromSubject(subjectStudents, english, studentJohn);
        printAllSubjectsStudents(subjectStudents);
    }

    public static void addStudent(Map<Student, Map<Subject, Integer>> studentSubjectGrades,
                                  Student student,
                                  Map<Subject, Integer> subjectGrades) {
        studentSubjectGrades.put(student, subjectGrades);
    }

    public static void addSubjectForStudent(Map<Student, Map<Subject, Integer>> studentSubjectGrades,
                                            Student student,
                                            Subject subject,
                                            Integer grade) {
        studentSubjectGrades.get(student).put(subject, grade);
    }

    public static void removeStudent(Map<Student, Map<Subject, Integer>> studentSubjectGrades,
                                     Student student) {
        studentSubjectGrades.remove(student);
    }

    public static void printAllStudentGrades(Map<Student, Map<Subject, Integer>> studentSubjectGrades) {
        for (var entry : studentSubjectGrades.entrySet()) {
            System.out.printf("Student: %s -> Grades: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void addSubject(Map<Subject, List<Student>> subjectStudents,
                                  Subject subject,
                                  List<Student> students) {
        subjectStudents.put(subject, students);
    }

    public static void addStudentToSubject(Map<Subject, List<Student>> subjectStudents,
                                           Subject subject,
                                           Student student) {
        try {
            subjectStudents.get(subject).add(student);
        } catch (NullPointerException e) {
            System.out.println("Please enter an existing subject");
        }
    }

    public static void removeStudentFromSubject(Map<Subject, List<Student>> subjectStudents,
                                                Subject subject,
                                                Student student) {
        try {
            subjectStudents.get(subject).remove(student);
        } catch (NullPointerException e) {
            System.out.println("Please enter an existing subject");
        }
    }

    public static void printAllSubjectsStudents(Map<Subject, List<Student>> subjectStudents) {
       for (var entry : subjectStudents.entrySet()) {
           System.out.printf("Subject: %s -> Students: %s\n", entry.getKey(), entry.getValue());
       }
    }
}
