package faang.school.godbless.uni;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.uni.Main.studentList;
import static java.util.stream.Collectors.groupingBy;

public class StudentService {

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        return students.stream()
                .collect(groupingBy(student -> new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear())));
    }

    public static void addStudentInList(Student student) {
        if (student != null) {
            studentList.add(student);
        }
    }

    public static void removeStudentFromList(Student student) {
        studentList.remove(student);
    }

    public static void printGroupStudentsByFacultyAndYear(Map<Map.Entry<String, Integer>, List<Student>> students) {
        students.forEach((k, v) -> {
            System.out.println("Faculty " + k.getKey() + ", year " + k.getValue());
            if (v != null) {
                System.out.println(v);
            }
        });
    }
}
