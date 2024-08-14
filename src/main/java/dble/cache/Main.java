package dble.cache;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String NO_GRADES = "Don't have grades for this student";
    public static final String HAS_GRADES_ALREADY = "Student grades already added";
    public static final String NOT_IN_SUBJECT_LIST = "Student not in this subject list";
    public static final String NO_SUBJECT = "Don't have this subject in the list";
    public static final String HAS_SUBJECT_GRADE_ALREADY = "Student already has this subject grade";
    public static final String ALREADY_ADDED_SUBJECT = "This subject already added";
    public static final String ALREADY_ADDED_STUDENT = "This student already in this subject list";

    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        var cache = new Main();
        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Biology");
        Subject subject3 = new Subject("Chemistry");
        Student student1 = new Student("Petya");
        Student student2 = new Student("Kolya");
        Student student3 = new Student("Vasya");
        var students1 = new ArrayList<>(List.of(student1, student2));
        var students2 = new ArrayList<>(List.of(student2));
        var students3 = new ArrayList<>(List.of(student1, student3));
        var grades1 = new HashMap<>(Map.of(
                subject1, 4,
                subject3, 5));
        var grades2 = new HashMap<>(Map.of(
                subject2, 4,
                subject3, 5));
        var grades3 = new HashMap<>(Map.of(
                new Subject("English"), 4,
                subject3, 5));
        cache.addSubjectStudents(subject1, students1);
        cache.addSubjectStudents(subject2, students2);
        cache.addSubjectStudents(subject3, students3);
        cache.printAllSubjectsStudents();
        handleException(() -> cache.addSubjectStudents(subject1, students1));
        handleException(() -> cache.addSubjectStudents(subject2, students3));
        handleException(() -> cache.addSubjectStudents(subject1, students1));
        handleException(() -> cache.addStudentToSubject(new Subject("English"), student1));
        cache.printAllSubjectsStudents();
        handleException(() -> cache.removeStudentFromSubject(subject2, student3));
        handleException(() -> cache.removeStudentFromSubject(subject1, new Student("Aboba")));
        handleException(() -> cache.removeStudentFromSubject(new Subject("Programming"), student1));
        cache.printAllSubjectsStudents();
        cache.addStudentGrades(student1, grades1);
        handleException(() ->  cache.addStudentGrades(student2, grades2));
        handleException(() -> cache.addStudentGrades(student3, grades3));
        handleException(() -> cache.addStudentGrades(student1, grades1));
        cache.printAllStudentsGrades();
        cache.addStudentToSubject(subject2, student1);
        handleException(() -> cache.addGradeForStudent(student1, subject1, 5));
        handleException(() -> cache.addGradeForStudent(new Student("Aboba"), subject1, 5));
        cache.addGradeForStudent(student1, subject2, 5);
        handleException(() -> cache.addGradeForStudent(student1, new Subject("PE"), 5));
        cache.printAllStudentsGrades();
        cache.removeStudentGrades(student1);
        handleException(() -> cache.removeStudentGrades(student3));
        cache.printAllStudentsGrades();
    }

    private static void handleException(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.printf("%n%s%n", e.getMessage());
        }
    }

    public void addStudentGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        if (checkIfStudentHasGrades(student)) {
            throw new IllegalArgumentException(HAS_GRADES_ALREADY);
        }
        validateAddingGrades(student, grades);
        studentGrades.put(student, grades);
        System.out.println("\nStudent grades added");
    }

    public void addGradeForStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        validateStudentAndGrades(student, subject);
        if (studentGrades.get(student).containsKey(subject)) {
            throw new IllegalArgumentException(HAS_SUBJECT_GRADE_ALREADY);
        }
        studentGrades.get(student).put(subject, grade);
        System.out.println("\nGrade added");
    }

    public void removeStudentGrades(@NonNull Student student) {
        if (!checkIfStudentHasGrades(student)) {
            throw new IllegalArgumentException(NO_GRADES);
        }
        studentGrades.remove(student);
        System.out.println("\nGrades for this student removed");
    }

    public void printAllStudentsGrades() {
        System.out.println();
        studentGrades.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach((subject, grade) -> System.out.println("    " + subject + " : " + grade));
        });
    }

    public void addSubjectStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        if (checkIfSubjectInList(subject)) {
            throw new IllegalArgumentException(ALREADY_ADDED_SUBJECT);
        }
        subjectStudents.put(subject, students);
        System.out.println("\nSubject added");
    }

    public void addStudentToSubject(@NonNull Subject subject, @NonNull Student student) {
        if (!checkIfSubjectInList(subject)) {
            throw new IllegalArgumentException(NO_SUBJECT);
        }
        if (subjectStudents.get(subject).contains(student)) {
            throw new IllegalArgumentException(ALREADY_ADDED_STUDENT);
        }
        subjectStudents.get(subject).add(student);
        System.out.println("\nStudent added to subject");
    }

    public void removeStudentFromSubject(@NonNull Subject subject, @NonNull Student student) {
        validateSubjectAndStudent(subject, student);
        subjectStudents.get(subject).remove(student);
        System.out.println("\nStudent remove from subject");
    }

    public void printAllSubjectsStudents() {
        System.out.println();
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(student -> System.out.println("    " + student));
        }
    }

    private void validateAddingGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        for (Subject subject : grades.keySet()) {
            if (!checkIfSubjectInList(subject)) {
                throw new IllegalArgumentException(NO_SUBJECT);
            }
            if (!subjectStudents.get(subject).contains(student)) {
                throw new IllegalArgumentException(NOT_IN_SUBJECT_LIST);
            }
        }
    }

    private boolean checkIfStudentHasGrades(@NonNull Student student) {
        return studentGrades.containsKey(student);
    }

    private void validateStudentAndGrades(@NonNull Student student, @NonNull Subject subject) {
        if (!checkIfStudentHasGrades(student)) {
            throw new IllegalArgumentException(NO_GRADES);
        }
        if (!checkIfSubjectInList(subject)) {
            throw new IllegalArgumentException(NO_SUBJECT);
        }
        if (!subjectStudents.get(subject).contains(student)) {
            throw new IllegalArgumentException(NOT_IN_SUBJECT_LIST);
        }
    }

    private void validateSubjectAndStudent(@NonNull Subject subject, @NonNull Student student) {
        if (!checkIfSubjectInList(subject)) {
            throw new IllegalArgumentException(NO_SUBJECT);
        }
        if (!subjectStudents.get(subject).contains(student)) {
            throw new IllegalArgumentException(NOT_IN_SUBJECT_LIST);
        }
    }

    private boolean checkIfSubjectInList(@NonNull Subject subject) {
        return subjectStudents.containsKey(subject);
    }

    public Map<Student, Map<Subject, Integer>> getStudentGrades() {
        return studentGrades;
    }

    public Map<Subject, List<Student>> getSubjectStudents() {
        return subjectStudents;
    }
}
