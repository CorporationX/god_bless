package faang.school.godbless.BJS2_4959;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;

    public static Map<Student, Integer> convertToHashMap(Set<Student> students) {
        Map<Student, Integer> studentsConvert = new HashMap<>();
        for (Student student : students) {
            studentsConvert.put(student, student.getYear());
        }
        return studentsConvert;
    }

    public static void addStudent(Map<Student, Integer> students, Student student) {
        students.put(student, student.getYear());
    }

    public static void deleteStudent(Map<Student, Integer> students, Student student) {
        students.remove(student);
    }

    public static Set<Student> findStudentsByFaculty(Map<Student, Integer> students, String faculty, int year) {
        Set<Student> studentsResult = new HashSet<>();
        for (Map.Entry<Student, Integer> entry : students.entrySet()) {
            if (entry.getKey().getFaculty().equals(faculty) && entry.getKey().getYear() == year) {
                studentsResult.add(entry.getKey());
            }
        }
        return studentsResult;
    }
}
