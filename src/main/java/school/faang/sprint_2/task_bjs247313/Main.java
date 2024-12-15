package school.faang.sprint_2.task_bjs247313;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String STUDENTS_PATH = "src/main/resources/sprint_2/task_bjs247313/students_test_data.json";

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> students = loadStudents();

        System.out.println(studentService.getAvgGradeInSchoolBySubject(students));
        System.out.println(studentService.getAvgGradeBySubjectByStudent(students, "Олег", "Сидоров"));
        System.out.println(studentService.getHardestSubject(students));
    }

    private static List<Student> loadStudents() {
        try {
            return StudentLoader.studentLoader(STUDENTS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
