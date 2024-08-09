package faang.school.godbless.BJS2_19335;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Den", "Afac", 2020));
        students.add(new Student("Egir", "Bfac", 2015));
        students.add(new Student("Max", "Dfac", 2020));
        students.add(new Student("Kim", "Afac", 2014));
        students.add(new Student("Kox", "Afac", 2020));

        addStudent();
        removeStudent("Kim", "Afac", 2014);
        findStudentsByFacultyAndYear("Dfac", 2020);
        getAllStudentsGroupedByFacultyAndYear();
    }

    public static void addStudent() {
        students.add(new Student("Extra", "Bfac", 2015));
    }

    public static void removeStudent(String name, String faulty, int year) {
        students.remove(new Student(name, faulty, year));
    }

    public static void findStudentsByFacultyAndYear(String faculty, int year) {
        System.out.println(insertIntoMap(students).get(faculty + ", " + year));
    }

    public static void getAllStudentsGroupedByFacultyAndYear() {
        insertIntoMap(students).forEach((k, v) -> System.out.println(k + v));
    }

    public static Map<String, List<Student>> insertIntoMap(List<Student> students){
        Map<String, List<Student>> map = new HashMap<>();

        students.forEach(
                student -> map.computeIfAbsent((student.faculty() + ", " + student.year()), k -> new ArrayList<>()).add(student));

        return map;
    }
}
