package school.faang.doubleCash;

import java.util.ArrayList;
import java.util.HashMap;
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
        Subject economy = new Subject(4, "Economy Theory");
        Map<Subject, Integer> ilyaGrades = new HashMap<>();
        ilyaGrades.put(algebra, 3);
        ilyaGrades.put(diff, 4);
        Map<Subject, Integer> sashaGrades = new HashMap<>();
        sashaGrades.put(algebra, 5);
        List<Student> studentsList = new ArrayList<>(List.of(ilya, sasha));

        addStudentAndGrades(ilya, ilyaGrades);
        addStudentAndGrades(sasha, sashaGrades);
        addSubjectAndGrade(sasha, diff, 4);
        removeStudent(sasha);
        addSubjectAndStudents(economy, studentsList);
        addSubjectAndStudents(philosophy, studentsList);
        addStudentToExistingSubject(diff, sasha, 4);
        removeStudentFromSubject(ilya, philosophy);
        removeStudentFromSubject(sasha, diff);
        printStudents();
        printSubjects();
    }

    private static void addStudentAndGrades(Student student, Map<Subject, Integer> gradeMap) {
        studentsGrades.put(student, gradeMap);
        for (var entry : gradeMap.entrySet()) {
            learntSubjects.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    private static void addSubjectAndGrade(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentsGrades.get(student);
        grades.put(subject, grade);
        learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    private static void removeStudent(Student student) {
        Map<Subject, Integer> studentsSubject = studentsGrades.remove(student);
        for (var entry : studentsSubject.entrySet()) {
            List<Student> studentsList = learntSubjects.get(entry.getKey());
            studentsList.remove(student);
            if (studentsList.isEmpty()) {
                learntSubjects.remove(entry.getKey());
            }
        }
    }

    private static void addSubjectAndStudents(Subject subject, List<Student> students) {
        for (Student student : students) {
            learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    private static void addStudentToExistingSubject(Subject subject, Student student, int grade) {
        learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    private static void removeStudentFromSubject(Student studentToRemove, Subject subject) {
        List<Student> studentsToRemove = learntSubjects.get(subject);
        studentsToRemove.removeIf(student -> student.equals(studentToRemove));
        Map<Subject, Integer> grades = studentsGrades.get(studentToRemove);
        grades.remove(subject);
        if (studentsToRemove.isEmpty()) {
            learntSubjects.remove(subject);
        }
        if (grades.isEmpty()) {
            studentsGrades.remove(studentToRemove);
        }
    }

    private static void printStudents() {
        for (var entry : studentsGrades.entrySet()) {
            System.out.println("Grades for student: " + entry.getKey().getName());
            for (var grades : entry.getValue().entrySet()) {
                System.out.println(grades.getKey().getName() + ": " + grades.getValue());
            }
        }
    }

    private static void printSubjects() {
        System.out.println("---------------");
        for (var entry : learntSubjects.entrySet()) {
            System.out.println("Students who learn subject: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}
