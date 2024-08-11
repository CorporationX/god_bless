package faang.school.godbless.double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> students = new HashMap<>();

    private static final Map<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        Student student = new Student(UUID.randomUUID(), "John");
        Map<Subject, Integer> subject = new HashMap<>() {{
            put(new Subject(UUID.randomUUID(), "Maths"), 90);
            put(new Subject(UUID.randomUUID(), "Science"), 80);
        }};
        addStudent(student, subject);
        System.out.println();

        addSubject(List.of(student), new Subject(UUID.randomUUID(), "English"));
        System.out.println();

        addSubjectForStudent(student, new Subject(UUID.randomUUID(), "English"), 80);
        System.out.println();

        printStudents();

        addStudentForSubject(new Subject(UUID.randomUUID(), "French"), student);
        System.out.println(subjects);
        System.out.println();

        removeStudentForSubject(new Subject(UUID.randomUUID(), "English"), student);
        System.out.println(subjects);
        System.out.println();

        System.out.println(removeStudent(student));
        System.out.println(students);
        System.out.println();

        printSubject();
    }

    public static void addStudent(Student student, Map<Subject, Integer> subject) {
        students.put(student, subject);
    }

    public static void addSubjectForStudent(Student student, Subject subject, Integer marks) {
        students.computeIfAbsent(student, k -> new HashMap<>()).put(subject, marks);
    }

    public static boolean removeStudent(Student student) {
        return students.remove(student) != null;
    }

    public static void printStudents() {
        System.out.println();
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
    }

    public static void addSubject(List<Student> students, Subject subject) {
        for (Student student : students) {
            subjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public static void addStudentForSubject(Subject subject, Student student) {
        subjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static boolean removeStudentForSubject(Subject subject, Student student) {
        if (subjects.containsKey(subject)) {
            for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
                if (entry.getKey().equals(subject)) {
                    entry.getValue().remove(student);
                }

            }
        }
        return true;
    }

    public static void printSubject() {
        System.out.println();
        for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
    }
}
