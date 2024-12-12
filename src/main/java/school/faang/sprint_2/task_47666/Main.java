package school.faang.sprint_2.task_47666;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String STUDENTS_FILEPATH = "src/main/resources/sprint_2/task_47666/students_test_data.json";

    public static void main(String[] args) throws IOException {
        List<Student> students = StudentLoader.loadStudent(STUDENTS_FILEPATH);
        StudentService studentService = new StudentService();

        System.out.printf("Самый сложный предмет это %s\n", studentService.getMostDifficultSubject(students));
        System.out.println("Печать школьного журнала...");
        studentService.printPerformanceTable(students);
    }
}
