package faang.school.godbless.bjs2_22762;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.bjs2_22762.TrendGranularity.DAILY;
import static faang.school.godbless.bjs2_22762.TrendGranularity.MONTHLY;
import static faang.school.godbless.bjs2_22762.TrendGranularity.WEEKLY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataAnalyzerTest {
    private DataAnalyzer dataAnalyzer;
    private List<String> jsonJobs;
    private JobStreamProcessor jobStreamProcessor;
    private List<Job> jobs;

    @BeforeEach
    void setup() {
        dataAnalyzer = new DataAnalyzer();
        jsonJobs = new ArrayList<>();
        jobStreamProcessor = new JobStreamProcessor();
        jobs = jobStreamProcessor.process(jsonJobs.stream());
    }

    @Test
    void testGetSalaryDistribution() {
        var job1 = new Job("1", List.of(), 1, "1", LocalDate.parse("2024-05-05"));
        var job2 = new Job("2", List.of(), 9, "1", LocalDate.parse("2024-05-05"));
        var job3 = new Job("3", List.of(), 10, "1", LocalDate.parse("2024-05-05"));
        var job4 = new Job("4", List.of(), 19, "1", LocalDate.parse("2024-05-05"));
        var job5 = new Job("5", List.of(), 50, "1", LocalDate.parse("2024-05-05"));
        var job6 = new Job("6", List.of(), 51, "1", LocalDate.parse("2024-05-05"));
        var job7 = new Job("7", List.of(), 99, "1", LocalDate.parse("2024-05-05"));
        var job8 = new Job("8", List.of(), 100, "1", LocalDate.parse("2024-05-05"));
        var job9 = new Job("9", List.of(), 101, "1", LocalDate.parse("2024-05-05"));

        var jobs = List.of(job1, job2, job3, job4, job5, job6, job7, job8, job9);

        var intervals = List.of(10, 20, 50, 100);

        var result = dataAnalyzer.getSalaryDistribution(jobs, intervals);

        assertEquals(2, result.get("0 - 9"));
        assertEquals(2, result.get("10 - 19"));
        assertEquals(3, result.get("50 - 99"));
        assertEquals(2, result.get("100+"));
        System.out.println();
    }

    @Test
    void testAnalyzeTrendsDaily() {
        var job01 = new Job("01", List.of(), 0, "01", LocalDate.parse("2024-08-11"));
        var job02 = new Job("02", List.of(), 0, "02", LocalDate.parse("2024-08-11"));
        var job1 = new Job("1", List.of(), 1, "1", LocalDate.parse("2024-08-12"));
        var job21 = new Job("21", List.of(), 2, "21", LocalDate.parse("2024-08-13"));
        var job22 = new Job("22", List.of(), 2, "22", LocalDate.parse("2024-08-13"));
        var job23 = new Job("23", List.of(), 2, "23", LocalDate.parse("2024-08-13"));
        var job31 = new Job("31", List.of(), 3, "31", LocalDate.parse("2024-08-14"));
        var job32 = new Job("32", List.of(), 3, "32", LocalDate.parse("2024-08-14"));
        var job41 = new Job("41", List.of(), 4, "41", LocalDate.parse("2024-08-15"));
        var job42 = new Job("42", List.of(), 4, "42", LocalDate.parse("2024-08-15"));
        var job51 = new Job("51", List.of(), 5, "51", LocalDate.parse("2024-08-16"));
        var job52 = new Job("52", List.of(), 5, "52", LocalDate.parse("2024-08-16"));
        var job53 = new Job("53", List.of(), 5, "53", LocalDate.parse("2024-08-16"));
        var job54 = new Job("54", List.of(), 5, "54", LocalDate.parse("2024-08-16"));
        var job6 = new Job("6", List.of(), 6, "6", LocalDate.parse("2024-08-17"));

        var jobs = List.of(job01, job02, job1, job21, job22, job23, job31, job32, job41, job42, job51, job52, job53, job54, job6);

        var result = dataAnalyzer.analyzeTrends(jobs, LocalDate.parse("2024-08-12"), LocalDate.parse("2024-08-16"), DAILY);
        assertEquals(5, result.size());

        assertEquals(1, result.get(LocalDate.parse("2024-08-12")).getCount());
        assertEquals(0, result.get(LocalDate.parse("2024-08-12")).getChange());

        assertEquals(3, result.get(LocalDate.parse("2024-08-13")).getCount());
        assertEquals(2, result.get(LocalDate.parse("2024-08-13")).getChange());

        assertEquals(2, result.get(LocalDate.parse("2024-08-14")).getCount());
        assertEquals(-1, result.get(LocalDate.parse("2024-08-14")).getChange());

        assertEquals(2, result.get(LocalDate.parse("2024-08-15")).getCount());
        assertEquals(0, result.get(LocalDate.parse("2024-08-15")).getChange());

        assertEquals(4, result.get(LocalDate.parse("2024-08-16")).getCount());
        assertEquals(2, result.get(LocalDate.parse("2024-08-16")).getChange());
    }

    @Test
    void testAnalyzeTrendsWeekly() {
        var job0 = new Job("0", List.of(), 0, "0", LocalDate.parse("2024-08-11"));
        var job1 = new Job("1", List.of(), 1, "1", LocalDate.parse("2024-08-12"));
        var job2 = new Job("2", List.of(), 2, "2", LocalDate.parse("2024-08-13"));
        var job3 = new Job("3", List.of(), 3, "3", LocalDate.parse("2024-08-18"));
        var job4 = new Job("4", List.of(), 4, "4", LocalDate.parse("2024-08-19"));
        var job5 = new Job("5", List.of(), 5, "5", LocalDate.parse("2024-08-20"));
        var job6 = new Job("6", List.of(), 6, "6", LocalDate.parse("2024-08-26"));

        var jobs = List.of(job0, job1, job2, job3, job4, job5, job6);

        var result = dataAnalyzer.analyzeTrends(jobs, LocalDate.parse("2024-08-12"), LocalDate.parse("2024-08-26"), WEEKLY);
        assertEquals(3, result.size());
        assertNotNull(result.get(LocalDate.parse("2024-08-12")));
        assertNotNull(result.get(LocalDate.parse("2024-08-19")));
        assertNotNull(result.get(LocalDate.parse("2024-08-26")));
    }

    @Test
    void testAnalyzeTrendsMonthly() {
        var job0 = new Job("0", List.of(), 0, "0", LocalDate.parse("2024-06-11"));
        var job1 = new Job("1", List.of(), 1, "1", LocalDate.parse("2024-06-12"));
        var job2 = new Job("2", List.of(), 2, "2", LocalDate.parse("2024-06-13"));
        var job3 = new Job("3", List.of(), 3, "3", LocalDate.parse("2024-07-12"));
        var job4 = new Job("4", List.of(), 4, "4", LocalDate.parse("2024-08-11"));
        var job5 = new Job("5", List.of(), 5, "5", LocalDate.parse("2024-08-12"));
        var job6 = new Job("6", List.of(), 6, "6", LocalDate.parse("2024-08-13"));

        var jobs = List.of(job0, job1, job2, job3, job4, job5, job6);

        var result = dataAnalyzer.analyzeTrends(jobs, LocalDate.parse("2024-06-12"), LocalDate.parse("2024-09-12"), MONTHLY);
        assertEquals(3, result.size());
        assertNotNull(result.get(LocalDate.parse("2024-06-12")));
        assertNotNull(result.get(LocalDate.parse("2024-07-12")));
        assertNotNull(result.get(LocalDate.parse("2024-08-12")));
    }


}