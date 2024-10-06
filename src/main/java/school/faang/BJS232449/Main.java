package school.faang.BJS232449;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();

    static Map<Map<String, Integer>, List<Student>> groupStudentListToMap() {
        Map<Map<String, Integer>, List<Student>> studentMap = new HashMap<>();
        for (Student student : students) {
            Map<String, Integer> key = Map.of(student.getFaculty(), student.getYear());
            studentMap.computeIfAbsent(key, v -> new ArrayList<>()).add(student);
        }
        return studentMap;
    }

    static void addNewStudent(Student newStudent) {
        try {
            students.add(newStudent);
            System.out.println("ADDED - " + newStudent);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The incorrect input. Try again!");
        }
    }

    static void deleteStudent(String name, String faculty, int year) {
        try {
            Student student = new Student(name, faculty, year);
            students.remove(student);
            System.out.println("DELETED - " + student);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The name/faculty/year are wrong! Check inputs");
        }
    }

    static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        Map<String, Integer> key = Map.of(faculty, year);
        return groupStudentListToMap().get(key);
    }

    static void showAllStudents() {
        for (Map.Entry<Map<String, Integer>, List<Student>> mapListEntry : groupStudentListToMap().entrySet()) {
            System.out.println(mapListEntry.getKey() + " ");
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

        System.out.println(groupStudentListToMap());
        addNewStudent(new Student("Batyr", "Jurisprudence", 1));
        deleteStudent("Alex", "Software Engineering", 1);
        System.out.println(findStudentsByFacultyAndYear("Marketing", 2));
        showAllStudents();
    }
}
