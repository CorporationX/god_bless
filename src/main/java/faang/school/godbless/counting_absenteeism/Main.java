package faang.school.godbless.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    private static String createKey(Student student) {
        return student.getFaculty() + "_" + student.getYear();
    }

    public static void main(String[] args) {
        STUDENTS.add(new Student("Lisa", "Mathematics", 2));
        STUDENTS.add(new Student("Bob", "Literature", 1));
        STUDENTS.add(new Student("Sam", "Physics", 5));
        STUDENTS.add(new Student("Frodo", "Geometry", 3));
        STUDENTS.add(new Student("Patrik", "Mathematics", 2));
        STUDENTS.add(new Student("Billy", "Mathematics", 9));
        STUDENTS.add(new Student("Bob", "Literature", 1));

        Student student = new Student("Billy", "Mathematics", 9);

        Map<String, List<Student>> sortedMap = groupStudents(STUDENTS);

        addStudent(sortedMap, student);

        printAllStudentGroupByFacultyYear(sortedMap);

    }

    public static Map<String, List<Student>> groupStudents(List<Student> listStudents) {
        Map<String, List<Student>> resMap = new HashMap<>();

        for (Student student : listStudents) {
            resMap.computeIfAbsent(createKey(student), key -> new ArrayList<>()).add(student);
        }
        return resMap;
    }

    public static void addStudent(Map<String, List<Student>> groupStudents, Student student) {
        groupStudents.computeIfAbsent(createKey(student), key -> new ArrayList<>()).add(student);
    }

    public static void removeStudentByNameFacultyYear(Map<String, List<Student>> groupStudents, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);

        groupStudents.get(createKey(student)).remove(student);
    }

    public static List<Student> getAllStudentByFacultyYear(Map<String, List<Student>> groupStudents, String faculty, int year) {
        return groupStudents.get(faculty + "_" + year);
    }

    public static void printAllStudentGroupByFacultyYear(Map<String, List<Student>> groupStudents) {
        groupStudents.entrySet().forEach(System.out::println);
    }
}