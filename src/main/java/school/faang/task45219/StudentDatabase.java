package school.faang.task45219;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> everyStudentScore = new HashMap<>();
    private Map<Subject, List<Student>> studentLearnAll = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> score) {
        if (student == null || score == null) {
            throw new IllegalArgumentException("Student or score cannot be null!");
        }
        everyStudentScore.putIfAbsent(student, score);
    }

    public void addSubject(Subject subject, Map<Student, Integer> scoreStudent) {
        if (subject == null || scoreStudent == null) {
            throw new IllegalArgumentException("Subject or score cannot be null!");
        }
        for (var entry : scoreStudent.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            everyStudentScore
                    .get(entry.getKey())
                    .putIfAbsent(subject, entry.getValue());

            if (!studentLearnAll.get(subject).contains(entry.getKey())) {
                studentLearnAll.get(subject).add(entry.getKey());
            }
        }
    }

    private void delete(Student student) {
        if (student == null || !everyStudentScore.containsKey(student)) {
            throw new IllegalArgumentException("There is no such student");
        }
        everyStudentScore.remove(student);
        studentLearnAll.forEach((subject, students) -> students.remove(student));
        System.out.println("Deleted student: " + student);
    }

    public void deleteStudentAndSubjects(Student student) {
        delete(student);
    }

    public void deleteStudentFromSubject(Student student) {
        delete(student);
    }

    public void printAllStudents() {
        if (everyStudentScore.isEmpty()) {
            throw new IllegalArgumentException("The list of students is empty.");
        }
        everyStudentScore.forEach((student, scores) -> {
            System.out.println("Student: " + student);
            scores.forEach((subject, score) -> System.out.println(subject + " Оценка: " + score));
        });
    }

    public void printAllSubjects() {
        if (studentLearnAll.isEmpty()) {
            throw new IllegalArgumentException("The list of students is empty.");
        }
        studentLearnAll.forEach((subject, students) -> {
            System.out.println("Subject: " + subject);
            students.forEach(System.out::println);
        });
    }
}
