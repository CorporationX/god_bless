package faang.school.godbless.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        STUDENTS.add(new Student("John", "Computer Science", 2));
        STUDENTS.add(new Student("Alice", "Mathematics", 1));
        STUDENTS.add(new Student("Bob", "Computer Science", 2));
        STUDENTS.add(new Student("Eve", "Mathematics", 1));

        addStudent(STUDENTS, new Student("Charlie", "Physics", 3));

        removeStudent(STUDENTS, "Alice", "Mathematics", 1);

        List<Student> foundStudents = findStudentsByFacultyAndYear(STUDENTS, "Computer Science", 2);
        System.out.println("Found students:");
        for (Student student : foundStudents) {
            System.out.println(student.getName());
        }

        printStudents(STUDENTS);
    }

    public static void printStudents(List<Student> students) {
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(students);
        System.out.println("Grouped students:");
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Faculty and Year: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("Student: " + student.getName());
            }
        }
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> result = new HashMap<>();
        for (Student s : students) {
            String key = String.format("Факультет - %s курс - %d", s.getFaulty(), s.getYear());
            if (result.containsKey(key))
                result.get(key).add(s);
            else
                result.put(s.getFaulty() + s.getYear(), List.of(s));
        }
        return result;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getName().equals(faculty) && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaulty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

}
