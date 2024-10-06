package school.faang.count.skipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountingSystem {
    private final List<Student> students = new ArrayList<>();
    private final Map<String, Integer> studentToIndex = new HashMap<>();
    private final Map<Course, List<Student>> courseToStudents = new HashMap<>();

    public void add(Student student) {
        Objects.requireNonNull(student, "student is null");
        students.add(student);
        studentToIndex.put(student.getName(), students.size() - 1);
        List<Student> students = courseToStudents.getOrDefault(student.getCourse(), new ArrayList<>());
        students.add(student);
        courseToStudents.put(student.getCourse(), students);
    }

    public void remove(String name) {
        int position = studentToIndex.get(name);
        int lastIndex = students.size() - 1;

        students.set(position, students.get(lastIndex));
        Student lastStudent = students.remove(lastIndex);
        studentToIndex.remove(name);
        if (!name.equals(lastStudent.getName())) {
            studentToIndex.put(lastStudent.getName(), position);
        }

        for (var entry : courseToStudents.entrySet()) {
            Course course = entry.getKey();
            List<Student> students = entry.getValue();
            students.removeIf(s -> s.getName().equals(name));
            if (students.isEmpty()) {
                courseToStudents.remove(course);
                return;
            }
            courseToStudents.put(course, students);
        }
    }

    public List<Student> get(Course course) {
        return courseToStudents.get(course);
    }

    public void print() {
        courseToStudents.forEach((course, students) -> System.out.println(course + ": " + students));
    }

    public Map<Course, List<Student>> groupingByCourse(List<Student> students) {
        Map<Course, List<Student>> courseToStudents = new HashMap<>();
        for (Student student : students) {
            List<Student> list = courseToStudents.getOrDefault(student.getCourse(), new ArrayList<>());
            list.add(student);
            courseToStudents.put(student.getCourse(), list);
        }
        return courseToStudents;
    }
}
