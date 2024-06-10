package faang.school.godbless.module1.sprint1.task9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Anton", "Economy", 2));
        students.add(new Student("Piter", "SQL", 4));
        students.add(new Student("Robert", "Java", 3));
        students.add(new Student("Ben", "Economy", 2));
        GroupStudentsByCourse groupStudentsByCourse = new GroupStudentsByCourse(students);
        addStudentInGroup(new Student("Pavel","Economy",2),groupStudentsByCourse);
        addStudentInGroup(new Student("Pavel","Economy",3),groupStudentsByCourse);
        System.out.println(groupStudentsByCourse);
        System.out.println();
        deleteStudentInGroup(new Student("Pavel","Economy",2),groupStudentsByCourse);
        System.out.println(groupStudentsByCourse);
        searchStudentsByCourse("Economy", 2,groupStudentsByCourse);
        printAllStudentsInGroup(groupStudentsByCourse);
    }

    public static void addStudentInGroup(Student student, GroupStudentsByCourse groupStudentsByCourse) {
        groupStudentsByCourse.getMap().computeIfAbsent(Map.entry(student.getFaculty(), student.getYear()),
                k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentInGroup(Student student, GroupStudentsByCourse groupStudentsByCourse) {
        groupStudentsByCourse.getMap().get(Map.entry(student.getFaculty(), student.getYear())).remove(student);
    }

    public static void searchStudentsByCourse(String subject, Integer course, GroupStudentsByCourse groupStudentsByCourse) {
        groupStudentsByCourse.getMap().get(Map.entry(subject, course));
    }

    public static void printAllStudentsInGroup(GroupStudentsByCourse groupStudentsByCourse) {
        groupStudentsByCourse.getMap().forEach((key, value) -> {
            System.out.println("Group: " + key.getKey() + ", Year: " + key.getValue());
            value.forEach(student -> System.out.println("  " + student));
        });
    }






}
