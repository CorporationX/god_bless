package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {
    private DataAnalyzer dataAnalyzer;
    private List<Job> jobs;

    @BeforeEach
    void setUp() {
        dataAnalyzer = new DataAnalyzer();

        Job job1 = new Job();
        job1.setPositionName("Software Engineer");
        job1.setCandidateRequirements(Arrays.asList("Java", "Spring", "SQL"));
        job1.setSalary(80000.0);
        job1.setLocation("New York");
        job1.setDateAdded(new Date());

        Job job2 = new Job();
        job2.setPositionName("Data Analyst");
        job2.setCandidateRequirements(Arrays.asList("Python", "SQL", "Data Analysis"));
        job2.setSalary(70000.0);
        job2.setLocation("San Francisco");
        job2.setDateAdded(new Date());

        Job job3 = new Job();
        job3.setPositionName("Product Manager");
        job3.setCandidateRequirements(Arrays.asList("Product Management", "Agile", "Leadership"));
        job3.setSalary(120000.0);
        job3.setLocation("Seattle");
        job3.setDateAdded(new Date());

        Job job4 = new Job();
        job4.setPositionName("Product Manager");
        job4.setCandidateRequirements(Arrays.asList("Product Management", "Agile", "Leadership"));
        job4.setSalary(90000.0);
        job4.setLocation("San Francisco");
        job4.setDateAdded(new Date());

        Job job5 = new Job();
        job5.setPositionName("BackEnd");
        job5.setCandidateRequirements(Arrays.asList("C#", "SQL", "Framework"));
        job5.setSalary(20000.0);
        job5.setLocation("Paris");
        job5.setDateAdded(new Date());

        jobs = Arrays.asList(job1, job2, job3, job4, job5);
    }
    @Test
    void testGetTopSkills() {
        List<String> expectedTopSkills = Arrays.asList("sql", "product management", "leadership", "agile", "c#");

        List<String> topSkills = dataAnalyzer.getTopSkills(jobs);

        assertEquals(expectedTopSkills, topSkills);
    }

    @Test
    void testGetTopPositions() {
        int topCount = 2;
        List<String> expectedTopPositions = Arrays.asList("Product Manager", "BackEnd");

        List<String> topPositions = dataAnalyzer.getTopPositions(jobs, topCount);

        assertEquals(expectedTopPositions, topPositions);
    }

    @Test
    void testAnalyzeSalary() {
        int salaryRange = 150000;
        int rangeSize = 50000;
        Map<String, Integer> expectedSalaryDist = Map.of(
                "0k-49k", 1,
                "50k-99k", 3,
                "100k-149k", 1
        );

        Map<String, Integer> salaryDist = dataAnalyzer.analyzeSalary(jobs, salaryRange);

        assertEquals(expectedSalaryDist, salaryDist);
    }

    @Test
    void testGetTopLocation() {
        List<String> expectedTopLocations = Arrays.asList("San Francisco", "New York", "Seattle", "Paris");

        List<String> topLocations = dataAnalyzer.getTopLocations(jobs);

        assertEquals(expectedTopLocations, topLocations);
    }


}