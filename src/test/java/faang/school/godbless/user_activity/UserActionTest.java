package faang.school.godbless.user_activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserActionTest {

    private List<UserAction> actions;

    @BeforeEach
    public void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date lastMonth = cal.getTime();

        actions = List.of(
                new UserAction("1", "Alice", ActionType.POST, new Date(), "Hello #java"),
                new UserAction("1", "Alice", ActionType.COMMENT, new Date(), "Great post! #java"),
                new UserAction("1", "Alice", ActionType.COMMENT, lastMonth, "Nice work!"),
                new UserAction("2", "Bob", ActionType.LIKE, new Date(), ""),
                new UserAction("2", "Bob", ActionType.REPOST, new Date(), "Nice!"),
                new UserAction("2", "Bob", ActionType.COMMENT, new Date(), "I agree!"),
                new UserAction("2", "Bob", ActionType.COMMENT, new Date(), "Well said!"),
                new UserAction("3", "Charlie", ActionType.POST, new Date(), "#java is awesome"),
                new UserAction("3", "Charlie", ActionType.COMMENT, new Date(), "#coding"),
                new UserAction("3", "Charlie", ActionType.LIKE, new Date(), ""),
                new UserAction("3", "Charlie", ActionType.COMMENT, new Date(), "Thanks for sharing"),
                new UserAction("3", "Charlie", ActionType.COMMENT, new Date(), "Interesting..."),
                new UserAction("4", "Dave", ActionType.POST, new Date(), "#java #spring"),
                new UserAction("5", "Eve", ActionType.POST, new Date(), "#coding is fun"),
                new UserAction("5", "Eve", ActionType.COMMENT, new Date(), "Awesome! #coding"),
                new UserAction("6", "Frank", ActionType.REPOST, new Date(), "#development"),
                new UserAction("6", "Frank", ActionType.LIKE, new Date(), ""),
                new UserAction("6", "Frank", ActionType.POST, new Date(), "#java #coding #development")
        );
    }

    @Test
    public void testTopUsers() {
        List<String> topUsers = UserAction.topUsers(actions);
        assertEquals(List.of("3", "2", "1", "6", "5", "4"), topUsers);
    }

    @Test
    public void testTopTopics() {
        List<String> topTopics = UserAction.topTopics(actions);
        assertEquals(List.of("java", "coding", "development", "spring"), topTopics);
    }

    @Test
    public void testTopCommenters() {
        List<String> topCommenters = UserAction.topCommenters(actions);
        assertEquals(List.of("3", "1", "2"), topCommenters);
    }

    @Test
    public void testActivityPortion() {
        Map<ActionType, Double> activityPortion = UserAction.activityPortion(actions);

        assertEquals(27.77, activityPortion.get(ActionType.POST), 0.1);
        assertEquals(44.44, activityPortion.get(ActionType.COMMENT), 0.1);
        assertEquals(16.66, activityPortion.get(ActionType.LIKE), 0.1);
        assertEquals(11.11, activityPortion.get(ActionType.REPOST), 0.1);
    }
}