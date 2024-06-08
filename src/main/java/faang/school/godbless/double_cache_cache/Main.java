package faang.school.godbless.double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    Map<Subject, List<Student>> courses = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            courses.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    public void enrollStudent(Student student, Subject subject, int grade) {
        if(!students.containsKey(student))
            throw new IllegalArgumentException("Student " + student + " does not exist");
        students.get(student).put(subject, grade);
        courses.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void graduateStudent(Student student) {
        students.get(student).forEach((subject, grade) -> {
            courses.computeIfPresent(subject, (key, students) -> {
                students.remove(student);
                return students.isEmpty() ? null : students;
            });
        });
    }

    public void statistics() {
        for (Map.Entry<Subject, List<Student>> entry : courses.entrySet()) {
            System.out.println("*******" + entry.getKey() + "*******");
            for (Student student : entry.getValue()) {
                int grade = students.get(student).get(entry.getKey());
                System.out.println("    " + student.getName() + " " + student.getId() + ": " + grade);
            }
        }
    }
}
