package faang.school.godbless.stream.jobanalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobScraperTest {

    @Test
    void testParseJson() {
        String json = """
                {
                  "title": "Software Engineer",
                  "requirements": ["Java", "Spring", "REST APIs"],
                  "salary": 120000,
                  "location": "New York",
                  "addedDate": "2024-08-17"
                }""";
        JobScraper jobScraper = new JobScraper();

        Job job = jobScraper.parseJson(json);

        String expectedToString = "Job(title=Software Engineer, requirements=[Java, Spring, REST APIs]," +
                " salary=120000, location=New York, addedDate=2024-08-17)";
        assertEquals(expectedToString, job.toString());
    }
}