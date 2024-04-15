package faang.school.godbless.BJS2_4277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> SUBJECT = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student tony = new Student("Tony");
        Student joan = new Student("Joan");
        Student steve = new Student("Steve");
        List<Student> students = new ArrayList<>();
        students.add(tony);
        students.add(joan);

        Subject geography = new Subject("Geography");
        Subject geometry = new Subject("Geometry");
        Subject physic = new Subject("Physic");

        registrationStudent(tony, geography, 5);
        registrationStudent(joan, geography, 4);
        registrationStudent(steve, physic, 4);

        addNewSubject(tony, geometry, 5);
        addNewSubject(tony, physic, 4);
        addNewSubject(joan, geography, 5);
        addNewSubject(steve, geography, 4);

        removeStudent(steve);

        printStudentAllInfo();

        registrationSubject(geography, students);
        addNewStudent(geography, steve);

        printAllSubjectInfo();
    }

    private static void registrationStudent(Student student, Subject subject, Integer grade) {
        SUBJECT.computeIfAbsent(student, k -> new HashMap<>()).putIfAbsent(subject, grade);
    }

    private static void addNewSubject(Student student, Subject subject, Integer grade) {
        SUBJECT.computeIfPresent(student, (key, value) -> {
            value.put(subject, grade);
            return value;
        });
    }

    private static void removeStudent(Student student) {
        SUBJECT.remove(student);
    }

    private static void printStudentAllInfo() {
        for (var entry : SUBJECT.entrySet()) {
            System.out.println("Student:" + entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void registrationSubject(Subject subject, List<Student> students) {
        STUDENTS.putIfAbsent(subject, students);
    }

    private static void addNewStudent(Subject subject, Student student) {
        STUDENTS.computeIfPresent(subject, (key, students) -> {
            students.add(student);
            return students;
        });
    }

    private static void printAllSubjectInfo() {
        for (var entry : STUDENTS.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
