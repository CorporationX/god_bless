package faang.school.godbless.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> grades = new HashMap<>();
    private static final Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void main(String[] args) {
        Subject math = new Subject(1, "Math");
        Subject eng = new Subject(2, "English");
        Subject geology = new Subject(3, "Geology");

        Student kate = new Student(1, "Kate");
        Student max = new Student(2, "Max");

        Map<Subject, Integer> kateGrades = new HashMap<>();
        kateGrades.put(math, 5);
        kateGrades.put(eng, 4);
        addStudentToStudents(kate, kateGrades);

        Map<Subject, Integer> maxGrades = new HashMap<>();
        maxGrades.put(math, 2);
        maxGrades.put(eng, 3);
        addStudentToStudents(max, maxGrades);

        System.out.println("All Students with Grades:");
        printAllStudents();

        System.out.println("\nAll Subjects with Students:");
        printAllSubjects();

        addSubjectToStudent(kate, geology, 53);

        System.out.println("\nUpdated Grades and Subjects:");
        printAllStudents();
        printAllSubjects();

        deleteStudentFromStudents(kate);

        System.out.println("\nAfter Deleting Student Kate:");
        printAllStudents();
        printAllSubjects();
    }

    public static void addStudentToStudents(Student student, Map<Subject, Integer> studentGrades) {
        grades.put(student, studentGrades);
        studentGrades.keySet().forEach(subject -> studentsBySubject.computeIfAbsent(subject, v -> new ArrayList<>()).add(student));
    }

    public static void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        grades.get(student).put(subject, grade);
        studentsBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromStudents(Student student) {
        grades.remove(student);
        studentsBySubject.values().forEach(studentsList -> studentsList.remove(student));
    }

    public static void printAllStudents() {
        for (var gradesEntry : grades.entrySet()) {
            Student student = gradesEntry.getKey();
            if (student != null) {
                System.out.println("Student: " + student.getName());
                for (var subjectsEntry : gradesEntry.getValue().entrySet()) {
                    if (subjectsEntry.getKey() != null) {
                        System.out.println("Subject: " + subjectsEntry.getKey() + " Grade: " + subjectsEntry.getValue());
                    }
                    else {
                        System.out.println("Error: subject is null");
                    }
                }
            }
            else {
                System.out.println("Error: user is null");
            }
        }
    }

    public static void addSubjectToSubjects(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
    }

    public static void addStudentToSubjects(Student student, Subject subject) {
        studentsBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromSubjects(Student student, Subject subject) {
        List<Student> students = studentsBySubject.get(subject);
        if (students != null) {
            students.remove(student);
        }
        else {
            System.out.println("Subject does not exist");
        }
    }

    public static void printAllSubjects() {
        for  (var entry : studentsBySubject.entrySet()) {
            if (entry != null) {
                Subject subject = entry.getKey();
                System.out.println("Subject: " + subject.getName());
                for (var student : entry.getValue()) {
                    if (student != null) {
                        System.out.println(student);
                    }
                    else {
                        System.out.println("Error: student is null");
                    }
                }
            }
            else {
                System.out.println("Error: subject is null");
            }
        }
    }
}
