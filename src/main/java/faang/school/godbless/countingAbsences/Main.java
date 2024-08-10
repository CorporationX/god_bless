package faang.school.godbless.countingAbsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<FacultyAndYear, List<Student>> groupedStudents = new HashMap<>();

    public static void groupByFacultyAndYear(List<Student> students) {
        for (Student student : students) {
            addToGroupedStudents(student);
        }
    }

    public static void addToGroupedStudents(Student student) {
        FacultyAndYear key = new FacultyAndYear(student.getFaculty(), student.getYear());
        groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    }

    public static void printGroupedStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<FacultyAndYear, List<Student>> entry : groupedStudents.entrySet()) {
            entry.getValue().forEach(student -> stringBuilder.append(student).append(System.lineSeparator()));
        }
        System.out.println(stringBuilder);
    }

    public static void addStudent(Student student) {
        students.add(student);
        addToGroupedStudents(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
        FacultyAndYear key = new FacultyAndYear(student.getFaculty(), student.getYear());
        groupedStudents.get(key).remove(student);
    }

    public static List<Student> searchStudentsByFacultyAndYear(String faculty, int year) {
        return groupedStudents.get(new FacultyAndYear(faculty, year));
    }

    public static void searchAndPrint(String faculty, int year) {
        List<Student> students = searchStudentsByFacultyAndYear(faculty, year);
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        students.add(new Student("Алексей", "Экономика", 1));
        students.add(new Student("Виктор", "Экономика", 2));
        students.add(new Student("Павел", "Математика", 1));
        students.add(new Student("Виктор", "Математика", 1));
        students.add(new Student("Алексей", "Математика", 1));
        students.add(new Student("Александр", "Математика", 2));

        groupByFacultyAndYear(students);
        printGroupedStudents();
        System.out.println("-----------------------");

        addStudent(new Student("Александр", "Экономика", 2));
        printGroupedStudents();
        System.out.println("----------------");

        searchAndPrint("Экономика", 2);
        System.out.println("----------------");

        removeStudent("Виктор", "Математика", 1);
        searchAndPrint("Математика", 1);
        System.out.println("----------------");

        printGroupedStudents();
    }
}
