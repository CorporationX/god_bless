package school.faang.doublecachecache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static school.faang.doublecachecache.SubjectService.findSubjectByName;

public class StudentService {
    public static void addNewStudent(Student student, String subjectName, int grade, Map<Student, Map<Subject, Integer>> students, Set<Subject> subjects) {
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName, subjects);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        if (grade < 0 || grade > 5) {
            System.out.println("Grade must be between 0 and 5!");
            return;
        }
        students.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public static void addSubjectForExistStudent(String studentName, String subjectName, int grade, Map<Student, Map<Subject, Integer>> students, Set<Subject> subjects) {
        Student student = findStudentByName(studentName, students);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        if (student == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        Subject subject = findSubjectByName(subjectName, subjects);
        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }
        students.computeIfAbsent(student, stud -> new HashMap<>())
                .put(subject, grade);
    }

    public static void removeStudent(String studentName, Map<Student, Map<Subject, Integer>> students) {
        Student studentForRemove = findStudentByName(studentName, students);
        if (studentForRemove == null) {
            System.out.println("Student cannot be null!");
            return;
        }
        students.remove(studentForRemove);
    }

    public static void printInfoAcademicPerformance(Map<Student, Map<Subject, Integer>> students) {
        for (var entry : students.entrySet()) {
            System.out.println(entry.getKey().getName() + "'s academic performance:");
            for (var subjects : entry.getValue().entrySet()) {
                System.out.println("Subject name: " + subjects.getKey() + " | Grade: " + subjects.getValue());
            }
        }
    }

    public static Student findStudentByName(String studentName, Map<Student, Map<Subject, Integer>> students) {
        for (Student student : students.keySet()) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }
}
