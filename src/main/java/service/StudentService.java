package service;

import model.Group;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static Map<Group, List<Student>> groupedStudentsByFacultyAndYear = new HashMap<>();
    public static List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("Zhubanysh", "IT", 3),
            new Student("Artur", "Security", 4),
            new Student("Nurzhan", "Design", 2),
            new Student("Nurbek", "Finance", 3),
            new Student("Madiyar", "IT", 1),
            new Student("Bekassyl", "Security", 1),
            new Student("Damir", "Design", 2),
            new Student("Daniyar", "Finance", 4)
    ));

    public static Map<Group, List<Student>> groupingStudentsByFacultyAndYear(List<Student> students) {
        students.forEach(student -> {
            var currentStudentGroup = new Group(student.getFaculty(), student.getYear());
            groupedStudentsByFacultyAndYear.computeIfAbsent(currentStudentGroup, group -> new ArrayList<Student>()).add(student);
        });

        return groupedStudentsByFacultyAndYear;
    }

    public static Student addStudent(String name, String faculty, int year){
        var newStudent = new Student(name, faculty, year);
        var groupOfTheNewStudent = new Group(faculty, year);

        students.add(newStudent);
        groupedStudentsByFacultyAndYear.computeIfAbsent(groupOfTheNewStudent, group -> new ArrayList<Student>()).add(newStudent);

        return newStudent;
    }

    public static Student removeStudent(String name, String faculty, int year){
        var removingStudent = new Student(name, faculty, year);
        var deletingStudentGroup = new Group(faculty, year);

        students.remove(removingStudent);
        groupedStudentsByFacultyAndYear.computeIfPresent(deletingStudentGroup, (group, studentList) -> {
            studentList.remove(removingStudent);
            if(studentList.size() == 0){
                return null;
            }
            return studentList;
        });

        return removingStudent;
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year){
        var group = new Group(faculty, year);

        return groupedStudentsByFacultyAndYear.get(group);
    }
}
