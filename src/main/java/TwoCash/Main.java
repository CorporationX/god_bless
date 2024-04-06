package TwoCash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentMapMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectListMap = new HashMap<>();

    public static void main(String[] args) {
        Student vasya = new Student(1, "Vasya");
        Student dima = new Student(2, "Dima");

        Subject math = new Subject(1, "Math");
        Subject history = new Subject(2, "History");
        Subject english = new Subject(3, "English");
        Subject physic = new Subject(4, "Physic");
        Subject chemistry = new Subject(5, "Chemistry");

        Map<Subject, Integer> vasyaSubj = new HashMap<>();
        vasyaSubj.put(math, 7);
        vasyaSubj.put(history, 8);
        vasyaSubj.put(english, 10);

        Map<Subject, Integer> dimaSubj = new HashMap<>();
        dimaSubj.put(math, 5);
        dimaSubj.put(physic, 9);
        dimaSubj.put(english, 9);

        addStudentAndHisSubjects(vasya, vasyaSubj);
        addStudentAndHisSubjects(dima, dimaSubj);

        printAllStudentAndTheurSubjects();
        System.out.println();

        addStudentAndSubject(dima, chemistry, 6);

        printAllStudentAndTheurSubjects();
        System.out.println();

        removeStudentAndHisSubject(vasya);
        printAllStudentAndTheurSubjects();
        System.out.println();

        //Part2
        System.out.println("Part2");
        List<Student> students = new ArrayList<>();
        students.add(vasya);
        students.add(dima);
        addSubjectAndListOfStudents(math, students);
        printSubjectsAndTheirStudents();
        System.out.println();

        Student katya = new Student(3, "Katya");
        addStudentToSubject(math, katya);
        printSubjectsAndTheirStudents();
        System.out.println();

        removeStudentFromSubject(math, vasya);
        printSubjectsAndTheirStudents();
    }

    public static void addStudentAndHisSubjects(Student student, Map<Subject, Integer> map) {
        studentMapMap.put(student, map);
    }

    public static void addStudentAndSubject(Student student, Subject subject, Integer grade) {
        studentMapMap.get(student).put(subject, grade);
    }

    public static void removeStudentAndHisSubject(Student student) {
        studentMapMap.remove(student);
    }

    public static void printAllStudentAndTheurSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentMapMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().forEach(System.out::println);
        }
    }

    public static void addSubjectAndListOfStudents(Subject subject, List<Student> students) {
        subjectListMap.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (subjectListMap.containsKey(subject)) {
            subjectListMap.get(subject).add(student);
        } else {
            System.out.println("There is no such subject");
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        subjectListMap.get(subject).remove(student);
    }

    public static void printSubjectsAndTheirStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectListMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
