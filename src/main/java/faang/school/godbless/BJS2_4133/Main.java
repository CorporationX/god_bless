package faang.school.godbless.BJS2_4133;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>(Set.of(
                new Student("Andrei", "IT", 2024),
                new Student("Victor", "IT", 2024),
                new Student("Vlad", "NotIT", 2022),
                new Student("Jack", "NotIT", 2022),
                new Student("Nick", "NotIT", 2020))
        );

        HashMap<String, HashSet<Student>> groupedStudents = Student.groupStudentsByDirection(students);
        System.out.println(groupedStudents);

        Student.addStudentToDirection(new Student("Vlad", "IT", 2024), groupedStudents);
        System.out.println(groupedStudents);

        Student.removeStudentFromDirection("Vlad", "IT", 2024, groupedStudents);
        System.out.println(groupedStudents);

        System.out.println(Student.getStudentsByDirection("IT", 2024, groupedStudents));
    }
}