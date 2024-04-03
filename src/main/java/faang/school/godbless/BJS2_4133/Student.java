package faang.school.godbless.BJS2_4133;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    private String getDirectionKey() {
        return String.format("%s-%s", getFaculty(), getYear());
    }

    public static HashMap<String, HashSet<Student>> groupStudentsByDirection(HashSet<Student> students) {
        HashMap<String, HashSet<Student>> result = new HashMap<>();

        for (Student student : students) {
            addStudentToDirection(student, result);
        }

        return result;
    }

    public static void addStudentToDirection(Student student, HashMap<String, HashSet<Student>> target) {
        target.computeIfAbsent(student.getDirectionKey(), k -> new HashSet<>()).add(student);
    }

    public static void removeStudentFromDirection(String name, String faculty, int year, HashMap<String, HashSet<Student>> target) {
        Student student = new Student(name, faculty, year);
        HashSet<Student> studentGroup = target.get(student.getDirectionKey());

        if (studentGroup == null) {
            throw new IllegalArgumentException(String.format("Студент \"%s\", Факультет \"%s\", Год \"%s\" не найден", name, faculty, year));
        }

        studentGroup.remove(student);
    }

    public static HashSet<Student> getStudentsByDirection(String faculty, int year, HashMap<String, HashSet<Student>> target) {
        HashSet<Student> students = target.get(String.format("%s-%s", faculty, year));

        if (students == null) {
            return new HashSet<>();
        }

        return students;
    }
}
