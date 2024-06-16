package faang.school.godbless.stream.jobs;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JsonJobScraperTest {

    private final JobScraper jobScraper = new JsonJobScraper();

    @Test
    void testParseShouldSuccessfullyCreateJob() {
        var parsedJob = jobScraper.parse("""
                {
                            "title": "Software Engineer",
                            "reqs": ["Java", "Docker", "Spring"],
                            "offeredSalary": 10000.0,
                            "location": "San Francisco, CA",
                            "dateAdded": "2023-06-13"
                }
                """);

        assertEquals(Job.class, parsedJob.getClass());
        assertEquals("Software Engineer", parsedJob.title());
        assertEquals(3, parsedJob.reqs().size());
        assertEquals(10000.0, parsedJob.offeredSalary());
        assertEquals("San Francisco, CA", parsedJob.location());
        assertEquals(LocalDate.of(2023, 6, 13), parsedJob.dateAdded());
    }

    @Test
    void testParseNullShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> jobScraper.parse(null));
    }

    @Test
    void testParseEmptyStringShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> jobScraper.parse("  "));
    }

}