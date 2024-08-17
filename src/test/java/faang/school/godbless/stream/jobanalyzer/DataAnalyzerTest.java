package faang.school.godbless.stream.jobanalyzer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataAnalyzerTest {

    @Test
    void testPrintMostPopularSkills() {
        Job job1 = new Job("Senior Software Engineer", List.of("Java", "Python"), 1000, "New York", LocalDate.of(2022, 1, 1));
        Job job2 = new Job("Data Scientist", List.of("Python", "R"), 1500, "San Francisco", LocalDate.of(2021, 12, 1));
        Job job3 = new Job("Product Manager", List.of("Product Management", "Leadership"), 800, "Los Angeles", LocalDate.of(2021, 11, 1));
        Job job4 = new Job("Software Engineer", List.of("Java", "Python"), 1200, "New York", LocalDate.of(2022, 2, 1));
        Job job5 = new Job("Data Scientist", List.of("Python"), 1300, "San Francisco", LocalDate.of(2021, 11, 1));
        Job job6 = new Job("Product Manager", List.of("Product Management"), 900, "Los Angeles", LocalDate.of(2021, 10, 1));

        List<Job> jobs = Arrays.asList(job1, job2, job3, job4, job5, job6);

        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        dataAnalyzer.printMostPopularSkills(jobs, 3);
    }

    @Test
    void distributionOfSalariesByVacancies() {
        Job job1 = new Job("Senior Software Engineer", List.of("Java", "Python"), 1000, "New York", LocalDate.of(2022, 1, 1));
        Job job2 = new Job("Data Scientist", List.of("Python", "R"), 1500, "San Francisco", LocalDate.of(2021, 12, 1));
        Job job3 = new Job("Product Manager", List.of("Product Management", "Leadership"), 800, "Los Angeles", LocalDate.of(2021, 11, 1));
        Job job4 = new Job("Software Engineer", List.of("Java", "Python"), 1200, "New York", LocalDate.of(2022, 2, 1));
        Job job5 = new Job("Data Scientist", List.of("Python"), 1300, "San Francisco", LocalDate.of(2021, 11, 1));
        Job job6 = new Job("Product Manager", List.of("Product Management"), 900, "Los Angeles", LocalDate.of(2021, 10, 1));
        List<Job> jobs = Arrays.asList(job1, job2, job3, job4, job5, job6);

        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        Map<String, Integer> salaryBySegments = dataAnalyzer.distributionOfSalariesByVacancies(jobs, 500);
        assertEquals(4, salaryBySegments.size());
        assertTrue(salaryBySegments.containsKey("0-499"));
        assertEquals(0, salaryBySegments.get("0-499"));
        assertTrue(salaryBySegments.containsKey("500-999"));
        assertEquals(2, salaryBySegments.get("500-999"));
        assertTrue(salaryBySegments.containsKey("1000-1499"));
        assertEquals(3, salaryBySegments.get("1000-1499"));
        assertTrue(salaryBySegments.containsKey("1500-1999"));
        assertEquals(1, salaryBySegments.get("1500-1999"));
    }
}