package school.faang.task_45239;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);

        grades.keySet().forEach(subject ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student)
        );
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            grades.keySet().forEach(subject -> {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            });
        }
    }

    public void printAllStudentsWithGrades() {
        studentGrades.forEach((student, grades) -> {
            System.out.println("Student: " + student.name());
            grades.forEach((subject, grade) ->
                    System.out.println("  Subject: " + subject.name() + ", Grade: " + grade)
            );
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));

        students.forEach(student ->
                studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null)
        );
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }

        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        studentGrades.forEach((student, grades) -> {
            System.out.println("Student: " + student.name());
            grades.forEach((subject, grade) ->
                    System.out.println("  Subject: " + subject.name() + ", Grade: " + grade)
            );
        });
    }
}