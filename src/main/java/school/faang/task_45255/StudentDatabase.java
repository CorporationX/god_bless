package school.faang.task_45255;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_45255.entity.Student;
import school.faang.task_45255.entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final Logger log = LoggerFactory.getLogger(StudentDatabase.class);
    private final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private final Map<Subject, List<Student>> subjects = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjectMarks) throws IllegalArgumentException {
        if (students.containsKey(student)) {
            throw new IllegalArgumentException("student already exists");
        }
        if (subjectMarks.isEmpty()) {
            throw new IllegalArgumentException("subject marks cannot be empty");
        }
        subjectMarks.forEach((subject, mark) -> {
            if (mark > 5 || mark < 0) {
                throw new IllegalArgumentException("Note should be less than 5 or greater than 0");
            }
        });
        Map<Subject, Integer> copyOfSubjectMarks = new HashMap<>(subjectMarks);
        students.put(student, copyOfSubjectMarks);
        log.info("Added student {} with subject marks {}", student, subjectMarks);
    }

    /**
     * Adds a subject for a specific student along with an associated mark.
     */
    public void addSubjectForStudent(Student student, Subject subject, Integer mark) throws IllegalArgumentException {
        Map<Subject, Integer> subjectsInStudents = students.get(student);
        if (subjectsInStudents == null) {
            throw new IllegalArgumentException("No subjects in this student");
        }
        if (mark > 5 | mark < 0) {
            throw new IllegalArgumentException("note should be less then 5 or greater than 0");
        }
        subjectsInStudents.put(subject, mark);
        log.info("To student {} added {} with note {}", student.getName(), subject.getTitle(), mark);
    }

    public void removeStudent(Student student) throws IllegalArgumentException {
        Map<Subject, Integer> removedStudent = students.remove(student);
        if (removedStudent == null) {
            throw new IllegalArgumentException("Student" + student.getName() + " does not exist");
        }
        log.info("Student {} removed", student.getName());
    }

    public void printStudents() {
        students.forEach((student, subjectsAndMarks) -> {
            System.out.println("Student: " + student.getName());
            if (subjectsAndMarks.isEmpty()) {
                System.out.println("  No subjects or marks assigned.");
            } else {
                System.out.println("  Subjects and marks:");
                subjectsAndMarks.forEach((subject, mark) ->
                        System.out.println("    " + subject.getTitle() + ": " + mark));
            }
        });
    }

    public void addSubject(Subject subject, List<Student> student) {
        if (subjects.containsKey(subject)) {
            throw new IllegalArgumentException("Subject already exists");
        }
        if (student == null) {
            throw new IllegalArgumentException("student cannot be null");
        }
        List<Student> copyStudent = new ArrayList<>(student);
        subjects.put(subject, copyStudent);
    }

    /**
     * Adds a student to the list of students associated with a specific subject.
     */
    public void addStudentInSubject(Subject subject, Student student) {
        List<Student> studentsInSubjects = subjects.get(subject);
        if (studentsInSubjects == null) {
            throw new IllegalArgumentException("No students in this subject");
        }
        studentsInSubjects.add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) throws IllegalArgumentException {
        List<Student> studentsInSubjects = subjects.get(subject);
        if (studentsInSubjects == null) {
            throw new IllegalArgumentException("No students in this subject");
        }
        if (!(studentsInSubjects.contains(student))) {
            throw new IllegalArgumentException("Student " + student.getName() + " does not exist");
        }
        studentsInSubjects.remove(student);
        log.info("From subjects {} removed {}", subject.getTitle(), student.getName());
    }

    public void printSubjects() {
        subjects.forEach((key, value) -> {
            System.out.println("List of students who learned " + key + ":");
            value.forEach(student -> System.out.println("  - " + student.getName()));
        });
    }


}
