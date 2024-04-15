package faang.school.godbless.vacancy_analyzer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private static final DataAnalyzer DATA_ANALYZER = new DataAnalyzer();
    private static final List<Job> JOBS = Main.getJobs();

    @Test
    void findTopKRequirements() {
        List<String> result = DATA_ANALYZER.findTopKRequirements(JOBS, 2);
        List<String> expectedResult = List.of("SQL", "Spring");
        assertEquals(result, expectedResult);
    }

    @Test
    void findTopKPopularPositions() {
        List<String> result = DATA_ANALYZER.findTopKPopularPositions(JOBS, 1);
        List<String> expectedResult = List.of("Developer");
        assertEquals(result, expectedResult);
    }

    @Test
    void countJobsBySalaryRange() {
        Map<String, Long> result = DATA_ANALYZER.countJobsBySalaryRange(JOBS, 50000);
        Map<String, Long> expectedResult = Map.of(
                "150000-200000", 1L,
                "50000-100000", 3L,
                "100000-150000", 1L,
                "0-50000", 1L
        );
        assertEquals(result, expectedResult);
    }

    @Test
    void findTopKLocations() {
        List<String> result = DATA_ANALYZER.findTopKLocations(JOBS, 2);
        List<String> expectedResult = List.of("Moscow", "London");
        assertEquals(result, expectedResult);
    }

    @Test
    void analyzeTrends() {
        Map<Integer, List<Job>> result = DATA_ANALYZER.analyzeTrends(JOBS, LocalDate.now().minusMonths(1), LocalDate.now(), TrendGranularity.DAY);
        Map<Integer, List<Job>> expectedResult = Map.of(
                94, List.of(new Job("Developer", List.of("Java", "Spring"), 90000, "Moscow", LocalDate.of(2024, 4, 3)))
        );
        assertEquals(result, expectedResult);
    }
}