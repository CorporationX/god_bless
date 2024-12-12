package school.faang.task_47094;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String basePath = System.getProperty("user.dir");
        String jsonInputFolderPath =
                basePath + "\\src\\main\\java\\school\\faang\\task_47094\\json\\";

        File file = new File(jsonInputFolderPath + "vacancies.json");

        if (file.exists() && file.isFile()) {

            List<Job> jobs = MAPPER.readValue(file, new TypeReference<>() {
            });

            System.out.println("=== Тестируем printTop5Skills ===");
            DataAnalyzer.printTop5Skills(jobs);

            System.out.println("\n=== Тестируем printTop5PopularPositions ===");
            DataAnalyzer.printTop5PopularPositions(jobs);

            System.out.println("\n=== Тестируем groupingBySalary ===");
            Map<String, List<Job>> groupedJobs = DataAnalyzer.groupingBySalary(jobs);
            groupedJobs.forEach((range, jobList) -> {
                System.out.println("Диапазон зарплат: " + range + ", Количество вакансий: " + jobList.size());
            });

        } else {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
        }
    }

}
