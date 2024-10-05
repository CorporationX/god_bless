package bjs2_29013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        addStudent(students, new Student("Jack", "Computer Science", 3));
        addStudent(students, new Student("Jane", "Economy", 2));
        addStudent(students, new Student("Jess", "Computer Science", 3));
        addStudent(students, new Student("Jacob", "Economy", 2));
        addStudent(students, new Student("Jonathon", "Psychology", 4));

        removeStudent(students, "Jack");

        Map<AcademicProgram, List<Student>> groupedStudents = groupStudents(students);

        System.out.println(searchAcademicProgramStudents(groupedStudents,
                new AcademicProgram("Economy", 2)));
        System.out.println();

        printAllGroupedStudents(groupedStudents);
    }

    public static Map<AcademicProgram, List<Student>> groupStudents(List<Student> students) {
        Map<AcademicProgram, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            groupedStudents.computeIfAbsent(new AcademicProgram(student.getAcademicProgram().getFaculty(),
                    student.getAcademicProgram().getYear()), k -> new ArrayList<Student>()).add(student);
        }

        return groupedStudents;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name) {
        students.removeIf(n -> n.getName().equals(name));
    }

    public static List<Student> searchAcademicProgramStudents(Map<AcademicProgram, List<Student>> groupedStudents,
                                                              AcademicProgram academicProgram) {
        return groupedStudents.get(academicProgram);
    }

    public static void printAllGroupedStudents(Map<AcademicProgram, List<Student>> groupedStudents) {
        for (var entry : groupedStudents.entrySet()) {
            System.out.printf("Academic program: %s -> Students: %s\n", entry.getKey(), entry.getValue());
        }
    }
}

