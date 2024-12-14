package faang.school.godbless.bjs219665;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentManager {
    public static void addStudent(Set<Student> students, String name, String faculty, int year) {
        Student newStudent = new Student(name, faculty, year);
        students.add(newStudent);
        System.out.println("Student added");
    }

    public static void deleteStudent(Set<Student> students, String name, String faculty, int year) {
        if (!students.contains(new Student(name, faculty, year))) {
            System.out.println("Student not found");
        } else {
            students.remove(new Student(name, faculty, year));
            System.out.println("Student deleted");
        }
    }

    public static Set<Student> findByFacultyAndYear(Set<Student> students, String faculty, int year) {
        Set<Student> filteredStudents;
        filteredStudents = students.stream().filter(student -> student.getFaculty().equals(faculty) && student.getYear() == year)
                .collect(Collectors.toSet());
        return filteredStudents;
    }

    public static Map<MapKey, Set<Student>> groupedStudents(Set<Student> students) {
        Map<MapKey, Set<Student>> groupedStudents = new HashMap<>();
        Set<MapKey> mapKeys = new HashSet<>();
        students.forEach(student ->
                mapKeys.add(new MapKey(student.getFaculty(), student.getYear()))
        );
        mapKeys.forEach(mapKey ->
                groupedStudents.computeIfAbsent(mapKey, k -> findByFacultyAndYear(students, k.getFaculty(), k.getYear())));
        return groupedStudents;
    }
}
