package faang.school.godbless.BJS219448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>();

    public static Map<Pair, List<Student>> groupStudents(List<Student> students) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            studentMap.computeIfAbsent(pair, key -> new ArrayList<>()).add(student);
        }
        return studentMap;
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (studentList.contains(student)) {
            studentList.remove(student);
        } else {
            System.out.println("The student is not on the list.");
        }
    }

    public static void getStudentByFacultyAndYear(String faculty, int year) {
        System.out.println(groupStudents(studentList).get(new Pair(faculty, year)));
    }

    public static void printAllGroupStudents(List<Student> students) {
        Map<Pair, List<Student>> map = groupStudents(students);
        for (Map.Entry<Pair, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("Denis", "Faang-School", 1);
        Student st2 = new Student("Valera", "C++", 2);
        Student st3 = new Student("Masha", "Kotlin", 3);
        Student st4 = new Student("Svetlana", "Python", 1);
        Student st5 = new Student("Kile", "Faang-School", 1);
        Student st6 = new Student("Darina", "Java", 3);

        addStudent(st1);
        addStudent(st2);
        addStudent(st3);
        addStudent(st4);
        addStudent(st5);
        addStudent(st6);

        printAllGroupStudents(studentList);
        System.out.println();

        deleteStudent("Valera", "C++", 2);
        deleteStudent("Lana", "Rust", 0);
        printAllGroupStudents(studentList);
        System.out.println();

        getStudentByFacultyAndYear("Java", 3);
    }
}

