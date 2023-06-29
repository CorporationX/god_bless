package faang.school.godbless.job_analyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JobScraperTest {

        @Test
        void testParseJobFromJsonString() {
            String jsonString = "{\"position\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":80000,\"location\":\"San Francisco\",\"dateAdded\":\"2023-06-25\"}";

            JobScraper jobScraper = new JobScraper();
            Job job = jobScraper.parseJobFromJsonString(jsonString);

            assertNotNull(job);

            assertEquals("Software Engineer", job.getPosition());
            assertEquals(3, job.getRequirements().size());
            assertEquals(80000, job.getSalary());
            assertEquals("San Francisco", job.getLocation());
            assertEquals("2023-06-25", job.getDateAdded());
        }
}
