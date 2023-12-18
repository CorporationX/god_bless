package faang.school.godbless.stream_api.task3vacancies;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String json1 = "{\"position\":\"Software Developer\",\"requirements\":[\"Java\",\"Spring\"],\"salary\":80000,\"location\":\"City A\",\"dateAdded\":\"2023-01-01\"}";
        String json2 = "{\"position\":\"Data Scientist\",\"requirements\":[\"Python\",\"Machine Learning\"],\"salary\":90000,\"location\":\"City B\",\"dateAdded\":\"2023-01-02\"}";
        String json3 = "{\"position\":\"Frontend Developer\",\"requirements\":[\"JavaScript\",\"React\"],\"salary\":75000,\"location\":\"City C\",\"dateAdded\":\"2023-01-03\"}";
        String json4 = "{\"position\":\"Frontend Developer\",\"requirements\":[\"JavaScript\",\"React\"],\"salary\":75000,\"location\":\"City C\",\"dateAdded\":\"2023-01-03\"}";
        Stream<String> jobStream = Stream.of(json1, json2, json3, json4);

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();

        List<Job> processedJobs = jobStreamProcessor.processJobStream(jobStream);
        System.out.println();

        DataAnalyzer dataAnalyzer = new DataAnalyzer(processedJobs);

        System.out.println("Top Skills: " + dataAnalyzer.getTopSkills(3));
        System.out.println("Top Positions: " + dataAnalyzer.getTopPositions(2));
        System.out.println("Salary Distribution: " + dataAnalyzer.getSalaryDistribution());
        System.out.println("Top Locations: " + dataAnalyzer.getTopLocations(2));
    }
}
