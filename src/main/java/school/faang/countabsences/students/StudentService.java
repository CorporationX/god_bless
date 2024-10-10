package school.faang.countabsences.students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {

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
