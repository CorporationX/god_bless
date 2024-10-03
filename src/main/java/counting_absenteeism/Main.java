package counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static private final List<Student> students = new ArrayList<>();

    public static List<Student> getStudentsList() {
        return students;
    }

    public static void main(String[] args) {
        students.add(new Student("John", "Computer Science", 3));
        students.add(new Student("Jane", "Theatre", 3));
        students.add(new Student("Elizabeth", "Computer Science", 3));
        students.add(new Student("Kate", "Theatre", 4));

        Map<Course, List<Student>> courseByStudent = getCourseByStudents(students);
        System.out.println(courseByStudent);

        addStudent(new Student("Mark", "Computer Science", 3));
        System.out.println(students);

        removeStudent(new Student("John", "Computer Science", 3));
        System.out.println(students);

        System.out.println(getStudents(new Course("Computer Science", 3), courseByStudent));

        printAllInfo(courseByStudent);
    }

    public static Map<Course, List<Student>> getCourseByStudents(List<Student> students) {
        Map<Course, List<Student>> courseByStudent = new HashMap<>();

        for (Student student : students) {
            courseByStudent.computeIfAbsent(new Course(student.getFaculty(), student.getYear()), k -> new ArrayList<>()).add(student);
        }

        return courseByStudent;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

    public static List<Student> getStudents(Course course, Map<Course, List<Student>> courseByStudent) {
        return courseByStudent.get(course);
    }

    public static void printAllInfo(Map<Course, List<Student>> courseByStudent) {
        for (Map.Entry<Course, List<Student>> entry : courseByStudent.entrySet()) {
            System.out.println("Course: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
        }
    }
}
