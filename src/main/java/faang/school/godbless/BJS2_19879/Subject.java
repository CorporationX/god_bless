package faang.school.godbless.BJS2_19879;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Subject {
    public static Map<Subject, List<Student>> subjectStudentsMap = new HashMap<>();

    private int id;
    private String name;

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudentsMap.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        subjectStudentsMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = subjectStudentsMap.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }
}
