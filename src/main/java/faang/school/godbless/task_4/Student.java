package faang.school.godbless.task_4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Student {
    @Getter
    private final String name;
    @Getter
    private final String faculty;
    @Getter
    private final String course;

    @Getter
    private static List<Student> studentList = new ArrayList<>();


    public Student(String name, String faculty, String course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public static void addStudent(Student student) {
        if (!studentList.isEmpty()) {
            if (studentList.contains(student)) {
                System.out.println("There is already such a student at the University!");
            } else {
                studentList.add(student);
                System.out.println("Add student: " + student.getName());
            }
        }
    }

    public static void removeStudent(Student student) {
        if (!studentList.contains(student)) {
            System.out.println("There is not such a student at the University!");
        } else {
            studentList.remove(student);
            System.out.println("Remove student: " + student.getName());
        }
    }

    public static void searchStudent(Student student) {
        if (studentList.contains(student)) {
            System.out.println("Find student : " + student.getName());
        } else {
            System.out.println("There is not such a student at the University!");
        }
    }

    public static List<Student> getAllStudents(List<Student> students) {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, course);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + "}" + '\n';
    }
}
