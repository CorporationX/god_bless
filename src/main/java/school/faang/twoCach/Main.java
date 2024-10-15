package school.faang.twoCach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Map<Student, Map<Subject, Integer>> SUBJECTS_GRADES_BY_STUDENTS = new HashMap<>();
    private final static Map<Subject, List<Student>> LIST_OF_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student studentJack = new Student(1, "Jack");
        Student studentDan = new Student(2, "Dan");
        Student studentAlex = new Student(3, "Alex");

        Subject subjectMathematics = new Subject(1, "Mathematics");
        Subject subjectBiologic = new Subject(2, "Biologic");
        Subject subjectChemistry = new Subject(3, "Chemistry");


        addStudent(studentJack);
        addStudent(studentDan);
        addStudent(studentAlex);

        addSubject(subjectMathematics);
        addSubject(subjectBiologic);
        addSubject(subjectChemistry);

        addSubjectForStudent(studentJack, subjectMathematics, 10);
        addSubjectForStudent(studentDan, subjectChemistry, 8);

        printStudent();
        System.out.println("----------------------------");
        printSubject();
    }

    public static void addStudent(Student student) {
        SUBJECTS_GRADES_BY_STUDENTS.putIfAbsent(student, new HashMap<>());
    }

    public static void addSubject(Subject subject) {
        LIST_OF_STUDENTS.putIfAbsent(subject, new ArrayList<>());
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade) {
        SUBJECTS_GRADES_BY_STUDENTS.putIfAbsent(student, new HashMap<>());
        SUBJECTS_GRADES_BY_STUDENTS.get(student).put(subject, grade);

        LIST_OF_STUDENTS.putIfAbsent(subject, new ArrayList<>());
        if (!LIST_OF_STUDENTS.get(subject).contains(student)) {
            LIST_OF_STUDENTS.get(subject).add(student);
        }
    }

    public static void removeStudent(Student student) {
        SUBJECTS_GRADES_BY_STUDENTS.remove(student);
        for (List<Student> students : LIST_OF_STUDENTS.values()) {
            students.remove(student);
        }
    }

    public static void printStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : SUBJECTS_GRADES_BY_STUDENTS.entrySet()) {
            System.out.println(student);
        }
    }

    public static void printSubject() {
        for (Map.Entry<Subject, List<Student>> subject : LIST_OF_STUDENTS.entrySet()) {
            System.out.println(subject);
        }
    }
}
