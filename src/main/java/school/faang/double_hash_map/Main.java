package school.faang.double_hash_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var students = new HashMap<Student, Map<Subject, Integer>>();
        var subjects = new HashMap<Subject, List<Student>>();

        var tony = new Student(1, "Tony");
        var danny = new Student(2, "Danny");
        var kenny = new Student(3, "Kenny");

        var maths = new Subject(1, "Maths");
        var history = new Subject(2, "History");
        var art = new Subject(3, "Art");
        var gym = new Subject(4, "Gym");

        System.out.println("Students methods: ");
        addNewStudentAndSubjectWithGrades(students, tony, maths, 80);
        addNewStudentAndSubjectWithGrades(students, kenny, art, 70);
        addSubjectForExistingStudent(students, tony, art, 50);
        addSubjectForExistingStudent(students, kenny, history, 60);
        addNewStudentAndSubjectWithGrades(students, danny, history, 90);
        removeStudentAndSubjectWithGrades(students, kenny);
        printStudentsWithSubjectAndGrades(students);
        System.out.println("\nStudents: " + students + "\n");

        System.out.println("Subjects methods: ");
        addNewSubjectAndStudents(subjects, gym, tony);
        addNewSubjectAndStudents(subjects, maths, danny);
        addStudentToExistingSubject(subjects, gym, danny);
        addStudentToExistingSubject(subjects, maths, tony);
        printSubjectsAndRelatedStudents(subjects);
        removeStudent(subjects, gym, tony);
        System.out.println("\nSubjects: " + subjects);

    }

    private static void addNewStudentAndSubjectWithGrades(Map<Student, Map<Subject, Integer>> students,
                                                          Student student, Subject subject, int grade) {
        students.computeIfAbsent(student, v -> new HashMap<>()).put(subject, grade);
    }

    private static void addSubjectForExistingStudent(Map<Student, Map<Subject, Integer>> students,
                                                     Student student, Subject subject, int grade) {
        students.get(student).put(subject, grade);
    }

    private static void removeStudentAndSubjectWithGrades(Map<Student, Map<Subject, Integer>> students, Student student) {
        students.remove(student);
    }

    private static void printStudentsWithSubjectAndGrades(Map<Student, Map<Subject, Integer>> students) {
        students.forEach((student, subjects) -> {
            System.out.println("Student: " + student);
            subjects.forEach((subject, grade) -> System.out.println("Subject: " + subject + ", " + "Grade: " + grade));
        });
    }

    private static void addNewSubjectAndStudents(Map<Subject, List<Student>> subjects, Subject subject, Student student) {
        subjects.computeIfAbsent(subject, v -> new ArrayList<>()).add(student);
    }

    private static void addStudentToExistingSubject(Map<Subject, List<Student>> subjects, Subject subject, Student student) {
        subjects.get(subject).add(student);
    }

    private static void removeStudent(Map<Subject, List<Student>> subjects, Subject subject, Student student) {
        subjects.get(subject).removeIf(relatedStudent -> relatedStudent.equals(student));
    }

    private static void printSubjectsAndRelatedStudents(Map<Subject, List<Student>> subjects) {
        subjects.forEach((subject, students) -> {
            System.out.println("Subject: " + subject);
            students.forEach(student -> System.out.println("Student: " + student));
        });
    }
}
