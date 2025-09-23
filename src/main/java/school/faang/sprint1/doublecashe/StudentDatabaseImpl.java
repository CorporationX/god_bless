package school.faang.sprint1.doublecashe;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * In-memory implementation of {@link StudentDatabase}. Provides a double-cashe approach:
 * <ol>
 *   <li>{@link #studentSubjects} - fast access to student's subject-grades info</li>
 *   <li>{@link #subjectStudents} - fast access to all students enrolled to a specific subject</li>
 * </ol>
 */
@Slf4j
public class StudentDatabaseImpl implements StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();


    @Override
    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        validateStudent(student);
        validateGrades(grades);

        studentSubjects.put(student, new HashMap<>(grades));
        grades.keySet().forEach(subject -> addStudentToSubjectInternal(student, subject));
    }

    @Override
    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        validateStudent(student);
        validateSubject(subject);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addStudentToSubjectInternal(student, subject);
    }

    @Override
    public void removeStudent(Student student) {
        validateStudent(student);

        Optional.ofNullable(studentSubjects.remove(student)) // Map<Subject, Integer> grades
            .ifPresent(grades -> grades.keySet() // Set<Subject>
                .forEach(subject -> Optional.ofNullable(subjectStudents.get(subject)) //List<Student>
                    .ifPresent(students -> students.remove(student))
                )
            );
    }

    @Override
    public String printAllStudentsWithGrades() {
        StringBuilder sb = new StringBuilder();
        studentSubjects.forEach((student, grades) -> {
            sb.append("Student: ").append(student.getName()).append("\n");
            grades.forEach((subject, grade) ->
                sb.append("\tSubject: ").append(subject.getName()).append(", Grade: ").append(grade)
                    .append("\n"));
        });
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        validateSubject(subject);
        validateStudent(students);

        subjectStudents.put(subject, new ArrayList<>(students));
        students.forEach(student -> addSubjectToStudentInternal(student, subject));
    }

    @Override
    public void addStudentToSubject(Student student, Subject subject) {
        validateStudent(student);
        validateSubject(subject);

        addStudentToSubjectInternal(student, subject);
        addSubjectToStudentInternal(student, subject);

    }

    @Override
    public void removeStudentFromSubject(Student student, Subject subject) {
        validateStudent(student);
        validateSubject(subject);

        Optional.ofNullable(subjectStudents.get(subject)) //List<Student>
            .ifPresent(students -> students.remove(student));

        Optional.ofNullable(studentSubjects.get(student)) //Map<Subject, Integer>
            .ifPresent(grades -> grades.remove(subject));
    }

    @Override
    public String printAllSubjects() {
        StringBuilder sb = new StringBuilder();
        subjectStudents.forEach((subject, students) -> {
            sb.append("Subject: ").append(subject.getName()).append("\n");
            students.forEach(student ->
                sb.append("\tStudent: ").append(student.getName()).append("\n"));
        });
        System.out.println(sb.toString());
        return sb.toString();
    }


    private void addSubjectToStudentInternal(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
            .put(subject, null);
    }

    private void addStudentToSubjectInternal(Student student, Subject subject) {
        List<Student> students = subjectStudents
            .computeIfAbsent(subject, k -> new ArrayList<>());

        if (!students.contains(student)) {
            students.add(student);
        } else {
            System.out.println("Student " + student + " is already in subject " + subject);
        }
    }

    // Validation

    private void validateGrades(Map<Subject, Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Grades cannot be null or empty");
        }
    }

    private void validateSubject(Subject subject) {
        Objects.requireNonNull(subject, "Subject cannot be null");
    }

    private void validateStudent(List<Student> students) {
        Objects.requireNonNull(students, "Students list cannot be null");
        students.forEach(this::validateStudent);
    }

    private void validateStudent(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
    }
}
