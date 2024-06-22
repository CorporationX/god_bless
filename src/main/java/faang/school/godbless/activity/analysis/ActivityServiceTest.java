package faang.school.godbless.activity.analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ActivityServiceTest {

    ActivityService activityService;
    List<UserAction> actions;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService();

        actions = Arrays.asList(
                new UserAction(1L, "Alice", "post", LocalDate.now(), "Content 1"),
                new UserAction(1L, "Alice", "comment", LocalDate.now(), "Content 1"),
                new UserAction(1L, "Alice", "comment", LocalDate.now(), "Content 1"),
                new UserAction(2L, "Bob", "like", LocalDate.now(), "Content 1"),
                new UserAction(2L, "Bob", "post", LocalDate.now(), "Content 2"),
                new UserAction(2L, "Bob", "comment", LocalDate.now(), "Content 2"),
                new UserAction(3L, "Charlie", "share", LocalDate.now(), "Content 2"),
                new UserAction(3L, "Charlie", "comment", LocalDate.now(), "Content 2"),
                new UserAction(3L, "Charlie", "like", LocalDate.now(), "Content 2"),
                new UserAction(3L, "Charlie", "comment", LocalDate.now(), "Content 2"),
                new UserAction(4L, "David", "post", LocalDate.now(), "Content 2"),
                new UserAction(4L, "David", "comment", LocalDate.now(), "Content 2"),
                new UserAction(5L, "Eve", "comment", LocalDate.now(), "Content 2"),
                new UserAction(5L, "Eve", "post", LocalDate.now(), "Content 3"),
                new UserAction(5L, "Eve", "share", LocalDate.now(), "Content 3"),
                new UserAction(6L, "Frank", "like", LocalDate.now(), "Content 3"),
                new UserAction(6L, "Frank", "post", LocalDate.now(), "Content 3"),
                new UserAction(6L, "Frank", "comment", LocalDate.now(), "Content 3"),
                new UserAction(6L, "Frank", "comment", LocalDate.now(), "Content 3"),
                new UserAction(7L, "Grace", "share", LocalDate.now(), "Content 4"),
                new UserAction(7L, "Grace", "post", LocalDate.now(), "Content 4"),
                new UserAction(7L, "Grace", "comment", LocalDate.now(), "Content 4"),
                new UserAction(7L, "Grace", "like", LocalDate.now(), "Content 4"),
                new UserAction(8L, "Hank", "post", LocalDate.now(), "Content 4"),
                new UserAction(8L, "Hank", "comment", LocalDate.now(), "Content 4"),
                new UserAction(9L, "Ivy", "like", LocalDate.now(), "Content 5"),
                new UserAction(9L, "Ivy", "post", LocalDate.now(), "Content 5"),
                new UserAction(10L, "Jack", "share", LocalDate.now(), "Content 5"),
                new UserAction(11L, "Ken", "comment", LocalDate.now(), "Content 6"),
                new UserAction(11L, "Ken", "like", LocalDate.now(), "Content 6"),
                new UserAction(11L, "Ken", "comment", LocalDate.now(), "Content 6"),
                new UserAction(12L, "Laura", "comment", LocalDate.now(), "Content 7")
        );
    }

    @Test
    @DisplayName("Тест топ 10 активных пользователей")
    void testGetTop10ActiveUsers() {
        List<Long> top10Users = activityService.findTopTenActiveUsers(actions);

        List<Long> expectedTop10Users = Arrays.asList(3L, 6L, 7L, 1L, 2L, 5L, 11L, 4L, 8L, 9L);

        assertEquals(expectedTop10Users, top10Users);
    }

    @Test
    @DisplayName("Топ 5 наиболее попудярныъ тем обсуэжений")
    void testGetTopFiveContent() {
        List<String> expectedContent = List.of("Content 2", "Content 3", "Content 4", "Content 1", "Content 5");

        List<String> topFiveContent = activityService.getTopFiveContent(actions);

        assertEquals(expectedContent, topFiveContent);
    }

    @Test
    @DisplayName("Топ три пользователя по комментариям")
    void testTopThreeUsersByComment() {
        List<Long> expectedTopUsers = List.of(1L, 3L, 6L);

        List<Long> topUsers = activityService.topThreeUsersByComment(actions);

        assertEquals(expectedTopUsers, topUsers);
    }

    @Test
    @DisplayName("Процент действий для каждлго типа действий")
    void testGetActionTypePercentage() {
        Map<String, Double> expectedResult = Map.of("post", 25.0, "comment", 43.75, "like", 18.75, "share", 12.5);

        Map<String, Double> result = activityService.getActionTypePercentage(actions);

        assertEquals(expectedResult.get("post"), result.get("post"));
        assertEquals(expectedResult.get("comment"), result.get("comment"));
        assertEquals(expectedResult.get("like"), result.get("like"));
        assertEquals(expectedResult.get("share"), result.get("share"));
    }
}