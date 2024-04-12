package faang.school.godbless.streamAPI.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        JobsScraper jobsScraper = new JobsScraper();

        var softwareEngineer = """
                {
                  "positionName": "Software Engineer",
                  "requirements": ["Bachelor's degree in Computer Science", "Proficiency in Java and Python", "Experience with web development frameworks"],
                  "salary": 80000,
                  "location": "San Francisco, CA",
                  "creationDate": "2024-04-12T09:30:00"
                }
                """;

        var javaSoftwareEngineer = """
                {
                  "positionName": "Software Engineer",
                  "requirements": ["Bachelor's degree in Computer Science", "Proficiency in Java", "Experience with web development frameworks"],
                  "salary": 120000,
                  "location": "San Francisco, CA",
                  "creationDate": "2024-04-12T09:30:00"
                }
                """;

        var dataScientist = """
                {
                  "positionName": "Data Scientist",
                  "requirements": ["Master's degree in Statistics or related field", "Proficiency in Python and R programming", "Experience with machine learning algorithms"],
                  "salary": 130000,
                  "location": "New York, NY",
                  "creationDate": "2024-04-12T10:15:00"
                }
                """;

        var graphicDesigner = """
                {
                  "positionName": "Graphic Designer",
                  "requirements": ["Bachelor's degree", "Proficiency in Adobe Creative Suite", "Strong portfolio demonstrating creative skills"],
                  "salary": 60000,
                  "location": "Los Angeles, CA",
                  "creationDate": "2024-04-12T11:00:00"
                }
                """;

        var marketingManager = """
                {
                  "positionName": "Marketing Manager",
                  "requirements": ["Bachelor's degree", "Experience in digital marketing strategies", "Strong leadership and communication skills"],
                  "salary": 85000,
                  "location": "Chicago, IL",
                  "creationDate": "2024-04-12T11:45:00"
                }
                """;

        var job = jobsScraper.parseString(softwareEngineer);

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
