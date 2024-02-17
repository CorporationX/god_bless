package faang.school.godbless.vacancyanalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataAnalyzerTest {

    List<Job> jobs;
    DataAnalyzer dataAnalyzer;

    @BeforeEach
    void setUp() {
        List<String> jsonJobs = Arrays.asList(
                "{\"name\":\"Full Stack Developer\",\"requirements\":[\"Python\",\"JavaScript\",\"SQL\"],\"salary\":90000,\"location\":\"London\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Frontend Developer\",\"requirements\":[\"JavaScript\",\"Python\",\"MongoDB\"],\"salary\":120000,\"location\":\"Paris\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Software Engineer\",\"requirements\":[\"CSS\",\"JavaScript\"],\"salary\":75000,\"location\":\"Berlin\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Software Engineer\",\"requirements\":[\"C++\",\"CSS\",\"React\"],\"salary\":200000,\"location\":\"New York\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Frontend Developer\",\"requirements\":[\"Pascal\",\"JavaScript\",\"CSS\"],\"salary\":160000,\"location\":\"Tokyo\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Frontend Developer\",\"requirements\":[\"React\",\"JavaScript\",\"HTML\",\"CSS\"],\"salary\":70000,\"location\":\"San date\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Backend Developer\",\"requirements\":[\"Java\",\"Spring\",\"SQL\"],\"salary\":110000,\"location\":\"Berlin\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Machine Learning Engineer\",\"requirements\":[\"Python\",\"TensorFlow\",\"SQL\"],\"salary\":95000,\"location\":\"London\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"UI Designer\",\"requirements\":[\"Sketch\",\"InVision\",\"HTML\",\"CSS\"],\"salary\":85000,\"location\":\"Paris\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Data Scientist\",\"requirements\":[\"Python\",\"R\",\"Machine Learning\"],\"salary\":130000,\"location\":\"New York\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Full Stack Developer\",\"requirements\":[\"JavaScript\",\"Node.js\",\"MongoDB\"],\"salary\":120000,\"location\":\"Tokyo\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Mobile App Developer\",\"requirements\":[\"Java\",\"Swift\",\"iOS\",\"Android\"],\"salary\":110000,\"location\":\"San Francisco\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"DevOps Engineer\",\"requirements\":[\"Linux\",\"Docker\",\"Kubernetes\",\"Python\"],\"salary\":140000,\"location\":\"Seattle\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Cybersecurity Analyst\",\"requirements\":[\"Security\",\"Network\",\"Penetration Testing\"],\"salary\":115000,\"location\":\"Washington, D.C.\",\"date\":\"01-03-2024\"}",
                "{\"name\":\"Cloud Solutions Architect\",\"requirements\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Java\"],\"salary\":160000,\"location\":\"Dallas\",\"date\":\"01-03-2024\"}"
        );
        JsonScraper jsonScraper = new JsonScraper();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(jsonScraper);
        jobs = jobStreamProcessor.process(jsonJobs.stream());
        dataAnalyzer = new DataAnalyzer();
    }

    @Test
    void getMostPopularSkillsTest() {
        List<String> expected = List.of("JavaScript", "Python", "CSS", "Java", "SQL");

        List<String> actual = dataAnalyzer.getMostPopularSkills(jobs);

        assertEquals(expected, actual);
    }

    @Test
    void getMostPopularJobsTest() {
        List<String> expected = List.of("Frontend Developer", "Full Stack Developer", "Software Engineer", "DevOps Engineer", "Cloud Solutions Architect");

        List<String> actual = dataAnalyzer.getMostPopularJobs(jobs);

        assertEquals(expected, actual);
    }

    @Test
    void getCountJobsInSalaryRangeTest() {
        Map<String, Long> expected = Map.of("50K-100K", 5L, "100K-150K", 7L, "150K-200K", 3L);

        Map<String, Long> actual = dataAnalyzer.getCountJobsInSalaryRange(jobs, 50000, 500000);

        assertEquals(expected, actual);
    }

    @Test
    void getMostPopularLocationsTest() {
        List<String> expected = List.of("New York", "Tokyo", "Berlin", "London", "Paris");

        List<String> actual = dataAnalyzer.getMostPopularLocations(jobs);

        assertEquals(expected, actual);
    }
}
