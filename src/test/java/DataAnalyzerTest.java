import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.DataAnalyzer;
import school.faang.Job;
import school.faang.JobStreamProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataAnalyzerTest {
    List<Job> jobs;

    @BeforeEach
    public void setUp() {
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        try {
            String jsonContent = Files.readString(Path.of("src/main/resources/vacancies.json"));
            jobs = jobStreamProcessor.processJobs(jsonContent);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetTopFiveDemandingSkills_basicCase() {
        List<String> result = DataAnalyzer.getTopFiveDemandingSkills(jobs);
        assertEquals(List.of("JavaScript", "SQL", "Agile", "Spring", "Azure"), result);
    }

    @Test
    public void testJobConstructor_invalidPosition() {
        LocalDate datePosted = LocalDate.now();
        assertThrows(IllegalArgumentException.class, () ->
                new Job("", List.of("Java", "Spring"), 100000, "New York", datePosted));
        assertThrows(IllegalArgumentException.class, () ->
                new Job(null, List.of("Java", "Spring"), 100000, "New York", datePosted));
    }

    @Test
    public void testJobConstructor_invalidSalary() {
        LocalDate datePosted = LocalDate.now();
        assertThrows(IllegalArgumentException.class, () ->
                new Job("SE", List.of("Java", "Spring"), -100, "New York", datePosted));
    }

    @Test
    public void testJobConstructor_invalidDate() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, () ->
                new Job("SE", List.of("Java", "Spring"), -100, "New York", futureDate));
    }


    @Test
    public void testJobConstructor_nullRequirements() {
        LocalDate datePosted = LocalDate.now();
        assertThrows(IllegalArgumentException.class, () ->
                new Job("Software Engineer", null, 100000, "New York", datePosted));
    }

    @Test
    public void testGetTopFiveDemandingSkills_lessThanFiveJobs() {
        List<Job> jobs = List.of(
                new Job("Software Engineer", List.of("Java", "Spring", "AWS"),
                        100000, "New York", LocalDate.now()),
                new Job("Backend Engineer", List.of("Java", "Spring", "Kubernetes"),
                        120000, "San Francisco", LocalDate.now())
        );
        assertTrue(DataAnalyzer.getTopFiveDemandingSkills(jobs).size() <= 5);
    }

    @Test
    public void testGetTopFivePositions_basicCase() {
        List<String> expected = List.of("Data Scientist", "QA Engineer", "Software Engineer",
                "Product Manager", "Backend Developer");
        List<String> result = DataAnalyzer.getTopFivePositions(jobs);
        assertEquals(expected, result);
    }

    @Test
    void testGetTopFivePositions_lessThanFiveJobs() {
        List<Job> jobs = List.of(
                new Job("Software Engineer", List.of("Java", "Spring"), 120000, "NYC", LocalDate.of(2023, 1, 10)),
                new Job("Data Scientist", List.of("Python", "ML"), 110000, "NYC", LocalDate.of(2023, 3, 20)),
                new Job("Product Manager", List.of("Agile", "Leadership"), 140000, "LA", LocalDate.of(2023, 5, 15))
        );
        List<String> topPositions = DataAnalyzer.getTopFivePositions(jobs);
        assertThat(topPositions).containsExactly(
                "Product Manager", "Data Scientist", "Software Engineer");
    }

    @Test
    void testGetTopFivePositions_emptyList() {
        assertTrue(DataAnalyzer.getTopFivePositions(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGetTopFivePositions_nullList() {
        assertThrows(IllegalArgumentException.class,
                () -> DataAnalyzer.getTopFivePositions(null));
    }

    @Test
    void testGroupBySalary_basicCase() {
        Job job1 = new Job("Developer", List.of("Java"), 30000, "New York", LocalDate.now());
        Job job2 = new Job("Manager", List.of("Leadership"), 50000, "Los Angeles", LocalDate.now());
        Job job3 = new Job("Designer", List.of("Creativity"), 52000, "San Francisco", LocalDate.now());
        Job job4 = new Job("Director", List.of("Management"), 120000, "Chicago", LocalDate.now());
        List<Job> jobs = List.of(job1, job2, job3, job4);

        Map<String, List<Job>> grouped = DataAnalyzer.groupJobsBySalary(jobs);
        assertEquals(1, grouped.get("0-50000k").size());
        assertEquals(2, grouped.get("50000-100000k").size());
        assertEquals(1, grouped.get("100000-150000k").size());
    }

    @Test
    void testGroupBySalary_singleGroup() {
        Job job1 = new Job("Developer", List.of("Java", "Spring"), 30000, "New York", LocalDate.now());
        Job job2 = new Job("Tester", List.of("Testing"), 45000, "Los Angeles", LocalDate.now());
        List<Job> jobs = List.of(job1, job2);

        Map<String, List<Job>> grouped = DataAnalyzer.groupJobsBySalary(jobs);
        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("0-50000k").size());
    }

    @Test
    void testGroupBySalary_emptyJobList() {
        assertTrue(DataAnalyzer.groupJobsBySalary(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGroupBySalary_nullJobList() {
        assertThrows(IllegalArgumentException.class,
                () -> DataAnalyzer.groupJobsBySalary(null));
    }

    @Test
    void testGetTopFivePopularOffices_basicCase() {
        List<String> expected = List.of("UX/UI Designer", "Backend Developer", "Software Engineer",
                "Frontend Developer", "Software Engineer");
        assertEquals(expected, DataAnalyzer.getTopFivePopularOffices(jobs));
    }

    @Test
    void testGetTopFivePopularOffices_invalidPosition() {
        assertThrows(IllegalArgumentException.class, () ->
                new Job("", List.of("Java"), 100000, "San Francisco", LocalDate.now()));
    }

    @Test
    void testGetTopFivePopularOffices_withLessThanFiveJobs() {
        List<Job> jobs = List.of(
                new Job("Software Engineer", List.of("Java", "Spring"), 120000, "New York",
                        LocalDate.of(2024, 1, 1)),
                new Job("Data Scientist", List.of("Python", "ML"), 110000, "San Francisco",
                        LocalDate.of(2024, 2, 1))
        );
        assertEquals(2, DataAnalyzer.getTopFivePopularOffices(jobs).size());
    }

    @Test
    void testGetTopFivePopularOffices_withEmptyList() {
       assertTrue(DataAnalyzer.getTopFivePopularOffices(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGetTopFivePopularOffices_withNullList() {
        assertThrows(IllegalArgumentException.class,
                () -> DataAnalyzer.getTopFivePopularOffices(null));
    }
}