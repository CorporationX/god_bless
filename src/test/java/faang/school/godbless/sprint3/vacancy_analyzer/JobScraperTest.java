package faang.school.godbless.sprint3.vacancy_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobScraperTest {
    private JobScraper jobScraper;

    @BeforeEach
    void setUp() {
        jobScraper = new JobScraper();
    }

    @Test
    void jsonToPojoTest() {
        String jsonJob = "{" +
                "\"name\":\"Java-developer\"," +
                "\"requirements\":[\"Java core\",\"Spring\",\"SQL\"]," +
                "\"salary\":250000," +
                "\"location\":\"Moscow, Russia\"," +
                "\"dateAdded\":[2023,6,25]}";

        Job expected = new Job(
                "Java-developer",
                List.of("Java core", "Spring", "SQL"),
                250000, "Moscow, Russia",
                LocalDate.of(2023, 6, 25)
        );

        assertEquals(expected, jobScraper.jsonToPojo(jsonJob));
    }

    @Test
    void pojoToJsonTest() {
        JobScraper jobScraper = new JobScraper();
        Job job = new Job(
                "Java-developer",
                List.of("Java core", "Spring", "SQL"),
                250000, "Moscow, Russia",
                LocalDate.of(2023, 6, 25)
        );

        String expected = "{" +
                "\"name\":\"Java-developer\"," +
                "\"requirements\":[\"Java core\",\"Spring\",\"SQL\"]," +
                "\"salary\":250000," +
                "\"location\":\"Moscow, Russia\"," +
                "\"dateAdded\":[2023,6,25]}";

        assertEquals(expected, jobScraper.pojoToJson(job));
    }
}