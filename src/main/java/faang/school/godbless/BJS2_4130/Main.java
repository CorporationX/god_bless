package faang.school.godbless.BJS2_4130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student andrei = new Student(1, "Andrei");
        Student max = new Student(2, "Max");
        Student test = new Student(3, "Тест");

        Subject math = new Subject(1, "Математика");
        Subject physics = new Subject(2, "Физика");

        Map<Subject, Integer> andreiGrades = new HashMap<>();
        andreiGrades.put(math, 92);
        addStudent(andrei, andreiGrades);

        Map<Subject, Integer> maxGrades = new HashMap<>();
        maxGrades.put(physics, 85);
        addStudent(max, maxGrades);

        addSubjectToStudent(andrei, physics, 88);
        addSubjectToStudent(max, math, 75);
        printStudentGrades();

        addSubject(new Subject(3, "Химия"), new ArrayList<>(Arrays.asList(andrei, max, test)));

        printSubjectStudents();

        removeStudentFromSubject(physics, andrei);
        printSubjectStudents();

        removeStudent(andrei);
        printStudentGrades();
        printSubjectStudents();
    }

    public static void addStudent(Student student, Map<Subject, Integer> grades) {
        STUDENT_GRADES.put(student, grades);

        for (Subject subject : grades.keySet()) {
            SUBJECT_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> targetStudentData = STUDENT_GRADES.get(student);

        if (targetStudentData == null) {
            throw new IllegalArgumentException(String.format("Студент \"%s\", не найден!", student.getName()));
        }

        targetStudentData.put(subject, grade);
        SUBJECT_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        STUDENT_GRADES.remove(student);
        SUBJECT_STUDENTS.forEach((subject, students) -> students.remove(student));
    }

    public static void printStudentGrades() {
        STUDENT_GRADES.forEach((student, grades) -> {
            System.out.println("Студент: " + student.getName());
            grades.forEach((subject, grade) -> System.out.println(" - " + subject.getName() + ": " + grade));
        });
    }

    public static void addSubject(Subject subject, List<Student> students) {
        final int BASE_GRADE = 0;

        SUBJECT_STUDENTS.put(subject, students);
        students.forEach(student -> STUDENT_GRADES.computeIfAbsent(student, k -> new HashMap<>()).put(subject, BASE_GRADE));
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> targetSubjectData = SUBJECT_STUDENTS.get(subject);
        Map<Subject, Integer> targetStudentData = STUDENT_GRADES.get(student);

        if (targetSubjectData == null) {
            throw new IllegalArgumentException(String.format("Предмет \"%s\", не найден!", subject.getName()));
        }

        if (targetStudentData == null) {
            throw new IllegalArgumentException(String.format("Студент \"%s\", не найден!", student.getName()));
        }

        SUBJECT_STUDENTS.get(subject).remove(student);
        STUDENT_GRADES.get(student).remove(subject);
    }

    public static void printSubjectStudents() {
        SUBJECT_STUDENTS.forEach((subject, students) -> {
            System.out.println("Предмет: " + subject.getName());
            students.forEach(student -> System.out.println(" - " + student.getName()));
        });
    }
}
