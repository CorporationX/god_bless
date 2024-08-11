package faang.school.godbless.BJS2_19538;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    @Getter
    private static List<Student> students = new ArrayList<>(
            List.of(
                    new Student("Jack", "Engineering", 2018),
                    new Student("Dillon", "Engineering", 2018),
                    new Student("Anna", "Science", 2019),
                    new Student("Ada", "IT", 2020),
                    new Student("Alice", "Science", 2019),
                    new Student("Bob", "IT", 2020),
                    new Student("Sara", "Science", 2019),
                    new Student("Jane", "IT", 2020),
                    new Student("Robert", "Engineering", 2018),
                    new Student("Jill", "IT", 2020)
            )
    );

    public static void main(String[] args) {
        var groupedStudents = groupStudentsByFacultyAndYear(students);
        printGroupedStudents(groupedStudents);
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> grouped = new HashMap<>();

        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return grouped;
    }

    public static void addStudent(List<Student> adding,Student student) {
        adding.add(student);
    }

    public static void delete(String name, String faculty, int year, List<Student> removedList) {
        removedList.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty)
                && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        var foundStudents = new ArrayList<Student>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public static void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Grouped student: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student.getName() + " " + student.getFaculty() + " " + student.getYear());
            }
            System.out.println();
        }
    }
}