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
        if (!validate(studentName) || !validate(studentSubjectsAndMarks)) {
            return;
        }

        Student student = new Student(studentName);
        studentsScores.put(student, studentSubjectsAndMarks);

        //Optional can bind with addSubject if needed
        studentSubjectsAndMarks.forEach((subject, mark) -> {
            var studentsForSubject = subjectsStudents.get(subject);
            if (studentsForSubject != null) {
                boolean studentExists = studentsForSubject.stream().anyMatch(studentRegistered -> Objects.equals(
                        studentRegistered.getId(), student.getId()));

                if (!studentExists) {
                    studentsForSubject.add(student);
                } else {
                    studentsForSubject = new ArrayList<>();
                    studentsForSubject.add(student);
                    subjectsStudents.put(subject, studentsForSubject);
                }
            }
        });
    }

    public Student findStudent(UUID studentid) {
        //  if (!validate(studentid)) { return null; }

        return studentsScores.keySet().stream()
                .filter(existingStudent -> Objects.equals(existingStudent.getId(), studentid))
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Student not found by Id");
                    return null;
                });
        //.orElseThrow(() -> new IllegalArgumentException("Student not found by Id"));
    }

    public Student findStudentByName(String name) {
        //  if (!validate(name)) { return null; }

        return studentsScores.keySet().stream()
                .filter(existingStudent -> Objects.equals(existingStudent.getName(), name))
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Student not found by name");
                    return null;
                });
        //.orElseThrow(() -> new IllegalArgumentException("Student not found by name"));
    }

    public void addStudentSubject(UUID studentId, Map.Entry<Subject, Integer> subjectAndMark) {
        if (!validate(studentId) || !validate(subjectAndMark)) {
            return;
        }

        Student student = findStudent(studentId);
        Map<Subject, Integer> subjectsAndMarks = studentsScores.get(student);
        subjectsAndMarks.put(subjectAndMark.getKey(), subjectAndMark.getValue());
        studentsScores.put(student, subjectsAndMarks);

        //Optional can bind with addSubjectStudent if needed
        //Optional can bind with addSubject if needed
    }

    public void removeStudent(UUID studentId) {
        if (!validate(studentId)) {
            return;
        }

        Student student = findStudent(studentId);
        studentsScores.remove(student);
    }

    public void printAllStudentsWithScores() {
        if (!validate(studentsScores)) {
            System.out.println("Students list is empty!");
        }

        studentsScores.forEach((student, scores) -> {
            System.out.println(student);
            scores.forEach((subject, score) -> System.out.println("Subject: " + subject
                    + " Score: " + score));
        });
    }

    public void addSubject(String subjectName, List<Student> studentsOnCourse) {
        if (!validate(subjectName) || !validate(studentsOnCourse)) {
            return;
        }

        Subject subject = new Subject(subjectName);
        subjectsStudents.put(subject, studentsOnCourse);

        //Optional can bind with addStudent if needed
    }

    public Subject findSubject(UUID subjectId) {
        //  if (!validate(subjectId)) { return null; }

        return subjectsStudents.keySet().stream()
                .filter(existingStudent -> Objects.equals(existingStudent.getId(), subjectId))
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Subject not found by Id");
                    return null;
                });
        //.orElseThrow(() -> new IllegalArgumentException("Subject not found by Id"));
    }

    public Subject findSubjectByName(String name) {
        //  if (!validate(name)) { return null; }

        return subjectsStudents.keySet().stream()
                .filter(existingStudent -> Objects.equals(existingStudent.getName(), name))
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Subject not found by name");
                    return null;
                });
        //.orElseThrow(() -> new IllegalArgumentException("Subject not found by name"));
    }

    public void addSubjectStudent(UUID subjectId, Student studentOnCourse) {
        if (!validate(subjectId) || !validate(studentOnCourse)) {
            return;
        }

        Subject subject = findSubject(subjectId);
        List<Student> students = subjectsStudents.get(subject);
        students.add(studentOnCourse);
        subjectsStudents.put(subject, students);

        //Optional can bind with addStudentSubject if needed
        //Optional can bind with addStudent if needed
    }

    public void removeStudentFromSubject(UUID subjectId, Student studentOnCourse) {
        if (!validate(subjectId) || !validate(studentOnCourse)) {
            return;
        }

        Subject subject = findSubject(subjectId);
        subjectsStudents.remove(subject);
    }

    public void printAllSubjectsWithStudents() {
        if (!validate(subjectsStudents)) {
            System.out.println("Subjects list is empty!");
        }

        subjectsStudents.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(student -> System.out.println("Student: " + student));
        });
    }
}
