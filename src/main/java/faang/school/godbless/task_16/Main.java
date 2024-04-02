package faang.school.godbless.task_16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private static final Map<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Tem");
        Student student2 = new Student(2, "Valera");
        Student student3 = new Student(3, "Nikita");
        Student student4 = new Student(4, "Dasha");
        Student student5 = new Student(5, "Arseniy");
        Student student6 = new Student(6, "Kate");

        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "English");
        Subject subject3 = new Subject(3, "Literature");

        Map<Subject, Integer> marks1 = Map.of(subject1, 5, subject2, 4, subject3, 3);
        Map<Subject, Integer> marks2 = Map.of(subject1, 3, subject3, 3);
        Map<Subject, Integer> marks3 = Map.of(subject1, 4, subject2, 4);
        Map<Subject, Integer> marks4 = Map.of(subject1, 4, subject2, 3, subject3, 5);
        Map<Subject, Integer> marks5 = Map.of(subject1, 5, subject2, 4, subject3, 3);

        addStudentMarks(student1, marks1);
        addStudentMarks(student2, marks2);
        addStudentMarks(student3, marks3);
        addStudentMarks(student4, marks4);
        addStudentMarks(student5, marks5);

        addSubjectMarkToStudent(student6, subject3, 4);
        removeStudentWithMarks(student6);
        addSubjectMarkToStudent(student6, subject2, 3);
        addSubjectMarkToStudent(student6, subject3, 5);

        System.out.println(getAllStudentsAndMarks());

        addSubjectAndStudents(subject1, List.of(student1, student2, student3, student4, student5));
        addSubjectAndStudents(subject2, List.of(student1, student3, student4, student5, student6));
        addSubjectAndStudents(subject3, List.of(student1, student2, student4, student5));

//        операции не выполнятся т.к. листы иммутабельные
//
//        addStudentToSubject(subject3, student6);
//        addStudentToSubject(subject1, student6);
//
//        removeStudentFromSubject(subject1, student6);

        System.out.println(getAllSubjectsAndStudents());
    }

    public static void addStudentMarks(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
    }

    public static void addSubjectMarkToStudent(Student student, Subject subject, int mark) {
        if (!students.containsKey(student)) return;
        students.get(student).put(subject, mark);
    }

    public static void removeStudentWithMarks(Student student) {
        students.remove(student);
    }

    public static String getAllStudentsAndMarks() {
        StringBuilder builder = new StringBuilder();
        for (Student student : students.keySet()) {
            builder.append(student.getName()).append(": ");
            for (Subject subject : students.get(student).keySet()) {
                builder.append("\n").append("----").append(subject.getName())
                        .append(" -> ")
                        .append(students.get(student).get(subject));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        Main.subjects.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (!subjects.containsKey(subject)) return;
        subjects.get(subject).add(student);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (!subjects.containsKey(subject)) return;
        subjects.get(subject).remove(student);
    }

    public static String getAllSubjectsAndStudents() {
        StringBuilder builder = new StringBuilder();
        for (Subject subject : subjects.keySet()) {
            builder.append(subject.getName()).append(": ");
            for (Student student : subjects.get(subject)) {
                builder.append("\n").append("----").append(student.getName());
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
