package school.faang.s12task45216;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Getter
@AllArgsConstructor
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentToGrades;
    private final Map<Subject, List<Student>> subjectWithStudents;

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> grades) {
        Optional.ofNullable(student).ifPresent(s -> {
            studentToGrades.put(student, grades);
            log.info("Added student with id {}", s.getId());
            log.debug("Added grades for student {}: {}", s.getName(), grades);
        });
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> studentGrades = studentToGrades.computeIfAbsent(student, s -> new HashMap<>());
        studentGrades.put(subject, grade);
        log.info("Added subject with id {} for student with id {}", subject.getId(), student.getId());
    }

    public void removeStudentWithSubjects(Student student) {
        if (student != null) {
            studentToGrades.remove(student);
            log.info("The student with id {} have removed", student.getId());
        } else {
            log.warn("Attempted to remove a null student");
        }
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        studentToGrades.forEach((student, subjects) -> {
            log.info("{}", student);
            subjects.forEach((subject, grade) -> log.info("{}, {}", subject, grade));
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject != null && students != null) {
            List<Student> studentsList = subjectWithStudents.computeIfAbsent(subject, k -> new ArrayList<>());
            studentsList.addAll(students);
            log.info("Added {} students to subject with id {}", students, subject.getId());
        } else {
            log.warn("Attempted to add a null subject or students list. Subject: {}, Students: {}", subject, students);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (subject != null && student != null) {
            List<Student> students = subjectWithStudents.computeIfAbsent(subject, s -> new ArrayList<>());
            students.add(student);
            log.info("Added student with id {} to subject with id {}", student.getId(), subject.getId());
        } else {
            log.warn("Attempted to add a null subject or student. Subject: {}, Student: {}", subject, student);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            log.warn("Attempted to remove a null student or subject. Student: {}, Subject: {}", student, subject);
            throw new IllegalArgumentException("Student and subject must not be null");
        }

        List<Student> students = subjectWithStudents.get(subject);
        if (students != null) {
            students.removeIf(existStudent -> Objects.equals(existStudent.getId(), student.getId()));
            if (students.isEmpty()) {
                subjectWithStudents.remove(subject);
            }
            log.info("Removed student with id {} from subject with id {}", student.getId(), subject.getId());
        } else {
            log.warn("Subject with id {} does not exist", subject.getId());
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectWithStudents.forEach(((subject, students) -> {
            log.info("{}", subject);
            students.forEach((student -> log.info("{}", student)));
        }));
    }
}