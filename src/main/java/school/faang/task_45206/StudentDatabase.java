package school.faang.task_45206;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class StudentDatabase implements StudentProvider {
    public final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    public final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    @Override
    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades) {
        studentGrades.put(student, subjectsGrades);
    }

    @Override
    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (student != null) {
            studentGrades.forEach((currentStudent, subjectsGrades) -> {
                if (Objects.equals(student, currentStudent)) {
                    subjectsGrades.put(subject, grade);
                }
            });
            return;
        }
        throw new NullPointerException("Student cannot be null");
    }

    @Override
    public void deleteStudent(Student student) {
        if (student != null) {
            studentGrades.remove(student);
            subjectStudents.forEach((currentSubject, students) -> {
                students.remove(student);
            });
            return;
        }
        throw new NullPointerException("Student cannot be null");
    }

    @Override
    public void printAllStudentsWithSubjects() {
        studentGrades.forEach((student, subjectsGrades) -> {
            log.info(student.toString());
            subjectsGrades.forEach((subject, grade) -> {
                log.info(subject.toString() + ": " + grade.toString());
            });
        });
    }

    @Override
    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        if (subject != null) {
            subjectStudents.put(subject, students);
            return;
        }
        throw new NullPointerException("Subject cannot be null");
    }

    @Override
    public void addStudentForSubject(Subject subject, Student student) {
        if (subject != null) {
            subjectStudents.forEach((currentSubject, students) -> {
                if (Objects.equals(subject, currentSubject)) {
                    students.add(student);
                }
            });
            return;
        }
        throw new NullPointerException("Subject cannot be null");
    }

    @Override
    public void deleteStudentFromSubject(Subject subject, Student student) {
        if (student != null) {
            subjectStudents.forEach((currentSubject, students) -> {
                if (Objects.equals(subject, currentSubject)) {
                    students.remove(student);
                }
            });
            return;
        }
        throw new NullPointerException("Student cannot be null");
    }

    @Override
    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            log.info(subject.toString() + ":");
            students.forEach(student -> log.info(student.toString()));
        });
    }
}