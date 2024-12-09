package school.faang.bjs245254.repository;

import lombok.Getter;
import school.faang.bjs245254.model.Student;
import school.faang.bjs245254.model.Subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Getter
public class StudentDatabase implements StudentProvider {

    private final HashMap<Student, Map<Subject, Integer>> studentsGrades = new HashMap<>();
    private final HashMap<Subject, Set<Student>> subjectsStudent = new HashMap<>();

    @Override
    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades) {
        validate(student);
        studentsGrades.put(student, subjectsGrades);
    }

    @Override
    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        validate(student);
        studentsGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
    }

    @Override
    public void deleteStudent(Student student) {
        haveStudent(student);
        Map<Subject, Integer> subjectGrades = studentsGrades.remove(student);
        subjectGrades.forEach((subject, grades) -> {
            if (!subjectsStudent.containsKey(subject)) {
                throw new IllegalArgumentException("Subject is not found");
            }
            subjectsStudent.get(subject).remove(student);
        });
    }

    @Override
    public void printAllStudentsWithSubjects() {
        studentsGrades.forEach((student, subjectsGrades) -> {
            System.out.println(student);
            studentsGrades.forEach((subject, grades) -> {
                System.out.print(subject + ", ");
            });
            System.out.println("------------------");
        });
    }

    @Override
    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        validate(subject);
        subjectsStudent.put(subject, students);
    }

    @Override
    public void addStudentForSubject(Subject subject, Student student) {
        validate(subject);
        subjectsStudent.computeIfAbsent(subject, key -> new HashSet<>()).add(student);
    }

    @Override
    public void deleteStudentFromSubject(Subject subject, Student student) {
        validate(subject);
        haveSubject(subject);
        subjectsStudent.get(subject).remove(student);
    }

    @Override
    public void printAllSubjectsWithStudents() {
        subjectsStudent.forEach((subject, students) -> {
            System.out.print(subject + "- ");
            students.forEach(student -> {
                System.out.print(student + ", ");
            });
            System.out.println("---------------------");
        });
    }

    private void validate(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    private void haveStudent(Student student) {
        if (!studentsGrades.containsKey(student)) {
            throw new IllegalArgumentException("Student not found");
        }
    }

    private void haveSubject(Subject subject) {
        if (!subjectsStudent.containsKey(subject)) {
            throw new IllegalArgumentException("Subject not found");
        }
    }

    public void clearAll() {
        studentsGrades.clear();
        subjectsStudent.clear();
    }
}