package faang.school.godbless.BJS2_22852;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataAnalyzerTest {
    private DataAnalyzer dataAnalyzer;
    private List<Job> jobs;

    @BeforeEach
    public void setUp() {
        dataAnalyzer = new DataAnalyzer();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        String json1 = "{\"title\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\"],\"salary\":80000,\"location\":\"New York\",\"datePosted\":\"2024-07-01\"}";
        String json2 = "{\"title\":\"Data Scientist\",\"requirements\":[\"Python\",\"Machine Learning\",\"Data Analysis\"],\"salary\":100000,\"location\":\"San Francisco\",\"datePosted\":\"2024-06-15\"}";
        String json3 = "{\"title\":\"DevOps Engineer\",\"requirements\":[\"AWS\",\"Docker\",\"CI/CD\"],\"salary\":45000,\"location\":\"Seattle\",\"datePosted\":\"2024-07-10\"}";
        String json4 = "{\"title\":\"Software Engineer\",\"requirements\":[\"JavaScript\",\"React\",\"CSS\"],\"salary\":140000,\"location\":\"Austin\",\"datePosted\":\"2024-06-20\"}";
        String json5 = "{\"title\":\"Software Engineer\",\"requirements\":[\"Node.js\",\"Express\",\"Spring\"],\"salary\":75000,\"location\":\"Chicago\",\"datePosted\":\"2024-07-05\"}";
        String json6 = "{\"title\":\"Product Manager\",\"requirements\":[\"Java\",\"Scrum\",\"Communication\"],\"salary\":95000,\"location\":\"Boston\",\"datePosted\":\"2024-06-30\"}";
        String json7 = "{\"title\":\"QA Engineer\",\"requirements\":[\"Spring\",\"Test Automation\",\"Java\"],\"salary\":65000,\"location\":\"Los Angeles\",\"datePosted\":\"2024-07-08\"}";
        String json8 = "{\"title\":\"Product Manager\",\"requirements\":[\"Figma\",\"Adobe XD\",\"User Research\"],\"salary\":72000,\"location\":\"Portland\",\"datePosted\":\"2024-06-25\"}";
        String json9 = "{\"title\":\"Full Stack Developer\",\"requirements\":[\"Java\",\"React\",\"Node.js\"],\"salary\":82000,\"location\":\"Denver\",\"datePosted\":\"2024-07-02\"}";
        String json10 = "{\"title\":\"DevOps Engineer\",\"requirements\":[\"Python\",\"SQL\",\"AWS\"],\"salary\":88000,\"location\":\"New York\",\"datePosted\":\"2024-06-18\"}";
        String json11 = "{\"title\":\"Mobile Developer\",\"requirements\":[\"Swift\",\"AWS\",\"React Native\"],\"salary\":79000,\"location\":\"Miami\",\"datePosted\":\"2024-07-11\"}";
        String json12 = "{\"title\":\"Cloud Architect\",\"requirements\":[\"AWS\",\"Azure\",\"Google Cloud\"],\"salary\":98000,\"location\":\"San Diego\",\"datePosted\":\"2024-06-22\"}";
        String json13 = "{\"title\":\"DevOps Engineer\",\"requirements\":[\"Cybersecurity\",\"Risk Management\",\"Incident Response\"],\"salary\":86000,\"location\":\"Washington, D.C.\",\"datePosted\":\"2024-07-03\"}";
        String json14 = "{\"title\":\"Network Engineer\",\"requirements\":[\"Java\",\"Networking\",\"Spring\"],\"salary\":78000,\"location\":\"Atlanta\",\"datePosted\":\"2024-06-27\"}";
        String json15 = "{\"title\":\"QA Engineer\",\"requirements\":[\"SQL\",\"Data Analysis\",\"Project Management\"],\"salary\":83000,\"location\":\"Dallas\",\"datePosted\":\"2024-07-07\"}";

        jobs = jobStreamProcessor.getJobs(Stream.of(json1, json2, json3, json4, json5, json6, json7, json8, json9, json10, json11, json12, json13, json14, json15));
    }

    @Test
    @DisplayName("Тест метода, который возвращает самые популярные скиллы")
    public void testGetTopSkills() {
        List<String> topSkills = dataAnalyzer.getTopSkills(jobs, 3);
        assertEquals(3, topSkills.size());

        assertEquals(List.of("Java", "AWS", "Spring"), topSkills);
    }

    @Test
    @DisplayName("Тест метода, который возвращает самые популярные вакансии")
    public void testGetTopVacancies() {
        List<String> topVacancies = dataAnalyzer.getTopVacancies(jobs, 5);
        assertEquals(5, topVacancies.size());

        System.out.println(topVacancies);
        assertEquals(List.of("DevOps Engineer", "Software Engineer", "QA Engineer", "Product Manager", "Full Stack Developer"), topVacancies);
    }

    @Test
    @DisplayName("Тест метода, который возвращает данные по категориям зарплат")
    public void testAnalyzeSalaryCategory() {
        List<SalaryCategory> categories = List.of(new SalaryCategory("0-50k", 0, 50000),
                new SalaryCategory("50k-100k", 50000, 100000),
                new SalaryCategory("100k-150k", 100000, 150000),
                new SalaryCategory("150k-200k", 150000, 200000));

        Map<String, Long> salaryCategories = dataAnalyzer.analyzeSalaryCategory(jobs, categories);

        assertNotNull(salaryCategories);

        assertEquals(12, salaryCategories.get("50k-100k"));
    }

    @Test
    @DisplayName("Тест метода, который возвращает самые популярные локации")
    public void testFindMostPopularLocations() {
        List<String> locations = dataAnalyzer.findMostPopularLocations(jobs, 5);

        assertEquals(5, locations.size());

        assertEquals(List.of("New York", "Portland", "Seattle", "Chicago", "Austin"), locations);

    }

    @Test
    @DisplayName("Тест метода, который возвращает анализ тендеций")
    public void testAnalyzeTrends() {
        Map<LocalDate, Long> trends = dataAnalyzer.analyzeTrends(LocalDate.of(2024, 6, 1),
                LocalDate.of(2024, 7, 31), TrendGranularity.WEEKLY, jobs);

        assertNotNull(trends);

        assertEquals(3, trends.get(LocalDate.of(2024, 6, 17)));
    }
}
