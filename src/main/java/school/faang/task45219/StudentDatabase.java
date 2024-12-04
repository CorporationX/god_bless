package school.faang.task45219;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> everyStudentScore;
    private Map<Subject, List<Student>> studentLearnAll;

    public void addStudent(Student student, Map<Subject, Integer> score) {
        if (student == null || score == null) {
            throw new IllegalArgumentException("Student or score cannot be null!");
        }
        if (everyStudentScore.containsKey(student)) {
            throw new IllegalArgumentException("Student with this "
                    + student.getId()
                    + " already exists");
        }
        for (var entry : score.entrySet()) {
            Subject subject = entry.getKey();

            if (subject == null) {
                continue;
            }
            if (studentLearnAll.containsKey(subject)) {
                List<Student> students = studentLearnAll.get(subject);

                if (!students.contains(student)) {
                    students.add(student);
                }
            } else {
                studentLearnAll.putIfAbsent(subject, new ArrayList<>());
                studentLearnAll.get(subject).add(student);
            }
        }
        everyStudentScore.putIfAbsent(student, score);
        System.out.println("Added student " + student);
    }

    public void addSubject(Subject subject, Map<Student, Integer> scoreStudent) {
        try {
            if (subject == null || scoreStudent == null) {
                throw new IllegalArgumentException("Subject or score cannot be null!");
            }
            studentLearnAll.putIfAbsent(subject, new ArrayList<>());
            List<Student> students = studentLearnAll.get(subject);
            for (var entry : scoreStudent.entrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                Map<Subject, Integer> subjects = everyStudentScore.get(entry.getKey());
                if (subjects == null) {
                    throw new IllegalArgumentException("It is not possible to delete such a student.");
                }
                subjects.putIfAbsent(subject, entry.getValue());

                if (!students.contains(entry.getKey())) {
                    students.add(entry.getKey());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void delete(Student student) {
        try {
            if (student == null || !everyStudentScore.containsKey(student)) {
                throw new IllegalArgumentException("There is no such student");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
