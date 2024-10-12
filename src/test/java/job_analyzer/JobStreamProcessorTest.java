package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JobStreamProcessorTest {
    private static final JobScraper JOB_SCRAPER = mock(JobScraper.class);
    private static final JobStreamProcessor JOB_STREAM_PROCESSOR = new JobStreamProcessor();

    @Test
    public void testProcessJobs() throws JsonProcessingException {
        Stream<String> jsonStream = Stream.of(
                "[{",
                "\"position\": \"Software Engineer\",",
                "\"requirements\": [\"Java\", \"Spring\", \"SQL\"],",
                "\"salary\": 100000,",
                "\"location\": \"New York\",",
                "\"datePosted\": \"2023-10-03\"",
                "}]"
        );

        Job expectedJob = new Job("Software Engineer", List.of("Java", "Spring", "SQL"), 100000, "New York", "2023-10-03");
        when(JOB_SCRAPER.parseJobs(anyString())).thenReturn(List.of(expectedJob));
        List<Job> result = JOB_STREAM_PROCESSOR.processJobs(jsonStream);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expectedJob.getPosition(), result.get(0).getPosition());
        assertEquals(expectedJob.getRequirements(), result.get(0).getRequirements());
        assertEquals(expectedJob.getSalary(), result.get(0).getSalary());
        assertEquals(expectedJob.getLocation(), result.get(0).getLocation());
        assertEquals(expectedJob.getDatePosted(), result.get(0).getDatePosted());
    }

    @Test
    public void testProcessJobsWithInvalidJson() throws JsonProcessingException {
        Stream<String> invalidJsonStream = Stream.of("Invalid JSON");
        when(JOB_SCRAPER.parseJobs(anyString())).thenThrow(JsonProcessingException.class);
        assertThrows(JsonProcessingException.class, () -> JOB_STREAM_PROCESSOR.processJobs(invalidJsonStream));
    }
}