package faang.school.godbless.doubleCash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public static void addNewStudentWithSubjectsAndScores(Student student, Map<Subject, Integer> subjectsWithScores) {
        if (!studentMap.containsKey(student)) {
            studentMap.put(student, subjectsWithScores);
            for (Map.Entry<Subject, Integer> entry : subjectsWithScores.entrySet()) {
                addStudentIntoSubjectMap(student, entry.getKey());
            }
        } else {
            subjectsWithScores.forEach((subject, score) -> addNewSubjectForStudent(student, subject, score));
        }
    }

    public static void addNewSubjectForStudent(Student student, Subject subject, int score) {
        studentMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, score);
        addStudentIntoSubjectMap(student, subject);
    }

    public static void removeStudent(Student student) {
        if (studentMap.containsKey(student)) {
            for (Subject subject : studentMap.get(student).keySet()) {
                removeStudentFromSubject(student, subject);
            }
            studentMap.remove(student);
        }
    }

    public static void printStudentsWithSubjectsAndScores() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentMap.entrySet()) {
            stringBuilder.append(studentMapEntry.getKey()).append(":").append(System.lineSeparator());
            for (Map.Entry<Subject, Integer> subjectMapEntry : studentMapEntry.getValue().entrySet()) {
                stringBuilder.append(String.format("    -%s: Оценка - %d%n", subjectMapEntry.getKey(), subjectMapEntry.getValue()));
            }
        }
        System.out.println(stringBuilder);
    }

    public static void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        subjectMap.put(subject, students);
    }

    public static void addStudentIntoSubjectMap(Student student, Subject subject) {
        subjectMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        subjectMap.get(subject).remove(student);
    }

    public static void printSubjectsAndThemStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> entry : subjectMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(":").append(System.lineSeparator());
            for (Student student : entry.getValue()) {
                stringBuilder.append("    -").append(student).append(System.lineSeparator());
            }
        }
        System.out.println(stringBuilder);
    }

    public static void printInfo() {
        printStudentsWithSubjectsAndScores();
        System.out.println("-----------------------");
        printSubjectsAndThemStudents();
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Subject math = new Subject(1, "Математика");
        Subject geo = new Subject(2, "География");
        Subject fiz = new Subject(3, "Физика");
        Subject bio = new Subject(4, "Биология");
        Subject economy = new Subject(5, "Экономика");

        Student alexey = new Student(1, "Алексей");
        Student victor = new Student(2, "Виктор");
        Student misha = new Student(3, "Михаил");
        Student vit = new Student(4, "Виталий");

        addNewStudentWithSubjectsAndScores(alexey, new HashMap<>(Map.of(math, 5, economy, 5, geo, 4)));
        printInfo();

        addNewSubjectForStudent(alexey, bio, 3);
        printInfo();

        addNewSubjectForStudent(victor, fiz, 3);
        addNewSubjectForStudent(victor, bio, 3);
        addNewSubjectForStudent(victor, geo, 3);
        printInfo();

        addNewStudentWithSubjectsAndScores(misha, new HashMap<>(Map.of(math, 4, geo, 4, bio, 4)));
        addNewStudentWithSubjectsAndScores(vit, new HashMap<>(Map.of(fiz, 5, economy, 4, bio, 4)));
        printInfo();

        removeStudent(alexey);
        printInfo();
    }
}
