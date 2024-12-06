package school.faang.task_45206;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_45206.model.EducationalEntity;
import school.faang.task_45206.model.Student;
import school.faang.task_45206.model.Subject;

import java.util.HashMap;
import java.util.Map;
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
        validate(student);
        studentGrades.get(student).put(subject, grade);
    }

    @Override
    public void deleteStudent(Student student) {
        validate(student);
        Map<Subject, Integer> subjectGrade = studentGrades.remove(student);
        subjectGrade.forEach((subject, grade) -> {
            subjectStudents.get(subject).remove(student);
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
        validate(subject);
        subjectStudents.put(subject, students);
    }

    @Override
    public void addStudentForSubject(Subject subject, Student student) {
        validate(subject);
        subjectStudents.get(subject).add(student);
    }

    @Override
    public void deleteStudentFromSubject(Subject subject, Student student) {
        validate(student);
        subjectStudents.get(subject).remove(student);
    }

    @Override
    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            log.info("Subject: {}", subject);
            students.forEach(student -> log.info("  Student: {}", student));
        });
    }

    private void validate(EducationalEntity obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Educational entity cannot be null");
        }
    }
}