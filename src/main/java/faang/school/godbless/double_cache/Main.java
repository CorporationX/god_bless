package faang.school.godbless.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // Подумал что логичнее использовать List<Integer> для оценок, иначе для одного предмета возможно только 1 оценка
    private static final Map<Student, Map<Subject, List<Integer>>> STUDENT_MAP = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_MAP = new HashMap<>();
    private static final Subject MATHS = new Subject("maths");
    private static final Subject LANGUAGE = new Subject("language");

    public static void main(String[] args) {
        addNewStudentWithSubjects(new Student("test"), new HashMap<>(
                Map.of(
                        MATHS, new ArrayList<>(List.of(4, 5)),
                        LANGUAGE, new ArrayList<>(List.of(3, 5))
                )
        ));
        addNewStudentWithSubjects(new Student("new"), new HashMap<>(
                Map.of(
                        MATHS, new ArrayList<>(List.of(5))
                )
        ));
        printAllStudentsWithSubjectsAndMarks();

        addNewSubjectWithMarks(new Student(0, "test"), new Subject("PE"), new ArrayList<>(List.of(3, 3, 5, 5)));
        printAllStudentsWithSubjectsAndMarks();

        System.out.println();

        printSubjectsAndStudents();
    }

    public static void addNewStudentWithSubjects(Student student, Map<Subject, List<Integer>> subjectsWithMarks) {
        STUDENT_MAP.put(student, subjectsWithMarks);
        subjectsWithMarks.forEach((k, v) -> {
            SUBJECT_MAP.computeIfAbsent(k, e -> new ArrayList<>());
            SUBJECT_MAP.get(k).add(student);
        });
    }

    public static void addNewSubjectWithMarks(Student student, Subject subject, List<Integer> marks) {
        STUDENT_MAP.get(student).computeIfAbsent(subject, k -> new ArrayList<>());
        STUDENT_MAP.get(student).get(subject).addAll(marks);
        SUBJECT_MAP.computeIfAbsent(subject, k -> new ArrayList<>());
        SUBJECT_MAP.get(subject).add(student);
    }

    public static void deleteStudent(Student student) {
        STUDENT_MAP.remove(student);
    }

    public static void printAllStudentsWithSubjectsAndMarks() {
        STUDENT_MAP.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

    public static void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        SUBJECT_MAP.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (!SUBJECT_MAP.get(subject).contains(student)) {
            SUBJECT_MAP.get(subject).add(student);
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student student) {
        SUBJECT_MAP.get(subject).remove(student);
    }

    public static void printSubjectsAndStudents() {
        SUBJECT_MAP.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

}
