package faang.school.godbless.BJS2_19900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    private final static Map<Subject, List<Student>> subjectMap = new HashMap<>();
    private final static int DEFAULT_RATE = 4;

    public static void main(String[] args) {
        addStudent(new Student(0, "Ivan"), new HashMap<>() {{
            put(new Subject(0, "Math"), 5);
            put(new Subject(1, "Literature"), 4);
            put(new Subject(2, "Sport"), 4);
        }});
        addStudent(new Student(1, "Petr"), new HashMap<>() {{
            put(new Subject(0, "Math"), 4);
            put(new Subject(2, "Sport"), 5);
            put(new Subject(1, "Literature"), 4);
            put(new Subject(3, "Biology"), 5);
        }});

        printAllStudentRates();
        System.out.println("======");
        printAllSubjects();
        System.out.println("======Add subject Chemistry");
        addSubject(new Subject(4, "Chemistry"), List.of(new Student(2, "Roman")));
        addSubject(new Subject(5, "Programming"), List.of(new Student(3, "Dmitry")));
        printAllStudentRates();
        System.out.println("======");
        printAllSubjects();
        System.out.println("======Add subject for existing user");
        addSubjectForExistingStudent(new Student(2, "Roman"), new Subject(2, "Sport"));
        printAllStudentRates();
        System.out.println("===========");
        printAllSubjects();
        System.out.println("=========Add Student to existing subject");
        addStudentToExistingSubject(new Subject(2, "Sport"), new Student(3, "Dmitry"));
        printAllStudentRates();
        System.out.println("===========");
        printAllSubjects();
        System.out.println("===========Remove student");
        removeStudent(new Student(2, "Petr"));
        printAllStudentRates();
        System.out.println("===========");
        printAllSubjects();
        System.out.println("============Remove student from subject");
        removeStudentFromSubject(new Subject(2, "Sport"), new Student(3, "Dmitry"));
        printAllStudentRates();
        System.out.println("===========");
        printAllSubjects();
    }

    private static void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectMap.containsKey(subject)) {
            subjectMap.get(subject).remove(student);
        }
        if (studentMap.containsKey(student)) {
            studentMap.get(student).remove(subject);
        }
    }

    private static void removeStudent(Student student) {
        for (var subject : subjectMap.entrySet()) {
            subject.getValue().remove(student);
        }
        studentMap.remove(student);
    }

    private static void addStudentToExistingSubject(Subject subject, Student student) {
        subjectMap.computeIfPresent(subject, (key, value) -> {
            value.add(student);
            return value;
        });
        studentMap.computeIfPresent(student, (key, value) -> {
            value.put(subject, DEFAULT_RATE);
            return value;
        });
        studentMap.computeIfAbsent(student, key -> new HashMap<>()).put(subject, DEFAULT_RATE);
    }

    private static void addSubjectForExistingStudent(Student student, Subject subject) {
        studentMap.computeIfPresent(student, (key, value) -> {
            value.put(subject, DEFAULT_RATE);
            return value;
        });
        subjectMap.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    private static void addStudent(Student student, Map<Subject, Integer> subjectRatesMap) {
        studentMap.putIfAbsent(student, subjectRatesMap);
        for (var subject : subjectRatesMap.keySet()) {
            subjectMap.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
        }
    }

    private static void addSubject(Subject subject, List<Student> students) {
        subjectMap.putIfAbsent(subject, students);
        for (var student : students) {
            studentMap.putIfAbsent(student, new HashMap<>() {{
                put(subject, DEFAULT_RATE);
            }});
        }
    }

    private static void printAllStudentRates() {
        for (var entry : studentMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": ");
            for (var subject : entry.getValue().entrySet()) {
                System.out.println(subject.getKey().getName() + " - " + subject.getValue());
            }
            System.out.println("-------------");
        }
    }

    private static void printAllSubjects() {
        for (var entry : subjectMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }
}
