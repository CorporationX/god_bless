package faang.school.godbless.doublecache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<Student, Map<Subject, Integer>> studentsMarksBySubjects = new HashMap<>();
    static Map<Subject, List<Student>> studentByEachSubject = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addNewStudent(Student student, Map<Subject, Integer> marks) {
        studentsMarksBySubjects.put(student, marks);
        Set<Subject> subjects = marks.keySet();
        for (Subject subject : subjects) {
            addStudentToSubject(subject, student);
        }
    }

    public static void addNewSubjectForExistingStudent(Student student, Subject subject, Integer mark) {
        if (studentsMarksBySubjects.containsKey(student)) {
            studentsMarksBySubjects.get(student).put(subject, mark);
        } else {
            System.out.println("There is no such student in the Map");
        }
    }

    public static void deleteStudent(Student student) {
        for (Subject subject : studentsMarksBySubjects.get(student).keySet()) {
            deleteStudentFromSubject(subject, student);
        }
        studentsMarksBySubjects.remove(student);
    }

    public static void listStudentsAndMarks() {
        studentsMarksBySubjects.forEach((student, marks) -> System.out.println("Student: " + student + ", Marks: " + marks));
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        students.forEach(student -> addStudentToSubject(subject, student));
        studentByEachSubject.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (studentByEachSubject.containsKey(subject)) {
            studentByEachSubject.get(subject).add(student);
        } else {
            studentByEachSubject.put(subject, Arrays.asList(student));
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student student) {
        if (studentByEachSubject.containsKey(subject)) {
            studentByEachSubject.get(subject).remove(student);
        } else {
            System.out.println("There is no such subject in the Map");
        }
    }

    public static void listStudentsAndSubjects() {
        studentsMarksBySubjects.forEach((student, marks) -> System.out.println("Student: " + student + ", Marks: " + marks));
        studentByEachSubject.forEach((subject, students) -> {
            System.out.println("Subject: " + subject);
            students.stream().forEach(student -> System.out.println("\t" + student));
        });
    }

}
