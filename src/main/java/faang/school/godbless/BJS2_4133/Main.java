package faang.school.godbless.BJS2_4133;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>(Set.of(
                new Student("Andrei", "IT", 2024),
                new Student("Victor", "IT", 2024),
                new Student("Vlad", "NotIT", 2022),
                new Student("Jack", "NotIT", 2022),
                new Student("Nick", "NotIT", 2020))
        );

        Map<String, Set<Student>> groupedStudents = groupStudentsByDirection(students);
        System.out.println(groupedStudents);

        addStudentToDirection(new Student("Vlad", "IT", 2024), groupedStudents);
        System.out.println(groupedStudents);

        removeStudentFromDirection("Vlad", "IT", 2024, groupedStudents);
        System.out.println(groupedStudents);

        System.out.println(getStudentsByDirection("IT", 2024, groupedStudents));
    }

    private static String getDirectionKey(Student student) {
        return String.format("%s-%s", student.getFaculty(), student.getYear());
    }

    public static Map<String, Set<Student>> groupStudentsByDirection(Set<Student> students) {
        Map<String, Set<Student>> result = new HashMap<>();

        for (Student student : students) {
            addStudentToDirection(student, result);
        }

        return result;
    }

    public static void addStudentToDirection(Student student, Map<String, Set<Student>> target) {
        target.computeIfAbsent(getDirectionKey(student), k -> new HashSet<>()).add(student);
    }

    public static void removeStudentFromDirection(String name, String faculty, int year, Map<String, Set<Student>> target) {
        Student student = new Student(name, faculty, year);
        Set<Student> studentGroup = target.get(getDirectionKey(student));

        if (studentGroup == null) {
            throw new IllegalArgumentException(String.format("Студент \"%s\", Факультет \"%s\", Год \"%s\" не найден", name, faculty, year));
        }

        studentGroup.remove(student);
    }

    public static Set<Student> getStudentsByDirection(String faculty, int year, Map<String, Set<Student>> target) {
        Set<Student> students = target.get(String.format("%s-%s", faculty, year));

        if (students == null) {
            return new HashSet<>();
        }

        return students;
    }
}