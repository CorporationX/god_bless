package faang.school.godbless.job_analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private List<Job> jobs;

    @BeforeEach
    void setUp() {
        jobs = List.of(
                new Job("Software Engineer", List.of("Java"), 50000, "Seattle", "2023-06-01"),
                new Job("Data Scientist", List.of("Python", "R", "SQL"), 60000, "San Francisco", "2023-06-02"),
                new Job("Frontend Developer", List.of("HTML"), 55000, "Seattle", "2023-06-03"),
                new Job("Frontend Developer", List.of("JavaScript", "HTML", "CSS"), 50000, "New York", "2023-06-03"),
                new Job("Software Engineer", List.of("Java", "JavaScript"), 58000, "Chicago", "2023-06-04"),
                new Job("Data Analyst", List.of("SQL"), 52000, "Boston", "2023-06-05")
        );

    }

    @Test
    public void testGetTop5CommonSkillRequirements() {
        List<String> topSkills = new DataAnalyzer().getTop5CommonSkillRequirements(jobs);

        assertEquals(5, topSkills.size());
        assertEquals("java", topSkills.get(0).toLowerCase());
        assertEquals("html", topSkills.get(1).toLowerCase());
        assertEquals("javascript", topSkills.get(2).toLowerCase());
        assertEquals("sql", topSkills.get(3).toLowerCase());
        assertEquals("css", topSkills.get(4).toLowerCase());
    }


    @Test
    public void testGetMostCommonJobPositions() {
        List<String> commonPositions = new DataAnalyzer().getMostCommonJobPositions(jobs, 2);

        assertEquals(2, commonPositions.size());
        assertEquals("Frontend Developer", commonPositions.get(0));
        assertEquals("Software Engineer", commonPositions.get(1));
    }

    @Test
    public void testGetSalaryDistribution() {
        Map<String, Long> salaryDistribution = new DataAnalyzer().getSalaryDistribution(jobs);

        assertEquals(2, salaryDistribution.get("0-50k"));
        assertEquals(4, salaryDistribution.get("50k-100k"));
        assertEquals(null, salaryDistribution.get("100k-150k"));
        assertEquals(null, salaryDistribution.get("150k-200k"));
        assertEquals(null, salaryDistribution.get("200k+"));
    }

    @Test
    public void testGetTop5Locations() {
        List<String> topLocations = new DataAnalyzer().getTop5Locations(jobs);

        assertEquals(5, topLocations.size());
        assertEquals("Seattle", topLocations.get(0));
        assertEquals("San Francisco", topLocations.get(1));
        assertEquals("New York", topLocations.get(2));
        assertEquals("Chicago", topLocations.get(3));
        assertEquals("Boston", topLocations.get(4));
    }
}