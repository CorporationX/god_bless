package faang.school.godbless.BJS2_19944;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent(new Student("Suragan", "Engineering", 1));
        addStudent(new Student("Nurzhan", "Engineering", 2));
        addStudent(new Student("Sundet", "Science", 1));
        addStudent(new Student("Dimash", "Science", 2));
        addStudent(new Student("Aruzhan", "Arts", 1));

        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(students);

        printGroupedStudents(groupedStudents);

        addStudent(new Student("Kamila", "Engineering", 2));

        removeStudent(students, "Sundet", "Science", 1);

        List<Student> engineeringFirstYear = findStudentsByFacultyAndYear(students, "Engineering", 1);
        System.out.println("Engineering, 1st Year: " + engineeringFirstYear);

    }
    public static void addStudent(Student student) {
        students.add(student);
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        groupedStudents.forEach((key, studentList) -> {
            System.out.println("Faculty and Year: " + key);
            studentList.forEach(student -> System.out.println("  " + student));
        });
    }


    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }
}
