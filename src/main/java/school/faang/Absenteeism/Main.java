package school.faang.Absenteeism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Egor", "IT", 2024);
        Student student2 = new Student("John", "Management", 2022);
        Student student3 = new Student("Stacy", "Art", 2020);
        Student student4 = new Student("Bob", "IT", 2024);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);

        System.out.println(findStudentsByFacultyAndYear("Management", 2022));
        System.out.println();
        removeStudentByData("John", "Management", 2022);
        printAllStudents();

    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static Map<String, List<Student>> groupStudents() {
        return STUDENTS.stream().
                collect(Collectors.groupingBy(student -> (student.getFaculty() + "-" + student.getYear())));
    }

    public static void removeStudentByData(String name, String faculty, int year) {
        STUDENTS.removeIf(student -> student.equals(new Student(name, faculty, year)));
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        return STUDENTS.stream().
                filter(student -> student.getFaculty().equals(faculty)
                        && student.getYear() == year).collect(Collectors.toList());
    }

    public static void printAllStudents() {
        groupStudents().forEach((k, v) -> System.out.println(k + ": " + v));
    }
}