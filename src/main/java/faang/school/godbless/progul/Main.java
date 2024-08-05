package faang.school.godbless.progul;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Harry", "Gryffindor", 1),
                new Student("Malfoy", "Slytherin", 1),
                new Student("Hannah", "Gryffindor", 3),
                new Student("Michael", "Gryffindor", 4),
                new Student("Ron", "Gryffindor", 1)
        ));

        showGroupedStudents(groupByFacultyAndYear(students));
        System.out.println();

        addStudent(students, "Hermione", "Gryffindor", 1);
        addStudent(students, "Gregory", "Slytherin", 2);

        showGroupedStudents(groupByFacultyAndYear(students));
        System.out.println();

        removeStudent(students, "Hannah", "Gryffindor", 3);
        removeStudent(students, "Michael", "Gryffindor", 4);
        removeStudent(students, "Gregory", "Slytherin", 2);

        showGroupedStudents(groupByFacultyAndYear(students));
        System.out.println();

        findStudentsByFacultyAndYear(students, "Gryffindor", 1);
        System.out.println();

        findStudentsByFacultyAndYear(students, "Slytherin", 1);
    }

    public static Map<String, List<Student>> groupByFacultyAndYear(List<Student> students) {
        return students.stream().collect(groupingBy(student -> student.getFaculty() + " " + student.getYear()));
    }

    private static void addStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    private static void removeStudent(List<Student> students, String name, String faculty, int year) {
        Student student = getStudentByNameFacultyYear(students, name, faculty, year);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        students.remove(student);
    }

    private static Student getStudentByNameFacultyYear(List<Student> students, String name, String faculty, int year) {
        return students.stream()
                .filter(student -> student.getName().equals(name) &&
                        student.getFaculty().equals(faculty) &&
                        student.getYear() == year)
                .findFirst()
                .orElse(null);
    }

    public static void showGroupedStudents(Map<String, List<Student>> studentGroup) {
        studentGroup.entrySet().forEach(System.out::println);
    }

    public static void findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        var studentList = students.stream()
                .filter(student -> student.getFaculty().equals(faculty) &&
                        student.getYear() == year)
                .toList();
        System.out.println("Year " + year + " of " + faculty + " has " + studentList.size() + " student.");
        studentList.forEach(student -> System.out.println(student.getName()));
    }
}
