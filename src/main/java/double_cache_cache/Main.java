package double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<Student, Map<Subject, Integer>> studentsOfEstimation = new HashMap<>();
    static final Map<Subject, List<Student>> subjectsOfStudents = new HashMap<>();

    public static void main(String[] args) {
        Student firstStudent = new Student(1, "John");
        Student secondStudent = new Student(2, "Jane");

        Subject math = new Subject(1, "Math");
        Subject physics = new Subject(2, "Physics");
        Subject history = new Subject(3, "History");
        Subject chemistry = new Subject(4, "Chemistry");

        addStudentToSubject(firstStudent, math, 5);
        addStudentToSubject(firstStudent, physics, 3);
        addStudentToSubject(secondStudent, history, 4);

        System.out.println(studentsOfEstimation);
        System.out.println(subjectsOfStudents);

        removeStudentFromSubject(secondStudent);

        System.out.println(studentsOfEstimation);

        printAllStudent();

        addNewSubjectAndStudentsList(chemistry, List.of(secondStudent));

        System.out.println(studentsOfEstimation);
        System.out.println(subjectsOfStudents);

        addStudentByExistingSubject(firstStudent, chemistry);
        System.out.println(subjectsOfStudents);

        removeStudentForSubject(firstStudent, chemistry);
        System.out.println(subjectsOfStudents);

        printAllSubjects();
    }

    public static void addStudentToSubject(Student student, Subject subject, int estimation) {
        studentsOfEstimation.computeIfAbsent(student, k -> new HashMap<>()).put(subject, estimation);
        subjectsOfStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Student student) {
        studentsOfEstimation.remove(student);
    }

    public static void printAllStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsOfEstimation.entrySet()) {
            System.out.println("Student: " + entry.getKey());
            System.out.println("Subjects and estimations: " + entry.getValue());
        }
    }

    public static void addNewSubjectAndStudentsList(Subject subject, List<Student> students) {
        for (Student student : students) {
            subjectsOfStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            studentsOfEstimation.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public static void addStudentByExistingSubject(Student student, Subject subject) {
        if (!subjectsOfStudents.containsKey(subject)) {
            subjectsOfStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
        studentsOfEstimation.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public static void removeStudentForSubject(Student student, Subject subject) {
        subjectsOfStudents.get(subject).remove(student);
        studentsOfEstimation.remove(student);
    }

    public static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectsOfStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
        }
    }
}
