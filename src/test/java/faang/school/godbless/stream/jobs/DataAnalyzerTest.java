package faang.school.godbless.stream.jobs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private final DataAnalyzer dataAnalyzer = new DataAnalyzer();

    private final List<Job> jobs = List.of(
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 0.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 0.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 0.0, "San Fransisco", null),
            new Job("Data Engineer", List.of("SQL", "Hadoop"), 0.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 0.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 0.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 0.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 0.0, "Berlin", null),
            new Job("Java Developer", List.of("SQL", "Spring"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Amsterdam", null),
            new Job("Data Scientist", List.of("SQL", "Pandas"), 0.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 0.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 0.0, "Munich", null),
            new Job("ML Engineer", List.of("SQL", "Terraform"), 0.0, "Munich", null),
            new Job("DBA", List.of("SQL", "Oracle"), 0.0, "Moscow", null),
            new Job("DBA", List.of("SQL", "Oracle"), 0.0, "Moscow", null),
            new Job("Python Developer", List.of("SQL", "Django"), 0.0, "New York", null),
            new Job("Manual QA", List.of("SQL", "Manual QA"), 0.0, "Belgrade", null),
            new Job("QA Automation", List.of("SQL", "Selenium"), 0.0, "London", null)
    );

    @Test
    void listTop5InDemandSkills() {
        var topSkills = dataAnalyzer.listTop5InDemandSkills(jobs);

        assertEquals(5, topSkills.size());
        assertEquals("SQL", topSkills.get(0));
        assertEquals("Terraform", topSkills.get(topSkills.size() - 1));
    }

    @Test
    void testListTop5JobTitlesDescending() {
        var topJobTitles = dataAnalyzer.listTop5JobTitlesDescending(jobs);

        assertEquals(5, topJobTitles.size());
        assertEquals("Data Scientist", topJobTitles.get(0));
        assertEquals("DBA", topJobTitles.get(topJobTitles.size() - 1));
    }

    @Test
    void listTop5Locations() {
        var topLocations = dataAnalyzer.listTop5Locations(jobs);

        assertEquals(5, topLocations.size());
        assertEquals("Amsterdam", topLocations.get(0));
        assertEquals("Moscow", topLocations.get(topLocations.size() - 1));
    }
}