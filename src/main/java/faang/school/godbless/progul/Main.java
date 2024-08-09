package faang.school.godbless.progul;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> students = new ArrayList<>(List.of(
                new Student("Harry", "Gryffindor", 1),
                new Student("Malfoy", "Slytherin", 1),
                new Student("Hannah", "Gryffindor", 3),
                new Student("Michael", "Gryffindor", 3),
                new Student("Ron", "Gryffindor", 1)
        ));

        studentService.showGroupedStudents(students);
        System.out.println();

        studentService.addStudent(students, "Hermione", "Gryffindor", 1);
        studentService.addStudent(students, "Gregory", "Slytherin", 2);

        studentService.showGroupedStudents(students);
        System.out.println();

        studentService.removeStudent(students, "Hannah", "Gryffindor", 3);
        studentService.removeStudent(students, "Michael", "Gryffindor", 3);
        studentService.removeStudent(students, "Gregory", "Slytherin", 2);

        try {
            studentService.removeStudent(students, "Gregory", "Slytherin", 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        studentService.showGroupedStudents(students);
        System.out.println();

        studentService.findStudentsByFacultyAndYear(students, "Gryffindor", 1);
        System.out.println();

        studentService.findStudentsByFacultyAndYear(students, "Slytherin", 1);
    }
}
