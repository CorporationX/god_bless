package school.faang.doublecachecache;

import java.util.HashMap;

import static school.faang.doublecachecache.Main.STUDENTS;
import static school.faang.doublecachecache.SubjectService.findSubjectByName;

public class StudentService {
    public static void addNewStudent(Student student, String subjectName, int grade) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        if (grade < 0 || grade > 5) {
            System.out.println("Grade must be between 0 and 5!");
            return;
        }
        STUDENTS.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public static void addSubjectForExistStudent(String studentName, String subjectName, int grade) {
        Student student = findStudentByName(studentName);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        STUDENTS.computeIfAbsent(student, stud -> new HashMap<>())
                .put(subject, grade);
    }

    public static void removeStudent(String studentName) {
        Student studentForRemove = findStudentByName(studentName);
        if (studentForRemove == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        STUDENTS.remove(studentForRemove);
    }

    public static void printInfoAcademicPerformance() {
        for (var entry : STUDENTS.entrySet()) {
            System.out.println(entry.getKey().getName() + "'s academic performance:");
            for (var subjects : entry.getValue().entrySet()) {
                System.out.println("Subject name: " + subjects.getKey() + " | Grade: " + subjects.getValue());
            }
        }
    }

    public static Student findStudentByName(String studentName) {
        for (Student student : STUDENTS.keySet()) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }
}
