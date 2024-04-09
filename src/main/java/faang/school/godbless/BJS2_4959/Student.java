package faang.school.godbless.BJS2_4959;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;

    private static Map<String, Integer> getGroup(String faculty, int year) {
        Map<String, Integer> result = new HashMap<>();
        result.put(faculty, year);
        return result;
    }

    public static Map<Map<String, Integer>, Set<Student>> addStudentsByGroups(Set<Student> students) {
        Map<Map<String, Integer>, Set<Student>> result = new HashMap<>();
        for (Student student : students) {
            Student.addStudent(result, student);
        }
        return result;
    }

    public static void addStudent(Map<Map<String, Integer>, Set<Student>> students, Student student) {
        students.computeIfAbsent(getGroup(student.getFaculty(), student.getYear()), v -> new HashSet<>()).add(student);
    }

    public static void deleteStudent(Map<Map<String, Integer>, Set<Student>> students, Student student) {
        students.remove(getGroup(student.getFaculty(), student.getYear()));
    }

    public static Set<Student> findStudentsByFaculty(Map<Map<String, Integer>, Set<Student>> students, String faculty, int year) {
        return students.get(getGroup(faculty, year));
    }

    public static void printAllStudents(Map<Map<String, Integer>, Set<Student>> students) {
        for (Map.Entry<Map<String, Integer>, Set<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey().toString());
            for (Student student : entry.getValue()) {
                System.out.println(student.toString());
            }
        }
    }
}
