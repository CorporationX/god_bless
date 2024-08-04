package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private String faculty;
    private int year;

    public static Map<Student, List<Student>> createMapByFacultyAndYear(List<Student> students) {
        Map<Student, List<Student>> map = new HashMap<>();

        for (Student student : students) {
            addStudentToMap(map, student);
        }

        return map;
    }

    public static void addStudentToMap(Map<Student, List<Student>> map, Student student) {
        List<Student> count = map.getOrDefault(student, new ArrayList<>());
        count.add(student);
        map.put(student, count);
    }

    public static void removeStudentToMap(Map<Student, List<Student>> map, Student student) {
        List<Student> count = map.get(student);
        if (count != null) {
            count.remove(student);
            if (count.isEmpty()) {
                map.remove(student);
            }
        }
    }

    public static Optional<List<Student>> findListByFacultyAndYear(Map<Student, List<Student>> map, String faculty, int year) {
        List<Student> students = map.get(new Student("", faculty, year));
        return Optional.ofNullable(students);
    }

    public static void printStudents(Map<Student, List<Student>> map) {
        for (List<Student> students : map.values()) {
            Student student = students.get(0);
            System.out.printf("%s %s = %s%n", student.faculty, student.year, students);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
