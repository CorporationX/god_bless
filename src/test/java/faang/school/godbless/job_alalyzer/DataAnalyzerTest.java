package faang.school.godbless.job_alalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataAnalyzerTest {
    DataAnalyzer dataAnalyzer;

    @BeforeEach
    void setUp() {
        this.dataAnalyzer = new DataAnalyzer();
    }

    @Test
    public void testAnalyzeTrends_Daily() {
        List<Job> jobList = List.of(
                new Job("Developer", List.of("Java", "Spring"), 5000, "New York", LocalDate.of(2024, 6, 1)),
                new Job("Frontend Developer", List.of("JavaScript", "React"), 6000, "San Francisco", LocalDate.of(2024, 6, 2)),
                new Job("Backend Developer", List.of("Python", "Django"), 5500, "New York", LocalDate.of(2024, 6, 2))
        );

        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 3);
        TrendGranularity granularity = TrendGranularity.DAILY;

        Map<LocalDate, JobChanges> result = dataAnalyzer.analyzeTrends(jobList, startDate, endDate, granularity);

        assertEquals(1, result.get(LocalDate.of(2024, 6, 1)).getNumberOfJobs());
        assertEquals(2, result.get(LocalDate.of(2024, 6, 2)).getNumberOfJobs());
    }

    @Test
    public void testAnalyzeTrends_Weekly() {
        List<Job> jobList = List.of(
                new Job("Developer", List.of("Java", "Spring"), 5000, "New York", LocalDate.of(2024, 6, 1)),
                new Job("Frontend Developer", List.of("JavaScript", "React"), 6000, "San Francisco", LocalDate.of(2024, 6, 5)),
                new Job("Backend Developer", List.of("Python", "Django"), 5500, "New York", LocalDate.of(2024, 6, 10))
        );

        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 15);
        TrendGranularity granularity = TrendGranularity.WEEKLY;

        Map<LocalDate, JobChanges> result = dataAnalyzer.analyzeTrends(jobList, startDate, endDate, granularity);

        assertEquals(2, result.get(LocalDate.of(2024, 6, 1)).getNumberOfJobs());
        assertEquals(1, result.get(LocalDate.of(2024, 6, 8)).getNumberOfJobs());
    }

    @Test
    public void testAnalyzeTrends_Monthly() {
        List<Job> jobList = List.of(
                new Job("Developer", List.of("Java", "Spring"), 5000, "New York", LocalDate.of(2024, 6, 1)),
                new Job("Frontend Developer", List.of("JavaScript", "React"), 6000, "San Francisco", LocalDate.of(2024, 6, 15)),
                new Job("Backend Developer", List.of("Python", "Django"), 5500, "New York", LocalDate.of(2024, 7, 1))
        );

        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 1);
        TrendGranularity granularity = TrendGranularity.MONTHLY;

        Map<LocalDate, JobChanges> result = dataAnalyzer.analyzeTrends(jobList, startDate, endDate, granularity);

        assertEquals(2, result.get(LocalDate.of(2024, 6, 1)).getNumberOfJobs());
        assertEquals(1, result.get(LocalDate.of(2024, 7, 1)).getNumberOfJobs());
    }
}