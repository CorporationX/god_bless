package school.faang.HashMaps.doubleCache.service;

import school.faang.HashMaps.doubleCache.Student;
import school.faang.HashMaps.doubleCache.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAndSubjectAction {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_MAP = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_MAP = new HashMap<>();

    public static void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        STUDENT_MAP.put(student, subjects);
        subjects.forEach((sub, grade) -> SUBJECT_MAP.computeIfAbsent(sub, v -> new ArrayList<>()).add(student));
    }

    public static void addSubjectForStudent(Subject subject, Student student, Integer grade) {
        SUBJECT_MAP.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        STUDENT_MAP.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
    }

    public static void removeStudent(Student student) {
        STUDENT_MAP.get(student).forEach((sub, grade) -> removeStudentFromSubject(sub, student));
        STUDENT_MAP.remove(student);
    }

    public static void printStudents() {
        STUDENT_MAP.forEach((student, map) -> {
            System.out.println(student + " {");
            map.forEach((subject, grade) -> System.out.println(subject + " Grade: " + grade));
            System.out.println("}");
        });
    }

    public static void addSubject(Subject subject, List<Student> students) {
        SUBJECT_MAP.put(subject, students);
        students.forEach(stud -> STUDENT_MAP.computeIfAbsent(stud, subj -> new HashMap<>()).put(subject, null));
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        SUBJECT_MAP.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        STUDENT_MAP.computeIfAbsent(student, s -> new HashMap<>()).put(subject, null);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = SUBJECT_MAP.getOrDefault(subject, new ArrayList<>());
        Map<Subject, Integer> subjects = STUDENT_MAP.getOrDefault(student, new HashMap<>());

        students.remove(student);
        if (students.isEmpty()) {
            SUBJECT_MAP.remove(subject);
        }
        subjects.remove(subject);
        if (subjects.isEmpty()) {
            STUDENT_MAP.remove(student);
        }
    }

    public static void printSubjects() {
        SUBJECT_MAP.forEach((subject, list) -> {
            System.out.println("Subject: " + subject + " Students: ");
            list.forEach(System.out::println);
        });
    }
}
