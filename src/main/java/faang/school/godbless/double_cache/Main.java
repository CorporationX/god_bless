package faang.school.godbless.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();

    public static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public static void main(String[] args) {
        Student varya = new Student(1, "Varya");
        Student anna = new Student(2, "Anna");

        Subject mathematics = new Subject(1, "Mathematics");
        Subject physics = new Subject(2, "Physics");

        addStudentWithGrades(varya, new HashMap<>(Map.of(mathematics, 2)));
        addStudentWithGrades(anna, new HashMap<>(Map.of(mathematics, 2)));

        addSubjectToStudent(varya, physics, 2);

        removeStudent(varya);

        printAllStudents();

        Subject chemistry = new Subject(3, "Chemistry");
        addSubjectWithStudents(chemistry, new ArrayList<>(List.of(varya)));

        addStudentToSubject(chemistry, anna);

        removeStudent(chemistry, varya);

        printAllSubjects();
    }

    public static void addStudentWithGrades(Student student, Map<Subject, Integer> gradesMap) {
        studentMap.put(student, gradesMap);
    }

    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentMap.get(student).put(subject, grade);
    }

    public static void removeStudent(Student student) {
        studentMap.remove(student);
    }

    public static void printAllStudents() {
        studentMap.entrySet().forEach(System.out::println);
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> studentList) {
        subjectMap.put(subject, studentList);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        subjectMap.get(subject).add(student);
    }

    public static void removeStudent(Subject subject, Student student) {
        subjectMap.get(subject).remove(student);
    }

    public static void printAllSubjects() {
        subjectMap.entrySet().forEach(System.out::println);
    }
}