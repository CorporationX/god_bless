package faang.school.godbless.sprint_2.user_activity_analysis;

import faang.school.godbless.sprint_2.user_activity_analysis.ActionType;
import faang.school.godbless.sprint_2.user_activity_analysis.Main;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findTopUsersByActions() {
        List<Integer> result = Main.findTopUsersByActions(Main.getUserActions(), 10);
        List<Integer> expectedResult = List.of(1, 3, 4, 6, 10, 2, 5, 7, 72, 8);
        assertEquals(result, expectedResult);
    }

    @Test
    void findTopFiveTopics() {
        List<String> result = Main.findTopFiveTopics(Main.getUserActions());
        List<String> expectedResult = List.of("#test6", "#test3", "#test5");
        assertEquals(result, expectedResult);
    }

    @Test
    void findTopThreeUsersByCountCommentedLastMonth() {
        List<Integer> result = Main.findTopThreeUsersByCountCommentedLastMonth(Main.getUserActions());
        List<Integer> expectedResult = List.of(1, 2, 4);
        assertEquals(result, expectedResult);
    }

    @Test
    void getStatisticsForUserActions() {
        Map<ActionType, Double> result = Main.getStatisticsForUserActions(Main.getUserActions());
        Map<ActionType, Double> expectedResult = Map.of(
                ActionType.COMMENT, 33.33,
                ActionType.LIKE, 23.81,
                ActionType.SHARE, 23.81,
                ActionType.POST, 19.05);
        assertEquals(result, expectedResult);
    }
}