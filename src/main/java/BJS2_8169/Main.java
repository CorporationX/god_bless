package BJS2_8169;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Set<Student> students = new HashSet<>();

    public static void main(String[] args) {
        addStudents("Yaroslav", "IT", 3);
        addStudents("Dima", "IT", 3);
        addStudents("Alya", "IT", 1);
        addStudents("Bob", "RIT", 1);
        addStudents("Alex", "RIT", 1);

        removeStudent("Leo", "IT", 1);
        removeStudent("Alex", "RIT", 1);

        printGroupUsers(findGroupStudents());
    }

    public static void addStudents(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name)
                && student.getFaculty().equals(faculty) && student.getYear() == year);
    }

    public static Map<List<Object>, List<Student>> findGroupStudents() {
        return students.stream()
                .collect(Collectors
                        .groupingBy(user -> Arrays.asList(user.getFaculty(), user.getYear())));
    }

    public static void printGroupUsers(Map<List<Object>, List<Student>> studentsByFacultyAndYear) {
        studentsByFacultyAndYear.forEach((key, value) -> {
            System.out.format("Faculty: %s, Year: %d\n", key.get(0), (Integer) key.get(1));
            value.forEach(System.out::println);
        });
    }
}
