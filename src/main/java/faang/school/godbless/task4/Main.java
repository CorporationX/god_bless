package faang.school.godbless.task4;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(List.of(
                new Student("Anton", "IT", 5),
                new Student("Roman", "Design", 3),
                new Student("Maxim", "IT", 5),
                new Student("Andrei", "Medicine", 2),
                new Student("Vladimir", "Aviation", 1),
                new Student("Igor", "IT", 5),
                new Student("Artem", "Aviation", 3),
                new Student("Konstantin", "Aviation", 1),
                new Student("Bob", "Aviation", 1),
                new Student("Alexey", "IT", 4)
        ));

        Map<Pair<String, Integer>, List<Student>> sortStudent = Student.groupMapFacultyYear(students);
        System.out.println("*********************");
        Student.showInfo(sortStudent);
        System.out.println("*********************");
        System.out.println(Student.searchStudentsByFacultyAndYear(students, "IT", 5));
        System.out.println("*********************");
        Student.addStudentsForList(students, "Gennady", "Aviation", 4);
        System.out.println(students);
        System.out.println("*********************");
        Student.removeStudenYear(students, 3);
        System.out.println(students);
    }
}


@Getter
@ToString
@EqualsAndHashCode
class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
    }

    public static Map<Map.Entry<String, Integer>, List<Student>> groupMapFacultyYear(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> groupingMap = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            groupingMap.putIfAbsent(key, new ArrayList<>());
            groupingMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupingMap;
    }

    public static void addStudentsForList(List<Student> students, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    public static void removeStudentName(List<Student> students, String name) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                iterator.remove();
            }
        }
    }

    public static void removeStudentFaculty(List<Student> students, String faculty) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getFaculty().equalsIgnoreCase(faculty)) {
                iterator.remove();
            }
        }
    }

    public static void removeStudenYear(List<Student> students, int year) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getYear() == year) {
                iterator.remove();
            }
        }
    }

    public static void showInfo(Map<Pair<String, Integer>, List<Student>> mapy) {
        for (Map.Entry<Pair<String, Integer>, List<Student>> entry : mapy.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static List<Student> searchStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> groupStudentsFaculty = new ArrayList<>();
        for (Student student : students)
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                groupStudentsFaculty.add(student);
            }
        return groupStudentsFaculty;
    }
}