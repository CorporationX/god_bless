package faang.school.godbless.r_edzie.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        Student s0 = new Student("Boris", "A", 2000);
        Student s1 = new Student("Ivan", "B", 2001);
        Student s2 = new Student("Petr", "B", 2001);
        Student s3 = new Student("Vladimir", "A", 2000);
        Student s4 = new Student("Dmitriy", "A", 2000);

        add(s0);
        add(s1);
        add(s2);
        add(s3);
        add(s4);

        remove(s3.getName(), s3.getFaculty(), s3.getYear());

        Map<Graduate, List<Student>> graduateGroups = groupByFacultyAndYear(STUDENTS);

        findByFacultyAndYear(s0.getFaculty(), s0.getYear(), graduateGroups);

        printAll(graduateGroups);
    }

    public static void add(Student student) {
        STUDENTS.add(student);
    }

    public static void remove(String name, String faculty, int year) {
        STUDENTS.remove(new Student(name, faculty, year));
    }

    public static Map<Graduate, List<Student>> groupByFacultyAndYear(List<Student> students) {
        Map<Graduate, List<Student>> graduateGroups = new HashMap<>();

        for (Student student : students) {
            Graduate graduateGroup = new Graduate(student.getFaculty(), student.getYear());
            graduateGroups.computeIfAbsent(graduateGroup, k -> new ArrayList<>()).add(student);
        }

        return graduateGroups;
    }

    public static void findByFacultyAndYear(String faculty, int year, Map<Graduate, List<Student>> graduateGroups) {
        List<Student> studentList = graduateGroups.get(new Graduate(faculty, year));
        System.out.print(faculty + " " + year + " ");

        if (studentList == null) {
            System.out.println("Not found");
            return;
        }

        studentList.forEach(student -> System.out.print(student.getName() + " "));
        System.out.println();
    }

    public static void printAll(Map<Graduate, List<Student>> graduateGroups) {
        graduateGroups.forEach((graduate, students) -> {
            System.out.print(graduate.getFaculty() + " " + graduate.getYear() + " ");
            students.forEach(student -> System.out.print(student.getName() + " "));
            System.out.println();
        });
    }
}
