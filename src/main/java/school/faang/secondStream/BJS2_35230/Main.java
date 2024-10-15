package school.faang.secondStream.BJS2_35230;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        String filePath = "students.json";
        List<Student> students;

        try {
            students = service.loadStudentsFromJson(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Средние оценки по предметам:");
        System.out.println(service.getAverageGradesBySubject(students));
        System.out.println("\nИтоговые оценки Олега Сидорова:");
        System.out.println(service.getFinalGrade(students, "Олег Сидоров"));
        System.out.println("\nСамый сложный предмет:");
        System.out.println(service.getMostDifficultSubject(students));
        System.out.println("\nТаблица успеваемости:");
        service.printPerformanceTable(students);
    }
}
