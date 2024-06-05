package faang.school.godbless.cache;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University {

    Map<Student, Map<Subject, Integer>> studentGrades;
    Map<Subject, List<Student>> studentsBySubjects;

    public void addStudentWithGrades(Student student, Map<Subject, Integer> gradesBySubject) {
        if (student == null || gradesBySubject == null) {
            throw new IllegalArgumentException("Student and their grades must not be null");
        }
        studentGrades.computeIfAbsent(student, v -> new HashMap<>()).putAll(gradesBySubject);
    }

    public void addSubjectGrade(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student and subject must not be null");
        }
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).putIfAbsent(subject, grade);
        } else {
            throw new IllegalArgumentException("There's no mapping for this student.");
        }
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }
        studentGrades.remove(student);
    }

    public void printStudentGrades() {
        studentGrades.forEach((student, grades) -> {
            System.out.printf("%s:", student);
            grades.forEach((subject, grade) -> System.out.printf("%s->%d ", subject.name(), grade));
            System.out.println();
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Subject and students taking that class must not be null");
        }
        studentsBySubjects.computeIfAbsent(subject, v -> new ArrayList<>()).addAll(students);
    }

    public void addStudentToCurrentSubject(Subject subject, Student student) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Subject and their students must not be null");
        }
        studentsBySubjects.computeIfAbsent(subject, v -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Subject and their students must not be null");
        }
        studentsBySubjects.get(subject).remove(student);
    }

    public void printAllSubjects() {
        studentsBySubjects.forEach((subject, students) -> {
            System.out.printf("%s: ", subject.name());
            System.out.print(students);
            System.out.println();
        });
    }

}
