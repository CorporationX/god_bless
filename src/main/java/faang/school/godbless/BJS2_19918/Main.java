package faang.school.godbless.BJS2_19918;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> subjectGradesByStudent = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
    private static Map<Student, Integer> indexesByStudent = new HashMap<>();

    public static void main(String[] args) {
        Subject math = new Subject(1, "Math");
        Subject physics = new Subject(2, "Physics");
        Subject english = new Subject(3, "English");

        Student alex = new Student(1, "Alex");
        Student maria = new Student(2, "Maria");
        Student max = new Student(3, "Max");

        Map<Subject, Integer> alexSubjectGrades = new HashMap<>();
        alexSubjectGrades.put(math, 8);
        alexSubjectGrades.put(physics, 9);
        Map<Subject, Integer> mariaSubjectGrades = new HashMap<>();
        mariaSubjectGrades.put(math, 9);
        mariaSubjectGrades.put(english, 9);

        addStudent(alex, alexSubjectGrades);
        addStudent(maria, mariaSubjectGrades);
        addSubjectForStudent(alex, english, 10);
        System.out.println("Adding result: ");
        printStudents();
        deleteStudent(alex);
        System.out.println("Deleting result:");
        printStudents();

        List<Student> students = new ArrayList<>();
        students.add(alex);
        students.add(maria);

        addSubject(math, students);
        addStudentToSubject(physics, max);
        System.out.println("Adding result: ");
        printSubjects();
        deleteStudentFromSubject(maria, math);
        System.out.println("Deleting result:");
        printSubjects();
    }

    public static void addStudent(Student student, Map<Subject, Integer> subjects) {
        subjectGradesByStudent.put(student, subjects);
    }

    private static void addSubjectForStudent(Student student, Subject subject, int grade) {
        subjectGradesByStudent.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
    }

    private static void deleteStudent(Student student) {
        subjectGradesByStudent.remove(student);
    }

    private static void printStudents() {
        for (var student : subjectGradesByStudent.entrySet()) {
            System.out.println(student.getKey());
            for (var subjectGrade : student.getValue().entrySet()) {
                System.out.println("Subject:");
                System.out.println(subjectGrade.getKey());
                System.out.println("Grade: " + subjectGrade.getValue());
            }
        }
    }

    private static void addSubject(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
        for (int i = 0; i < students.size(); i++) {
            indexesByStudent.put(students.get(i), i);
        }
    }

    private static void addStudentToSubject(Subject subject, Student student) {
        studentsBySubject.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        int index = studentsBySubject.get(subject).size() - 1;
        indexesByStudent.put(student, index);
    }

    private static void deleteStudentFromSubject(Student student, Subject subject) {
        int index = indexesByStudent.remove(student);
        studentsBySubject.get(subject).remove(index);
    }

    private static void printSubjects() {
        for (var subject : studentsBySubject.entrySet()) {
            System.out.println("Subject: ");
            System.out.println(subject.getKey());
            System.out.println("Students: ");
            subject.getValue().forEach(System.out::println);
        }
    }
}
