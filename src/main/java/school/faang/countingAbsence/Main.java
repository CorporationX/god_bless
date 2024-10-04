package school.faang.countingAbsence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student potter = new Student("Harry Potter", "Puffendui", 1);
        Student yuji = new Student("Yuji Itadori", "Magic", 2);
        Student nobara = new Student("Nobara Kugisaki", "Magic", 2);
        Student gojo = new Student("Satoru gojo", "Magic", 3);

        addStudent(potter);
        addListOfStudents(List.of(yuji, nobara, gojo));
        printAllStudents();
        removeStudent("Harry Potter", "Puffendui", 1);
        printAllStudents();
        Map<String, List<Student>> groupedStudents = groupByFacultyAndYear(students);
        printGroupedStudents(groupedStudents);
        findByFacultyAndYear(groupedStudents, "Magic", 2);
    }

    private static void addStudent(Student student) {
        students.add(student);
    }

    private static void addListOfStudents(List<Student> studentsList) {
        students.addAll(studentsList);
    }

    private static void removeStudent(String name, String faculty, int year) {
        students.removeIf(k -> (k.getName().equals(name)
                && k.getYear() == year
                && k.getFaculty().equals(faculty)));

    }

    private static void findByFacultyAndYear(Map<String, List<Student>> groupedStudents, String faculty, int year) {
        for (var entry : groupedStudents.entrySet()) {
            if (entry.getKey().equals(faculty+year)) {
                System.out.println(entry.getValue());
                break;
            }
        }
    }

    private static Map<String, List<Student>> groupByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    private static void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        System.out.println(groupedStudents);
    }

    private static void printAllStudents() {
        System.out.println(students);
    }
}
