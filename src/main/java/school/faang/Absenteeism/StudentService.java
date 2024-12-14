package school.faang.Absenteeism;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {

    public static void addStudent(Student student, List<Student> students) {
        students.add(student);
    }

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        return students.stream().
                collect(Collectors.groupingBy(student -> (student.getFaculty() + "-" + student.getYear())));
    }

    public static void removeStudentByData(String name, String faculty, int year, List<Student> students) {
        students.removeIf(student -> student.equals(new Student(name, faculty, year)));
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year, List<Student> students) {
        return students.stream().
                filter(student -> student.getFaculty().equals(faculty)
                        && student.getYear() == year).collect(Collectors.toList());
    }

    public static void printAllStudents(List<Student> students) {
        groupStudents(students).forEach((k, v) -> System.out.println(k + ": " + v));
    }

}
