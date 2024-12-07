package school.faang.task_45243;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final HashMap<Student, Map<Subject, Integer>> studentGrades;
    private final HashMap<Subject, List<Student>> subjectStudents;

    public StudentDatabase(HashMap<Student, Map<Subject, Integer>> studentGrades,
                           HashMap<Subject, List<Student>> subjectStudents) {
        this.studentGrades = studentGrades;
        this.subjectStudents = subjectStudents;
    }

    public StudentDatabase() {
        this(new HashMap<>(), new HashMap<>());
    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        grades.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            grades.forEach((subject, grade) -> {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            });
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("%n%s:%n", subject);
            students.forEach(student -> {
                int grade = studentGrades.get(student).get(subject);
                System.out.printf("\t%s - %d%n", student, grade);
            });
        });
    }

}
