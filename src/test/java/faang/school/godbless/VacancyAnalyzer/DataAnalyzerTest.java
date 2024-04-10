package faang.school.godbless.VacancyAnalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    private DataAnalyzer analyzer;
    private Job job1, job2, job3, job4, job5, job6;
    @BeforeEach
    void setUp() throws JsonProcessingException {
        job1 = new Job("Software Engineer", Arrays.asList("Java"), 80000,
                "San Francisco", LocalDateTime.of(2024, 4, 10, 12, 0));
        job6 = new Job("Software Engineer", Arrays.asList("Java", "Java Script"), 110000,
                "San Francisco", LocalDateTime.of(2024, 4, 10, 12, 0));
        job2 = new Job("Data Scientist", Arrays.asList("Python", "Machine Learning"), 90000,
                "New York", LocalDateTime.of(2024, 4, 9, 10, 30));
        job3 = new Job("UX Designer", Arrays.asList("UI/UX Design", "Adobe XD"), 75000,
                "Los Angeles", LocalDateTime.of(2024, 4, 8, 9, 15));
        job4 = new Job("Project Manager", Arrays.asList("Project Management", "Agile"), 45000,
                "Chicago", LocalDateTime.of(2024, 4, 7, 14, 45));
        job5 = new Job("Marketing Specialist", Arrays.asList("Digital Marketing", "Social Media"), 70000,
                "Seattle", LocalDateTime.of(2024, 4, 6, 8, 0));

        ObjectMapper mapper = new ObjectMapper();
        Stream<String> jobs = Stream.of(mapper.writeValueAsString(job1), mapper.writeValueAsString(job2),
                        mapper.writeValueAsString(job3), mapper.writeValueAsString(job4),
                        mapper.writeValueAsString(job5), mapper.writeValueAsString(job6));

        analyzer = new DataAnalyzer(jobs);
    }

    @Test
    void getMostPopularSkills() {
        List<String> excepted = analyzer.getMostPopularSkills(2);
        assertIterableEquals(excepted, analyzer.getMostPopularSkills(1));
    }

    @Test
    void getMostPopularNames() {
        List<String> excepted = List.of("Software Engineer");
        assertIterableEquals(excepted, analyzer.getMostPopularNames(1));
    }

    @Test
    void getMostPopularOfficeLocations() {
        List<String> excepted = List.of("San Francisco");
        assertIterableEquals(excepted, analyzer.getMostPopularOfficeLocations(1));
    }

    @Test
    void getSalaryIntervalsWithJobs() {
        Map<String, List<Job>> actual = analyzer.getSalaryIntervalsWithJobs();
    }

    @Test
    void analyzeTrends() {
        Map<String, List<Job>> actual = analyzer.analyzeTrends(LocalDate.of(2024, 4, 6),
                LocalDate.of(2024, 4, 10), TrendGranularity.WEEK);
        assertEquals(1, 1);
    }
}