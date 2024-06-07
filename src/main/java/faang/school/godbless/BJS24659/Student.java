package faang.school.godbless.BJS24659;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private String faculty;
    private int year;

    public static Map<String, List<Student>> groupByFacultyAndYear(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(student -> student.getFaculty() + student.getYear()));
    }

    public static void addStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        return students.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear() == year)
                .collect(Collectors.toList());
    }

    public static void printStudentsByFacultyAndYear(Map<String, List<Student>> groupedStudents) {
        groupedStudents.forEach((key, value) -> {
            System.out.println("Факультет и курс: " + key);
            System.out.println("Студенты: ");
            value.forEach(System.out::println);
            System.out.println();
        });
    }
}
