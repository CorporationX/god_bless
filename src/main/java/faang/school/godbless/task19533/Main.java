package faang.school.godbless.task19533;

import java.util.*;

public class Main {
    public static List<Student> listOfStudents;
    public static void main(String[] args) {
        listOfStudents = new ArrayList<>();
        Student student1 = new Student("Inna", "economic", 2017);
        Student student2 = new Student("Igor", "math", 2017);
        Student student3 = new Student("Nina", "economic", 2020);
        Student student4 = new Student("Alla", "history", 2021);
        Student student5 = new Student("Liza", "history", 2020);

        System.out.println(getStudentsByYearFaculty(listOfStudents));

    }
    public static Map<String, List<Student>> getStudentsByYearFaculty(List<Student> list){
        Map<String, List<Student>> map = new HashMap<>();
        Set<Integer> yearSet = new HashSet<>();
        Set<String> facultySet = new HashSet<>();

        for (Student student:list) {
            yearSet.add(student.getYear());
        }
        for (Student student:list) {
            facultySet.add(student.getFaculty());
        }
        for (Student student:list) {
            facultySet.add(student.getFaculty());
        for (Integer year:yearSet) {
            for (String string:facultySet) {
                String key = student.getYear() + student.getFaculty();
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
                map.get(key).add(student);
            }

        }}
        return map;
    }

    public static void addStudent(String name, String faculty, Integer year){
        listOfStudents.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year){
        listOfStudents.removeIf(student -> student.getName().equals(name) && student.getYear().equals(year) &&
                student.getFaculty().equals(faculty));
    }
}
