package school.faang.countAbsenteeism;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final List<Student> students = new ArrayList<>();

    private static Map<Map.Entry<String, Integer>, List<Student>> groupedStudents = new HashMap<>();

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudents(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            AbstractMap.SimpleEntry<String, Integer> key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (Objects.equals(student.getYear(), year) && student.getFaculty().equals(faculty)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public static void showGroupedStudents() {
        System.out.println(groupedStudents);
    }


    public static void main(String[] args) {
        Student student1 = new Student("Abzalkhan", "IT", 5);
        Student student2 = new Student("Olzhas", "Math", 2);
        Student student3 = new Student("Aida", "Math", 2);
        Student student4 = new Student("Ruslan", "Physics", 4);
        Student student5 = new Student("Madi", "IT", 5);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        System.out.println(students);
        System.out.println();

        deleteStudent("Ruslan", "Physics", 4);
        System.out.println(students);
        System.out.println();

        System.out.println(findStudentsByFacultyAndYear("IT", 5));
        System.out.println();

        groupedStudents = groupStudents(students);
        showGroupedStudents();
    }
}
