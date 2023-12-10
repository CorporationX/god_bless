package faang.school.godbless.counting_absenteeism;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {

        for (Student student : students) {
            if (student.getYear() == year && student.getName().equals(name) && student.getFaculty().equals(faculty)) {
                students.remove(student);
                break;
            }
        }

    }

    public static List<Student> searchAllStudentsGroup(List<Student> students, String faculty, int year) {
        List<Student> allStudentsGroup = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                allStudentsGroup.add(student);
            }
        }
        return allStudentsGroup;
    }

    public static void infoGroupedStudents(Map<Course, List<Student>> groupedStudents) {
        for (Map.Entry<Course, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

    }

}
