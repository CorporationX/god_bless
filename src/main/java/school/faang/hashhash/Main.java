package school.faang.hashhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> STUDENT_TO_SUBJECT_MARKS = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_TO_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Subject math = new Subject(1, "Math");
        Subject biology = new Subject(2, "Biology");
        Subject physics = new Subject(3, "Physics");
        Student alex = new Student(1, "Alex");
        Student ivan = new Student(2, "Ivan");
        Student petr = new Student(3, "Petr");

        addStudent(alex, new HashMap<>(Map.of(math, 5, physics, 4)));
        addStudent(ivan, new HashMap<>(Map.of(math, 4, biology, 3)));
        addStudent(petr, new HashMap<>(Map.of(biology, 2)));
        printAllStudentsMarks();

        System.out.println("Add biology to Alex");
        addMarkToStudent(alex, biology, 5);
        printAllStudentsMarks();

        System.out.println("Remove Petr marks");
        removeStudentMarks(petr);
        printAllStudentsMarks();

        addSubject(physics, new ArrayList<>(List.of(alex, ivan, petr)));
        addSubject(biology, new ArrayList<>(List.of(petr)));
        addSubject(math, new ArrayList<>(List.of(alex, ivan)));
        printAllSubjectsStudents();

        System.out.println("Add petr to math");
        addStudentToSubject(math, petr);
        printAllSubjectsStudents();

        System.out.println("Remove petr from biology");
        removeStudentFromSubject(biology, petr);
        printAllSubjectsStudents();
    }

    public static void addStudent(Student student, Map<Subject, Integer> marks) {
        if (student == null || marks == null) {
            throw new IllegalArgumentException();
        }
        STUDENT_TO_SUBJECT_MARKS.put(student, marks);
        for (Subject subject : marks.keySet()) {
            addStudentToSubject(subject, student);
        }
    }

    public static void addMarkToStudent(Student student, Subject subject, int mark) {
        if (student == null || subject == null || mark < 0 || mark > 5) {
            throw new IllegalArgumentException();
        }
        if (STUDENT_TO_SUBJECT_MARKS.containsKey(student)) {
            STUDENT_TO_SUBJECT_MARKS.get(student).put(subject, mark);
        }
    }

    public static void removeStudentMarks(Student student) {
        STUDENT_TO_SUBJECT_MARKS.remove(student);
    }

    public static void printAllStudentsMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentToSubjectEntry : STUDENT_TO_SUBJECT_MARKS.entrySet()) {
            System.out.println("Student: " + studentToSubjectEntry.getKey().getName());
            studentToSubjectEntry.getValue().forEach(
                    (subject, mark) -> System.out.println(subject.getName() + " - " + mark));
            System.out.println("---");
        }
    }

    public static void addSubject(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException();
        }
        SUBJECT_TO_STUDENTS.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException();
        }
        if (SUBJECT_TO_STUDENTS.containsKey(subject) &&
                !SUBJECT_TO_STUDENTS.get(subject).contains(student)) {
            SUBJECT_TO_STUDENTS.get(subject).add(student);
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (SUBJECT_TO_STUDENTS.containsKey(subject)) {
            SUBJECT_TO_STUDENTS.get(subject).remove(student);
        }
    }

    public static void printAllSubjectsStudents() {
        for (Map.Entry<Subject, List<Student>> subjectToStudentsEntry : SUBJECT_TO_STUDENTS.entrySet()) {
            System.out.println("Subject: " + subjectToStudentsEntry.getKey().getName());
            subjectToStudentsEntry.getValue().forEach(student -> System.out.println(student.getName()));
            System.out.println("---");
        }
    }
}
