package school.faang.countabsences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static final List<Student> students = new ArrayList<>(
            List.of(
                    new Student("name_1", "faculty_1", 1),
                    new Student("name_2", "faculty_2", 3),
                    new Student("name_3", "faculty_1", 3),
                    new Student("name_4", "faculty_3", 2)
            )
    );

    public static Map<Group, List<Student>> getGroupedStudents(List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.groupingBy(
                                s -> new Group(s.getFaculty(), s.getYear())
                        )
                );
    }

    public static List<Student> addStudentToList(List<Student> students, Student student) {
        students.add(student);
        return students;
    }

    public static List<Student> removeStudent(List<Student> students, String name, String faculty, int year) {
        return students.stream()
                .filter( s -> s.getName().equals(name) && s.getFaculty().equals(faculty) && s.getYear() == year)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        return students.stream()
                .filter( s-> s.getFaculty().equals(faculty) && s.getYear() == year)
                .collect(Collectors.toList());
    }
}