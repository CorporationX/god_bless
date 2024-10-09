package faang.school.godbless.students;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(@NonNull Student student) {
        students.add(student);
    }

    public void removeStudent(@NonNull String name, @NonNull String faculty, @NonNull Integer year) {
        students.removeIf(s -> name.equals(s.getName()) && faculty.equals(s.getFaculty()) && year.equals(s.getYear()));
    }

    public List<Student> findBy(@NonNull String faculty, @NonNull Integer year) {
        return students.stream().filter(s -> faculty.equals(s.getFaculty()) && year.equals(s.getYear())).toList();
    }

    public void printStudents() {
        var groups = groupStudents(students);
        System.out.println(groups);
    }

    public static Map<FacultyYearTuple, List<Student>> groupStudents(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(s -> new FacultyYearTuple(s.getFaculty(), s.getYear())));
    }

}
