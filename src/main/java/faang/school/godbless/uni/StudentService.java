package faang.school.godbless.uni;

import java.util.*;

import static faang.school.godbless.uni.Main.studentList;
import static java.util.stream.Collectors.groupingBy;

public class StudentService {

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        return students.stream().collect(groupingBy(student -> new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear())));
    }

    public static void addStudentInList(String name, String faculty, int year) {
        studentList.add(new Student(name, faculty, year));
    }

    public static void removeStudentFromList(String name, String faculty, int year) {
        studentList.remove(new Student(name, faculty, year));
    }

    public static void printGroupStudentsByFacultyAndYear(Map<Map.Entry<String, Integer>, List<Student>> students) {
        students.forEach((k, v) -> {
            System.out.println("Faculty " + k.getKey() + ", year " + k.getValue());
            System.out.println(v);
        });
    }
}
