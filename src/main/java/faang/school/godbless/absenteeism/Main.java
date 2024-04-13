package faang.school.godbless.absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        STUDENTS.add(new Student("John", "Computer Science",  3));
        STUDENTS.add(new Student("Alice", "Engineering",  4));
        STUDENTS.add(new Student("Bob", "Mathematics",  4));
        STUDENTS.add(new Student("Emily", "Physics",  1));
        STUDENTS.add(new Student("Tom", "Physics", 1));
        STUDENTS.add(new Student("Kate", "Physics", 2));

        Map<Course, List<Student>> studentMap = groupStudentsByFacultyAndCourse(STUDENTS);
        System.out.println(studentMap);
    }

    public static Map<Course, List<Student>> groupStudentsByFacultyAndCourse(List<Student> students) {
        Map<Course, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            Course course = new Course(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(course, st -> new ArrayList<>()).add(student);
        }

        return groupedStudents;
    }
}
