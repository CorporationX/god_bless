package faang.school.godbless.BJS219754;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentAndMarks = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void addNewStudentAndMarks(Student student, Map<Subject, Integer> marks) {
        studentAndMarks.put(student, marks);
    }

    public static void addMarkForStudent(Student student, Subject subject, int mark) {
        Map<Subject, Integer> marks = studentAndMarks.get(student);
        if (marks != null) {
            marks.put(subject, mark);
        } else {
            System.out.println("Student not found: " + student.getName());
        }
    }

    public static void removeStudentAndMarks(Student student) {
        if (studentAndMarks.containsKey(student)) {
            studentAndMarks.remove(student);
        } else {
            System.out.println("Student not found: " + student.getName());
        }
    }

    public static void printStudentsAndMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentAndMarks.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            for (Map.Entry<Subject, Integer> entryMark : entry.getValue().entrySet()) {
                System.out.println(entryMark.getKey().getName() + " - " + entryMark.getValue());
            }
        }
    }

    public static void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
    }

    public static void addStudentForSubject(Student student, Subject subject) {
        List<Student> students = studentsBySubject.get(subject);
        if (students != null) {
            students.add(student);
        } else {
            System.out.println("Subject not found: " + subject.getName());
        }
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = studentsBySubject.get(subject);
        if (students != null) {
            students.remove(student);
        } else {
            System.out.println("Subject not found: " + subject.getName());
        }
    }

    public static void printSubjectAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey().getName() + ":");
            for (Student student : entry.getValue()) {
                System.out.println("-" + student.getName());
            }
        }
    }
}
