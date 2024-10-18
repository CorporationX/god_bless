package school.faang.analyzerjob;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        String filePath = "src/main/resources/vacancies.json";
        JobScraper jobScraper = new JobScraper();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(jobScraper);
        String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        List<Job> jobs = jobStreamProcessor.processJobs(Stream.of(jsonData));

        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        System.out.println("\nTop 5 Skills: " + dataAnalyzer.top5Skills(jobs));
        System.out.println("Top 5 Positions: " + dataAnalyzer.top5PopularPositions(jobs));
        System.out.println("Salary Distribution: " + dataAnalyzer.salaryDistribution(jobs));
        System.out.println("Top 5 Locations: " + dataAnalyzer.top5PopularLocations(jobs));

    }
}

