package faang.school.godbless.countinabsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<Student> ALL_STUDENTS = new ArrayList<>();
    private static final Map<Student, Integer> STUDENT_INDEXES = new HashMap<>();
    private static Map<String, List<Student>> groupingStudents = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("add 9 students");
        addStudent(new Student("Tom", "IT", 2));
        addStudent(new Student("Jim", "IT", 2));
        addStudent(new Student("Petr", "IT", 3));
        addStudent(new Student("Dima", "Laser System", 1));
        addStudent(new Student("Andrey", "Laser System", 1));
        addStudent(new Student("Simon", "airspace", 1));
        addStudent(new Student("Anton", "airspace", 1));
        addStudent(new Student("Egor", "airspace", 3));
        addStudent(new Student("John", "airspace", 3));
        System.out.println("-----------------------------------------");

        System.out.println("test addStudent: ");
        ALL_STUDENTS.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("delete Student Petr and test: ");
        deleteStudent("Petr", "IT", 3);
        ALL_STUDENTS.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("grouping students");
        groupingStudents = groupStudentsByFaculty(ALL_STUDENTS);
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("Test findStudentByFacultyAndYear (laser 1):");
        findStudentsByFacultyAndYear("Laser System", 1)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("print grouping students:");
        printGroupingStudents();

    }

    public static void addStudent(Student student) {
        ALL_STUDENTS.add(student);
        STUDENT_INDEXES.put(student, ALL_STUDENTS.size() - 1);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student studentToDelete = new Student(name, faculty, year);
        ALL_STUDENTS.remove((int) STUDENT_INDEXES.get(studentToDelete));
    }

    public static Map<String, List<Student>> groupStudentsByFaculty(List<Student> students) {
        Map<String, List<Student>> groupingStudents = new HashMap<>();
        for (Student student : students) {
            groupingStudents.computeIfAbsent(student.getFACULTY() + student.getYEAR(),
                    key -> new ArrayList<>()).add(student);
        }
        return groupingStudents;
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        return groupingStudents.get(faculty + year);
    }

    public static void printGroupingStudents() {
        for (Map.Entry<String, List<Student>> entry : groupingStudents.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
