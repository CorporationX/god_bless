package faang.school.godbless.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(){
            {
                add(new Student("John", "Computer Science", 2021));
                add(new Student("Jane", "Engineering", 2021));
                add(new Student("Daniel", "Astronomy", 2021));
            }
        };

        addStudent(students, new Student("Samantha", "Computer Science", 2021));

        for (Map.Entry<Faculty, List<Student>> item : groupStudentsByFaculty(students).entrySet()) {
            System.out.println(item.getKey().getTitle() + " " + item.getKey().getYear());
            for (Student student : item.getValue()) {
                System.out.println("\t" + student);
            }
        }
        System.out.println("\n");

        removeStudent(students, new Student("Samantha", "Computer Science", 2021));

        for (Map.Entry<Faculty, List<Student>> item : groupStudentsByFaculty(students).entrySet()) {
            System.out.println(item.getKey().getTitle() + " " + item.getKey().getYear());
            for (Student student : item.getValue()) {
                System.out.println("\t" + student);
            }
        }

        System.out.println("\n");

        addStudent(students, new Student("Samantha", "Computer Science", 2021));
        searchStudentByFaculty(students, new Faculty("Computer Science", 2021));

        System.out.println("\n");
        printAllStudents(students);
    }

    public static Map<Faculty, List<Student>> groupStudentsByFaculty(List<Student> students) {
        Map<Faculty, List<Student>> groupedStudents = new HashMap<>();
        students.forEach(
                student -> groupedStudents.computeIfAbsent(
                        new Faculty(student.getFaculty(), student.getYear()), key -> new ArrayList<>()
                ).add(student));
        return groupedStudents;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, Student student) {
        students.remove(student);
    }

    public static void searchStudentByFaculty(List<Student> students, Faculty faculty) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty.getTitle()) && student.getYear() == faculty.getYear()) {
                System.out.println(student);
            }
        }
    }

    public static void printAllStudents(List<Student> students) {
        for (Map.Entry<Faculty, List<Student>> item : groupStudentsByFaculty(students).entrySet()) {
            System.out.println(item.getKey().getTitle() + " " + item.getKey().getYear());
            for (Student student : item.getValue()) {
                System.out.println("\t" + student);
            }
        }
    }
}
