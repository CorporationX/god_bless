package faang.school.godbless.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<String, List<Student>> SORTED_STUDENTS = new HashMap<>();

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

        System.out.println(SORTED_STUDENTS);
        System.out.println("------------------------------------");
        groupStudents(STUDENTS);
        System.out.println(SORTED_STUDENTS);
        System.out.println("------------------------------------");
        removeStudentByNameFacultyYear(SORTED_STUDENTS, "Billy", "Mathematics", 9);
        System.out.println("------------------------------------");
        System.out.println(SORTED_STUDENTS);

    }

    public static Map<String, List<Student>> groupStudents(List<Student> listStudents) {
        Map<String, List<Student>> resMap = new HashMap<>();

        for (Student student : listStudents) {
            SORTED_STUDENTS.computeIfAbsent(createKey(student), key -> new ArrayList<>()).add(student);
        }
        return SORTED_STUDENTS;
    }

    public static void addStudent(Map<String, List<Student>> sortedStudents, Student student) {
        if (!sortedStudents.containsKey(createKey(student))) {
            sortedStudents.computeIfAbsent(createKey(student), key -> new ArrayList<>()).add(student);
        } else {
            sortedStudents.get(createKey(student)).add(student);
        }
    }

    public static void removeStudentByNameFacultyYear(Map<String, List<Student>> sortedStudents, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);

        sortedStudents.get(createKey(student)).remove(student);
    }

    public static List<Student> getAllStudentByFacultyYear(Map<String, List<Student>> sortedStudents, String faculty, int year) {
        return sortedStudents.get(faculty + "_" + year);
    }

    public static void printAllStudentGroupByFacultyYear(Map<String, List<Student>> sortedStudents) {
        sortedStudents.entrySet().forEach(System.out::println);
    }
}