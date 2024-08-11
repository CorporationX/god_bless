package faang.school.godbless.BJS2_19879;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    public static Map<Student, Map<Subject, Integer>> studentGradesMap = new HashMap<>();
    private int id;
    private String name;

    public static void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGradesMap.put(student, grades);
    }

    public static void addGradeForStudent(Student student, Subject subject, int grade) {
        studentGradesMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public static void removeStudent(Student student) {
        studentGradesMap.remove(student);
    }
}
