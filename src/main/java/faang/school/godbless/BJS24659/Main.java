package faang.school.godbless.BJS24659;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student.addStudent(students, "Иванов", "ИТ", 1);
        Student.addStudent(students, "Петров", "ИТ", 2);
        Student.addStudent(students, "Сидоров", "Математика", 1);
        Student.addStudent(students, "Смирнов", "Математика", 2);
        Student.addStudent(students, "Козлов", "Физика", 1);

        System.out.println("Информация о студентах:");
        students.forEach(System.out::println);

        Map<String, List<Student>> groupedStudents = Student.groupByFacultyAndYear(students);

        System.out.println("\nГруппировка студентов по факультету и курсу:");
        Student.printStudentsByFacultyAndYear(groupedStudents);

        Student.removeStudent(students, "Иванов", "ИТ", 1);

        System.out.println("Информация о студентах после удаления:");
        students.forEach(System.out::println);

        String faculty = "Математика";
        int year = 1;
        System.out.println("\nСтуденты факультета " + faculty + " " + year + " курса:");
        List<Student> foundStudents = Student.findStudentsByFacultyAndYear(students, faculty, year);
        foundStudents.forEach(System.out::println);
    }
}
