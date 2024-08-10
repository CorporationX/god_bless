package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deanery {
    private final Map<Student, Map<Subject, Integer>> studentGradesMap = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudentsMap = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        if (student == null || grades == null) {
            throw new IllegalArgumentException("Student or grades cannot be null");
        }

        studentGradesMap.put(student, new HashMap<>(grades));

        for (Subject subject : grades.keySet()) {
            subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null.");
        }

        studentGradesMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        Map<Subject, Integer> grades = studentGradesMap.remove(student);

        if (grades != null) {
            grades.keySet().forEach(subject -> {
                List<Student> students = subjectStudentsMap.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            });
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Subject and students list cannot be null");
        }

        subjectStudentsMap.put(subject, new ArrayList<>(students));
        students.forEach(s -> studentGradesMap.computeIfAbsent(s, k -> new HashMap<>()).put(subject, 0));
    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Subject or student cannot be null.");
        }

        subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentGradesMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void printAllStudentsWithGrades() {
        studentGradesMap.forEach((student, grades) -> {
            System.out.println("Student " + student.getName() + ":");
            grades.forEach((subject, grade) -> {
                if (grade > 0) {
                    System.out.println("  " + subject + ": " + grade);
                }
            });
        });
    }

    public void printAllSubjectsWithStudents() {
        subjectStudentsMap.forEach((subject, students) -> {
            System.out.println(subject + ":");
            students.forEach(student -> System.out.println("  " + student.getName()));
        });
    }
}