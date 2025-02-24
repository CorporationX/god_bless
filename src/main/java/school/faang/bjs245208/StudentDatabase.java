package school.faang.bjs245208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static school.faang.bjs245208.ValidatorUtil.validate;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentsScores = new HashMap<>();
    private final Map<Subject, List<Student>> subjectsStudents = new HashMap<>();

    public void addStudent(String studentName, Map<Subject, Integer> studentSubjectsAndMarks) {
        validate(studentName);
        validate(studentSubjectsAndMarks);

        Student student = new Student(studentName);
        studentsScores.put(student, studentSubjectsAndMarks);

        studentSubjectsAndMarks.keySet().forEach(subject -> {
            var currentSubjectStudents = subjectsStudents.computeIfAbsent(subject, s -> new ArrayList<>());
            currentSubjectStudents.add(student);
        });
    }

    public Student findStudent(UUID studentId) {
        validate(studentId);

        Student foundStudent = null;
        for (Student student : studentsScores.keySet()) {
            if (Objects.equals(student.getId(), studentId)) {
                if (foundStudent != null) {
                    throw new IllegalArgumentException("More than one student found with the same ID");
                }
                foundStudent = student;
            }
        }

        if (foundStudent == null) {
            throw new IllegalArgumentException("Student not found by Id");
        }
        return foundStudent;
    }

    public Student findStudentByName(String studentName) {
        validate(studentName);

        return studentsScores.keySet().stream()
                .filter(existingStudent -> Objects.equals(existingStudent.getName(), studentName))
                .reduce((a, b) -> {
                    throw new IllegalArgumentException("More than one student found with the same name");
                })
                .orElseThrow(() -> new IllegalArgumentException("Student not found by name"));
    }

    public void addStudentSubject(UUID studentId, Map.Entry<Subject, Integer> subjectAndMark) {
        validate(studentId);
        validate(subjectAndMark);

        Student student = findStudent(studentId);
        Map<Subject, Integer> subjectsAndMarks = studentsScores.get(student);
        subjectsAndMarks.put(subjectAndMark.getKey(), subjectAndMark.getValue());
    }

    public void removeStudent(UUID studentId) {
        validate(studentId);

        Student student = findStudent(studentId);
        studentsScores.remove(student);
    }

    public void printAllStudentsWithScores() {
        validate(studentsScores);

        studentsScores.forEach((student, scores) -> {
            System.out.println(student);
            scores.forEach((subject, score) -> System.out.println("Subject: " + subject
                    + " Score: " + score));
        });
    }

    public void addSubject(String subjectName, List<Student> studentsOnCourse) {
        validate(subjectName);
        validate(studentsOnCourse);

        Subject subject = new Subject(subjectName);
        subjectsStudents.put(subject, studentsOnCourse);
    }

    public Subject findSubject(UUID subjectId) {
        validate(subjectId);

        return subjectsStudents.keySet().stream()
                .filter(existingsubject -> Objects.equals(existingsubject.getId(), subjectId))
                .reduce((a, b) -> {
                    throw new IllegalArgumentException("More than one subject found with the same id");
                })
                .orElseThrow(() -> new IllegalArgumentException("Subject not found by id"));
    }

    public Subject findSubjectByName(String subjectName) {
        validate(subjectName);

        return subjectsStudents.keySet().stream()
                .filter(existingsubject -> Objects.equals(existingsubject.getName(), subjectName))
                .reduce((a, b) -> {
                    throw new IllegalArgumentException("More than one subject found with the same name");
                })
                .orElseThrow(() -> new IllegalArgumentException("Subject not found by name"));
    }

    public void addSubjectStudent(UUID subjectId, Student studentOnCourse) {
        validate(subjectId);
        validate(studentOnCourse);

        Subject subject = findSubject(subjectId);
        List<Student> students = subjectsStudents.get(subject);
        students.add(studentOnCourse);
    }

    public void removeStudentFromSubject(UUID subjectId, Student studentOnCourse) {
        validate(subjectId);
        validate(studentOnCourse);

        Subject subject = findSubject(subjectId);
        subjectsStudents.remove(subject);
    }

    public void printAllSubjectsWithStudents() {
        validate(subjectsStudents);

        subjectsStudents.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(student -> System.out.println("Student: " + student));
        });
    }
}
