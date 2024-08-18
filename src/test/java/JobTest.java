import faang.school.godbless.jobsAnalis.DataAnalyzer;
import faang.school.godbless.jobsAnalis.Job;
import faang.school.godbless.jobsAnalis.JobScraper;
import faang.school.godbless.jobsAnalis.JobStreamProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JobTest {
    private static List<Job> jobs = Arrays.asList(
            new Job("1", Arrays.asList("1", "2", "3"), 10000, "1"),
            new Job("1", Arrays.asList("1", "2", "4"), 50001, "2"),
            new Job("1", Arrays.asList("1", "3", "4"), 100000, "2"),
            new Job("2", Arrays.asList("2", "4", "5"), 100001, "3"),
            new Job("2", Arrays.asList("2", "4", "6"), 100000000, "3"),
            new Job("2", Arrays.asList("2", "5", "6"), 10, "3"),
            new Job("2", Arrays.asList("3", "5", "6"), 80000, "4"),
            new Job("2", Arrays.asList("3", "5", "7"), 90000, "4"),
            new Job("3", Arrays.asList("4", "5", "7"), 0, "4"),
            new Job("4", Arrays.asList("4", "6", "8"), 10, "4"),
            new Job("5", Arrays.asList("3", "6", "8"), 80000, "5"),
            new Job("5", Arrays.asList("3", "6", "8"), 90500, "5"),
            new Job("5", Arrays.asList("3", "6", "8"), 110000, "5"),
            new Job("5", Arrays.asList("3", "6", "8"), 900000, "5"),
            new Job("6", Arrays.asList("3", "6", "8"), 100, "5")
    );

    @Test
    public void jobScraperTest() {
        Job job = new Job("1", Arrays.asList("1", "2", "3"), 10000, "1");

        Job job1 = JobScraper.parceJob(JobScraper.toString(job));

        Assertions.assertEquals(job, job1);
    }

    @Test
    public void jobProcessorTest() {
        Assertions.assertEquals(jobs, JobStreamProcessor.process(jobs.stream()
                .map(JobScraper::toString)));
    }

    @Test
    public void top5DemandSkillsTest() {
        Assertions.assertEquals(
                Arrays.asList("3", "6", "4", "8", "2")
                , DataAnalyzer.top5DemandSkills(jobs));
    }

    @Test
    public void top5TitlesTest() {
        Assertions.assertEquals(
                Arrays.asList("2", "5", "1", "3", "4")
                , DataAnalyzer.top5Titles(jobs));
    }

    @Test
    public void salaryRangesTest() {
        Assertions.assertEquals(
                Map.of(
                        "0-50k", 5L,
                        "50k-100k", 5L,
                        "100k-150k", 3L,
                        "UNDEFINED", 2L
                )
                , DataAnalyzer.salaryRanges(jobs));
    }

    @Test
    public void top5LocationsTest() {
        Assertions.assertEquals(
                List.of("5", "4", "3", "2", "1")
                , DataAnalyzer.top5Locations(jobs));
    }

}
