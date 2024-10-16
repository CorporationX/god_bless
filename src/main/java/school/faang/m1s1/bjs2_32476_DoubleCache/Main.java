package school.faang.m1s1.bjs2_32476_DoubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_TO_SUBJECT_MAP = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_TO_STUDENT_MAP = new HashMap<>();

    public static void main(String[] args) {

        updateDataBase(new Student(1, "Alice"), Map.of(
                new Subject(1, "Literature"), 5,
                new Subject(2, "Math"), 4,
                new Subject(3, "CS"), 3
        ));
        updateDataBase(new Student(2, "Bob"), Map.of(
                new Subject(1, "Literature"), 5
        ));
        updateDataBase(new Student(3, "Charlie"), Map.of(
                new Subject(2, "Math"), 5,
                new Subject(3, "CS"), 4,
                new Subject(4, "Physics"), 4
        ));

        displayStudents();
        displaySubjects();

        removeStudent(new Student(2, "Bob"));

        displayStudents();
        displaySubjects();
    }

    public static void updateDataBase(Student student, Map<Subject, Integer> scores) {
        STUDENT_TO_SUBJECT_MAP.computeIfAbsent(student, k -> new HashMap<>()).putAll(scores);
        for (Subject subject : scores.keySet()) {
            updateSubject(subject, student);
        }
    }

    public static void removeStudent(Student student) {
        Set<Subject> subjectSet = STUDENT_TO_SUBJECT_MAP.remove(student).keySet();
        for (Subject subject : subjectSet) {
            SUBJECT_TO_STUDENT_MAP.get(subject).remove(student);
        }
    }

    public static void displayStudents() {
        for (var entry : STUDENT_TO_SUBJECT_MAP.entrySet()) {
            Student student = entry.getKey();
            System.out.printf("Student %s (id #%d). ", student.getName(), student.getId());
            var scores = entry.getValue();
            for (var subjectScore : scores.entrySet()) {
                Subject subject = subjectScore.getKey();
                int score = subjectScore.getValue();
                System.out.printf("%s, score: %d; ", subject.getName(), score);
            }
            System.out.println();
        }
    }

    private static void updateSubject(Subject subject, Student student) {
        SUBJECT_TO_STUDENT_MAP.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void displaySubjects() {
        for (var entry : SUBJECT_TO_STUDENT_MAP.entrySet()) {
            Subject subject = entry.getKey();
            System.out.printf("%s (id #%d). Students: ", subject.getName(), subject.getId());
            List<Student> studentList = entry.getValue();
            for (Student student : studentList) {
                System.out.printf("%s (id #%d), ", student.getName(), student.getId());
            }
            System.out.println();
        }
    }
}
