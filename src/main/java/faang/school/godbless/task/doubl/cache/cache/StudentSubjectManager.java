package faang.school.godbless.task.doubl.cache.cache;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class StudentSubjectManager {
    private static final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectsMap = new HashMap<>();

    public static void addOrUpdateStudentGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null || grades == null) {
            throw new IllegalArgumentException("Neither student nor grades can be null.");
        }
        studentGrades.put(student, grades);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Neither subject nor student can be null.");
        }
        subjectsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Neither subject nor student can be null.");
        }
        List<Student> students = subjectsMap.getOrDefault(subject, new ArrayList<>());
        if (!students.remove(student)) {
            throw new NoSuchElementException("Student not found in subject.");
        }
    }

    public static void printAllStudentGrades() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades available.");
            return;
        }
        studentGrades.forEach((student, grades) -> {
            System.out.println("Student: " + student);
            grades.forEach((subject, grade) ->
                    System.out.println("Subject: " + subject + ", Grade: " + grade));
        });
    }

    public static void printAllSubjectsAndStudents() {
        if (subjectsMap.isEmpty()) {
            System.out.println("No subjects with enrolled students.");
        } else {
            subjectsMap.forEach((subject, students) -> {
                System.out.println("Subject: " + subject);
                students.forEach(student ->
                        System.out.println("Student: " + student));
            });
        }
    }
}
