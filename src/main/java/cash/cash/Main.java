package cash.cash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentGradesMap = new HashMap<>();
        Map<Subject, List<Student>> subjectStudentsMap = new HashMap<>();

        addStudentAndGrades(studentGradesMap, subjectStudentsMap, new Student(1, "Alice"));
        addGrade(studentGradesMap, subjectStudentsMap, new Student(1, "Alisson"), new Subject(101, "Math"), 85);
        addGrade(studentGradesMap, subjectStudentsMap, new Student(1, "Alisson"), new Subject(102, "History"), 92);

        addStudentAndGrades(studentGradesMap, subjectStudentsMap, new Student(2, "Bob"));
        addGrade(studentGradesMap, subjectStudentsMap, new Student(2, "James"), new Subject(101, "Math"), 78);

        printStudentGrades(studentGradesMap);

        printSubjectStudents(subjectStudentsMap);

        removeStudentAndGrades(studentGradesMap, subjectStudentsMap, new Student(1, "Alice"));

        printStudentGrades(studentGradesMap);

        printSubjectStudents(subjectStudentsMap);

        addSubjectAndStudents(subjectStudentsMap, new Subject(201, "Physics"));

        addStudentToSubject(subjectStudentsMap, new Student(3, "Gregory"), new Subject(201, "Physics"));
        addStudentToSubject(subjectStudentsMap, new Student(3, "Gregory"), new Subject(102, "History"));

        printSubjectStudents(subjectStudentsMap);

        removeStudentFromSubject(subjectStudentsMap, new Student(3, "Gregory"), new Subject(201, "Physics"));

        printSubjectStudents(subjectStudentsMap);
    }

    private static void addStudentAndGrades(Map<Student, Map<Subject, Integer>> studentGradesMap, Map<Subject, List<Student>> subjectStudentsMap, Student student) {
        studentGradesMap.putIfAbsent(student, new HashMap<>());
        System.out.println("Student " + student.getName() + " added.\n");
    }

    private static void addGrade(Map<Student, Map<Subject, Integer>> studentGradesMap, Map<Subject, List<Student>> subjectStudentsMap, Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGradesMap.computeIfAbsent(student, k -> new HashMap<>());
        grades.put(subject, grade);

        subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        System.out.println("Grade added for Student " + student.getName() + " in Subject " + subject.getName() + "\n");
    }

    private static void removeStudentAndGrades(Map<Student, Map<Subject, Integer>> studentGradesMap, Map<Subject, List<Student>> subjectStudentsMap, Student student) {
        Map<Subject, Integer> grades = studentGradesMap.remove(student);
        if (grades != null) {
            for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
                Subject subject = entry.getKey();
                List<Student> students = subjectStudentsMap.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
        System.out.println("Student " + student.getName() + " removed.\n");
    }

    private static void printStudentGrades(Map<Student, Map<Subject, Integer>> studentGradesMap) {
        System.out.println("All students:");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGradesMap.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();

            System.out.println("Student: " + student.getName());
            System.out.println("Grades:");

            for (Map.Entry<Subject, Integer> gradeEntry : grades.entrySet()) {
                Subject subject = gradeEntry.getKey();
                int grade = gradeEntry.getValue();
                System.out.println("  Subject: " + subject.getName() + ", Grade: " + grade);
            }

            System.out.println();
        }
    }

    private static void printSubjectStudents(Map<Subject, List<Student>> subjectStudentsMap) {
        System.out.println("All subjects and students:");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudentsMap.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Subject: " + subject.getName());
            System.out.println("Students:");

            for (Student student : students) {
                System.out.println("  Student: " + student.getName());
            }

            System.out.println();
        }
    }

    private static void addSubjectAndStudents(Map<Subject, List<Student>> subjectStudentsMap, Subject subject) {
        subjectStudentsMap.putIfAbsent(subject, new ArrayList<>());
        System.out.println("Subject " + subject.getName() + " added.\n");
    }

    private static void addStudentToSubject(Map<Subject, List<Student>> subjectStudentsMap, Student student, Subject subject) {
        List<Student> students = subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>());
        students.add(student);
        System.out.println("Student " + student.getName() + " added to Subject " + subject.getName() + "\n");
    }

    private static void removeStudentFromSubject(Map<Subject, List<Student>> subjectStudentsMap, Student student, Subject subject) {
        List<Student> students = subjectStudentsMap.get(subject);
        if (students != null) {
            students.remove(student);
            System.out.println("Student " + student.getName() + " removed from Subject " + subject.getName() + "\n");
        }
    }
}
