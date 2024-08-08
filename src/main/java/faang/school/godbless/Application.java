package faang.school.godbless;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Deanery deanery = new Deanery(Arrays.asList(
                new Student("Alice", "Computer Science", 1),
                new Student("Bob", "Computer Science", 2),
                new Student("Charlie", "Mathematics", 3),
                new Student("Mike", "Mathematics", 3)
        ));

        Map<FacultyYearInfo, List<Student>> groupedStudents = deanery.groupStudentsByFacultyAndYear();

        System.out.println("All Students Grouped by Faculty and Year:");
        printGroupedByFacultyAndYearStudents(groupedStudents);

        deanery.addStudent(new Student("Frank", "Computer Science", 2));
        deanery.removeStudent("Alice", "Computer Science", 1);

        FacultyYearInfo facultyYearInfo = new FacultyYearInfo("Computer Science", 2);
        List<Student> byFacultyAndYearStudents = deanery.getStudentsByFacultyAndYear(facultyYearInfo);

        System.out.println("\nStudents in Computer Science Year 2:");
        printStudents(byFacultyAndYearStudents);
    }

    public static void printGroupedByFacultyAndYearStudents(Map<FacultyYearInfo, List<Student>> groupedStudents) {
        for (FacultyYearInfo key : groupedStudents.keySet()) {
            System.out.println(key.toString());
            printStudents(groupedStudents.get(key));
        }
    }

    public static void printStudents(List<Student> students) {
        students.forEach(student -> System.out.println("    " + student.toString()));
    }
}