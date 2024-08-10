package faang.school.godbless.BJS219321;

import java.util.*;

public class Main {
    private static Set<Student> students = new HashSet<>();
    private static Map<String, List<Student>> sortStudentsByFacultyAndYear = new HashMap<>();

    public static Map<String, List<Student>> sortStudentsByFacultyAndYear(Set<Student> students) {
        Map<String, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return result;
    }

    public static void addStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }

    public static List<Student> searchStudentsByFacultyAndYear(String faculty, int year) {
        String key = faculty + "-" + year;
        return sortStudentsByFacultyAndYear.get(key);
    }

    public static void printGroupedStudents() {
        for (Map.Entry<String, List<Student>> entry : sortStudentsByFacultyAndYear.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        addStudent("Alice", "Engineering", 2);
        addStudent("Bob", "Engineering", 2);
        addStudent("Charlie", "Business", 1);
        addStudent("Dave", "Engineering", 1);
        addStudent("Eve", "Business", 2);

        sortStudentsByFacultyAndYear = sortStudentsByFacultyAndYear(students);

        printGroupedStudents();

        List<Student> engineeringYear2 = searchStudentsByFacultyAndYear("Engineering", 2);
        System.out.println("\nStudents in Engineering, Year 2:");
        engineeringYear2.forEach(student -> System.out.println(student.toString()));
    }
}
