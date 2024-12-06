package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.entity.Student;
import school.faang.entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final Logger log = LoggerFactory.getLogger(StudentDatabase.class);
    private final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private final Map<Subject, List<Student>> subjects = new HashMap<>();

    public void addStudents(Student student, Subject subject, Integer note) throws IllegalArgumentException {
        Map<Subject, Integer> subjects = students.computeIfAbsent(student, k -> new HashMap<>());
        if (note > 5 | note < 0) {
            throw new IllegalArgumentException("note should be less then 5 or greater than 0");
        }
        subjects.put(subject, note);
        log.info("To student {} added {} with note {}", student.getName(), subject.getTitle(),note);
    }

    public void removeStudents(Student student) throws IllegalArgumentException {
        if (!(students.containsKey(student))) {
            throw new IllegalArgumentException("Student does not exist");
        }
        students.remove(student);
        log.info("Student {} removed", student.getName());
    }

    public void printStudents() {
        students.forEach((key, value) -> System.out.println("Student " + key.getName() + " " + value));
    }

    public void addSubjects(Subject subject, Student student) throws IllegalArgumentException {
        List<Student> studentsInSubjects = subjects.computeIfAbsent(subject, k -> new ArrayList<>());
        studentsInSubjects.add(student);
        log.info("To subjects {} added {}", subject.getTitle(), student.getName());
    }

    public void removeSubjects(Subject subject) throws IllegalArgumentException {
        if (!(subjects.containsKey(subject))) {
            throw new IllegalArgumentException("Subject does not exist");
        }
        subjects.remove(subject);
        log.info("Subject {} removed", subject.getTitle());
    }

    public void printSubjects() {
        subjects.forEach((key, value) -> {
            System.out.println("List of students who learned " + key + ":");
            value.forEach(student -> System.out.println("  - " + student.getName()));
        });
    }


}
