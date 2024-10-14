package school.faangSprint2.t18;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        String filePath = "students.json";
        List<Student> students;
        try {
            students = system.loadStudentsFromJson(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Средние оценки по предметам:");
        System.out.println(system.getAverageGradesBySubject(students));

        System.out.println("\nИтоговые оценки Олега Сидорова:");
        System.out.println(system.getFinalGrades(students, "Олег", "Сидоров"));

        System.out.println("\nСамый сложный предмет:");
        System.out.println(system.getMostDifficultSubject(students));

        System.out.println("\nТаблица успеваемости:");
        system.printPerformanceTable(students);
    }
}