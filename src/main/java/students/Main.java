package students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Vadim", "Cybernate", 5),
                new Student("Anna", "Finance", 4),
                new Student("Serge", "Cybernate", 5),
                new Student("Lex", "Finance", 1)
        ));

        System.out.println(sortStud(students));
        addStud(students, "New", "New", 2024);
        addStud(students, "New", "New", 2024);
        addStud(students, "New Student", "New", 2020);
        System.out.println("Students added: " + students);

        removeStud(students, "New", "New", 2024);
        System.out.println("Students after removing - " + students);
        System.out.println("Поиск: "+searchStud(students, "Cybernate", 5));
        printSortedStud(students);
    }

    public static Map<String, List<Student>> sortStud(List<Student> students) {

        Map<String, List<Student>> sortedStud = new HashMap<>();

        for (Student stud : students) {
            String key = stud.getFaculty() + " - " + stud.getYear();
            sortedStud.putIfAbsent(key, new ArrayList<>());
            sortedStud.get(key).add(stud);
        }
        return sortedStud;
    }

    public static void addStud(List<Student> students, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public static void removeStud(List<Student> students, String name, String faculty, int year) {

        Student newStudent = new Student(name, faculty, year);
        for (Student student : students) {
            if (student.equals(newStudent)) {
                students.remove(student);
            }
        }
    }

    public static List<Student> searchStud(List<Student> students, String faculty, int year) {
        Map<String, List<Student>> sortList = sortStud(students);
        return sortList.get(faculty + " - " + year);
    }

    public static void printSortedStud(List<Student> students) {
        System.out.println("\n" + "All students sorted by faculty and year:");
        for (Map.Entry entry : sortStud(students).entrySet()) {
            System.out.println(entry);
        }
    }
}