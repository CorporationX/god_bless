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

    public static Map<String, List<Student>> groupStudents(List<Student> arr) {
        Map<String, List<Student>> groups = new HashMap<>();
        for (Student elem : arr) {
            if (!groups.containsKey((elem.faculty() + elem.year()))) {
                groups.put((elem.faculty() + elem.year()), new ArrayList<>());
            }
            groups.get((elem.faculty() + elem.year())).add(elem);
        }
        return groups;
    }

    public static void addNewStudent(Map<String, List<Student>> groups, Student student) {
        if (!groups.containsKey((student.faculty() + student.year()))) {
            groups.put((student.faculty() + student.year()), new ArrayList<>());
        }
        groups.get((student.faculty() + student.year())).add(student);
    }

    public static void removeStudent(Map<String, List<Student>> groups, String name, String faculty, int year) {
        if (!groups.containsKey((faculty + year))) {
            System.out.println("There is no such student");
        } else {
            (groups.get(faculty + year)).remove(new Student(name, faculty, year));
        }
    }

    public static List<Student> searchStudents(Map<String, List<Student>> group, String faculty, int year) {
        return group.get(faculty + year);
    }

    public static void printAllStudents(Map<String, List<Student>> groups) {
        for (Map.Entry<String, List<Student>> entry : groups.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (Student student : entry.getValue()) {
                System.out.print(student + " ");
            }
            System.out.println();
        }
    }
}

