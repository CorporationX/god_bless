package countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final List<Student> STUDENTS = new ArrayList<>();

    private static String generateKey(String faculty, int year) {
        return "%s-%d".formatted(faculty, year);
    }

    public static Map<String, List<Student>> studentGroups(List<Student> students) {
        Map<String, List<Student>> studentGroups = new HashMap<>();

        students.forEach(student -> {
            studentGroups.computeIfAbsent(
                    generateKey(student.getFaculty(), student.getYear()),
                    k -> new ArrayList<>()
            ).add(student);
        });

        return studentGroups;
    }

    public static void addStudent(String name, String faculty, int year) {
        STUDENTS.add(new Student(name, faculty, year));
    }

    public static void deleteStudent(String name, String faculty, int year) {
        STUDENTS.remove(new Student(name, faculty, year));
    }

    public static List<Student> facultyGroup(String faculty, int year) {
        return studentGroups(STUDENTS).get(generateKey(faculty, year));
    }

    public static void printStudentsGroup() {
        studentGroups(STUDENTS).forEach((key, value) -> {
            System.out.printf("%s - %s%n", key, value);
        });

    }

    public static void main(String[] args) {
        addStudent("Alice", "Computer Science", 1);
        addStudent("Bob", "Software Engineering", 2);
        addStudent("Charlie", "Software Engineering", 3);

        printStudentsGroup();
        addStudent("Charlie", "Software Engineering", 4);
        addStudent("Bob", "Computer Science", 5);
        printStudentsGroup();
        deleteStudent("Alice", "Software Engineering", 5);
        deleteStudent("Bob", "Software Engineering", 2);
        System.out.println();
        printStudentsGroup();
        System.out.println();
        System.out.println(facultyGroup("Mathematics", 2));
        System.out.println(facultyGroup("Computer Science", 1));
    }
}
