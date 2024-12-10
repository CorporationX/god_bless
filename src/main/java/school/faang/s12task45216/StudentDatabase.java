package school.faang.s12task45216;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Getter
@AllArgsConstructor
public class StudentDatabase {
    HashMap<Student, Map<Subject, Integer>> subjectsWithGrades;
    HashMap<Subject, List<Student>> subjectWithStudents;

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> grades) {
        Optional.ofNullable(student).ifPresent(s -> subjectsWithGrades.put(student, grades));
        log.info("The Student with Subjects and Grades have added");
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
    /* Optional.ofNullable(subjectsWithGrades.get(student))
                .ifPresent(subjects -> subjects.putIfAbsent(subject, grade));*/

        // думаю, что по логике задачи решение с computeIfAbsent лучше, чем с Optional.ofNullable
        subjectsWithGrades.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
        log.info("The Subject for Student have added");
    }

    public void removeStudentWithSubjects(Student student) {
        Optional.ofNullable(student).ifPresent(s -> subjectsWithGrades.remove(s));
        log.info("The Student have removed");
    }

    public void printAllStudentsWithSubjectsAndGrades() {
        subjectsWithGrades.forEach((student, subjects) -> {
            log.info("{}", student);
            subjects.forEach((subject, grade) -> log.info("{}, {}", subject, grade));
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        Optional.ofNullable(subject).ifPresent(s -> subjectWithStudents.put(subject, students));
        log.info("The Subject with Students have added");
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectWithStudents.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        log.info("The Student to the Subject have added");
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Optional.ofNullable(subject)
                .ifPresent(s -> subjectWithStudents.
                        computeIfPresent(s, (k, v) -> { v
                                    .removeIf(st -> st
                                            .equals(student));
                            return v;
                        }));
        log.info("The Student from Subject have removed");
    }

    public void printAllSubjectsWithStudents() {
        subjectWithStudents.forEach(((subject, students) -> {
            log.info("{}", subject);
            students.forEach((student -> log.info("{}", student)));
        }));
    }
}