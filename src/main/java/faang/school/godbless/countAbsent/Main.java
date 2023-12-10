package faang.school.godbless.countAbsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students;

    public static void main(String[] args) {

        students = new ArrayList<>();
        students.add(new Student("Tom", "IT", 2020));
        students.add(new Student("Mike", "IT", 2021));
        students.add(new Student("Jin", "Math", 2020));
        students.add(new Student("Min", "Math", 2020));
        students.add(new Student("Bob", "IT", 2021));

        showSortStudents(sortedStudentsByFacultyYear(students));
        addStudent("Jerry", "IT", 2021);
        removeStudent("Bob", "IT", 2021);
        System.out.println();
        showSortStudents(sortedStudentsByFacultyYear(students));
        System.out.println();
        System.out.println("IT faculty students 2021");
        for (Student student : sortedStudentsByFacultyYear(students).get("IT 2021")) {
            System.out.println(student);
        }
    }

    private static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    private static void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    private static void showSortStudents(Map<String, List<Student>> students) {
        for (Map.Entry<String, List<Student>> student : students.entrySet()) {
            System.out.println(student);
        }
    }

    private static Map<String, List<Student>> sortedStudentsByFacultyYear(List<Student> students) {
        Map<String, List<Student>> sortedStudents = new HashMap<>();
        for (Student student : students) {
            String newKey = student.getFaculty() + " " + student.getYear();
            sortedStudents.putIfAbsent(newKey, new ArrayList<>());
            sortedStudents.get(newKey).add(student);
        }
        return sortedStudents;
    }
}
