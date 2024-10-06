package school.faang.BJS2_32417;

import java.util.*;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENTS_SUBJECTS = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_WITH_SUBJECT = new HashMap<>();

    public static void addStudent(Student student, Subject subject, int grade) {
        dataValidation(student, subject, grade);

        STUDENTS_SUBJECTS.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);

        STUDENTS_WITH_SUBJECT.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void addSubject(Student student, Subject subject, int grade) {
        dataValidation(student, subject, grade);

        if (!STUDENTS_SUBJECTS.containsKey(student)) {
            System.out.println("Студент не найден");
        }

        STUDENTS_SUBJECTS.get(student).putIfAbsent(subject, grade);

        STUDENTS_WITH_SUBJECT.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudent(Student student) {
        dataValidation(student);

        STUDENTS_SUBJECTS.remove(student);
    }

    //для доп возможности удалить студента по id
    public static void deleteStudent(int id) {
        STUDENTS_SUBJECTS.entrySet().removeIf(entry -> entry.getKey().getId() == id);
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

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        dataValidation(students, subject);

        STUDENTS_WITH_SUBJECT.putIfAbsent(subject, students);
    }

    public static void addNewStudentToSubject(Student student, Subject subject) {
        dataValidation(student, subject);

        if (!STUDENTS_WITH_SUBJECT.containsKey(subject)) {
            System.out.println("Предмет не найден");
        }

        STUDENTS_WITH_SUBJECT.get(subject).add(student);
    }

    public static void deleteStudentFromSubject(Student student, Subject subject) {
        dataValidation(student, subject);

        if (STUDENTS_WITH_SUBJECT.containsKey(subject)) {
            STUDENTS_WITH_SUBJECT.get(subject).remove(student);
        } else {
            System.out.println("Предмет не найден");
        }
    }

    public static void getAllSubjectsWithStudents() {
        for (var entry : STUDENTS_WITH_SUBJECT.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Subjects: " + subject.getName() + " has students ");

            for (Student student : students) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }

    private static void dataValidation(Student student, Subject subject, int grade) {
        if (Objects.isNull(student) && Objects.isNull(subject) && grade <= 0) {
            throw new IllegalArgumentException("Проверьте данные");
        }
    }

    private static void dataValidation(Student student, Subject subject) {
        if (Objects.isNull(student) && Objects.isNull(subject)) {
            throw new IllegalArgumentException("Проверьте данные");
        }
    }

    private static void dataValidation(List<Student> students, Subject subject) {
        if (students.isEmpty() && Objects.isNull(subject)) {
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

        addStudent(mark, new Subject(1, "CS"), 5);
        addStudent(tim, new Subject(2, "English"), 4);
        addStudent(erik, new Subject(3, "Sport"), 3);

        getAllStudents();
        getAllSubjectsWithStudents();

        addSubject(tim, new Subject(4, "Mathe"), 5);
        deleteStudent(erik);

        Subject chemistry = new Subject(5, "Chemistry");
        addSubjectAndStudents(chemistry, List.of(mark, tim));

        getAllStudents();
        getAllSubjectsWithStudents();
    }
}