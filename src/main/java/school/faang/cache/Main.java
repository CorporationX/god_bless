package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   private static final Map<Student, Map<Subject, Integer>> STUDENTS = new HashMap<>();
   private static final Map<Subject, List<Student>> SUBJECTS = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Jack");
        Student student2 = new Student(2, "Jane");
        Student student3 = new Student(3, "Bob");
        Subject math = new Subject(1, "Math");
        Subject science = new Subject(2, "Science");
        Subject management = new Subject(3, "Management");
        Subject it = new Subject(4, "IT");

        Map<Subject, Integer> student1Grades = new HashMap<>();
        student1Grades.put(management, 3);
        student1Grades.put(math, 4);

        Map<Subject, Integer> student2Grades = new HashMap<>();
        student2Grades.put(science, 5);
        student2Grades.put(it, 4);

        addStudent(student1, student1Grades);
        addStudent(student2, student2Grades);

        addSubjectAndGrade(student1, science, 3);

        printAllStudents();
        System.out.println();

        removeStudent(student2);
        printAllStudents();


        List<Student> students = new ArrayList<>();
        students.add(student1);
        addSubject(it, students);

        addStudentToSubject(it, student3, 3);

        removeStudentFromSubject(math, student1);

        printAllStudents();
        printAllSubjects();


    }

    public static void addStudent(Student student, Map<Subject, Integer> subjects) {
        STUDENTS.put(student, subjects);
        subjects.forEach((k, v) -> SUBJECTS.computeIfAbsent(k, s -> new ArrayList<>()).add(student));
    }

    public static void addSubjectAndGrade(Student student, Subject subject, int grade) {
        STUDENTS.get(student).put(subject, grade);
        SUBJECTS.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        STUDENTS.remove(student);
        SUBJECTS.forEach((k, v) -> v.remove(student));
        SUBJECTS.values().removeIf(List::isEmpty);
    }

    public static void printAllStudents() {
        STUDENTS.forEach((k, v) -> {
            System.out.printf("Student %s id %d: \n", k.getName(), k.getId());
            v.forEach((k1, v1) -> System.out.printf("%s grade: %d \n", k1.getName(), v1));
            System.out.println();
        });
    }

    public static void addSubject(Subject subject, List<Student> students) {
        students.forEach(student -> {
            SUBJECTS.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
            STUDENTS.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        });
    }

    private static void addStudentToSubject(Subject subject, Student student, int grade){
        SUBJECTS.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        STUDENTS.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public static void removeStudentFromSubject(Subject subject, Student student){
        SUBJECTS.get(subject).remove(student);
        SUBJECTS.values().removeIf(List::isEmpty);

        STUDENTS.forEach((k, v) -> v.remove(subject));
    }

    public static void printAllSubjects() {
        SUBJECTS.forEach((k, v) -> {
            System.out.printf("Subject %s id %d: \n", k.getName(), k.getId());
            v.forEach(student ->
                    System.out.printf("Student %s, id %d\n", student.getName(), student.getId()));
            System.out.println();
        });
    }
}
