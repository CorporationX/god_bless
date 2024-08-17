package faang.school.godbless.dolbahlop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String name, String faculty, int year) {
        return students.removeIf(student ->
                student.getName().equals(name) &&
                student.getFaculty().equals(faculty) &&
                student.getYear() == year
        );
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        return students.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear() == year)
                .collect(Collectors.toList());
    }

    public Map<String, List<Student>> groupStudentsByFacultyAndYear() {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " " + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }
}
