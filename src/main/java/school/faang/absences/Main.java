package school.faang.absences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final  List<Student> STUDENTS = new ArrayList<>();
    public static void main(String[] args) {

        addStudent(STUDENTS, new Student("John", "Computer Science", 21));
        addStudent(STUDENTS, new Student("Jack", "Data Science", 25));
        addStudent(STUDENTS, new Student("Will", "Physics", 25));
        addStudent(STUDENTS, new Student("John", "Computer Science", 21));


        for (Student student : STUDENTS) {
            System.out.println(student);
        }
    }

    public static HashMap<String, List<Student>> groupByYear(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            map.computeIfAbsent(student.getFaculty() + " " + student.getYear(), k -> new ArrayList<>()).add(student);
        }
        return new HashMap<>(map);
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.removeIf(s -> s.equals(student)); // Используем лямбда-выражение для удаления
    }

    public static void findFaculty(List<Student> students, String faculty, int year) {
        for (Student student : students) {
            if (student.getYear() == year && student.getFaculty().equals(faculty)) {
                System.out.println(student.getName());
            }
        }
    }
}
