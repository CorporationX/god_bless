package bjs256991;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Getter
@ToString
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(StudentDatabase.class);

    public void addStudentSubjectsEstimates(Student student, Subject subject, Integer estimate) {
        Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
        if (Objects.nonNull(student) && Objects.nonNull(subject) && Objects.nonNull(estimate)) {
            if (subjectsToEstimates == null) {
                subjectsToEstimates = new HashMap<>();
            }
            subjectsToEstimates.put(subject, estimate);
            studentSubjects.put(student, subjectsToEstimates);
        }
        List<Student> students = subjectStudents.get(subject);
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        subjectStudents.put(subject, students);
    }

    public void addSubjectForStudentWithEstimate(Subject subject, Student student, Integer estimate) {
        Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
        if (Objects.nonNull(subject) && Objects.nonNull(student) && Objects.nonNull(estimate)) {
            if (subjectsToEstimates == null) {
                subjectsToEstimates = new HashMap<>();
            }
            subjectsToEstimates.put(subject, estimate);
            studentSubjects.put(student, subjectsToEstimates);

            List<Student> students = subjectStudents.get(subject);
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add(student);
            subjectStudents.put(subject, students);
        }
    }

    public void removeStudentSubjects(Student student) {
        Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
        if (Objects.nonNull(student)) {
            if (subjectsToEstimates != null) {
                studentSubjects.remove(student);
            }
        }
    }

    public void printAllStudents() {
        studentSubjects.forEach((student, subjectsToEstimates) -> {
            logger.info("Student: {}", student);
            subjectsToEstimates.forEach((subject, estimate) -> {
                logger.info("Subject: {}, Estimate: {}", subject, estimate);
            });
        });
    }

    public void addSubjectStudents(Subject subject, List<Student> students) {
        if (Objects.nonNull(subject) && Objects.nonNull(students)) {
            Map<Subject, Integer> subjectsToEstimates = new HashMap<>();
            students.forEach(student -> {
                subjectsToEstimates.put(subject, null);
                studentSubjects.put(student, subjectsToEstimates);
            });
            subjectStudents.put(subject, students);
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
        if (Objects.nonNull(student) && Objects.nonNull(subject)) {
            Map<Subject, Integer> subjectsToEstimates = studentSubjects.get(student);
            if (subjectsToEstimates != null) {
                Iterator<Map.Entry<Subject, Integer>> subjectsToEstimatesIterator = subjectsToEstimates.entrySet().iterator();
                if (subjectsToEstimatesIterator.hasNext()) {
                    Map.Entry<Subject, Integer> subjectToEstimate = subjectsToEstimatesIterator.next();
                    if (subjectToEstimate.getKey().equals(subject)) {
                        subjectsToEstimatesIterator.remove();
                    }
                }
            }
            studentSubjects.put(student, subjectsToEstimates);
            if (subjectStudents.get(subject) != null) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }

    protected void printAllSubjects() {
        subjectStudents.forEach((subject, students) -> {
            logger.info("Subject: {}", subject);
            students.forEach(student -> {
                logger.info("The student who studies the subject: {}", student);
            });
        });
    }
}
