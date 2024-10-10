package school.faang.BJS2_32549;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex Turner", "Mathematics", 1));
        students.add(new Student("Sophie Chen", "Mathematics", 2));
        students.add(new Student("Liam Brown", "Science", 1));
        students.add(new Student("Olivia Williams", "Mathematics", 1));
        students.add(new Student("Ella Johnson", "Science", 2));
        students.add(new Student("James Wilson", "Literature", 3));
        students.add(new Student("Chloe Martinez", "Literature", 1));
        students.add(new Student("Ethan White", "Science", 2));
        students.add(new Student("Mia Garcia", "Arts", 3));

        Map<String, List<Student>> map = groupStudentsByFacultyAndYear(students);

        addStudent(map, new Student("New Student", "Arts", 3));

        removeStudent(map, "Sophie Chen", "Mathematics", 2);

        printGroupStudents(map);
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return map;
    }

    public static void addStudent(Map<String, List<Student>> map, Student student) {
        String key = student.getFaculty() + "-" + student.getYear();
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Map<String, List<Student>> map, String name, String faculty, int year) {
        String key = faculty + "-" + year;
        List<Student> students = map.get(key);
        if (students != null) {
            students.removeIf(student -> student.getName().equals(name));
            if (students.isEmpty()) {
                map.remove(key);
            }
        }
    }

    public static  List<Student> getStudents(Map<String, List<Student>> map, String faculty, int year) {
        return map.getOrDefault(faculty + "-" + year, new ArrayList<>());
    }

    public static void printGroupStudents(Map<String, List<Student>> map) {
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println("Faculty and Year: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
