package faang.school.godbless.user_activity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static faang.school.godbless.user_activity.StatsAnalyzer.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StatsAnalyzerTest {

    List<UserAction> userActions = List.of(
            new UserAction(1L, "user1", "Content 1 #newPost#tech#innovation#coding", ActionType.POST, LocalDate.of(2024, 1, 10)),  // POST (1)
            new UserAction(2L, "user1", "Content 2 #update#java#springboot#backend", ActionType.POST, LocalDate.of(2024, 2, 15)),  // POST (2)
            new UserAction(3L, "user1", "Content 3 #announcement#webdev#opensource#community", ActionType.POST, LocalDate.of(2024, 3, 20)),  // POST (3)
            new UserAction(4L, "user2", "Content 4 #review#feedback#improvement#comments", ActionType.COMMENT, LocalDate.of(2024, 8, 1)),  // COMMENT (1)
            new UserAction(5L, "user2", "Content 5 #discussion#opinion#thoughts#insights", ActionType.COMMENT, LocalDate.of(2024, 8, 10)), // COMMENT (2)
            new UserAction(6L, "user2", "Content 6 #questions#debate#viewpoint#interaction", ActionType.COMMENT, LocalDate.of(2024, 8, 16)), // COMMENT (3)
            new UserAction(7L, "user3", "Content 7", ActionType.LIKE, LocalDate.of(2024, 7, 12)),  // LIKE (1)
            new UserAction(8L, "user3", "Content 8", ActionType.LIKE, LocalDate.of(2024, 8, 1)),  // LIKE (2)
            new UserAction(9L, "user3", "Content 9", ActionType.LIKE, LocalDate.of(2024, 8, 16)), // LIKE (3)
            new UserAction(10L, "user4", "Content 10", ActionType.SHARE, LocalDate.of(2024, 3, 8)),  // SHARE (1)
            new UserAction(11L, "user4", "Content 11", ActionType.SHARE, LocalDate.of(2024, 5, 14)),  // SHARE (2)
            new UserAction(12L, "user4", "Content 12", ActionType.SHARE, LocalDate.of(2024, 7, 21)),  // SHARE (3)
            new UserAction(13L, "user5", "Content 13 #technews#update#announcement#trending", ActionType.POST, LocalDate.of(2024, 8, 7)), // POST (4)
            new UserAction(14L, "user6", "Content 14 #insights#feedback#discussion#learning", ActionType.COMMENT, LocalDate.of(2024, 8, 12)), // COMMENT (4)
            new UserAction(15L, "user7", "Content 15", ActionType.LIKE, LocalDate.of(2024, 6, 19)),  // LIKE (4)
            new UserAction(16L, "user8", "Content 16", ActionType.SHARE, LocalDate.of(2024, 2, 22)),  // SHARE (4)
            new UserAction(17L, "user9", "Content 17 #breakingnews#announcement#latestupdate#official", ActionType.POST, LocalDate.of(2024, 8, 3)), // POST (5)
            new UserAction(18L, "user10", "Content 18 #feedback#review#questions#interaction", ActionType.COMMENT, LocalDate.of(2024, 8, 14)), // COMMENT (5)
            new UserAction(19L, "user11", "Content 19", ActionType.LIKE, LocalDate.of(2024, 5, 9)),  // LIKE (5)
            new UserAction(20L, "user12", "Content 20", ActionType.LIKE, LocalDate.of(2024, 7, 17)),  // LIKE (6)
            new UserAction(21L, "user13", "Content 21", ActionType.LIKE, LocalDate.of(2024, 7, 19)),  // LIKE (7)
            new UserAction(22L, "user14", "Content 22 #news#events#latest#breaking", ActionType.POST, LocalDate.of(2024, 7, 27)),  // POST (6)
            new UserAction(23L, "user15", "Content 23 #review#thoughts#discussion#interaction", ActionType.COMMENT, LocalDate.of(2024, 8, 14)),  // COMMENT (6)
            new UserAction(24L, "user16", "Content 24", ActionType.SHARE, LocalDate.of(2024, 6, 18))  // SHARE (5)
    );


    @Test
    public void testTop10ActiveUsers() {
        assertEquals(List.of("user1", "user14", "user9", "user5"), top10UsersByAction(userActions, ActionType.POST));
        assertEquals(List.of("user2", "user10", "user15", "user6"), top10UsersByAction(userActions, ActionType.COMMENT));
        assertEquals(List.of("user3", "user11", "user13", "user12", "user7"), top10UsersByAction(userActions, ActionType.LIKE));
        assertEquals(List.of("user4", "user16", "user8"), top10UsersByAction(userActions, ActionType.SHARE));
    }

    @Test
    public void testTop5ActiveHashtags() {
        assertEquals(List.of("discussion", "feedback", "review", "announcement", "interaction"),
                top5HashtagsInPostsComments(userActions)
        );
    }

    @Test
    public void testTop3UsersByPostsCommentsLastMonth() {
        assertEquals(List.of("user2", "user10", "user15"), top3UsersByCommentsLastMonth(userActions));
    }

    @Test
    public void testActionPercentage() {
        assertEquals(25.0, actionPercentage(userActions, ActionType.POST, 1));
        assertEquals(25.00, actionPercentage(userActions, ActionType.COMMENT, 2));
        assertEquals(29.167, actionPercentage(userActions, ActionType.LIKE, 3));
        assertEquals(20.8333, actionPercentage(userActions, ActionType.SHARE, 4));

        assertThrows(IllegalArgumentException.class, () -> actionPercentage(userActions, ActionType.POST, 5));
    }
}
