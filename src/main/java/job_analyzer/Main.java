package job_analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String filePath = "vacancies.json";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
             Stream<String> jsonStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()) {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
            List<Job> jobs = jobStreamProcessor.processJobs(jsonStream);

            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            System.out.println("\nТоп-5 навыков:");
            dataAnalyzer.printTop5Skills(jobs);

            System.out.println("\nТоп-5 позиций:");
            dataAnalyzer.printTop5Positions(jobs);

            System.out.println("\nРаспределение зарплат:");
            dataAnalyzer.printSalaryDistribution(jobs);

            System.out.println("\nТоп-5 местоположений:");
            dataAnalyzer.printTop5Locations(jobs);

            TrendsAnalyzer trendsAnalyzer = new TrendsAnalyzer();
            trendsAnalyzer.analyzeTrends(jobs, "2023-01-01", "2023-12-31", Trends.MONTHLY);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
