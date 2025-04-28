package school.faang.electronic_devil;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static school.faang.electronic_devil.Student.loadStudents;

@Slf4j
public class Main {
    public static void main(String[] args) {

        try {
            String jsonFilePath =
                    "/Users/nick/god_bless/src/main/java/school/faang/electronic_devil/students_test_data.json";
            log.info("Trying to load: {}", new File(jsonFilePath).getAbsolutePath());

            List<Student> students = loadStudents(jsonFilePath);
            log.info("Successfully loaded students: {}", students.size());

            students.forEach(student -> {
                log.info("\nStudent: {} {}", student.getFirstName(), student.getLastName());
                student.getSubjects().forEach((subject, grades) -> {
                    double avg = grades.stream().mapToInt(Integer::intValue).average().orElse(0);
                    System.out.printf("  %s: %s (Средний балл: %.1f)%n", subject, grades, avg);
                });
            });

        } catch (Exception e) {
            log.info("ERROR: {}", e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        List<Student> students1 = Arrays.asList(
                new Student("Иван", "Иванов", Map.of(
                        "Математика", Arrays.asList(5, 4, 5),
                        "Физика", Arrays.asList(4, 3, 5))
                ),
                new Student("Петр", "Петров", Map.of(
                        "Математика", Arrays.asList(3, 4, 3),
                        "Физика", Arrays.asList(5, 5, 5))
                )
        );

        SchoolService service = new SchoolService();

        log.info("Средние оценки по школе:");
        service.averageGradeSchoolEachSubject(students1).forEach((subject, avg) ->
                System.out.printf("%s: %.2f%n", subject, avg));

        log.info("\nОценки Ивана Иванова:");
        service.getFinalGradesForStudent(students1, "Иван", "Иванов")
                .forEach((subject, grade) ->
                        System.out.printf("%s: %d%n", subject, grade));

        log.info("\nСамый сложный предмет: {}", service.findMostDifficultSubject(students1));

        log.info("\nТаблица успеваемости:");
        service.printPerformanceTable(students1);
    }
}
