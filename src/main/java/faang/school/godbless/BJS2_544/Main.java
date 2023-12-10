package faang.school.godbless.BJS2_544;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.stream.Collectors;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Ivanov", "Computer Science", 2));
        students.add(new Student("Petrov", "Physics", 1));
        students.add(new Student("Sidorov", "Chemistry", 3));
        students.add(new Student("Kozlov", "Computer Science", 1));
        students.add(new Student("Smirnova", "Physics", 2));
        students.add(new Student("Alexeeva", "Chemistry", 3));
        students.add(new Student("Pavlov", "Biology", 4));
        students.add(new Student("Morozov", "Computer Science", 2));

        showGroupStudentsByFacultyAndYear(students);
    }

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> studentList) {
        Map<Map.Entry<String, Integer>, List<Student>> resultStudentsMap = new HashMap<>();

        for (Student student : studentList) {
            resultStudentsMap.computeIfAbsent(new AbstractMap.SimpleEntry<>(
                    student.getFaculty(), student.getYear()), studentByKey -> new ArrayList<>()).add(student);
        }
        return resultStudentsMap;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> listOfStudents(String faculty, int year) {
        return groupStudentsByFacultyAndYear(students).get(new AbstractMap.SimpleEntry<>(faculty, year));
    }

    public static void showGroupStudentsByFacultyAndYear(List<Student> studentList) {
        System.out.println(groupStudentsByFacultyAndYear(studentList));
    }
}
