package VacancyAnalyzer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.VacancyAnalyzer.DataAnalyzer.mostPopularSkills;
import static faang.school.godbless.VacancyAnalyzer.DataAnalyzer.mostPopularTitles;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
            "'location': 'Moscow'," +
            "'createdAt': '2023-06-13'" +
            "}";
    String job3 = "{" +
            "'title': 'C# Developer'," +
            "'requirements': [" +
            "'SQL'," +
            "'C#'" +
            "]," +
            "'salary': 1000," +
            "'location': 'Paris'," +
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
            "'location': 'Saint-Petersburg'," +
            "'createdAt': '2023-06-11'" +
            "}";
    List<String> list = List.of(job1, job2, job3, job4, job5);

    @Test
    void mostPopularSkillsTest() {
        List<String> result = mostPopularSkills(list);

        assertEquals("SQL", result.get(0));
    }

    @Test
    void mostPopularTitlesTest(){
        List<String> result = mostPopularTitles(list);

        assertEquals("Developer", result.get(0));
    }
}
