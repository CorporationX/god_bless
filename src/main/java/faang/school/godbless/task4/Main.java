package faang.school.godbless.task4;

import lombok.AllArgsConstructor;
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

        Map<KeyMap, List<Student>> sortStudent = Student.groupMapFacultyYear(students);
        System.out.println("*********************");
        Student.showInfo(sortStudent);
        System.out.println("*********************");
        System.out.println(Student.searchStudentFacultyAndYear(Student.groupMapFacultyYear(students), "IT", 5));
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
@AllArgsConstructor
class Student {
    private String name;
    private String faculty;
    private int year;

    public static Map<KeyMap, List<Student>> groupMapFacultyYear(List<Student> students) {
        Map<KeyMap, List<Student>> groupingMap = new HashMap<>();
        for (Student student : students) {
            KeyMap keyMap = new KeyMap(student.getFaculty(), student.getYear());
            groupingMap.putIfAbsent(keyMap, new ArrayList<>());
            groupingMap.get(keyMap).add(student);
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

    public static void showInfo(Map<KeyMap, List<Student>> mapy) {
        for (Map.Entry<KeyMap, List<Student>> entry : mapy.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static List<Student> searchStudentFacultyAndYear(Map<KeyMap, List<Student>> map, String faculty, int year) { //static
        List<Student> groupStudentsFaculty = new ArrayList<>();
        KeyMap tempKey = new KeyMap(faculty, year);
        if (map.containsKey(tempKey)) {
            groupStudentsFaculty.addAll(map.get(tempKey));
        }
        return groupStudentsFaculty;
    }
}


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
class KeyMap {
    private String faculty;
    private int year;
}