package bjs256991;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(StudentDatabase.class);

    public void addStudentSubjectsEstimates(Student student, Subject subject, Integer estimate) {
        if (Objects.nonNull(student) && Objects.nonNull(subject) && Objects.nonNull(estimate)) {
            Map<Subject, Integer> subjectsToEstimates = new HashMap<>();
            subjectsToEstimates.putIfAbsent(subject, estimate);
            studentSubjects.putIfAbsent(student, subjectsToEstimates);
        }
    }

    public void addSubjectForStudentWithEstimate(Subject subject, Student student, Integer estimate) {
        if (Objects.nonNull(subject) && Objects.nonNull(student) && Objects.nonNull(estimate)) {
            Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
            subjectsToEstimates.putIfAbsent(subject, estimate);
            studentSubjects.put(student, subjectsToEstimates);

            List<Student> students = subjectStudents.get(subject);
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add(student);
            subjectStudents.putIfAbsent(subject, students);
        }
    }

    public void removeStudentSubjects(Student student) {
        studentSubjects.remove(student);
    }

    public void printAllStudents() {
        studentSubjects.forEach((student, subjectsToEstimates) -> {
            logger.info("Student: {}", student);
            subjectsToEstimates.forEach((subject, estimate) ->
                logger.info("Subject: {}, Estimate: {}", subject, estimate)
            );
        });
    }

    public void addSubjectStudents(Subject subject, Set<Student> students) {
        if (Objects.nonNull(subject) && Objects.nonNull(students)) {
            Map<Subject, Integer> subjectToEstimate = new HashMap<>();
            List<Student> studentsWithoutDuplicates = new ArrayList<>(students);
            studentsWithoutDuplicates.forEach(studentWithoutDuplicate -> {
                subjectToEstimate.put(subject, null);
                studentSubjects.put(studentWithoutDuplicate, subjectToEstimate);
            });
            subjectStudents.put(subject, studentsWithoutDuplicates);
        }
    }

    public void addStudentSubject(Student student, Subject subject) {
        Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
        if (Objects.nonNull(student) && Objects.nonNull(subject)) {
            if (subjectsToEstimates == null) {
                subjectsToEstimates = new HashMap<>();
                subjectsToEstimates.put(subject, null);
            }
            studentSubjects.put(student, subjectsToEstimates);
        }
        List<Student> students = subjectStudents.get(subject);
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        subjectStudents.put(subject, students);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Subject> subjects = studentSubjects.get(student).keySet().stream().toList();
        subjects.stream().filter(streamSubject -> subjectStudents.get(streamSubject) != null)
                .forEach(streamSubject -> subjectStudents.get(streamSubject).remove(student));
    }

    protected void printAllSubjects() {
        subjectStudents.forEach((subject, students) -> {
            logger.info("Subject: {}", subject);
            students.forEach(student ->
                logger.info("The student who studies the subject: {}", student));
        });
    }
}
