import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JobScraper scraper = new JobScraper();
        JobStreamProcessor processor = new JobStreamProcessor(scraper);
        DataAnalyzer analyzer = new DataAnalyzer();

        try {
            List<String> jsonLines = Files.readAllLines(Paths.get("vacancies.json"));
            String jsonContent = String.join("", jsonLines);

            JSONArray jsonArray = new JSONArray(jsonContent);
            List<String> jsonData = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonData.add(jsonArray.getJSONObject(i).toString());
            }

            List<Job> jobs = processor.processStream(jsonData.stream());

            System.out.println("\nРезультаты анализа:");
            System.out.println("Топ-5 навыков: " + analyzer.getTopSkills(jobs, 5));
            System.out.println("Топ-5 позиций: " + analyzer.getTopPositions(jobs, 5));
            System.out.println("Распределение по зарплатам: " + analyzer.getSalaryRanges(jobs));
            System.out.println("Топ-5 локаций: " + analyzer.getTopLocations(jobs, 5));

            LocalDate startDate = LocalDate.of(2023, 1, 1);
            LocalDate endDate = LocalDate.of(2023, 12, 31);
            System.out.println("Тренды за 2023 год: " + analyzer.analyzeTrends(jobs, startDate, endDate, "monthly"));

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}