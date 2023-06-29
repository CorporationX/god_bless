package VacancyAnalyzer;

import faang.school.godbless.VacancyAnalyzer.Job;
import faang.school.godbless.VacancyAnalyzer.JobStreamProcessor;
import faang.school.godbless.VacancyAnalyzer.Statistics;
import faang.school.godbless.VacancyAnalyzer.TrendGranularity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.VacancyAnalyzer.DataAnalyzer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VacancyAnalyzerTest {
    String job1 = "{" +
            "'title': 'Java Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "Java" +
            "]," +
            "'salary': 2000," +
            "'location': 'Seoul'," +
            "'createdAt': '2023-06-22'" +
            "}";
    String job2 = "{" +
            "'title': 'Python Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "Python" +
            "]," +
            "'salary': 1500," +
            "'location': 'Rio'," +
            "'createdAt': '2023-06-13'" +
            "}";
    String job3 = "{" +
            "'title': 'C# Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "'C#'" +
            "]," +
            "'salary': 1000," +
            "'location': 'Rio'," +
            "'createdAt': '2023-06-15'" +
            "}";
    String job4 = "{" +
            "'title': 'Go Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "'Go'" +
            "]," +
            "'salary': 800," +
            "'location': 'Rio'," +
            "'createdAt': '2023-06-17'" +
            "}";
    String job5 = "{" +
            "'title': 'Java Senior Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "'Java'," +
            "'Everything'" +
            "]," +
            "'salary': 5000," +
            "'location': 'Seoul'," +
            "'createdAt': '2023-06-11'" +
            "}";
    List<String> stringList = List.of(job1, job2, job3, job4, job5);
    List<Job> list = JobStreamProcessor.process(stringList.stream());

    @Test
    void mostPopularSkillsTest() {
        List<String> result = mostRequiredSkills(list);

        assertEquals("SQL", result.get(0));
    }

    @Test
    void mostPopularTitlesTest() {
        List<String> result = mostPopularTitles(list);

        assertEquals("Developer", result.get(0));
    }

    @Test
    void rangeOfSalariesTest() {
        Map<String, Integer> result = rangeOfSalaries(list);

        assertEquals(Map.of("Less then 1000", 2, "1001-2000", 2, "More then 2001", 1), result);
    }

    @Test
    void mostPopularLocationsTest() {
        List<String> result = mostPopularLocations(list);

        assertEquals("Rio", result.get(0));
        assertEquals("Seoul", result.get(1));
    }

    @Test
    void analyzeTrendsTest() {
        List<Statistics> statistics = analyzeTrends(Date.from(Instant.parse("2023-06-01T00:00:00.00Z")),
                Date.from(Instant.parse("2023-06-30T00:00:00.00Z")), TrendGranularity.WEEK, list);

       assertNotNull(statistics);
       assertEquals(5,statistics.size());
    }
}
