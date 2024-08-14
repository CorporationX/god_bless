package faang.school.godbless.uni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uni {
    private List<Student> students = new ArrayList<>();
    private Map<String, List<Student>> grouped = new HashMap<>();

    public void addStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        String key = faculty + "-" + year;

        if (students.contains(student)) {
            throw new IllegalArgumentException("such student already exists");
        } else {
            students.add(student);
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        String key = faculty + "-" + year;
        if (students.contains(student)) {
            students.remove(student);
            grouped.get(key).remove(student);
        } else {
            throw new IllegalArgumentException("no such student");
        }
    }

    public Map<String, List<Student>> groupedStudents() {
        return grouped;
    }

    public void printGrouped() {
        grouped.forEach((classId, students) -> {
            System.out.println(classId + ":");
            students.forEach(student -> System.out.println("student " + student.getName()));
        });
    }

    public List<Student> search(String faculty, int year) {
        String key = faculty + "-" + year;
        return grouped.get(key);
    }
}
