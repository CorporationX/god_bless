package vacancy.analizator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path jobsPath = Path.of("src/main/java/vacancy/analizator/resources/jobsJson.txt");
        var jobs = JobStreamProcessor.getJobsFromJson(Files.lines(jobsPath));
        System.out.println();
        jobs.forEach(System.out::println);
        System.out.println();
        System.out.println(DataAnalyzer.getMostValuableSkills(jobs, 3));
        System.out.println();
        System.out.println(DataAnalyzer.getMostPopularVacancies(jobs, 2));
        System.out.println();
        System.out.println(DataAnalyzer.getMostPopularWorkPlaces(jobs, 3));
        System.out.println();
        DataAnalyzer.getSalariesRanges(jobs, 50000).forEach((k, v) -> {
            System.out.println(k + ": ");
            v.forEach(j -> System.out.printf("    %s%n", j));
        });
    }
}
