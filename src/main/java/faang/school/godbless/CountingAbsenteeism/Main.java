package faang.school.godbless.CountingAbsenteeism;

import faang.school.godbless.GameOfThrones.House;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Victor", "Math", 1));
        students.add(new Student("Maikl", "Math", 1));
        students.add(new Student("Anna", "Physics", 1));
        students.add(new Student("Yulia", "Math", 2));
        students.add(new Student("Maksim", "Physics", 2));
        removeStudentFromGroups(students, "Maikl", "Math", 1);
        Map<KeyFacultyAndYear, List<Student>> studentsByGroups = addStudentInGroups(students);
        lookAllStudentsByFaculty(studentsByGroups, "Math", 1);
        System.out.println("_______________");
        addStudentInGroup(studentsByGroups, "Almaz", "Math", 1);
        lookAllStudentsByFaculty(studentsByGroups, "Math", 1);

    }

    public static void addStudentInGroup(Map<KeyFacultyAndYear, List<Student>> StudentInGroups, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        StudentInGroups.computeIfAbsent(new KeyFacultyAndYear(student.getFaculty(), student.getYear()), k -> new ArrayList<>()).add(student);
    }

    public static Map<KeyFacultyAndYear, List<Student>> addStudentInGroups(List<Student> students) {
        Map<KeyFacultyAndYear, List<Student>> studentsByGroups = new HashMap<>();
        for (Student student : students) {
            KeyFacultyAndYear key = new KeyFacultyAndYear(student.getFaculty(), student.getYear());
            studentsByGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return studentsByGroups;
    }

    public static void removeStudentFromGroups(List<Student> students, String name, String faculty, int year) {
        for (Student student : students) {
            if (student.toString().equals(new Student(name, faculty, year).toString())) {
                students.remove(student);
                break;
            }
        }
    }

    public static void lookAllStudentsByFaculty(Map<KeyFacultyAndYear, List<Student>> studentsByGroups, String faculty, int year) {
        for (Student student : studentsByGroups.get(new KeyFacultyAndYear(faculty, year))) {
            System.out.println(student.getName());
        }
    }
}

