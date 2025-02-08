package school.faang.double_cache_cache.BJS2_56997;

import lombok.Getter;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDatabase.class);

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(
            @NonNull Student student, @NonNull Map<Subject, Integer> studentSubjects) {
        validateMap(studentSubjects, student + " is empty");

        this.studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putAll(studentSubjects);

        LOGGER.info("Added student {}", student);

        for (Subject subject : studentSubjects.keySet()) {
            this.subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }

        LOGGER.info("Added subject");
    }

    public void addSubjectAndGrade(
            @NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        validateMap(subjects, subjects + " is empty");

        if (!studentSubjects.containsKey(student)) {
            LOGGER.info("{} is not in the database", student);
            throw new IllegalArgumentException(student + " student is not in the database");
        }
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putAll(subjects);
        LOGGER.info("Added student {}", student);

        for (Subject subject : subjects.keySet()) {
            this.subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }

        LOGGER.info("Added subject");
    }

    public void removeStudentAndItems(@NonNull Student student) {
        studentSubjects.remove(student);

        for (var students : subjectStudents.values()) {
            students.removeIf(s -> s.equals(student));
        }
        LOGGER.info("Removed student {}", student);
    }

    public void printAllStudents() {
        if (studentSubjects.isEmpty()) {
            LOGGER.info("No students in the database");
            return;
        }

        for (var student : studentSubjects.keySet()) {
            System.out.println("Student: " + student.name());
            System.out.print("Subject: ");
            for (var subjects : studentSubjects.get(student).keySet()) {
                System.out.print(subjects.name() + ", ");
            }
            System.out.print("\n \n");
        }

        LOGGER.info("All students in the database");
    }

    public void addSubjectWithStudent(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).addAll(students);
        LOGGER.info("Added {}", subject);

        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }

        LOGGER.info("Added students");
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        LOGGER.info("Added {}", student);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        LOGGER.info("Added {}", subject);
    }

    public void removeStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students == null) {
            LOGGER.warn("student {} is not in the database", student);
            throw new IllegalArgumentException("student " + student + " is not in the database");
        }
        students.remove(student);

        LOGGER.info("Removed {}", student);

        Map<Subject, Integer> removedSubjects = studentSubjects.get(student);
        if (removedSubjects == null || removedSubjects.isEmpty()) {
            LOGGER.warn("student {} is not in the database", student);
            throw new IllegalArgumentException("student " + student + " is not in the database");
        }
        removedSubjects.remove(subject);
        LOGGER.info("Removed {}", subject);

    }

    public void printAllSubjectsWithStudent() {
        for (var subject : subjectStudents.keySet()) {
            System.out.println("Subject: " + subject.name());
            System.out.print("Student: ");
            for (Student student : subjectStudents.get(subject)) {
                System.out.print(student.name() + ", ");
            }
            System.out.print("\n \n");
        }

        LOGGER.info("All subjects in the database and students");
    }

    private static void validateMap(Map<Subject, Integer> studentSubjects, String studentName) {
        if (studentSubjects.isEmpty()) {
            LOGGER.error("{} is empty", studentSubjects);
            throw new IllegalArgumentException(studentName + " is empty");
        }
    }
}
