package school.faang.t06;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();


    public static void main(String[] args) {

        Student studOne = new Student("Masha", "it", 1);
        Student studTwo = new Student("Sasha", "it", 2);
        Student studThree = new Student("Vasya", "gum", 1);
        Student studFour = new Student("ADel", "gum", 3);
        Student studFive = new Student("Tom", "it", 1);
        Student Addotic = new Student("Addotic", "gum", 5);

        students.add(studOne);
        students.add(studTwo);
        students.add(studThree);
        students.add(studFour);
        students.add(studFive);

        addStudent(Addotic);

        removeStudent("Addotic", "gum", 5);

        findStudentsByFacultyAndYear("it", 1);

        printAllGroupedUsers();
    }


    static void addStudent(Student student) {
        students.add(student);
    }

    static void removeStudent(String name, String faculty, int year) {
        Student key = new Student(name, faculty, year);
        students.remove(key);
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public static void printAllGroupedUsers() {
        Map<Map.Entry<String, Integer>, List<Student>> result = groupStudents(students);

        for (Map.Entry<Map.Entry<String, Integer>, List<Student>> listEntry : result.entrySet()) {
            System.out.println(listEntry);
        }
    }

    static Map<Map.Entry<String, Integer>, List<Student>> groupStudents(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }
}