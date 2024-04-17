package faang.school.godbless.streamAPI.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        JobsScraper jobsScraper = new JobsScraper();

        var softwareEngineer = "/jsons/softwareEngineer.json";

        var javaSoftwareEngineer = "/jsons/javaSoftwareEngineer.json";

        var dataScientist = "/jsons/dataScientist.json";

        var graphicDesigner = "/jsons/graphicDesigner.json";

        var marketingManager = "/jsons/marketingManager.json";

        var job = jobsScraper.parseFile(softwareEngineer);

        job.ifPresent(System.out::println);

        job.ifPresent(j -> {
            var serializedJob = jobsScraper.serialize(j);

            serializedJob.ifPresent(System.out::println);
        });


        JobsStreamProcessor jobsStreamProcessor = new JobsStreamProcessor();


        var jobsStream = Stream.of(softwareEngineer, graphicDesigner, dataScientist, marketingManager, javaSoftwareEngineer);

        System.out.println("\n\nProcessing jobs stream:");
        var jobsOptional = jobsStreamProcessor.processJobsStream(jobsStream);

        if (jobsOptional.isEmpty()) {
            log.warn("Jobs stream processing failed. No jobs was returned. Terminating operation.");
            return;
        }

        DataAnalyzer dataAnalyzer = new DataAnalyzer(jobsOptional.get());

        var mostPopularSkills = dataAnalyzer.getMostPopularSkills();
        System.out.println("\nMost popular skills through all jobs:\n" + mostPopularSkills);

        var mostPopularPositions = dataAnalyzer.getMostPopularPositions();
        System.out.println("\nMost popular positions through all jobs:\n" + mostPopularPositions);

        var jobsBySalaryRange = dataAnalyzer.getJobsBySalaryRange();
        System.out.println("\nJobs by salary range:\n");
        jobsBySalaryRange.forEach((key, value) -> System.out.println("For " + key + " range are available " + value.size() + " positions."));

        var mostPopularLocations = dataAnalyzer.getMostPopularPositionLocation();
        System.out.println("\nMost popular locations through all jobs:\n" + mostPopularLocations);
    }
}
