package faang.school.godbless.sprint3.vacancy_analyzer;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataAnalyzerTest {
    private DataAnalyzer analyzer;
    private List<Job> jobList;

    @BeforeEach
    void setUp() {
        analyzer = new DataAnalyzer();
        jobList = List.of(
                new Job(
                        "Java-developer",
                        List.of("Java core", "Spring", "SQL"),
                        250000, "Saint-Petersburg",
                        LocalDate.of(2023, 6, 22)
                ),
                new Job(
                        "Java-developer",
                        List.of("Java core", "Spring", "SQL"),
                        270000, "Moscow",
                        LocalDate.of(2023, 6, 25)
                ),
                new Job(
                        "Junior Java-developer",
                        List.of("Java core", "Spring", "SQL"),
                        130000,
                        "Moscow",
                        LocalDate.of(2023, 6, 23)
                ),
                new Job(
                        "Junior Java-developer",
                        List.of("Java", "Spring", "SQL"),
                        110000,
                        "Kazan",
                        LocalDate.of(2023, 6, 23)
                ),
                new Job(
                        "QA engineer",
                        List.of("Java", "Mockito", "SQL"),
                        160000,
                        "Ekaterinburg",
                        LocalDate.of(2023, 6, 21)
                ),
                new Job(
                        "Project Manager",
                        List.of("Java", "Python", "Git"),
                        200000,
                        "Moscow",
                        LocalDate.of(2023, 6, 25)
                ),
                new Job(
                        "Senior Java-developer",
                        List.of("Java core", "Spring", "SQL", "Multithreading"),
                        345000,
                        "Saint-Petersburg",
                        LocalDate.of(2023, 6, 25)
                ),
                new Job(
                    "Android-developer",
                    List.of("Kotlin", "Git", "SQL", "Docker"),
                        200000,
                        "Samara",
                        LocalDate.of(2023, 6, 25)
                )
        );
    }

    @Test
    void getTopFiveJobSkillsTest() {
        List<String> expected = List.of("SQL", "Spring", "Java core", "Java", "Git");
        assertEquals(expected, analyzer.getTopFiveJobSkills(jobList));
    }

    @Test
    void getTopFiveVacanciesTest() {
        List<String> expected = List.of("Java-developer", "Junior Java-developer", "Senior Java-developer");
        assertEquals(expected, analyzer.getTopThreeVacancies(jobList));
    }

    @Test
    void getSalaryByRangeTest() {
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("0k-49k", 0L);
        expected.put("50k-99k", 0L);
        expected.put("100k-149k", 2L);
        expected.put("150k-199k", 1L);
        expected.put("200k-249k", 2L);
        expected.put("250k-299k", 2L);
        expected.put("300k-349k", 1L);

        assertEquals(expected, analyzer.getSalaryByRange(jobList, 50000, 350000));
    }

    @Test
    void getTopFiveLocationsTest() {
        List<String> expected = List.of("Moscow", "Saint-Petersburg", "Ekaterinburg", "Samara", "Kazan");
        assertEquals(expected, analyzer.getTopFiveLocations(jobList));
    }
}