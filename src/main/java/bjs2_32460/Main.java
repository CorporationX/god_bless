package bjs2_32460;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent(new Student("name1", "faculty1", 1));
        addStudent(new Student("name2", "faculty2", 3));
        addStudent(new Student("name3", "faculty1", 1));
        addStudent(new Student("name4", "faculty1", 4));

        System.out.println(getGroups(students));
        System.out.println("===============================");
        System.out.println(students);
        System.out.println("===============================");
        System.out.println(findStudentsByFacultyAndYear("faculty1", 1));
        System.out.println("===============================");
        deleteStudent("name3", "faculty1", 1);
        System.out.println(students);
        System.out.println("===============================");
        System.out.println(getGroups(students));
        System.out.println("===============================");
        printAllGroups();
    }

    public static Map<FacultyYear, List<Student>> getGroups(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(student ->
                        new FacultyYear(student.getFaculty(), student.getYear())
                ));
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
        return getGroups(students).get(new FacultyYear(faculty, year));
    }

    public static void printAllGroups() {
        for (var entry : getGroups(students).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
