package school.faang.sprint2.task_BJS2_58200;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserActionAnalyzerTest {
    private final UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();
    private final List<UserAction> userActions = List.of(
            new UserAction(0, "Vasya", ActionType.COMMENT, LocalDate.now().minusYears(1), "#cont"),
            new UserAction(0, "Vasya", ActionType.SHARE, LocalDate.now().minusDays(8), "#content"),
            new UserAction(1, "Petya", ActionType.SHARE, LocalDate.now().minusMonths(1), "content"),
            new UserAction(2, "Kolya", ActionType.POST, LocalDate.now().minusWeeks(2), "#cont"),
            new UserAction(2, "Kolya", ActionType.POST, LocalDate.now(), "content")
    );

    @Test
    public void getTopMostActiveUsers() {
        List<Integer> excepted = List.of(0, 2, 1);
        assertEquals(excepted, userActionAnalyzer.getTopMostActiveUsers(userActions, 3));
    }

    @Test
    public void getTopMostPopularTopics() {
        List<String> excepted = List.of("#cont");
        assertEquals(excepted, userActionAnalyzer.getTopMostPopularTopics(userActions, 1));
    }

    @Test
    public void getUsersByMostCommentsInMonth() {
        List<Integer> excepted = List.of(2, 0);
        assertEquals(excepted, userActionAnalyzer.getUsersByMostCommentsInMonth(userActions, 3));
    }

    @Test
    public void getActionTypePercent() {
        Map<ActionType, Double> excepted = Map.of(ActionType.SHARE, 40.0, ActionType.POST, 40.0,
                ActionType.COMMENT, 20.0, ActionType.LIKE, 0.0);
        assertEquals(excepted, userActionAnalyzer.getActionTypePercent(userActions));
    }
}