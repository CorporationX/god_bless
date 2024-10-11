package school.faang.jobanalysis;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        String filePath = "src/main/java/school/faang/jobanalysis/vacancies" +
                ".json";

        JobScraper jobScraper = new JobScraper();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(jobScraper);

        String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

        List<Job> jobs = jobStreamProcessor.processJobs(Stream.of(jsonData));

        DataAnalyzer dataAnalyzer = new DataAnalyzer(jobs);

        System.out.println("\nтоп-5 наиболее востребованных навыков:");
        dataAnalyzer.printTop5Skills();

        System.out.println("\nтоп-5 популярных названий позиций:");
        dataAnalyzer.printTop5Positions();

        System.out.println("\nРаспределение зарплат:");
        dataAnalyzer.printSalaryDistribution();

        System.out.println("\nтоп-5 популярных местоположений:");
        dataAnalyzer.printTop5Locations();
    }
}
