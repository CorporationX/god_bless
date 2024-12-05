package school.faang.task_45206;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Getter
public class StudentDatabase implements StudentProvider {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    @Override
    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades) {
        studentGrades.put(student, subjectsGrades);
    }

    @Override
    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        validateStudent(student);
        studentGrades.forEach((currentStudent, subjectsGrades) -> {
            if (Objects.equals(student, currentStudent)) {
                subjectsGrades.put(subject, grade);
            }
        });
    }

    @Override
    public void deleteStudent(Student student) {
        validateStudent(student);
        studentGrades.remove(student);
        subjectStudents.forEach((currentSubject, students) -> {
            students.remove(student);
        });
    }

    @Override
    public void printAllStudentsWithSubjects() {
        studentGrades.forEach((student, subjectsGrades) -> {
            log.info("Student: {}", student);
            subjectsGrades.forEach((subject, grade) -> {
                log.info("{}: {}", subject, grade);
            });
        });
    }

    @Override
    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        validateSubject(subject);
        subjectStudents.put(subject, students);
    }

    @Override
    public void addStudentForSubject(Subject subject, Student student) {
        validateSubject(subject);
        subjectStudents.forEach((currentSubject, students) -> {
            if (Objects.equals(subject, currentSubject)) {
                students.add(student);
            }
        });
    }

    @Override
    public void deleteStudentFromSubject(Subject subject, Student student) {
        validateStudent(student);
        subjectStudents.forEach((currentSubject, students) -> {
            if (Objects.equals(subject, currentSubject)) {
                students.remove(student);
            }
        });
    }

    @Override
    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            log.info("Subject: {}", subject);
            students.forEach(student -> log.info("  Student: {}", student));
        });
    }

    private void validateSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
    }

    private void validateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
    }
}