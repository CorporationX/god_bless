package school.faang.doubleCache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final HashMap<Student, Map<Subject, Integer>> STUDENT_MAP = new HashMap<>();
    private static final HashMap<Subject, Set<Student>> SUBJECT_MAP = new HashMap<>();

    public static void addNewStudentWithSubjectsAndMark(Student student, Subject subject, Integer mark) {
        Map<Subject, Integer> map = new HashMap<>();
        map.put(subject, mark);
        STUDENT_MAP.put(student, map);
        SUBJECT_MAP.computeIfAbsent(subject, s -> new HashSet<>()).add(student);
    }

    public static void addNewSubject(Student student, Subject subject, Integer mark) {
        SUBJECT_MAP.computeIfAbsent(subject, s -> new HashSet<>()).add(student);
        Map<Subject, Integer> map = new HashMap<>();
        map.put(subject, mark);
        STUDENT_MAP.put(student, map);
    }

    public static void deleteStudentWithSubjectAndMarks(Student student) {
        STUDENT_MAP.remove(student);
        for (Map.Entry<Subject, Set<Student>> entry : SUBJECT_MAP.entrySet()) {
            entry.getValue().remove(student);
        }
    }

    public static void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_MAP.entrySet()) {
            System.out.println("Student :" + entry.getKey());
            System.out.println("Subject with marks :" + entry.getValue());
        }
    }

    public static void printAllSubjects() {
        for (Map.Entry<Subject, Set<Student>> entry : SUBJECT_MAP.entrySet()) {
            System.out.println("Subject :" + entry.getKey());
            System.out.println("Students :" + entry.getValue());
            System.out.println("------------");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Abzalkhan");
        Student student2 = new Student(2, "Olzhas");
        Student student3 = new Student(3, "Aida");

        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Biology");
        Subject subject3 = new Subject(3, "Physics");
        Subject subject4 = new Subject(4, "Chemistry");

        addNewStudentWithSubjectsAndMark(student1, subject1, 5);
        addNewStudentWithSubjectsAndMark(student2, subject2, 4);
        addNewStudentWithSubjectsAndMark(student3, subject3, 7);
        addNewStudentWithSubjectsAndMark(student1, subject3, 10);
        addNewStudentWithSubjectsAndMark(student2, subject4, 8);
        addNewStudentWithSubjectsAndMark(student3, subject2, 15);

        printAllStudents();
        System.out.println();
        printAllSubjects();
        System.out.println();

        Subject subject5 = new Subject(5, "Shooting");
        addNewSubject(student1, subject5, 99);
        printAllSubjects();
        System.out.println();

        deleteStudentWithSubjectAndMarks(student2);
        printAllStudents();
        System.out.println();
        printAllSubjects();
        System.out.println();

    }
}
