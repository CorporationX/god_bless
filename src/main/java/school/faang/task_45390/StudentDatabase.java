package school.faang.task_45390;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final Logger logger = LoggerFactory.getLogger(StudentDatabase.class);

    protected final Map<Student, Map<Subject, Integer>> gradesByStudent;
    protected final Map<Subject, List<Student>> studentsBySubject;

    public StudentDatabase(
            Map<Student, Map<Subject, Integer>> gradesByStudent,
            Map<Subject, List<Student>> studentsBySubject
    ) {
        this.gradesByStudent = gradesByStudent;
        this.studentsBySubject = studentsBySubject;
    }

    protected void addStudentWithGrades(
            Student student,
            Map<Subject, Integer> gradeBySubject
    ) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (gradeBySubject == null || gradeBySubject.isEmpty()) {
            throw new IllegalArgumentException("Grade map cannot be null or empty");
        }

        gradesByStudent.computeIfAbsent(student, k -> new HashMap<>()).putAll(gradeBySubject);

        gradeBySubject.forEach((subject, grade) ->
                studentsBySubject.computeIfAbsent(subject, s -> new ArrayList<>()).add(student));

        logger.info("Added student {} with grade map {}", student.getName(), gradeBySubject);
    }

    protected void addSubjectForStudent(
            Student student,
            Subject subject,
            int grade
    ) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }

        gradesByStudent.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        studentsBySubject.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);

        logger.info("Added subject {} with grade {}", subject, grade);
    }

    protected void removeStudent(Student student) {
        if (!gradesByStudent.containsKey(student)) {
            throw new IllegalArgumentException("Student not found");
        }

        gradesByStudent.get(student).keySet().forEach(subject -> studentsBySubject.get(subject).remove(student));

        gradesByStudent.remove(student);

        logger.info("Student {} removed from the database", student.getName());
    }

    protected void removeStudentFromSubject(
            Student student,
            Subject subject
    ) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }

        gradesByStudent.getOrDefault(student, new HashMap<>()).remove(subject);

        studentsBySubject.getOrDefault(subject, new ArrayList<>()).remove(student);

        logger.info("Student {} removed from subject {}", student.getName(), subject.getName());
    }

    protected void printAllStudentsWithGrades() {
        logger.info("# All students and their grades:");
        gradesByStudent.forEach((student, grade) -> logger.info("{}: {}", student, grade));
    }

    protected void printAllSubjectsAndStudents() {
        logger.info("# All subjects and their students:");
        studentsBySubject.forEach((subject, students) -> logger.info("{}:{}", subject, students));
    }
}