package faang.school.godbless.BJS219448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> listStudent = new ArrayList<>();

    public static Map<Pair, List<Student>> groupStudent(List<Student> students) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (!studentMap.containsKey(pair)) {
                studentMap.put(pair, new ArrayList<>());
                studentMap.get(pair).add(student);
            } else {
                studentMap.get(pair).add(student);
            }
        }
        return studentMap;
    }

    public static void addStudent(Student student) {
        listStudent.add(student);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        listStudent.remove(student);
    }

    public static List<Student> searchByFacultyAndYear(String faculty, int year) {
        List<Student> findStudent = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                findStudent.add(student);
            }
        }
        return findStudent;
    }

    public static void printAllGroupStudents(List<Student> students) {
        Map<Pair, List<Student>> map = groupStudent(students);
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

        printAllGroupStudents(listStudent);
        System.out.println();

        deleteStudent("Valera", "C++", 2);
        printAllGroupStudents(listStudent);
        System.out.println();

        System.out.println(searchByFacultyAndYear("Java", 3));
    }
}

