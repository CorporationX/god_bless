package faang.school.godbless;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(addStudent("Adel", "Programming", 1));
        System.out.println(addStudent("Мария Петрова", "Engineering", 2));
        System.out.println(addStudent("Сергей Сидоров", "Programming", 1));
        System.out.println(addStudent("Анна Смирнова", "Humanitarian", 4));
        System.out.println(addStudent("Sam", "Programming", 1));
        System.out.println(addStudent("Ольга Кузнецова", "Engineering", 2));
        System.out.println(addStudent("New student", "Law", 4));

        System.out.println(remove("Adel", "Programming", 1));
        System.out.println(getStudentsByFacultyAndYear(students));
        System.out.println(searchStudent("Programming", 1));
        groupByFacultyAndYear("Programming", 1);
    }


    public static void groupByFacultyAndYear(String faculty, int year) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student != null && student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No students found for the given criteria.");
        } else {
            System.out.println("Students matching the criteria: " + result);
        }
    }


    public static Map<String, List<Student>> getStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> studentMap = new HashMap<>();

        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            studentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }

        return studentMap;
    }


    public static String addStudent(String faculty, String year, int age) {
        Student student = new Student(faculty, year, age);
        if (students.contains(student)) {
            return "Student already exists";
        } else {
            students.add(student);
            return "Student successfully added";
        }
    }


    public static String remove(String faculty, String year, int age) {
        Student student = new Student(faculty, year, age);
        if (!students.contains(student)) {
            return "Student not exists";
        } else {
            students.remove(student);
            return "Student successfully removed";
        }
    }


    public static List<Student> searchStudent(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student == null || student.getFaculty().isBlank()) {
                throw new NullPointerException("student is null");
            }
            if (student.getFaculty().equals(faculty) || student.getYear() == year) {
                result.add(student);
            }
        }

        return result;
    }
}