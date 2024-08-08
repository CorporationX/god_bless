package faang.school.godbless.BJS2_19421;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data

public class Student {

    private String name;
    private String faculty;
    private int year;

    public static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> studentMap = new HashMap<>();

        for (Student student : students) {
            String facultyAndYear = student.getFaculty() + " " + student.getYear();
            List studentList = studentMap.get(facultyAndYear);
            if (studentList == null) {
                studentList = new ArrayList();
                studentMap.put(facultyAndYear, studentList);
            }
            studentList.add(student);
        }
        return studentMap;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void deleteStudent(List<Student> students, Student student) {
        students.remove(student);
    }

    public static void searchStudents(List<Student> students, String faculty, int year) {
        for (Student student : students) {
            if (student.getYear() == year && student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
    }

    public static void printStudentsGrouped(Map<String, List<Student>> studentMapResult) {
        for (Map.Entry<String, List<Student>> entry : studentMapResult.entrySet()) {
            System.out.println("Faculty and Year: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("Name: " + student.getName());
            }
            System.out.println("");
        }
    }

}
