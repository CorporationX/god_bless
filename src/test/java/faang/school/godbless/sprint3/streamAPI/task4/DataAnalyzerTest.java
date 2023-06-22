package faang.school.godbless.sprint3.streamAPI.task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    private DataAnalyzer dataAnalyzer;

    @BeforeEach
    void setUp() {
        dataAnalyzer = new DataAnalyzer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMostPopularSkills() {
    }

    @ParameterizedTest
    @MethodSource("providerJobs")
    void testGetMostPopularSkills(List<Job> jobs){
        List<String> expected = List.of("Spring", "Hibernate", "Java 8", "Git", "Docker");

        List<String> actual = dataAnalyzer.getMostPopularSkills(jobs, 5);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerJobs")
    void testGetMostPopularPositions(List<Job> jobs){
        List<String> expected = List.of("Senior java developer", "Middle java developer", "Junior java developer");

        List<String> actual = dataAnalyzer.getMostPopularPositions(jobs, 3);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerJobs")
    void testGetSalaryByVacancies(List<Job> jobs){
        Map<String, Long> expected = Map.of(
            "От 150000 до 200000", 6L,
            "От 250000 до 300000", 2L,
            "От 0 до 50000", 5L,
            "От 200000 до 250000", 2L,
            "От 100000 до 150000", 4L,
            "От 50000 до 100000", 4L
        );

        Map<String, Long> actual = dataAnalyzer.getSalaryByVacancies(jobs);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerJobs")
    void testGetMostPopularLocations(List<Job> jobs){
        List<String> expected = List.of("Москва", "Нижний Новгород", "Санкт-Петербург");

        List<String> actual = dataAnalyzer.getMostPopularLocations(jobs, 5);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerJobs")
    void testGetDate(List<Job> jobs){
        Map<String, List<String>> map = Map.of(
                "Популярные локации", List.of("Москва", "Казань", "Санкт-Петербург"),
                "Популярные вакансии", List.of("Senior java developer"),
                "Популярные скиллы", List.of("Spring", "Hibernate", "Docker")
        );
        Map<String, Map<String, List<String>>> expected = Map.of(
                "Отчет за 2023-06-01 - 2023-07-01", map
        );

        Map<String, Map<String, List<String>>> actual = dataAnalyzer.analyzeTrends(jobs,
                LocalDate.of(2023, 6, 1), LocalDate.of(2023, 7, 1), TrendGranularity.MONTHLY);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> providerJobs() {
        List<Job> jobs = List.of(
                new Job("Senior java developer", List.of("Java 11", "Spring", "Microservices", "Hibernate", "Kafka", "Docker", "Git", "CI/CD"), 300_000, "Москва", LocalDate.of(2023, 6, 14)),
                new Job("Senior java developer", List.of("Java 11", "Spring", "Microservices", "Hibernate", "Kafka", "Docker", "Git", "CI/CD"), 300_000, "Москва", LocalDate.of(2023, 6, 12)),
                new Job("Senior java developer", List.of("Java 17", "Spring", "Microservices", "Hibernate", "Kafka", "Docker"), 250_000, "Казань", LocalDate.of(2023, 6, 10)),
                new Job("Senior java developer", List.of("Java 17", "Spring", "Microservices", "Kafka", "Docker", "Git", "CI/CD"), 200_000, "Москва", LocalDate.of(2023, 6, 8)),
                new Job("Senior java developer", List.of("Java 8", "Spring", "Microservices", "Hibernate", "Kafka", "Docker"), 200_000, "Москва", LocalDate.of(2023, 6, 6)),
                new Job("Senior java developer", List.of("Java 8", "Spring", "Microservices", "Hibernate", "Git", "CI/CD"), 230_000, "Санкт-Петербург", LocalDate.of(2023, 6, 4)),
                new Job("Senior java developer", List.of("Java 8", "Spring", "Hibernate", "Kafka", "Docker"), 200_000, "Москва", LocalDate.of(2023, 6, 2)),
                new Job("Senior java developer", List.of("Java 8", "Spring", "Hibernate", "Kafka", "Docker"), 200_000, "Москва", LocalDate.of(2023, 5, 31)),
                new Job("Middle java developer", List.of("Java 8", "Spring"), 150_000, "Москва", LocalDate.of(2023, 5, 29)),
                new Job("Middle java developer", List.of("Java 11", "Spring", "Hibernate", "Kafka", "Docker", "Git", "CI/CD"), 170_000, "Москва", LocalDate.of(2023, 5, 27)),
                new Job("Middle java developer", List.of("Java 11", "Hibernate", "Kafka", "Docker", "Git", "CI/CD"), 180_000, "Нижний Новгород", LocalDate.of(2023, 5, 25)),
                new Job("Middle java developer", List.of("Java 11", "Spring", "Hibernate"), 140_000, "Москва", LocalDate.of(2023, 5, 23)),
                new Job("Middle java developer", List.of("Java 8", "Spring", "Hibernate", "Docker", "Git", "CI/CD"), 130_000, "Нижний Новгород", LocalDate.of(2023, 5, 21)),
                new Job("Middle java developer", List.of("Java 8", "Spring", "Hibernate", "Docker", "Git", "CI/CD"), 130_000, "Москва", LocalDate.of(2023, 5, 19)),
                new Job("Junior java developer", List.of("Java 17", "Spring", "Hibernate","Git"), 80_000, "Нижний Новгород", LocalDate.of(2023, 5, 17)),
                new Job("Junior java developer", List.of("Java 8", "Spring", "Hibernate","Git"), 70_000, "Санкт-Петербург", LocalDate.of(2023, 5, 15)),
                new Job("Junior java developer", List.of("Java 8", "Spring"), 90_000, "Москва", LocalDate.of(2023, 5, 13)),
                new Job("Junior java developer", List.of("Java 11", "Spring", "Hibernate","Git"), 60_000, "Сочи", LocalDate.of(2023, 5, 11)),
                new Job("Junior java developer", List.of("Java 8"), 50_000, "Казань", LocalDate.of(2023, 5, 9)),
                new Job("Intern java developer", List.of("Java 8"), 30_000, "Москва", LocalDate.of(2023, 5, 7)),
                new Job("Intern java developer", List.of("Java 8"), 30_000, "Москва", LocalDate.of(2023, 5, 5)),
                new Job("Intern java developer", List.of("Java 8"), 30_000, "Санкт-Петербург", LocalDate.of(2023, 5, 3)),
                new Job("Intern java developer", List.of("Java 8"), 30_000, "Нижний Новгород", LocalDate.of(2023, 5, 1))
        );

        return Stream.of(Arguments.of(jobs));
    }
}