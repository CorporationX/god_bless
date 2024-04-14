package faang.school.godbless.absenteeism;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        STUDENTS.add(new Student("John", "Computer Science",  3));
        STUDENTS.add(new Student("Alice", "Engineering",  4));
        STUDENTS.add(new Student("Bob", "Mathematics",  4));
        STUDENTS.add(new Student("Emily", "Physics",  1));
        STUDENTS.add(new Student("Tom", "Physics", 1));
        STUDENTS.add(new Student("Kate", "Physics", 2));

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
