package faang.school.godbless.sprint3.vacancy_analyzer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JobStreamProcessorTest {
    private JobStreamProcessor jobStreamProcessor;

    @BeforeEach
    void setUp() {
        jobStreamProcessor = new JobStreamProcessor();
    }

    @Test
    void processTest() {
        Stream<String> jobStream = Stream.of("{" +
                "\"name\":\"Java-developer\"," +
                "\"requirements\":[\"Java core\",\"Spring\",\"SQL\"]," +
                "\"salary\":250000," +
                "\"location\":\"Moscow, Russia\"," +
                "\"dateAdded\":[2023,6,25]}");

        List<Job> expected = List.of(
                new Job(
                        "Java-developer",
                        List.of("Java core", "Spring", "SQL"),
                        250000, "Moscow, Russia",
                        LocalDate.of(2023, 6, 25)
                )
        );

        assertEquals(expected, jobStreamProcessor.process(jobStream));
    }
}