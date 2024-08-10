package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Subject[] INITIAL_SUBJECTS = {
            new Subject(101, "Maths"),
            new Subject(102, "Physics"),
            new Subject(103, "Biology")
    };

    private static Map<Student, Map<Subject, Integer>> studentsAndGrades = new HashMap<>();
    private static Map<Subject, List<Student>> subjectsAndStudents = new HashMap<>();

    public static void main(String[] args) {
        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");
        Student charlie = new Student(3, "Charlie");

        Map<Subject, Integer> aliceGrades = assignGradesToSubjects(alice, INITIAL_SUBJECTS, new int[]{4, 5, 5});
        Map<Subject, Integer> bobGrades = assignGradesToSubjects(bob, INITIAL_SUBJECTS, new int[]{3, 5, 3});
        Map<Subject, Integer> charlieGrades = assignGradesToSubjects(charlie, INITIAL_SUBJECTS, new int[]{5, 4, 3});

        addNewStudentAndSubjects(alice, aliceGrades);
        addNewStudentAndSubjects(bob, bobGrades);
        addNewStudentAndSubjects(charlie, charlieGrades);

        Subject sports = new Subject(4, "Sports");

        System.out.println("\nPrinting all data after Sports has been added.");
        addSubjectToStudent(bob, sports, 4);
        addSubjectToStudent(charlie, sports, 3);

        printStudentsAndGrades();
        printSubjectsAndStudents();

        Student david = new Student(5, "David");
        removeStudent(david);
        removeStudent(bob);

        System.out.println("\nPrinting all data after deleting students.");
        printStudentsAndGrades();
        printSubjectsAndStudents();

        List<Student> newStudents = new ArrayList<>(List.of(david, bob));
        Subject arts = new Subject(105, "Arts");
        addSubjectAndStudents(arts, newStudents);

        System.out.println("\nPrinting all data after adding a new subject with students.");
        printStudentsAndGrades();
        printSubjectsAndStudents();

        addStudentToExistingSubject(alice, arts, 4);
        removeStudentFromSubject(bob, arts);

        System.out.println("\nPrinting out resulting data.");
        printStudentsAndGrades();
        printSubjectsAndStudents();
    }

    public static void addNewStudentAndSubjects(Student student, Map<Subject, Integer> subjectsAndGrades) {
        studentsAndGrades.computeIfAbsent(student, k -> subjectsAndGrades);
        for (Subject subject : subjectsAndGrades.keySet()) {
            subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public static void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentsAndGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentsAndGrades.get(student);
        if (subjects == null) {
            System.out.println("\nStudent " + student.getName() + " not found");
            return;
        }
        studentsAndGrades.remove(student);
        for (Subject subject : subjects.keySet()) {
            subjectsAndStudents.get(subject).remove(student);
        }
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        subjectsAndStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentsAndGrades.putIfAbsent(student, new HashMap<>());
            studentsAndGrades.get(student).put(subject, 0);
        }
    }

    public static void addStudentToExistingSubject(Student student, Subject subject, int grade) {
        subjectsAndStudents.get(subject).add(student);
        studentsAndGrades.putIfAbsent(student, new HashMap<>());
        studentsAndGrades.get(student).put(subject, grade);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectsAndStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectsAndStudents.remove(subject);
            }
        }
        Map<Subject, Integer> subjects = studentsAndGrades.get(student);
        if (subjects != null) {
            subjects.remove(subject);
            if (subjects.isEmpty()) {
                studentsAndGrades.remove(student);
            }
        }
    }

    public static void printStudentsAndGrades() {
        System.out.println("\nStudents and Grades:");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsAndGrades.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Subject, Integer> grades : entry.getValue().entrySet()) {
                System.out.println("  " + grades.getKey() + ": " + grades.getValue());
            }
        }
    }

    public static void printSubjectsAndStudents() {
        System.out.println("\nSubjects and Students:");
        for (Map.Entry<Subject, List<Student>> entry : subjectsAndStudents.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }

    public static Map<Subject, Integer> assignGradesToSubjects(Student student, Subject[] subjects, int[] grades) {
        if (subjects.length != grades.length) {
            throw new IllegalArgumentException("The number of subjects does not match the number of grades.");
        }

        Map<Subject, Integer> subjectGrades = new HashMap<>();
        for (int i = 0; i < subjects.length; i++) {
            subjectGrades.put(subjects[i], grades[i]);
        }
        return subjectGrades;
    }
}
