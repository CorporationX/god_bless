package faang.school.godbless.jobanalyzer;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String jsonJob1 = """
                {
                  "name": "fullstack",
                  "salary": 130000,
                  "location": "Moscow",
                  "jobAdditions": "2024-02-03",
                  "requirementsForCandidates": [
                    "Java",
                    "Spring",
                    "Docker",
                    "Redis"
                  ]
                }""";

        String jsonJob2 = """
                {
                  "name": "Backend",
                  "salary": 180000,
                  "location": "SBP",
                  "jobAdditions": "2024-03-03",
                  "requirementsForCandidates": [
                    "Java",
                    "Spring",
                    "Docker"
                  ]
                }""";

        String jsonJob3 = """
                {
                  "name": "frontend",
                  "salary": 90000,
                  "location": "Moscow",
                  "jobAdditions": "2024-02-03",
                  "requirementsForCandidates": [
                    "Java",
                    "Spring",
                    "Paint"
                  ]
                }""";

        List<Job> jobs = JobStreamProcessor.convertToListOfJobs(Stream.of(jsonJob1, jsonJob2, jsonJob3));

        DataAnalyzer.getMostPopularSkills(jobs);
        System.out.println();

        DataAnalyzer.getMostPopularVacancy(jobs);
        System.out.println();

        DataAnalyzer.getMostPopularLocations(jobs);
        System.out.println();

        System.out.println(DataAnalyzer.distributeSalariesAcrossDifferentRanges(jobs));

    }
}
