package module_1.module_1_2_HashMap.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_SCORES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student studentAlice = new Student("Alice");
        Student studentJohn = new Student("John");
        Student studentBrain = new Student("Brain");
        Subject subjectMath = new Subject("Math");
        Subject subjectBiology = new Subject("Biology");
        Subject subjectArt = new Subject("Art");
        Subject subjectHistory = new Subject("History");
        Subject subjectEnglish = new Subject("English");
        Subject subjectIT = new Subject("IT");

        addStudent(studentJohn,
                Map.of(
                        subjectMath, 5,
                        subjectBiology, 4,
                        subjectArt, 3,
                        subjectHistory, 5,
                        subjectEnglish, 4,
                        subjectIT, 3
                )
        );
        addStudent(studentAlice,
                Map.of(
                        subjectBiology, 3,
                        subjectArt, 4,
                        subjectEnglish, 5,
                        subjectIT, 5
                )
        );
        addStudent(studentBrain,
                Map.of(
                        subjectMath, 4,
                        subjectBiology, 5,
                        subjectHistory, 3
                )
        );

        printAllStudents();
        System.out.println();
        printAllSubjects();

        removeStudent(studentAlice);
        System.out.println();
        printAllStudents();

    }

    /**
     * добавление нового студента и его предметов с оценками
     *
     * @param student
     * @param scores
     */
    public static void addStudent(Student student, Map<Subject, Integer> scores) {
        STUDENT_SUBJECTS_SCORES.computeIfAbsent(student, k -> new HashMap<>()).putAll(scores);
        for (Subject subject : scores.keySet()) {
            updateSubject(subject, student);
        }
    }

    /**
     * добавление нового предмета для существующего студента с оценкой
     * добавление нового предмета и списка студентов, изучающих его
     *
     * @param subject
     */
    private static void updateSubject(Subject subject, Student student) {
        SUBJECT_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    /**
     * удаление студента и его предметов с оценками
     * удаление студента из предмета
     *
     * @param student
     */
    public static void removeStudent(Student student) {
        Set<Subject> subjects = STUDENT_SUBJECTS_SCORES.remove(student).keySet();
        for (Subject subject : subjects) {
            SUBJECT_STUDENTS.get(subject).remove(student);
        }
    }

    /**
     * вывод списка всех студентов и их оценок по предметам
     */
    public static void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECTS_SCORES.entrySet()) {
            System.out.println("Student id-" + entry.getKey().getId() + " name: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjects : entry.getValue().entrySet()) {
                System.out.println("\t" + subjects.getKey().getName() + "-" + subjects.getValue());
            }
        }
    }

    /**
     * вывод списка всех предметов и студентов, изучающих их
     */
    public static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECT_STUDENTS.entrySet()) {
            System.out.println("Subject id-" + entry.getKey().getId() + " " + entry.getKey().getName());
            if (entry.getValue() != null) System.out.println(entry.getValue());
        }
    }


}

