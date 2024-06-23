package faang.school.godbless.task_4_analizator;

import faang.school.godbless.sprint_2.stream_API.task_4_analizator.models.Job;
import faang.school.godbless.sprint_2.stream_API.task_4_analizator.scrappers.JsonJobScrapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonJobScrapperTest {
    @Test
    public void testParse(){
        // Arrange
        String position = "backend developer";
        List<String> requirements = List.of("Java","Spring","softSkills");
        int salary = 150000;
        String location = "Russian Federation";
        LocalDate date = LocalDate.of(2024, 6, 21);

        String jsonJob = """
                {
                    "position": "backend developer",
                    "requirements": ["Java","Spring","softSkills"],
                    "salary": 150000,
                    "location": "Russian Federation",
                    "dataAdded": [2024,6,21]
                }
                """;
        JsonJobScrapper scrapper = new JsonJobScrapper();

        // Act
        Job jobFromJson = scrapper.parse(jsonJob);

        // Assert
        assertEquals(position, jobFromJson.position(), "Не совпадают имена при position job из json формата");
        assertEquals(requirements, jobFromJson.requirements(), "Не совпадают requirements при парсинге job из json формата");
        assertEquals(salary, jobFromJson.salary(), "Не совпадают salary при парсинге job из json формата");
        assertEquals(location, jobFromJson.location(), "Не совпадают location при парсинге job из json формата");
        assertEquals(date, jobFromJson.dataAdded(), "Не совпадают date при парсинге job из json формата");
    }


}
