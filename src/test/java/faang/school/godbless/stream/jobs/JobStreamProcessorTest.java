package faang.school.godbless.stream.jobs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JobStreamProcessorTest {

    private final JobStreamProcessor processor = new JobStreamProcessor(new JsonJobScraper());

    @Test
    void processJobs() {
        List<Job> jobs = processor.processJobs(Stream.of("""
                        {
                                    "title": "Software Engineer",
                                    "reqs": ["Java", "Docker", "Spring"],
                                    "offeredSalary": 10000.0,
                                    "location": "San Francisco, CA",
                                    "dateAdded": "2023-06-13"
                        }
                        """,
                """
                        {
                                    "title": "Principal Engineer",
                                    "reqs": ["System Design", "Software Architecture"],
                                    "offeredSalary": 20000.0,
                                    "location": "San Francisco, CA",
                                    "dateAdded": "2023-06-13"
                        }
                        """,
                """
                        {
                                    "title": "Engineering Manager",
                                    "reqs": ["Team Management", "Leadership"],
                                    "offeredSalary": 15000.0,
                                    "location": "San Francisco, CA",
                                    "dateAdded": "2023-06-13"
                        }
                        """
        ));

        assertEquals(3, jobs.size());
        assertEquals("Software Engineer", jobs.get(0).title());
        assertEquals("Principal Engineer", jobs.get(1).title());
        assertEquals("Engineering Manager", jobs.get(2).title());
    }
}