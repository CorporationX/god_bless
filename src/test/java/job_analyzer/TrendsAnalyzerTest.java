package job_analyzer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrendsAnalyzerTest {
    private static final TrendsAnalyzer ANALYZER = new TrendsAnalyzer();
    
    private static final List<Job> JOBS = List.of(
            new Job("Software Engineer", List.of("Java", "Spring"), 100000, "New York", "2023-10-01"),
            new Job("Data Scientist", List.of("Python", "Machine Learning"), 120000, "San Francisco", "2023-10-02"),
            new Job("Backend Developer", List.of("Java", "Spring Boot"), 110000, "Los Angeles", "2023-10-01"),
            new Job("Frontend Developer", List.of("JavaScript", "React"), 90000, "Chicago", "2023-10-03")
    );

    @Test
    void testAnalyzeTrendsDailyGranularity() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ANALYZER.analyzeTrends(JOBS, "2023-10-01", "2023-10-03", Trends.DAILY);

        assertEquals(
                """
                        Период: 2023-10-01
                        Количество вакансий: 2
                        Топ навыков за период:
                        Java: 2 упоминаний
                        Spring Boot: 1 упоминаний
                        Spring: 1 упоминаний
                        
                        Период: 2023-10-02
                        Количество вакансий: 1
                        Топ навыков за период:
                        Machine Learning: 1 упоминаний
                        Python: 1 упоминаний
                        
                        Период: 2023-10-03
                        Количество вакансий: 1
                        Топ навыков за период:
                        JavaScript: 1 упоминаний
                        React: 1 упоминаний
                        
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }

    @Test
    void testAnalyzeTrendsMonthlyGranularity() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ANALYZER.analyzeTrends(JOBS, "2023-09-01", "2023-10-31", Trends.MONTHLY);

        assertEquals(
                """
                        Период: 2023-10
                        Количество вакансий: 4
                        Топ навыков за период:
                        Java: 2 упоминаний
                        JavaScript: 1 упоминаний
                        Spring Boot: 1 упоминаний
                        Spring: 1 упоминаний
                        React: 1 упоминаний
                        
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }

    @Test
    void testAnalyzeTrendsYearlyGranularity() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ANALYZER.analyzeTrends(JOBS, "2022-01-01", "2023-12-31", Trends.YEARLY);

        assertEquals(
                """
                        Период: 2023
                        Количество вакансий: 4
                        Топ навыков за период:
                        Java: 2 упоминаний
                        JavaScript: 1 упоминаний
                        Spring Boot: 1 упоминаний
                        Spring: 1 упоминаний
                        React: 1 упоминаний
                        
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}