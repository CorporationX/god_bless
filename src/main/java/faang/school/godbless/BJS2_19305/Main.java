package faang.school.godbless.BJS2_19305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    static List<Student> students = Arrays.asList(
            new Student("Alice Smith", "Computer Science", 2),
            new Student("Bob Johnson", "Mathematics", 3),
            new Student("Charlie Brown", "Physics", 1),
            new Student("Diana Prince", "Engineering", 4),
            new Student("Evan Stone", "Literature", 2),
            new Student("Fiona Green", "Biology", 1),
            new Student("Adam Smith", "Literature", 2)
    );

    public static void main(String[] args) {
        printAllGrouped();
    }

    public static HashMap<Pair, List<Student>> groupByFacultyAndYear(List<Student> list) {
        HashMap<Pair, List<Student>> result = new HashMap<>();

        for(var student : list) {
            result.computeIfAbsent(new Pair(student.getFaculty(), student.getYearOfStudy()),
                    k -> new ArrayList<>()).add(student);
        }

        return result;
    }

    public static void addStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }

    public static void searchByFacultyAndYear(String faculty, int year) {
        Pair pair = new Pair(faculty, year);
        HashMap<Pair, List<Student>> grouped = groupByFacultyAndYear(students);
        for(var student : grouped.get(pair)) {
            System.out.println(student);
        }
    }

    public static void printAllGrouped() {
        HashMap<Pair, List<Student>> grouped = groupByFacultyAndYear(students);
        for(var pair : grouped.entrySet()) {
            System.out.println(pair.getKey() + ":");
            for(var student : pair.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }
}
