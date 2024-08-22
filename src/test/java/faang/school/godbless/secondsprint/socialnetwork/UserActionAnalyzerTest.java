package faang.school.godbless.secondsprint.socialnetwork;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserActionAnalyzerTest {
    private List<UserAction> actions;

    @BeforeEach
    public void setUp() {
        actions = List.of(
                new UserAction(1L, "Alice", "post", LocalDateTime.now().minusDays(34),
                        "#FAANG some text #Java #Memes"),
                new UserAction(2L, "Bob", "post", LocalDateTime.now().minusDays(4),
                        "some text #Java #Memes"),
                new UserAction(2L, "Bob", "share", LocalDateTime.now().minusDays(1),
                        "#Bootcamp some text #Java #Humor"),
                new UserAction(3L, "Charlie", "comment", LocalDateTime.now().minusDays(6),
                        "#FAANG some text"),
                new UserAction(3L, "Charlie", "comment", LocalDateTime.now().minusDays(13),
                        "some text #Java"),
                new UserAction(7L, "John", "comment", LocalDateTime.now().minusDays(6),
                        "some text #Java"),
                new UserAction(4L, "David", "comment", LocalDateTime.now().minusDays(14),
                        "#Bootcamp some text"),
                new UserAction(4L, "David", "comment", LocalDateTime.now().minusDays(17),
                        "#Bootcamp some text"),
                new UserAction(4L, "David", "comment", LocalDateTime.now().minusDays(11),
                        "some text"),
                new UserAction(5L, "Eve", "share", LocalDateTime.now().minusDays(14),
                        "#Bootcamp some text #Java some text #Coding"),
                new UserAction(5L, "Eve", "like", LocalDateTime.now().minusDays(12),
                        "some text #Java #Coding"),
                new UserAction(6L, "Frank", "like", LocalDateTime.now().minusDays(35),
                        "some text #Bootcamp some text #Java")
        );
    }

    @Test
    @DisplayName("Should correctly find top active users from list of actions")
    void testGetTopTenActiveUsers() {
        List<String> topUsers = UserActionAnalyzer.getTopActiveUsers(actions);

        assertAll(
                () -> assertNotNull(topUsers),
                () -> assertEquals(7, topUsers.size()),
                () -> assertEquals("David (id:4)", topUsers.get(0)),
                () -> assertEquals("Bob (id:2)", topUsers.get(3))
        );
    }

    @Test
    @DisplayName("Should correctly find top five hashtags from list of actions")
    void testGetTopHashtags() {
        List<String> topHashtags = UserActionAnalyzer.getTopHashtags(actions);

        assertAll(
                () -> assertNotNull(topHashtags),
                () -> assertEquals(5, topHashtags.size()),
                () -> assertEquals("#java", topHashtags.get(0)),
                () -> assertEquals("#faang", topHashtags.get(3))
        );
    }

    @Test
    @DisplayName("Should correctly find top three commenters over a month period")
    void testGetTopCommentersLastMonth() {
        List<String> expectedList = List.of("David (id:4)", "Charlie (id:3)", "John (id:7)");
        List<String> topCommenters = UserActionAnalyzer.getTopCommentersLastMonth(actions);

        assertAll(
                () -> assertNotNull(topCommenters),
                () -> assertEquals(3, topCommenters.size()),
                () -> assertEquals(expectedList, topCommenters)
        );
    }

    @Test
    @DisplayName("Should correctly find percentages of actions")
    void testGetActionTypePercentages() {
        Map<String, Double> actionPercentages = UserActionAnalyzer.getActionTypePercentages(actions);

        assertAll(
                () -> assertNotNull(actionPercentages),
                () -> assertEquals(4, actionPercentages.size()),
                () -> assertTrue(actionPercentages.get("post").equals(actionPercentages.get("like"))
                        && actionPercentages.get("like").equals(actionPercentages.get("share"))),
                () -> assertEquals(50.0, actionPercentages.get("comment"))
        );
    }
}
