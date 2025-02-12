package bjs256991;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    private static final int INIT_ESTIMATE = 0;
    private static final Logger logger = LoggerFactory.getLogger(StudentDatabase.class);

    public void addStudentSubjectsEstimates(Student student, Map<Subject, Integer> subjectsToEstimates) {
        if (Objects.nonNull(student) && Objects.nonNull(subjectsToEstimates) && !subjectsToEstimates.isEmpty()) {
            studentSubjects.computeIfAbsent(student, v -> new HashMap<>()).putAll(subjectsToEstimates);
            subjectsToEstimates.keySet().forEach(subject ->
                    subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student)
            );
        }
    }

    public void addSubjectForStudentWithEstimate(Student student, Map<Subject, Integer> subjectsToEstimates) {
        if (Objects.nonNull(student) && Objects.nonNull(subjectsToEstimates) && !subjectsToEstimates.isEmpty()) {
            if (Objects.nonNull(studentSubjects.get(student))) {
                studentSubjects.compute(student, (subject, estimate) -> studentSubjects.get(student))
                        .putAll(subjectsToEstimates);
            }
            subjectsToEstimates.keySet()
                    .forEach(subject -> {
                        Objects.requireNonNull(subjectStudents
                                        .computeIfPresent(subject, (subjectInMap, students)
                                                -> subjectStudents.get(subject)))
                                .add(student);
                        subjectStudents.computeIfAbsent(subject, v -> new ArrayList<>()).add(student);
                    });
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

    public void addSubjectStudents(Subject subject, List<Student> students) {
        if (Objects.nonNull(subject) && Objects.nonNull(students)) {
            if (subjectStudents.containsKey(subject)) {
                throw new IllegalArgumentException("Subject already exists");
            }
            Set<Student> uniqueStudents = new HashSet<>(students);
            subjectStudents.put(subject, new ArrayList<>(uniqueStudents));

            students.forEach(s -> studentSubjects.computeIfAbsent(s, v ->
                    new HashMap<>()).put(subject, INIT_ESTIMATE));
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
