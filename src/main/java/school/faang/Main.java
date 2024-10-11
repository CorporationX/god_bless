package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<Group, List<Student>> groupsMap = new HashMap<>();

    public static void main(String[] args) {
        addStudent(students, "Ivan", "AVTI", "2015");
        addStudent(students, "Sergey", "INEI", "2013");
        addStudent(students, "Dima", "AVTI", "2015");
        updateStudentsMap(groupsMap, students);

        //viewAllStudents(groupsMap);
        System.out.println(searchStudentByGroup(groupsMap, "AVTI", "2015"));
        removeStudent(groupsMap, "Ivan", "AVTI", "2015");
        viewAllStudents(groupsMap);
    }

    public static void addStudent(List<Student> students, String name, String faculty, String year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    private static void updateStudentsMap(Map<Group, List<Student>> groupsMap, List<Student> students) {
        for (Student student : students) {
            Group group = new Group(student);
            groupsMap.computeIfAbsent(group, k -> new ArrayList<>()).add(student);
        }
    }

    public static void removeStudent(Map<Group, List<Student>> map, String name, String faculty, String year) {
        Group group = new Group(faculty, year);
        List<Student> bufferList = map.get(group);
        bufferList.remove(new Student(name, faculty, year));
        map.putIfAbsent(group, bufferList);
    }

    public static String searchStudentByGroup(Map<Group, List<Student>> map, String faculty, String year) {
        Group group = new Group(faculty, year);
        List<Student> studentList = map.get(group);
        return group.toString() + ":\n" + studentList.toString();
    }

    public static void viewAllStudents(Map<Group, List<Student>> map) {
        map.forEach((k, v) -> {
            System.out.println("\n" + k.toString());
            v.forEach(student -> System.out.println(student.getName()));
        });
    }
}

