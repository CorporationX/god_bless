package school.faang.BJS2_32484;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static Map<Entry<Faculty, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<Entry<Faculty, Integer>, List<Student>> studentsGroup = new HashMap<>();

        for (Student student : students) {
            Entry<Faculty, Integer> key = new SimpleEntry<>(student.getFaculty(), student.getYear());
            studentsGroup.computeIfAbsent(key, value -> new ArrayList<>()).add(student);
        }
        return studentsGroup;
    }

    public static void printAllGroupedUsers(Map<Map.Entry<Faculty, Integer>, List<Student>> studentsGroup) {
        System.out.println("Список студентов группированных по факультету и курсу: \n");

        for (Map.Entry<Map.Entry<Faculty, Integer>, List<Student>> entry : studentsGroup.entrySet()) {
            System.out.println("Факультет: " + entry.getKey().getKey() + ", Курс: " + entry.getKey().getValue() + ", студенты: ");

            entry.getValue().forEach(student -> System.out.println("\t" + student.getName()));
            System.out.println();
        }
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void deleteStudent(String name, Faculty faculty, int year) {
        STUDENTS.removeIf(student -> (student.getName().equals(name)) && (student.getFaculty().equals(faculty))
                && (student.getYear() == year));
    }

    public static List<Student> getStudentsByFacultyAndYear(Faculty faculty, int year) {
        List<Student> matchedStudents = new ArrayList<>();
        for (Student student : STUDENTS) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                matchedStudents.add(student);
            }
        }
        return matchedStudents;
    }

    public static void main(String[] args) {
        STUDENTS.add(new Student("John", Faculty.CS, 1));
        STUDENTS.add(new Student("Peter", Faculty.PSYCHOLOGY, 2));
        STUDENTS.add(new Student("Tom", Faculty.MARKETING, 3));
        STUDENTS.add(new Student("Mark", Faculty.CS, 1));
        STUDENTS.add(new Student("Artur", Faculty.PSYCHOLOGY, 2));
        STUDENTS.add(new Student("Maria", Faculty.MARKETING, 3));

        printAllGroupedUsers(groupStudentsByFacultyAndYear(STUDENTS));

        addStudent(new Student("Nina", Faculty.PSYCHOLOGY, 4));
        deleteStudent("John", Faculty.CS, 1);
        System.out.println(getStudentsByFacultyAndYear(Faculty.CS, 1));
    }
}
