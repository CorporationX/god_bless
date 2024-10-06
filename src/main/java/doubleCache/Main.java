package doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<Student, Map<Subject, Integer>> STUDENT_PERFORMANCE = new HashMap<>();
    static final Map<Subject, List<Student>> STUDENTS_SUBJECT = new HashMap<>();

    public static void addStudent(Student student, Map<Subject, Integer> subjectPerf) {
        STUDENT_PERFORMANCE.putIfAbsent(student, subjectPerf);
        STUDENT_PERFORMANCE.get(student).forEach((subject, grade) -> {
            addStudentToSubjects(student, subject);
        });
    }

    public static void addSubjectAndGradeToStudent(Student student, Subject subject, Integer grade) {
        addStudentToSubjects(student, subject);
        STUDENT_PERFORMANCE.get(student).put(subject, grade);
    }

    public static void deleteStudent(Student student) {
        List<Subject> subjectsToByDeleted = new ArrayList<>();
        STUDENTS_SUBJECT.forEach((subject, students) -> {
            students.remove(student);
            if (students.isEmpty()) {
                subjectsToByDeleted.add(subject);
            }
        });

        subjectsToByDeleted.forEach(STUDENTS_SUBJECT::remove);

        STUDENT_PERFORMANCE.remove(student);
    }

    public static void printStudentsPerformance() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_PERFORMANCE.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
    }

    public static void addSubjectToStudents(Subject subject, List<Student> students) {
        STUDENTS_SUBJECT.put(subject, students);
    }

    public static void addStudentToSubjects(Student student, Subject subject) {
        STUDENTS_SUBJECT.putIfAbsent(subject, new ArrayList<>());
        STUDENTS_SUBJECT.get(subject).add(student);
    }

    public static void deleteStudentFromSubjects(Subject subject, Student student) {
        STUDENTS_SUBJECT.get(subject).remove(student);

        if (STUDENTS_SUBJECT.get(subject).isEmpty()) {
            STUDENTS_SUBJECT.remove(subject);
        }

        STUDENT_PERFORMANCE.get(student).remove(subject);
    }

    public static void printSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : STUDENTS_SUBJECT.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
    }


    public static void main(String[] args) {
        addStudent(new Student(1, "Alice"), new HashMap<>() {{
            put(new Subject(101, "Math"), 4);
            put(new Subject(102, "Science"), 5);
        }});
        addStudent(new Student(2, "Bob"), new HashMap<>() {{
            put(new Subject(103, "History"), 4);
            put(new Subject(104, "Art"), 5);
        }});
        addStudent(new Student(3, "John"), new HashMap<>() {{
            put(new Subject(105, "Music"), 4);
            put(new Subject(106, "Geography"), 5);
            put(new Subject(101, "Math"), 5);
        }});

        System.out.println("Добавление предмета с оценкой");
        addSubjectAndGradeToStudent(new Student(2, "Bob"), new Subject(105, "Music"), 3);
        printStudentsPerformance();
        printSubjectsWithStudents();
        System.out.println();

        System.out.println("Удаление студента");
        deleteStudent(new Student(3, "John"));
        printStudentsPerformance();
        printSubjectsWithStudents();
        System.out.println();


        System.out.println("Добавление студентов к предмету");
        addSubjectToStudents(new Subject(105, "Music"), List.of(
                new Student(2, "Bob"),
                new Student(3, "John")
        ));
        printSubjectsWithStudents();
        System.out.println();

        System.out.println("Добавление студента к предмету");
        addStudentToSubjects(new Student(2, "Bob"), new Subject(106, "Geography"));
        printSubjectsWithStudents();
        System.out.println();

        System.out.println("Удаление студента из предмета");
        deleteStudentFromSubjects(new Subject(106, "Geography"), new Student(2, "Bob"));
        printSubjectsWithStudents();
        System.out.println();


    }
}
