package faang.school.godbless.jobanalyzer;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private DataAnalyzer dataAnalyzer = new DataAnalyzer();

    @Test
    void getMostFoundSkills() {
        List<Job> jobs = List.of(
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "HashMap", "StreamAPI", "Collections")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "HashMap")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL"))
        );

        List<String> result = dataAnalyzer.getMostFoundSkills(jobs, 3);
        List<String> expected = List.of("Java", "Spring", "HashMap");

        assertEquals(expected, result);
    }

    @Test
    void getMostPopularVacancyName() {
        List<Job> jobs = List.of(
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "HashMap", "StreamAPI", "Collections")),
                new Job("Python Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("ML", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("ML", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("ML", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("Backend Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "HashMap")),
                new Job("Backend Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "HashMap")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL")),
                new Job("Java Developer", 130000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL"))
        );

        List<String> expected = List.of("Java Developer", "ML", "Backend Developer");
        List<String> result = dataAnalyzer.getMostPopularVacancyName(jobs, 3);
        assertEquals(expected, result);
    }

    @Test
    void getSortedVacancyBySalaryRange() {
        List<Job> jobs = List.of(
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "HashMap", "StreamAPI", "Collections")),
                new Job("Java Developer", 140000, "Moscow", LocalDateTime.now(), List.of("Java", "Kafka", "Redis", "Spring")),
                new Job("Java Developer", 90000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "HashMap")),
                new Job("Java Developer", 90000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL")),
                new Job("Java Developer", 45000, "Moscow", LocalDateTime.now(), List.of("Java", "Spring", "SQL"))
        );

        Map<String, Long> expected = Map.of(
                "100-150k", 2l,
                "50-100k", 2l,
                "0-50k", 1l
        );

        Map<String, Long> result = dataAnalyzer.getSortedVacancyBySalaryRange(jobs);
        assertEquals(expected, result);
    }
}