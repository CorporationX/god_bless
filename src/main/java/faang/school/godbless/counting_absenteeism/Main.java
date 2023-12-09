package faang.school.godbless.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(sortStudents(students));
    }
    public static Map<Course, List<Student>> sortStudents(List<Student> students) {
        Map<Course, List<Student>> classmates = new HashMap<>();
        for (Student student : students) {
            Course course = new Course(student.getFaculty(), student.getYear());
            classmates.putIfAbsent(course, new ArrayList<>());
            classmates.get(course).add(student);
        }
        return classmates;
    }


}


