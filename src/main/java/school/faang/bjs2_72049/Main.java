package school.faang.bjs2_72049;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            URL resource = Main.class.getClassLoader().getResource("students_test_data.json");
            if (resource == null) {
                log.error("Файл students_test_data.json не найден в test/resources");
                return;
            }

            String filePath = new File(resource.toURI()).getAbsolutePath();
            StudentDataLoader loader = new JsonStudentDataLoader(filePath);
            List<Student> students = loader.loadStudents();

            log.info("Средняя успеваемость по предметам:");
            StudentService.calculateSchoolAverage(students).forEach((k, v) ->
                    log.info("{}: {:.2f}", k, v));

            log.info("\nИтоговые оценки Иван Иванов:");
            StudentService.getStudentFinalGrades(students, "Иван", "Иванов").forEach((k, v) ->
                    log.info("{}: {}", k, v));

            String hardest = StudentService.findHardestSubject(students);
            log.info("\nСамый сложный предмет: {}", hardest);

            System.out.println("\nТаблица успеваемости:");
            PerformanceTablePrinter.print(students);

        } catch (Exception e) {
            log.error("Ошибка при выполнении main", e);
        }
    }
}

