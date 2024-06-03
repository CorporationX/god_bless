package faang.school.godbless.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentOrganizer {

    public static Map<FacultyYearKey, List<Student>> organizeStudentsByFacultyToYear(List<Student> students) {
        Map<FacultyYearKey, List<Student>> organizedMap = new HashMap<>();
        for (Student student : students) {
            FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
            organizedMap.computeIfAbsent(facultyYearKey, k -> new ArrayList<>()).add(student);
        }
        return organizedMap;
    }

    public static void addNewStudent(Map<FacultyYearKey, List<Student>> targetMap, Student student) {
        Objects.requireNonNull(student);
        FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
        targetMap.computeIfPresent(facultyYearKey, (key, list) -> {
            list.add(student);
            return list;
        });
    }

    public static void removeStudent(Map<FacultyYearKey, List<Student>> targetMap, Student student) {
        Objects.requireNonNull(student);
        FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
        targetMap.computeIfPresent(facultyYearKey, (key, list) -> {
            list.remove(student);
            return list;
        });
    }

    public static List<Student> getStudentsFromSingleGroup(Map<FacultyYearKey, List<Student>> students, FacultyYearKey facultyYearKey) {
        Objects.requireNonNull(students);
        return students.get(facultyYearKey);
    }

    public static void printOrganizedMap(Map<FacultyYearKey, List<Student>> students) {
        Objects.requireNonNull(students);
        students.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
