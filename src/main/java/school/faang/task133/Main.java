package school.faang.task133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService.printAllGroupedStudents();
        System.out.println();

        Student student = new Student("Вася", "Пуффендуй", 4);
        StudentService.addStudent(student);
        StudentService.printAllGroupedStudents();
        System.out.println();

        StudentService.removeStudent("Ilya", "Гриффиндор", 4);
        StudentService.printAllGroupedStudents();
        System.out.println();

        List<Student> studentList = StudentService.findStudentsByFacultyAndYear("Пуффендуй", 4);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }
}
