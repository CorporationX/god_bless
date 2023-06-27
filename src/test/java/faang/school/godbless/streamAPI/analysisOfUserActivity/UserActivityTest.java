package faang.school.godbless.streamAPI.analysisOfUserActivity;

import faang.school.godbless.streamAPI.analysisOfUserActivity.ActionType;
import faang.school.godbless.streamAPI.analysisOfUserActivity.UserAction;
import faang.school.godbless.streamAPI.analysisOfUserActivity.UserActivity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserActivityTest {
    private UserActivity userActivity;
    private List<UserAction> userActivities = List.of(
            new UserAction("2", "Sveta", ActionType.COMMENT, LocalDate.of(2023, 6, 25), "cool"),
            new UserAction("2", "Sveta", ActionType.POST, LocalDate.of(2023, 6, 25), "#nice"),
            new UserAction("2", "Sveta", ActionType.COMMENT, LocalDate.of(2023, 6, 25), "note #content"),
            new UserAction("2", "Sveta", ActionType.LIKE, LocalDate.of(2023, 6, 25), "akj #like"),
            new UserAction("3", "Petr", ActionType.COMMENT, LocalDate.of(2023, 6, 19), "#nice"),
            new UserAction("3", "Petr", ActionType.LIKE, LocalDate.of(2023, 6, 19), "like"),
            new UserAction("3", "Petr", ActionType.COMMENT, LocalDate.of(2023, 6, 19), "content1"),
            new UserAction("3", "Petr", ActionType.COMMENT, LocalDate.of(2023, 6, 19), "content2"),
            new UserAction("4", "Bob", ActionType.POST, LocalDate.of(2023, 3, 11), "agaglj #go sgeg"),
            new UserAction("4", "Bob", ActionType.COMMENT, LocalDate.of(2023, 3, 19), "check"),
            new UserAction("4", "Bob", ActionType.COMMENT, LocalDate.of(2023, 3, 19), "check"),
            new UserAction("4", "Bob", ActionType.COMMENT, LocalDate.of(2023, 3, 19), "check"),
            new UserAction("4", "Bob", ActionType.COMMENT, LocalDate.of(2023, 3, 19), "check"),
            new UserAction("4", "Bob", ActionType.LIKE, LocalDate.of(2023, 3, 19), "check"),
            new UserAction("1", "Egor", ActionType.COMMENT, LocalDate.now(), "hello mir #go #content"),
            new UserAction("1", "Egor", ActionType.LIKE, LocalDate.now(), "just like"),
            new UserAction("1", "Egor", ActionType.POST, LocalDate.now(), "#go #content"),
            new UserAction("1", "Egor", ActionType.COMMENT, LocalDate.now(), "hello mir #go"),
            new UserAction("1", "Egor", ActionType.COMMENT, LocalDate.now(), "#bootcamp")
    );

    @BeforeEach
    public void before() {
        this.userActivity = new UserActivity();
    }

    @Test
    public void testTopMostActiveUsers() {
        List<String> users = userActivity.getTopMostActiveUsers(userActivities);
        List<String> expected = List.of("4", "1");
        assertEquals(expected, users);
    }

    @Test
    public void testTopMostPopularDiscussion() {
        List<String> discussions = userActivity.getTopMostPopularDiscussion(userActivities);
        List<String> expected = List.of("#go", "#content", "#nice");
        assertEquals(expected, discussions);
    }

    @Test
    public void testTopMostActiveUsersByComments() {
        List<String> users = userActivity.getTopMostActiveUsersByComments(userActivities);
        List<String> expected = List.of("1", "3");
        assertEquals(expected, users);
    }

    @Test
    public void testActivityPercentage() {
        Map<ActionType, Double> map = userActivity.getActivityPercentage(userActivities);
        double expectedComments = 12.0 * 100 / 19;
        double expectedShare = 0.0;
        double expectedPost = 3.0 * 100 / 19;
        double expectedLike = 4.0 * 100 / 19;

        assertEquals(expectedComments, map.get(ActionType.COMMENT));
        assertEquals(expectedShare, map.get(ActionType.SHARE));
        assertEquals(expectedPost, map.get(ActionType.POST));
        assertEquals(expectedLike, map.get(ActionType.LIKE));
    }
}