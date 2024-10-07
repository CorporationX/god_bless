package school.faang.BJS232449;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();

    static Map<String, List<Student>> groupStudentsByFacultyAndYear() {
        Map<String, List<Student>> studentMap = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " " + student.getYear();
            studentMap.computeIfAbsent(key, v -> new ArrayList<>()).add(student);
        }
        return studentMap;
    }

    static void addStudent(Student newStudent) {
        try {
            students.add(newStudent);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The incorrect input. Try again!");
        }
    }

    static void deleteStudent(String name, String faculty, int year) {
        try {
            Student student = new Student(name, faculty, year);
            students.remove(student);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The name/faculty/year are wrong! Check inputs");
        }
    }

    static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        String key = faculty + " " + year;
        return groupStudentsByFacultyAndYear().get(key);
    }

    static void showAllStudents() {
        for (Map.Entry<String, List<Student>> mapListEntry : groupStudentsByFacultyAndYear().entrySet()) {
            System.out.println(mapListEntry.getKey());
            for (Student student : mapListEntry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        students.add(new Student("Alex", "Software Engineering", 1));
        students.add(new Student("John", "Marketing", 2));
        students.add(new Student("Esther", "Finance", 3));
        students.add(new Student("Tiffany", "Software Engineering", 1));
        students.add(new Student("Brook", "Marketing", 2));
        students.add(new Student("James", "Finance", 3));

        System.out.println(groupStudentsByFacultyAndYear());
        addStudent(new Student("Batyr", "Jurisprudence", 1));
        deleteStudent("Alex", "Software Engineering", 1);
        System.out.println(findStudentsByFacultyAndYear("Marketing", 2));
        showAllStudents();
    }
}
