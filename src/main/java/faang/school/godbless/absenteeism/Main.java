package faang.school.godbless.absenteeism;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static final List<Student> STUDENTS = List.of(
            new Student("John", "Computer Science",  3),
            new Student("Alice", "Engineering",  4),
            new Student("Bob", "Mathematics",  4),
            new Student("Emily", "Physics",  1),
            new Student("Tom", "Physics", 1),
            new Student("Kate", "Physics", 2));
    public static void main(String[] args) {
        Map<Course, List<Student>> studentMap = groupStudentsByCourse(STUDENTS);
        System.out.println(studentMap);
    }

    public static Map<Course, List<Student>> groupStudentsByCourse(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return Collections.emptyMap();
        }
        return students.stream().collect(Collectors.groupingBy(
                student -> new Course(student.getFaculty(), student.getYear())));
    }
}
