package school.faang.task225;

import school.faang.task225.student.Student;
import school.faang.task225.student.StudentLoader;
import school.faang.task225.student.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> studentList = StudentLoader.loadStudents("C:\\Users\\Святослав\\Desktop\\students_test_data.json");
        StudentService.getAllSubjectAvgGrade(studentList).forEach((s, d) -> {
            String str = String.format("%s %f", s, d);
            System.out.println(str);
        });
        System.out.println();

        System.out.println(StudentService.getHardest(studentList));
        System.out.println();

        StudentService.getFinalGrade("Олег", "Сидоров", studentList).forEach((s, d) -> {
            String str = String.format("%s %d", s, d);
            System.out.println(str);
        });
        System.out.println();

        StudentService.printAllInfoAboutStudent(studentList);
    }
}
