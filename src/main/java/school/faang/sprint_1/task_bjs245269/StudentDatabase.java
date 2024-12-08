package school.faang.sprint_1.task_bjs245269;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StudentDatabase {
    Logger log = LoggerFactory.getLogger(StudentDatabase.class);
    private final Map<Student, Map<Subject, Integer>> studentsWithGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectsWithStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        checkInputData(student, grades);
        studentsWithGrades.putIfAbsent(student, grades);
        log.info("Student {} added to base", student);
        grades.forEach((subject, integer) -> {
            List<Student> students = subjectsWithStudents
                    .computeIfAbsent(subject, key -> new ArrayList<>());
            students.add(student);
            log.info("For subject {} added student {}", subject, student);
        });
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        checkInputData(student, subject);
        studentsWithGrades.computeIfPresent(student, (key, grades) -> {
            grades.put(subject, grade);
            List<Student> students = subjectsWithStudents.computeIfAbsent(subject, studentsKey -> new ArrayList<>());
            students.add(student);
            log.info("For student {} added subject {} and grade {}", student, subject, grade);
            return grades;
        });
    }

    public void removeStudent(Student student) {
        checkInputData(student);

        Optional.ofNullable(studentsWithGrades.remove(student))
                .ifPresent(grades -> grades.forEach((subject, integer) -> {
                    List<Student> students = subjectsWithStudents.get(subject);
                    students.remove(student);
                }));
        log.info("removed student {}", student);
    }

    public void printAllStudentsWithGrades() {
        studentsWithGrades.forEach((student, grades) -> {
            System.out.println(student);
            grades.forEach((subject, grade) -> System.out.println(subject + " " + grade));
        });
        log.info("All students was printed");
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        checkInputData(subject, students);
        subjectsWithStudents.put(subject, students);

        students.forEach(student -> {
            Map<Subject, Integer> map = studentsWithGrades.computeIfAbsent(student, key -> new HashMap<>());
            map.computeIfAbsent(subject, key -> null);
        });
        log.info("for subject {} added students {}", subject, students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        checkInputData(student, subject);

        List<Student> students = subjectsWithStudents.computeIfAbsent(subject, key -> new ArrayList<>());
        students.add(student);

        Map<Subject, Integer> subjectGrades = studentsWithGrades.computeIfAbsent(student, key -> new HashMap<>());
        subjectGrades.put(subject, null);
        log.info("for subject {} added student {}", subject, student);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        checkInputData(student, subject);
        if (!studentsWithGrades.containsKey(student)) {
            throw new NoSuchElementException("No such Student");
        }

        List<Student> students = subjectsWithStudents.get(subject);
        students.remove(student);

        Map<Subject, Integer> studentGrades = studentsWithGrades.get(student);
        studentGrades.remove(subject);
        log.info("Student {} was deleted from subject {}", student, subject);
    }

    public void printAllSubjectsWithStudents() {
        subjectsWithStudents.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(System.out::println);
        });
        log.info("All subjects wis students was printed");
    }

    private <T> void checkInputData(T... t) {
        for (T object : t) {
            if (object == null) {
                throw new IllegalArgumentException("input data cannot be null");
            }
        }
    }
}
