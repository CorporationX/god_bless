package school.faang.count.skipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountingSystem {
    private final List<Student> students = new ArrayList<>();
    private final Map<String, Integer> index = new HashMap<>();

    public void add(Student student) {
        Objects.requireNonNull(student, "student is null");
        students.add(student);
        index.put(student.getName(), students.size() - 1);
    }

    public void remove(String name) {
        int position = index.get(name);
        int lastIndex = students.size() - 1;

        //удаление элемента
        students.set(position, students.get(lastIndex));
        Student lastStudent = students.remove(lastIndex);

        //обновление индекса
        index.remove(name);
        index.put(lastStudent.getName(), position);
    }

    public List<Student> get(Course course) {
        Map<Course, List<Student>> courseToStudents = transform(students);
        return courseToStudents.get(course);
    }

    public void print() {
        Map<Course, List<Student>> courseToStudents = transform(students);
        courseToStudents.forEach((course, students) -> System.out.println(course + ": " + students));
    }

    public Map<Course, List<Student>> transform(List<Student> students) {
        Map<Course, List<Student>> courseToStudents = new HashMap<>();
        for (Student student : students) {
            List<Student> list = courseToStudents.getOrDefault(student.getCourse(), new ArrayList<>());
            list.add(student);
            courseToStudents.put(student.getCourse(), list);
        }
        return courseToStudents;
    }
}
