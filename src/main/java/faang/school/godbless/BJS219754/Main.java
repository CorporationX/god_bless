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
        studentAndMarks.get(student).put(subject, mark);
    }

    public static void removeStudentAndMarks(Student student) {
        studentAndMarks.remove(student);
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
        studentsBySubject.get(subject).add(student);
    }

    public static void removeStudentIsSubject(Student student, Subject subject) {
        studentsBySubject.remove(subject).remove(student);
    }

    public static void printSubjectAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println("-" + student.getName());
            }
        }
    }
}
