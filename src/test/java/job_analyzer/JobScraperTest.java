package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobScraperTest {
    private JobScraper jobScraper = new JobScraper();

    @Test
    public void testParseJobs() throws JsonProcessingException {
        String json = """
        [
            {
                "position": "Software Engineer",
                "requirements": ["Java", "Spring", "SQL"],
                "salary": 100000,
                "location": "New York",
                "datePosted": "2023-10-03"
            },
            {
                "position": "Data Scientist",
                "requirements": ["Python", "Machine Learning", "SQL"],
                "salary": 120000,
                "location": "San Francisco",
                "datePosted": "2023-09-15"
            }
        ]
        """;

        List<Job> jobs = jobScraper.parseJobs(json);

        assertNotNull(jobs);
        assertEquals(2, jobs.size());

        Job firstJob = jobs.get(0);
        assertEquals("Software Engineer", firstJob.getPosition());
        assertEquals(List.of("Java", "Spring", "SQL"), firstJob.getRequirements());
        assertEquals(100000, firstJob.getSalary());
        assertEquals("New York", firstJob.getLocation());
        assertEquals("2023-10-03", firstJob.getDatePosted());

        Job secondJob = jobs.get(1);
        assertEquals("Data Scientist", secondJob.getPosition());
        assertEquals(List.of("Python", "Machine Learning", "SQL"), secondJob.getRequirements());
        assertEquals(120000, secondJob.getSalary());
        assertEquals("San Francisco", secondJob.getLocation());
        assertEquals("2023-09-15", secondJob.getDatePosted());
    }

    @Test
    public void testParseJobsInvalidJson() {
        String invalidJson = "Invalid JSON";
        assertThrows(JsonProcessingException.class, () -> jobScraper.parseJobs(invalidJson));
    }
}