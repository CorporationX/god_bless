package faang.school.godbless.stream.jobs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private final DataAnalyzer dataAnalyzer = new DataAnalyzer();

    private final List<Job> jobs = List.of(
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 400000.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 400000.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 400000.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 400000.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 300000.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 300000.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 300000.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 300000.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 300000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 120000.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 180000.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 180000.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 180000.0, "Munich", null),
            new Job("DBA", List.of("SQL", "Oracle"), 140000.0, "Moscow", null),
            new Job("DBA", List.of("SQL", "Oracle"), 140000.0, "Moscow", null),
            new Job("Python Developer", List.of("SQL", "Django"), 240000.0, "New York", null),
            new Job("Manual QA", List.of("SQL", "Manual QA"), 90000.0, "Belgrade", null),
            new Job("QA Automation", List.of("SQL", "Selenium"), 110000.0, "London", null)
    );

    @Test
    void listTopFiveInDemandSkills() {
        var topSkills = dataAnalyzer.listTopFiveInDemandSkills(jobs);

        assertEquals(5, topSkills.size());
        assertEquals("SQL", topSkills.get(0));
        assertEquals("Terraform", topSkills.get(topSkills.size() - 1));
    }

    @Test
    void testListTopFiveJobTitles() {
        var topJobTitles = dataAnalyzer.listTopFiveJobTitles(jobs);

        assertEquals(5, topJobTitles.size());
        assertEquals("Data Scientist", topJobTitles.get(0));
        assertEquals("DBA", topJobTitles.get(topJobTitles.size() - 1));
    }

    @Test
    void listTopFiveLocations() {
        var topLocations = dataAnalyzer.listTopFiveLocations(jobs);

        assertEquals(5, topLocations.size());
        assertEquals("Amsterdam", topLocations.get(0));
        assertEquals("Moscow", topLocations.get(topLocations.size() - 1));
    }

    @Test
    void categorizeBySalaryRange() {
        var salaryRangeInfo = dataAnalyzer.categorizeBySalaryRange(jobs);

        var numberOfJobsBySalaryRange = salaryRangeInfo.getNumberOfJobsBySalaryRange();
        assertEquals(4, numberOfJobsBySalaryRange.get(new SalaryRange(400000.0, 450000.0)));
        assertEquals(5, numberOfJobsBySalaryRange.get(new SalaryRange(300000.0, 350000.0)));
        assertEquals(9, numberOfJobsBySalaryRange.get(new SalaryRange(100000.0, 150000.0)));
        assertEquals(3, numberOfJobsBySalaryRange.get(new SalaryRange(150000.0, 200000.0)));
        assertEquals(1, numberOfJobsBySalaryRange.get(new SalaryRange(200000.0, 250000.0)));
        assertEquals(1, numberOfJobsBySalaryRange.get(new SalaryRange(50000.0, 100000.0)));
    }
}