package school.faang.Absenteeism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static school.faang.Absenteeism.StudentService.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Egor", "IT", 2024);
        Student student2 = new Student("John", "Management", 2022);
        Student student3 = new Student("Stacy", "Art", 2020);
        Student student4 = new Student("Bob", "IT", 2024);

        addStudent(student1, students);
        addStudent(student2, students);
        addStudent(student3, students);
        addStudent(student4, students);

        System.out.println(findStudentsByFacultyAndYear("Management", 2022, students));
        System.out.println();
        removeStudentByData("John", "Management", 2022, students);
        printAllStudents(students);
    }
}