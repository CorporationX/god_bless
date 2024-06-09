package faang.school.godbless.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        try {
            addStudent(new Student("Ivan", "ABC", 3));
            addStudent(new Student("Sergei", "BCD", 3));
            addStudent(new Student("Nikita", "ABC", 2));
            addStudent(new Student("Sveta", "BCD", 3));
            addStudent(new Student("Vlad", "CDE", 2));
            addStudent(new Student("Andrei", "CDE", 1));
            addStudent(new Student("Stepan", "ABC", 1));
            System.out.println("---------------------------");
            STUDENTS.forEach(System.out::println);
            System.out.println("---------------------------");
            removeStudent("Stepan", "ABC", 1);
            System.out.println("---------------------------");
            Map<String, List<Student>> students = getStudentsByFacultyAndYear();
            printStudentsByFacultyAndYear(students);
            System.out.println("---------------------------");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addStudent(Student student) {
        Objects.requireNonNull(student);
        STUDENTS.add(student);
        System.out.println("Student \"" + student.name() + "\" is added successfully.");
    }

    private static void removeStudent(String name, String faculty, int year) {
        Objects.requireNonNull(STUDENTS);
        Objects.requireNonNull(name);
        Objects.requireNonNull(faculty);
        Student student = new Student(name, faculty, year);
        if (STUDENTS.remove(student)) {
            System.out.println("Student : \"" + student.name() + "\" removed successfully");
        } else {
            throw new StudentNotFoundException("Student : \"" + student.name() + "\" is not deleted. No such student");
        }
    }

    public static Map<String, List<Student>> getStudentsByFacultyAndYear() {
        return STUDENTS.stream()
                .collect(Collectors.groupingBy(student -> student.faculty() + " " + student.year()));
    }

    public static void printStudentsByFacultyAndYear(Map<String, List<Student>> students) {
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
