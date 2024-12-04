package school.faang.task_45206;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StudentDatabase {
    public final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    public final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades) {
        studentGrades.put(student, subjectsGrades);
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentGrades.forEach((currentStudent, subjectsGrades) -> {
            if (Objects.equals(student, currentStudent)) {
                subjectsGrades.put(subject, grade);
            }
        });
    }

    public void deleteStudent(Student student) {
        studentGrades.remove(student);
    }

    public void printAllStudentsWithSubjects() {
        studentGrades.forEach((student, subjectsGrades) -> {
            System.out.println(student);
            subjectsGrades.forEach((subject, grade) -> {
                System.out.println(subject + ": " + grade);
            });
        });
    }

    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        subjectStudents.put(subject, students);
    }

    public void addStudentForSubject(Subject subject, Student student) {
        subjectStudents.forEach((currentSubject, students) -> {
            if (Objects.equals(subject, currentSubject)) {
                students.add(student);
            }
        });
    }

    public void deleteStudentFromSubject(Subject subject, Student student) {
        subjectStudents.forEach((currentSubject, students) -> {
            if (Objects.equals(subject, currentSubject)) {
                students.remove(student);
            }
        });
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println(subject + ":");
            students.forEach(System.out::println);
        });
    }
}