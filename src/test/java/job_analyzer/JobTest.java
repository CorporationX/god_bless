package job_analyzer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    private static final Job JOB = new Job("Test", List.of("Test"), 1000, "Test", "2020-01-01");
    @Test
    void getDatePostedAsLocalDate() {
        assertEquals(LocalDate.of(2020, 1, 1), JOB.getDatePostedAsLocalDate());
    }

    @Test
    void getYear() {
        assertEquals(2020, JOB.getYear());
    }

    @Test
    void getMonthValue() {
        assertEquals(1, JOB.getMonthValue());
    }
}