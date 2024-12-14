package faang.school.godbless.bjs219665;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        StudentManager.addStudent(students,"Alice", "Engineering", 2024);
        StudentManager.addStudent(students,"Bob", "Mathematics", 2024);
        StudentManager.addStudent(students,"Charlie", "Physics", 2023);
        StudentManager.addStudent(students,"David", "Literature", 2025);
        StudentManager.addStudent(students,"Eve", "Mathematics", 2024);
        StudentManager.addStudent(students,"John", "Mathematics", 2024);


        System.out.println(students);
        StudentManager.deleteStudent(students,"Charlie", "Physics", 2023);
        System.out.println(students);
        StudentManager.groupedStudents(students);
        System.out.println(StudentManager.groupedStudents(students));
    }
}
