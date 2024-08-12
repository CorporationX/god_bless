package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> studentSubjectGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> students = new HashMap<>();

    public static void main(String[] args) {

        Subject math = new Subject(1, "Math");
        Subject science = new Subject(2, "Science");
        Subject english = new Subject(3, "English");

        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");
        Student charlie = new Student(3, "Charlie");

        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 85);
        aliceGrades.put(science, 90);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(math, 75);
        bobGrades.put(english, 80);

        addStudent(alice, aliceGrades);
        addStudent(bob, bobGrades);

        System.out.println("Initial student grades:");
        printStudentGrades();

        System.out.println("Students enrolled in each subject:");
        printStudent();


        addStudentToSubject(charlie, english);

        addSubjectToStudent(bob, science, 78);

        System.out.println("Updated student grades after adding Charlie to English and Bob to Science:");
        printStudentGrades();

        System.out.println("Updated students enrolled in each subject:");
        printStudent();

        removeStudentFromSubject(alice, math);

        System.out.println("Students after removing Alice from Math:");
        printStudent();


        remove(charlie);

        System.out.println("Final state of students and grades after removing Charlie:");
        printStudentGrades();
        printStudent();
    }


    public static void printStudentGrades() {
        if (studentSubjectGrades.isEmpty()) {
            System.out.println("No student grades available.");
            return;
        }

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjectGrades.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    public static void addStudent(Student student, Map<Subject, Integer> subjects) {
        studentSubjectGrades.put(student, subjects);

        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            Subject subject = entry.getKey();
            if (!students.containsKey(subject)) {
                students.put(subject, new ArrayList<>());
            }

            students.get(subject).add(student);
        }
    }


    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (studentSubjectGrades.containsKey(student)) {
            studentSubjectGrades.get(student).put(subject, grade);

            if (!students.containsKey(subject)) {
                students.put(subject, new ArrayList<>());
            }

            students.get(subject).add(student);
        }
    }


    public static void remove(Student student) {
        studentSubjectGrades.remove(student);
    }


    public static void addStudentToSubject(Student student, Subject subject) {
        students.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }


    public static void printStudent(){
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Map.Entry<Subject, List<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void removeStudentFromSubject(Student student, Subject subject) {
        if (students.containsKey(subject)) {
            List<Student> studentList = students.get(subject);
            studentList.remove(student);

            if (studentList.isEmpty()) {
                students.remove(subject);
            }
        }
    }
}