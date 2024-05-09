package faang.school.godbless.java_hashmap.BJS2_5360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>(Set.of(
                new Student("Tom", "IT", 2015),
                new Student("Sam", "IT", 2024),
                new Student("Max", "Science", 2017),
                new Student("Vlad", "Medicine", 2015),
                new Student("Anna", "IT", 2024))
        );

        Map<String, Set<Student>> group = groupByFacultyYear(students);
        System.out.println(group);

        addStudent(new Student("Maxim", "IT", 2024), group);
        System.out.println(group);

        removeStudent("Maxim", "IT", 2024, group);
        System.out.println(group);

        System.out.println(getStudentsByFacultyYear("IT", 2024, group));
    }

    public static Map<String, Set<Student>> groupByFacultyYear(Set<Student> students) {
        Map<String, Set<Student>> result = new HashMap<>();

        for(Student student : students) {
            result.computeIfAbsent(student.getYearFacultyKey(), k -> new HashSet<>()).add(student);
        }

        return result;
    }

    public static void addStudent(Student student, Map<String, Set<Student>> target) {
        target.computeIfAbsent(student.getYearFacultyKey(), k -> new HashSet<>()).add(student);
    }

    public static void removeStudent(String name, String faculty, int year, Map<String, Set<Student>> target) {
        Student student = new Student(name, faculty, year);
        Set<Student> studentGroup = target.get(student.getYearFacultyKey());

        if (studentGroup == null) {
            throw new IllegalArgumentException("Студент не найден");
        }

        studentGroup.remove(student);
    }

    public static Set<Student> getStudentsByFacultyYear(String faculty, int year, Map<String, Set<Student>> target) {
        Set<Student> students = target.get(String.format("%s-%s", faculty, year));

        if (students == null) {
            return new HashSet<>();
        }

        return students;
    }
}
