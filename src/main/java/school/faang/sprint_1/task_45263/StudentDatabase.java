package school.faang.sprint_1.task_45263;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> grades = new HashMap<>();
    private final Map<Subject, List<Student>> classes = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> studentGrades) {
        grades.put(student, studentGrades);
        for (Subject subject : studentGrades.keySet()) {
            classes.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addGradeToStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> studentGrades = grades.get(student);
        if (studentGrades != null) {
            studentGrades.put(subject, grade);
            classes.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudentWithGrades(Student student) {
        Map<Subject, Integer> studentGrades = grades.remove(student);
        if (studentGrades != null) {
            for (Subject subject : studentGrades.keySet()) {
                List<Student> students = classes.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentWithGrades() {
        grades.forEach((k, v) -> {
            System.out.println(k.name());
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1.name() + " " + v1);
            });
        });
        System.out.println("\n");
    }

    public void addClass(Subject subject, List<Student> students) {
        classes.put(subject, students);
        for (Student student : students) {
            grades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToClass(Subject subject, Student student) {
        classes.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        grades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromClass(Subject subject, Student student) {
        List<Student> students = classes.get(subject);
        if (CollectionUtils.isNotEmpty(students)) {
            students.remove(student);
            if (CollectionUtils.isEmpty(students)) {
                classes.remove(subject);
            }
        }
        Map<Subject, Integer> studentGrades = grades.get(student);
        if (MapUtils.isNotEmpty(studentGrades)) {
            studentGrades.remove(subject);
        }
    }

    public void printAllClasses() {
        classes.forEach((k, v) -> {
            System.out.println(k.name());
            for (Student student : v) {
                System.out.println("\t" + student.name());
            }
        });
        System.out.println("\n");
    }
}
