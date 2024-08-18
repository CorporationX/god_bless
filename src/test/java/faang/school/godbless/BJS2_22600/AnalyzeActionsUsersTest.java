package faang.school.godbless.BJS2_22600;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeActionsUsersTest {
    private AnalyzeActionsUsers analyzer;
    private List<UserAction> actions;

    @BeforeEach
    public void setUp() {
        analyzer = new AnalyzeActionsUsers();
        actions = Arrays.asList(
                new UserAction(2, "Petya", ActionType.LIKE, LocalDateTime.now().minusDays(2), ""),
                new UserAction(3, "Masha", ActionType.COMMENT, LocalDateTime.now().minusDays(22), "Nice #post, #wow"),
                new UserAction(4, "Olya", ActionType.POST, LocalDateTime.now().minusDays(42), "Check this out, #like!"),
                new UserAction(1, "Sasha", ActionType.COMMENT, LocalDateTime.now().minusDays(11), "Comment content, nice, #badabum"),
                new UserAction(5, "Marina", ActionType.COMMENT, LocalDateTime.now().minusDays(21), "#wow!"),
                new UserAction(6, "Stepa", ActionType.LIKE, LocalDateTime.now().minusDays(6), ""),
                new UserAction(7, "Andrei", ActionType.POST, LocalDateTime.now().minusDays(70), "Interesting #wow"),
                new UserAction(8, "Misha", ActionType.POST, LocalDateTime.now().minusDays(83), "New post #wow, #badabum"),
                new UserAction(9, "Jenya", ActionType.COMMENT, LocalDateTime.now().minusDays(21), "I #like it"),
                new UserAction(10, "Katya", ActionType.LIKE, LocalDateTime.now().minusDays(10), ""),
                new UserAction(1, "Sasha", ActionType.POST, LocalDateTime.now().minusDays(9), "Must #see, #wow"),
                new UserAction(12, "Lena", ActionType.POST, LocalDateTime.now().minusDays(12), "Post #content #see, #badabum"),
                new UserAction(1, "Sasha", ActionType.COMMENT, LocalDateTime.now().minusDays(9), "Again #see, #wow")
        );
    }

    @Test
    void testFindTopTenUsers() {
        List<Long> topUsers = analyzer.findTopTenUsers(actions);
        assertEquals(10, topUsers.size());
        assertEquals(1L, topUsers.get(0), "Сашка должен быть самым активным");
    }

    @Test
    void testFindTopFiveThemes() {
        List<String> topThemes = analyzer.findTopFiveThemes(actions);
        assertEquals(5, topThemes.size());
        assertEquals("#wow", topThemes.get(0), "#wow - самый популярный хэштег");
    }

    @Test
    void testFindTopThreeUsersByComments() {
        List<Long> topCommentators = analyzer.findTopThreeUsersByComments(actions);
        assertEquals(3, topCommentators.size());
        assertEquals(1L, topCommentators.get(0), "Сашка лучший");
    }

    @Test
    void testFindPercentActions() {
        Map<ActionType, Double> percentActions = analyzer.findPercentActions(actions);
        assertNull(percentActions.get(ActionType.SHARE));
        assertEquals(38.5, percentActions.get(ActionType.COMMENT), 0.1);
    }
}