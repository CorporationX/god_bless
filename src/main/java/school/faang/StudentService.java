package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {
    public static void addStudent(List<Student> students, String name, String faculty, String year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    public static void updateStudentsMap(Map<FacultyYearGroup, List<Student>> groupsMap, List<Student> students) {
        for (Student student : students) {
            FacultyYearGroup group = new FacultyYearGroup(student);
            groupsMap.computeIfAbsent(group, k -> new ArrayList<>()).add(student);
        }
    }

    public static void removeStudent(Map<FacultyYearGroup, List<Student>> map, String name, String faculty, String year) {
        FacultyYearGroup group = new FacultyYearGroup(faculty, year);
        List<Student> bufferList = map.get(group);
        bufferList.remove(new Student(name, faculty, year));
        map.putIfAbsent(group, bufferList);
    }

    public static String searchStudentByGroup(Map<FacultyYearGroup, List<Student>> map, String faculty, String year) {
        FacultyYearGroup group = new FacultyYearGroup(faculty, year);
        List<Student> studentList = map.get(group);
        return group.toString() + ":\n" + studentList.toString();
    }

    public static void viewAllStudents(Map<FacultyYearGroup, List<Student>> map) {
        map.forEach((k, v) -> {
            System.out.println("\n" + k.toString());
            v.forEach(student -> System.out.println(student.getName()));
        });
    }
}
