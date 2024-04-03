package faang.school.godbless.BJS2_4133;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    private String getDirectionKey() {
        return String.format("%s-%s", getFaculty(), getYear());
    }

    public static Map<String, Set<Student>> groupStudentsByDirection(Set<Student> students) {
        Map<String, Set<Student>> result = new HashMap<>();

        for (Student student : students) {
            addStudentToDirection(student, result);
        }

        return result;
    }

    public static void addStudentToDirection(Student student, Map<String, Set<Student>> target) {
        target.computeIfAbsent(student.getDirectionKey(), k -> new HashSet<>()).add(student);
    }

    public static void removeStudentFromDirection(String name, String faculty, int year, Map<String, Set<Student>> target) {
        Student student = new Student(name, faculty, year);
        Set<Student> studentGroup = target.get(student.getDirectionKey());

        if (studentGroup == null) {
            throw new IllegalArgumentException(String.format("Студент \"%s\", Факультет \"%s\", Год \"%s\" не найден", name, faculty, year));
        }

        studentGroup.remove(student);
    }

    public static Set<Student> getStudentsByDirection(String faculty, int year, Map<String, Set<Student>> target) {
        Set<Student> students = target.get(String.format("%s-%s", faculty, year));

        if (students == null) {
            return new HashSet<>();
        }

        return students;
    }
}
