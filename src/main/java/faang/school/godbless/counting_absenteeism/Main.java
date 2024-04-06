package faang.school.godbless.counting_absenteeism;

import java.util.*;

public class Main {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Lisa", "Mathematics", 2));
        students.add(new Student("Bob", "Literature", 1));
        students.add(new Student("Sam", "Physics", 5));
        students.add(new Student("Frodo", "Geometry", 3));
        students.add(new Student("Patrik", "Mathematics", 2));
        students.add(new Student("Billy", "Mathematics", 9));
        students.add(new Student("Bob", "Literature", 1));

        printAllStudentGroupByFacultyYear(students);
    }

    public static Map<String, List<Student>> mapStudents(List<Student> listStudents) {
        Map<String, List<Student>> resMap = new HashMap<>();

        for (Student student : listStudents) {
            resMap.computeIfAbsent(student.getFaculty() + "_" + student.getYear(), key -> new ArrayList<>()).add(student);
        }
        return resMap;
    }

    public static void addStudent(List<Student> studentList, Student student) {
        studentList.add(student);
    }

    public static void removeStudentByNameFacultyYear(List<Student> studentList, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);

        studentList.remove(student);
    }

    public static List<Student> getAllStudentByFacultyYear(List<Student> studentList, String faculty, int year) {
        return mapStudents(studentList).get(faculty + "_" + year);
    }

    public static void printAllStudentGroupByFacultyYear(List<Student> studentList) {
        mapStudents(studentList).entrySet().stream().forEach(System.out::println);
    }
}