package faang.school.godbless.module1.sprint1.task14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Student, Map<Subject, Integer>> PERFORMANCE = new HashMap<>();
    public static final Map<Subject, List<Student>> GROUP_BY_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Subject subject = new Subject(1, "Geography");

        addStudentWithSubsAndGrades(new Student(1, "Alex"), subject, 5);
        addSubjectWithGradeByStudent(new Student(1, "Alex"), new Subject(2, "Economy"), 5);

        deleteStudent(new Student(1, "Alex"));
        printAllStudentsWithGrades();

        addListStudentsBySubject(new ArrayList<>() {{
            add(new Student(1, "Alex"));
            add(new Student(2, "Piter"));
        }}, subject);

        addListStudentsBySubject(List.of(new Student(1, "Alex"),
                new Student(2, "Piter")), subject);

        addStudentInGroupInSubject(new Student(3, "Adolph"), subject);
        deleteStudentFromGroup(new Student(3, "Adolph"), subject);
        printGroups(GROUP_BY_STUDENTS);
    }

    public static void addStudentWithSubsAndGrades(Student student,
                                                   Subject subject,
                                                   Integer grade) {
        Map<Subject, Integer> studentGrades = new HashMap<>();
        studentGrades.put(subject, grade);
        PERFORMANCE.put(student, studentGrades);

    }

    public static void addSubjectWithGradeByStudent(Student student, Subject subject, Integer grade) {
        PERFORMANCE.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }


    public static void deleteStudent(Student student) {
        PERFORMANCE.remove(student);
    }

    public static void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : PERFORMANCE.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Map.Entry<Subject, Integer> sub : entry.getValue().entrySet()) {
                System.out.print(sub.getKey() + ": " + sub.getValue() + " ");
            }
            System.out.println();
        }
    }

    public static void addListStudentsBySubject(List<Student> students, Subject subject) {
        for (Student student : students) {
            GROUP_BY_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public static void addStudentInGroupInSubject(Student student, Subject subject) {
        GROUP_BY_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromGroup(Student student, Subject subject) {
        GROUP_BY_STUDENTS.get(subject).remove(student);
    }

    public static void printGroups(Map<Subject, List<Student>> groups) {
        for (Map.Entry<Subject, List<Student>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ");
        }
    }
}
