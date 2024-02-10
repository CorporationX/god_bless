package faang.school.godbless.main.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    public static void main(String... args) {
        add(new Student("Ivan Ivanov", "Management", 2023));
        add(new Student("Elon Musk", "Robotics", 2020));
        add(new Student("Petr Petrov", "Management", 2023));
        add(new Student("Basil Cat", "Robotics", 2020));
        add(new Student("Aleksander Pushkin", "Literature", 2022));
        add(new Student("Leo Tolstoy", "Literature", 2021));
        add(new Student("Nikolay Gogol", "Literature", 2021));
        printAllStudentsByFacultyAndYear();
        remove("Elon Musk", "Robotics", 2020);
        printByFacultyAndYear("Robotics", 2020);
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void remove(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static void printByFacultyAndYear(String faculty, int year) {
        FacultyAndYear currentInfo = new FacultyAndYear(faculty, year);
        Map<FacultyAndYear, List<Student>> sortedStudents = organiseStudents(students);
        List<Student> currentList = sortedStudents.get(currentInfo);
        System.out.println(String.format("Students of faculty \"%s\" %d are:", faculty, year));
        if (currentList != null) {
            for (var student : currentList) {
                System.out.println(student.getName());
            }
        } else {
            System.out.println("No one");
        }
    }

    public static void printAllStudentsByFacultyAndYear() {
        Map<FacultyAndYear, List<Student>> sortedStudents = organiseStudents(students);
        for (var entry : sortedStudents.entrySet()) {
            System.out.println(String.format("Student of faculty \"%s\" %d are:", entry.getKey().getFaculty(), entry.getKey().getYear()));
            for (var student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
    public static Map<FacultyAndYear, List<Student>> organiseStudents(List<Student> students) {
        Map<FacultyAndYear, List<Student>> studentsByFaculty = new HashMap<>();
        List<Student> currentFacultyAndYearStudents;
        for (Student student : students) {
            FacultyAndYear currentStudentInfo = new FacultyAndYear(student.getFaculty(),student.getYear());
            if (studentsByFaculty.get(currentStudentInfo) == null) {
                currentFacultyAndYearStudents = new ArrayList<>();
            } else {
                currentFacultyAndYearStudents = studentsByFaculty.get(currentStudentInfo);
            }
            currentFacultyAndYearStudents.add(student);
            studentsByFaculty.put(currentStudentInfo, currentFacultyAndYearStudents);
        }
        return studentsByFaculty;
    }
}
