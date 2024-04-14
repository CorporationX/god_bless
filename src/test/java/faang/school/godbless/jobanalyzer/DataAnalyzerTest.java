package faang.school.godbless.jobanalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private DataAnalyzer dataAnalyzer;
    private List<Job> jobs;

    @BeforeEach
    void setUp() {
        dataAnalyzer = new DataAnalyzer();

        jobs = List.of(
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 120000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 110000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 140000, "Kazan", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Java Developer", 140000, "Kazan", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Backend Developer", 90000, "Kazan", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Backend Developer", 80000, "Kazan", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Backend Developer", 85000, "London", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Backend Developer", 70000, "London", LocalDateTime.now(), List.of("Java", "Spring", "Kafka", "Redis")),
                new Job("Python Developer", 45000, "London", LocalDateTime.now(), List.of("Java", "Spring", "Kafka")),
                new Job("Python Developer", 35000, "Amsterdam", LocalDateTime.now(), List.of("Java", "Spring", "Kafka")),
                new Job("ML", 10000, "Amsterdam", LocalDateTime.now(), List.of("Java", "Spring")),
                new Job("PHP Developer", 15000, "Viborg", LocalDateTime.now(), List.of("Java")),
                new Job("Any Developer", 15000, "Viborg", LocalDateTime.now(), List.of("Java")),
                new Job("1C", 15000, "Krim", LocalDateTime.now(), List.of("1C"))
        );

    }

    @Test
    void getMostFoundSkills() {
        List<String> result = dataAnalyzer.getMostFoundSkills(jobs, 3);
        List<String> expected = List.of("Java", "Spring", "Kafka");

        assertEquals(expected, result);
    }

    @Test
    void getMostPopularVacancyName() {
        List<String> expected = List.of("Java Developer", "Backend Developer", "Python Developer");
        List<String> result = dataAnalyzer.getMostPopularVacancyName(jobs, 3);

        assertEquals(expected, result);
    }

    @Test
    void getSortedVacancyBySalaryRange() {
        Map<String, Long> result = dataAnalyzer.getSortedVacancyBySalaryRange(jobs);

        Map<String, Long> expected = new HashMap<>();
        expected.put("0-50k", 6L);
        expected.put("50-100k", 4L);
        expected.put("100-150k", 7L);

        assertEquals(expected, result);
    }

    @Test
    void getMostPopularJobLocation() {
        List<String> result = dataAnalyzer.getMostPopularJobLocation(jobs, 5);
        List<String> expected = List.of("Moscow", "Kazan", "London", "Viborg", "Amsterdam");

        assertEquals(expected, result);
    }

    @Test
    void testMapToInt_negativeLimit() {
        assertThrows(IllegalArgumentException.class, () -> dataAnalyzer.getMostFoundSkills(jobs, -1));
    }

    @Test
    void getMostFoundSkill_EmptyList() {
        List<String> result = dataAnalyzer.getMostFoundSkills(new ArrayList<>(), 5);
        List<String> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    void getMostPopularVacancyName_EmptyList() {
        List<String> result = dataAnalyzer.getMostFoundSkills(new ArrayList<>(), 5);
        List<String> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    void getSortedVacancyBySalaryRange_EmptyList() {
        Map<String, Long> result = dataAnalyzer.getSortedVacancyBySalaryRange(new ArrayList<>());
        Map<String, Long> expected = new HashMap<>();
        expected.put("0-50k", 0L);
        expected.put("50-100k", 0L);
        expected.put("100-150k", 0L);

        assertEquals(expected, result);
    }

    @Test
    void getMostPopularJobLocation_EmptyList() {
        assertEquals(new ArrayList<>(), dataAnalyzer.getMostPopularJobLocation(new ArrayList<>(), 5));
    }
}