package school.faang.doubleCash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentsGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> learntSubjects = new HashMap<>();

    public static void main(String[] args) {
        Student ilya = new Student(13248, "Ilya Vyalov");
        Student sasha = new Student(48123, "Alexandr Tolstopyatenko");
        Subject algebra = new Subject(1, "Linear algebra");
        Subject diff = new Subject(2, "Differential equations");
        Subject philosophy = new Subject(3, "Philosophy");

        List<Subject> ilyasSubjects = new LinkedList<>(List.of(algebra, diff));
        List<Integer> ilyasGrades = new LinkedList<>(List.of(4, 3));
        List<Subject> sashasSubjects = new LinkedList<>(List.of(algebra, philosophy));
        List<Integer> sashasGrades = new LinkedList<>(List.of(5, 5));

        List<Student> studentsLearningAlgebra = new ArrayList<>(List.of(ilya, sasha));
        List<Student> studentsLearningDiff = new ArrayList<>(List.of(sasha, ilya));
        List<Student> studentsLearningPhilosophy = new ArrayList<>(List.of(sasha));

        addStudentAndGrades(ilya, ilyasSubjects, ilyasGrades);
        addStudentAndGrades(sasha, sashasSubjects, sashasGrades);
        addSubjectAndGrade(ilya, philosophy, 2);
        printStudents();
        removeStudent(sasha);
        printStudents();

        addSubjectAndStudents(algebra, studentsLearningAlgebra);
        addSubjectAndStudents(diff, studentsLearningDiff);
        addSubjectAndStudents(philosophy, studentsLearningPhilosophy);
        printSubjects();
        addStudentToExistingSubject(philosophy, ilya);
        printSubjects();
        removeStudentFromSubject(diff, ilya);
        printSubjects();
    }

    private static void addStudentAndGrades(Student student, List<Subject> subjects, List<Integer> grades) {
        Map<Subject, Integer> gradeMap = new HashMap<>();
        for (int i = 0; i < subjects.size(); i++) {
            gradeMap.put(subjects.get(i), grades.get(i));
        }
        studentsGrades.put(student, gradeMap);
    }

    private static void addSubjectAndGrade(Student student, Subject subject, int grade) {
        for (var entry : studentsGrades.entrySet()) {
            if (entry.getKey().equals(student)) {
                Map<Subject, Integer> gradeMap = entry.getValue();
                gradeMap.put(subject, grade);
            }
        }
    }

    private static void removeStudent(Student student) {
        studentsGrades.remove(student);
    }

    private static void addSubjectAndStudents(Subject subject, List<Student> students) {
        learntSubjects.put(subject, students);
    }

    private static void addStudentToExistingSubject(Subject subject, Student student) {
        learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    private static void removeStudentFromSubject(Subject subject, Student studentToRemove) {
        for (var entry : learntSubjects.entrySet()) {
            List<Student> students = entry.getValue();
            students.removeIf(student -> (student.equals(studentToRemove) && entry.getKey().equals(subject)));
        }
    }

    private static void printStudents() {
        System.out.println(studentsGrades);
    }

    private static void printSubjects() {
        System.out.println(learntSubjects);
    }
}
