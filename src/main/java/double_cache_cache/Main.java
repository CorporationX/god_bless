package double_cache_cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<Student, Map<Subject, Integer>> studentsOfEstimation = new HashMap<>();
    @Getter
    private static final Map<Subject, List<Student>> subjectsOfStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student = new Student(1, "John");
        Student student2 = new Student(2, "Jane");

        Subject subject = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Physics");
        Subject subject3 = new Subject(3, "History");
        Subject subject4 = new Subject(4, "Chemistry");

        addStudentToSubject(student, subject, 5);
        addStudentToSubject(student, subject2, 3);
        addStudentToSubject(student2, subject3, 4);

        System.out.println(studentsOfEstimation);
        System.out.println(subjectsOfStudents);

        removeStudentFromSubject(student2);

        System.out.println(studentsOfEstimation);

        printAllStudent();

        addNewSubjectAndStudentsList(subject4, List.of(student2));

        System.out.println(studentsOfEstimation);
        System.out.println(subjectsOfStudents);

        addStudentByExistingSubject(student, subject4);
        System.out.println(subjectsOfStudents);

        removeStudentForSubject(student, subject4);
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
        studentsOfEstimation.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public static void removeStudentForSubject(Student student, Subject subject) {
        subjectsOfStudents.get(subject).remove(student);
    }

    public static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectsOfStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
        }
    }
}
