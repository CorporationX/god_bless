package faang.school.godbless.uni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uni {
    private List<Student> students = new ArrayList<>();
    Map<String, List<Student>> grouped = new HashMap<>();

    public boolean addStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        String key = faculty + "-" + year;

        if (students.contains(student)) {
            return false;
        } else {
            students.add(student);
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
            return true;
        }
    }

    public boolean removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        String key = faculty + "-" + year;
        if (students.contains(student)) {
            students.remove(student);
            grouped.get(key).remove(student);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, List<Student>> groupedStudents() {
        return grouped;
    }

    public List<Student> search(String faculty, int year) {
        String key = faculty + "-" + year;
        return grouped.get(key);
    }
}
