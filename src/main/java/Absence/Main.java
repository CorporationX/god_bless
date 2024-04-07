package Absence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student kolya = new Student("Kolya", "M", 1);
        Student nikita = new Student("Nikita", "I", 3);
        Student alex = new Student("Alex", "H", 2);
        Student vera = new Student("Vera", "H", 2);
        List<Student> students = List.of(kolya, nikita, alex, vera);

        Map<String, List<Student>> group = groupStudents(students);
        addNewStudent(group, new Student("Tanya", "L", 2));
        printAllStudents(group);
        System.out.println();

        removeStudent(group, "Alex", "H", 2);
        printAllStudents(group);
        System.out.println();

        System.out.println(searchStudents(group, "L", 2));
    }

    private static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> groups = new HashMap<>();
        for (Student elem : students) {
            if (!groups.containsKey(generateKey(elem.getFaculty(), elem.getYear()))) {
                groups.put(generateKey(elem.getFaculty(), elem.getYear()), new ArrayList<>());
            }
            groups.get(generateKey(elem.getFaculty(), elem.getYear())).add(elem);
        }
        return groups;
    }

    private static void addNewStudent(Map<String, List<Student>> groups, Student student) {
        if (!groups.containsKey(generateKey(student.getFaculty(), student.getYear()))) {
            groups.put(generateKey(student.getFaculty(), student.getYear()), new ArrayList<>());
        }
        groups.get(generateKey(student.getFaculty(), student.getYear())).add(student);
    }

    private static void removeStudent(Map<String, List<Student>> groups, String name, String faculty, int year) {
        if (!groups.containsKey(generateKey(faculty, year))) {
            System.out.println("There is no such student");
        } else {
            groups.get(generateKey(faculty, year)).remove(new Student(name, faculty, year));
        }
    }

    private static List<Student> searchStudents(Map<String, List<Student>> group, String faculty, int year) {
        return group.get(generateKey(faculty, year));
    }

    private static void printAllStudents(Map<String, List<Student>> groups) {
        for (Map.Entry<String, List<Student>> entry : groups.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (Student student : entry.getValue()) {
                System.out.print(student + " ");
            }
            System.out.println();
        }
    }

    private static String generateKey(String faculty, int year) {
        return faculty + year;
    }
}

