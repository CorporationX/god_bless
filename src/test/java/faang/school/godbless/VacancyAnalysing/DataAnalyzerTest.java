package faang.school.godbless.VacancyAnalysing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(new JobScraper());
    File file = new File("src/main/java/faang/school/godbless/VacancyAnalysing/vacancies.json");
    List<Job> jobs;
    DataAnalyzer dataAnalyzer = new DataAnalyzer();

    @BeforeEach
    void setUp() {
        jobs = jobStreamProcessor.parse(file);
    }


    @Test
    void testGetThreePopularSkills() {
        List<String> excepted = List.of("SQL", "JavaScript", "Java");
        List<String> actual = dataAnalyzer.getThreePopularSkills(jobs);
        assertEquals(excepted, actual);
    }

    @Test
    void testGetThreePopularJobs() {
        List<String> excepted = List.of("Software Developer", "Data Analyst", "Frontend Developer");
        List<String> actual = dataAnalyzer.getThreePopularJobs(jobs);
        assertEquals(excepted, actual);
    }

    @Test
    void testGetSalaryRange() {
        Long i = 1L;
        Map<String, Long> excepted = Map.of("From 500000.0 To 550000.0", 1L
                , "From 350000.0 To 400000.0", 1L, "From 0.0 To 50000.0", 4L
                , "From 400000.0 To 450000.0", 2L, "From 50000.0 To 100000.0", 2L);
        Map<String, Long> actual = dataAnalyzer.getSalaryRange(jobs);
        System.out.println(actual);
        assertEquals(excepted, actual);
    }

    @Test
    void testGetThreePopularLocations() {
        List<String> excepted = List.of("New York", "London", "San Francisco");
        List<String> actual = dataAnalyzer.getThreePopularLocations(jobs);
        assertEquals(excepted, actual);
    }
}