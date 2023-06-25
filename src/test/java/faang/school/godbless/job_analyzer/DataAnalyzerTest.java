package faang.school.godbless.job_analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    DataAnalyzer dataAnalyzer;

    @BeforeEach
    void setUp() {
        String filePath = "src/main/java/faang/school/godbless/job_analyzer/vacancies.json";
        File json = new File(filePath);
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = jobStreamProcessor.processJob(json);
        dataAnalyzer = new DataAnalyzer(jobs);
    }

    @Test
    void popularSkills() {
        List<String> excepted = List.of("SQL", "JavaScript", "Java");
        List<String> actual = dataAnalyzer.popularSkills(3);
        assertEquals(excepted, actual);
    }

    @Test
    void popularPositions() {
        List<String> excepted = List.of("Software Developer", "Data Analyst", "Frontend Developer");
        List<String> actual = dataAnalyzer.popularPositions(3);
        assertEquals(excepted, actual);
    }

    @Test
    void salaryDistribution() {
        Map<String, Integer> excepted = Map.of("5000-6000", 3, "4000-5000", 5, "3000-4000", 2);
        Map<String, Integer> actual = dataAnalyzer.salaryDistribution(3000, 6000, 1000);
        assertEquals(excepted, actual);
    }

    @Test
    void popularLocations() {
        List<String> excepted = List.of("New York", "London", "San Francisco");
        List<String> actual = dataAnalyzer.popularLocations(3);
        assertEquals(excepted, actual);
    }

    @Test
    void analyzeTrends() {
        LocalDate start = LocalDate.of(2022, 1, 1);
        LocalDate end = LocalDate.of(2022, 6, 30);
        Map<String, List<String>> actual = dataAnalyzer.analyzeTrends(start, end, TrendGranularity.MONTHLY);
        assertTrue(actual.get("2022-04-01 - 2022-05-01").contains("Most popular skill: [JavaScript]"));
        assertEquals(6, actual.size());
    }
}