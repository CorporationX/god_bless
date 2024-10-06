package school.faang.BJS2_32417;

import java.util.*;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENTS_SUBJECTS = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_WITH_STUDENTS = new HashMap<>();


    public static void addStudent(Student student, Map<Subject, Integer> scores) {
        STUDENTS_SUBJECTS.computeIfAbsent(student, k -> new HashMap<>()).putAll(scores);
        for (Subject subject : scores.keySet()) {
            addSubject(subject, student);
        }
    }

    private static void addSubject(Subject subject, Student student) {
        dataValidation(student, subject);
        SUBJECT_WITH_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudent(Student student) {
        dataValidation(student);
        Set<Subject> subjectSet = STUDENTS_SUBJECTS.remove(student).keySet();
        for (Subject subject : subjectSet) {
            SUBJECT_WITH_STUDENTS.get(subject).remove(student);
        }
    }

    public static void getAllStudents() {
        for (var entry : STUDENTS_SUBJECTS.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();

            System.out.println("Student: " + student.getName() + " has subjects ");

            List<String> subjectsList = new ArrayList<>();

            for (var gradeEntry : grades.entrySet()) {
                Subject subject = gradeEntry.getKey();
                Integer grade = gradeEntry.getValue();

                subjectsList.add(subject.getName() + " с оценкой " + grade);
            }

            System.out.println(String.join(", ", subjectsList));
            System.out.println();
        }
    }

    public static void getAllSubjectsWithStudents() {
        for (var entry : SUBJECT_WITH_STUDENTS.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Subjects: " + subject.getName() + " has students ");

            for (Student student : students) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }

    private static void dataValidation(Student student, Subject subject) {
        if (Objects.isNull(student) && Objects.isNull(subject)) {
            throw new IllegalArgumentException("Проверьте данные");
        }
    }

    private static void dataValidation(Student student) {
        if (Objects.isNull(student)) {
            throw new IllegalArgumentException("Проверьте данные");
        }
    }

    public static void main(String[] args) {
        Student mark = new Student(1, "Mark");
        Student tim = new Student(2, "Tim");
        Student erik = new Student(3, "Erik");

        addStudent(mark, Map.of(new Subject(1, "CS"), 5,
                new Subject(2, "English"), 4));
        addStudent(tim, Map.of(new Subject(3, "Literature"), 4,
                new Subject(2, "English"), 4));
        addStudent(erik, Map.of(new Subject(3, "Literature"), 3,
                new Subject(1, "CS"), 5));

        getAllStudents();
        getAllSubjectsWithStudents();

        Subject chemistry = new Subject(4, "Chemistry");

        addSubject(chemistry, mark);
        deleteStudent(erik);

        getAllStudents();
        getAllSubjectsWithStudents();
    }
}