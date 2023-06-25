package faang.school.godbless.vacancy_analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class DataAnalyzerTest {

    List<Job> jobs;

    @BeforeEach
    void setUp(){
        jobs = List.of(
                new Job("hr", List.of("personnel search", "communicative", "friendly"),
                        30000, "IT", LocalDateTime.now()),
                new Job("sales", List.of("sales skills", "communicative", "proactive"),
                        110000, "FR", LocalDateTime.now()),
                new Job("sales", List.of("sales skills", "communicative", "friendly"),
                        80000, "US", LocalDateTime.now()),
                new Job("marketing", List.of("creative", "communicative", "proactive"),
                        90000, "US", LocalDateTime.now()),
                new Job("hr", List.of("legal skills", "communicative", "proactive"),
                        60000, "US" , LocalDateTime.now()),
                new Job("hr", List.of("proactive", "communicative", "friendly"),
                        120000, "IT", LocalDateTime.now())
                );
    }

    @Test
    void getTopSkillsTest(){
        List<String> result = DataAnalyzer.getTopSkills(jobs, 3);
        List<String> expected = List.of("communicative", "proactive", "friendly");

        Assertions.assertEquals(expected, result);
    }

    @Test
    void sortJobsByPopularityTest(){
        List<String> result = DataAnalyzer.sortJobsByPopularity(jobs);
        List<String> expected = List.of("hr", "sales", "marketing");

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSalaryRangeTest(){
        Map<String, Long> result = DataAnalyzer.getSalaryRange(jobs, 50000);
        Map<String, Long> expected = Map.of("50000-100000", 3L, "100000-150000", 2L,"0-50000",1L);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getPopularLocationsTest(){
        List<String> result = DataAnalyzer.getPopularLocations(jobs, 3);
        List<String> expected = List.of("US", "IT", "FR");
        Assertions.assertEquals(expected, result);
    }
}
