package faang.school.godbless.javamagics.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManager {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", "Computer Science", "1st year"));
        students.add(new Student("Bruce Banner", "Information Science", "3rd year"));
        students.add(new Student("John Smith", "Computer Science", "1st year"));
        students.add(new Student("Tony Stark", "Information Science", "3rd year"));
        students.add(new Student("Petter Parker", "Information Science", "1st year"));

        Map<String, List<Student>> map = sortStudentsByFacultyAndYear(students);

        System.out.println(map);
    }

    private static Map<String, List<Student>> sortStudentsByFacultyAndYear(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(student -> student.getYear() + " " + student.getFaculty()));
    }

    private static void addStudent(Student student, List<Student> students) {
        students.add(student);
    }

    private static void removeStudentByName(String name, List<Student> students) {
        students.removeIf(student -> student.getName().equals(name));
    }

    private static List<Student> getClassmates(String faculty, String year, List<Student> students) {
        return students.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear().equals(year))
                .collect(Collectors.toList());
    }
}
