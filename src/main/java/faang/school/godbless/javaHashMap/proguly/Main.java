package faang.school.godbless.javaHashMap.proguly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentBase;

    public static void main(String[] args) {
        studentBase = new ArrayList<>();

        studentBase.add(new Student("Oleg", "IT", 3));
        studentBase.add(new Student("Vasya", "IT", 3));
        studentBase.add(new Student("Yarik", "IT", 4));
        studentBase.add(new Student("Ruslan", "Economics", 1));
        studentBase.add(new Student("Alex", "Economics", 1));
        studentBase.add(new Student("Danil", "Phys-tech", 4));
        studentBase.add(new Student("Anna", "Pharma", 4));

        System.out.println("StudentManager test.\n");

        System.out.println("Student base at start point:");
        printGroupedStudents();


        System.out.println("\nAdding new student:");
        addNewStudent("Denis", "IT", 4);

        System.out.println("Student base after that:");
        printGroupedStudents();


        System.out.println("\nRemoving a student (Ruslan):");
        removeStudent("Ruslan", "Economics", 1);

        System.out.println("Student base after that:");
        printGroupedStudents();


        System.out.println("\nStudents of IT faculty 4th year:");
        getStudentsByFacultyAndYear("IT", 4).forEach(System.out::println);


        System.out.println("Done.");
    }

    public static Map<StudentKey, List<Student>> groupStudents(List<Student> studentList) {
        Map<StudentKey, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : studentList) {
            StudentKey currentKey = new StudentKey(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(currentKey, key -> new ArrayList<>()).add(student);
        }

        return groupedStudents;
    }

    public static void addNewStudent(String name, String faculty, int year) {
        studentBase.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student studentToBeRemoved = new Student(name, faculty, year);

        studentBase.remove(studentToBeRemoved);
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        return groupStudents(studentBase).getOrDefault(new StudentKey(faculty, year), null);
    }

    public static void printGroupedStudents() {
        groupStudents(studentBase).entrySet().forEach(System.out::println);
    }
}
