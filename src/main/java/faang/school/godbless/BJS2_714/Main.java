package faang.school.godbless.BJS2_714;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Student, Map<Subject, Integer>> subjectsAndGrandesByStudent = new HashMap<>();
    public static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student("John Doe");
        Student student2 = new Student("Jane Doe");

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");

        addSubjectsAndGradesWithStudent(student1, Map.of(math, 90, physics, 85));
        addSubjectsAndGradesWithStudent(student2, Map.of(math, 95, physics, 88));

        System.out.println("All Students and Their Grades:");
        showAllStudentsAndGrades();

        addSubjectAndStudents(physics, new ArrayList<>(List.of(student1, student2)));

        System.out.println("\nAll Subjects and Students:");
        showStudentsBySubject();

        addSubjectToStudent(student2, math);

        System.out.println("\nAfter adding a new student to Math:");
        showStudentsBySubject();

        removeStudentAndGrades(student1);

        System.out.println("\nAfter removing John Doe:");
        showAllStudentsAndGrades();
    }

    public static void addSubjectsAndGradesWithStudent(Student student, Map<Subject, Integer> subjectAndGrades) {
        subjectsAndGrandesByStudent.putIfAbsent(student, subjectAndGrades);
        subjectAndGrades.keySet().forEach(subject ->
        {
            List<Student> existsStudents = studentsBySubject.computeIfAbsent(subject, students -> new ArrayList<>());
            if (!existsStudents.contains(student)) {
                existsStudents.add(student);
            }
        });
    }

    public static void addSubjectAndGradeToStudent(Student student, Subject subject, int grade) {
        subjectsAndGrandesByStudent.computeIfAbsent(student, v -> new HashMap<>())
                .put(subject, grade);
        studentsBySubject.computeIfAbsent(subject, students -> new ArrayList<>())
                .add(student);
    }

    public static void removeStudentAndGrades(Student student) {
        subjectsAndGrandesByStudent.remove(student);
        studentsBySubject.values().forEach(students -> students.remove(student));
    }

    public static void showAllStudentsAndGrades() {
        subjectsAndGrandesByStudent.forEach((student, subjectsAndGrades) -> {
            System.out.println(student.getName() + ": " + subjectsAndGrades);
        });
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
    }

    public static void addSubjectToStudent(Student student, Subject subject) {
        studentsBySubject.getOrDefault(subject, new ArrayList<>()).add(student);
    }

    public static void showStudentsBySubject() {
        studentsBySubject.forEach((sbj, students) -> {
            System.out.println("Subject is " + sbj + " and students: " + students);
        });
    }
}
