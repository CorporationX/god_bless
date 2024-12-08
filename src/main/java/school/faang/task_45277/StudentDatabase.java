package school.faang.task_45277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        grades.keySet().forEach(subject ->
                subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>()).add(student)
        );
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentGrades.computeIfPresent(student, (s, grades) -> {
            grades.put(subject, grade);
            subjectStudents.computeIfAbsent(subject, sub -> new ArrayList<>()).add(student);
            return grades;
        });
    }

    public void removeStudent(Student student) {
        Optional.ofNullable(studentGrades.remove(student))
                .ifPresent(grades -> grades.keySet()
                        .forEach(subject ->
                                subjectStudents.computeIfPresent(subject, (sub, students) -> {
                                    students.remove(student);
                                    return students;
                                })
                        )
                );
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Optional.ofNullable(subjectStudents.get(subject))
                .ifPresent(students -> students.removeIf(s -> s.equals(student)));

        Optional.ofNullable(studentGrades.get(student))
                .ifPresent(grades -> grades.remove(subject));
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        students.forEach(student ->
                studentGrades.computeIfAbsent(student, s -> new HashMap<>())
                        .putIfAbsent(subject, null)
        );
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>())
                .stream()
                .filter(s -> s.equals(student))
                .findAny()
                .orElseGet(() -> {
                    subjectStudents.get(subject).add(student);
                    return student;
                });
        studentGrades.computeIfAbsent(student, s -> new HashMap<>())
                .putIfAbsent(subject, null);
    }

    public void printAllStudentsWithGrades() {
        studentGrades.forEach((student, grades) -> {
            System.out.println("Студент: " + student.getName() + " (ID: " + student.getId() + ")");
            grades.forEach((subject, grade) ->
                    System.out.println("   Предмет: " + subject.getName() + " (ID: " + subject.getId() + "), Оценка: " + grade)
            );
        });
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Предмет: " + subject.getName() + " (ID: " + subject.getId() + ")");
            students.forEach(student ->
                    System.out.println("   Студент: " + student.getName() + " (ID: " + student.getId() + ")")
            );
        });
    }
}