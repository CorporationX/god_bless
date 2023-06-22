package faang.school.godbless.secondSprint.ActivityAnalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ActivityAnalyzerTest {
    List<UserAction> actions;
    ActivityAnalyzer activityAnalyzer;

    @BeforeEach
    public void setUp() {
        activityAnalyzer = new ActivityAnalyzer();
        actions = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            actions.add(new UserAction(1, "Pasha", ActionType.COMMENT,
                    LocalDate.of(2023, 5, 15), "#1"));
            if (i < 10) {
                actions.add(new UserAction(2, "Dima", ActionType.COMMENT,
                        LocalDate.of(2023, 6, 22), "#2"));
            }
            if (i < 9) {
                actions.add(new UserAction(3, "Ilya", ActionType.COMMENT,
                        LocalDate.of(2023, 6, 22), "#3"));
            }
            if (i < 8) {
                actions.add(new UserAction(4, "Maks", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#4"));
            }
            if (i < 7) {
                actions.add(new UserAction(5, "Sergey", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#5"));
            }
            if (i < 6) {
                actions.add(new UserAction(6, "Kolya", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#6"));
            }
            if (i < 5) {
                actions.add(new UserAction(7, "Anton", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#7"));
            }
            if (i < 4) {
                actions.add(new UserAction(8, "Rinat", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#8"));
            }
            if (i < 3) {
                actions.add(new UserAction(9, "Igor", ActionType.COMMENT,
                        LocalDate.of(2023, 6, 22), "#9"));
            }
            if (i < 2) {
                actions.add(new UserAction(10, "Nikita", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#10"));
            }
            if (i < 1) {
                actions.add(new UserAction(11, "Sasha", ActionType.POST,
                        LocalDate.of(2023, 6, 22), "#11"));
            }
        }
    }

    @Test
    public void testFindMostActiveUsers() {
        List<String> result = activityAnalyzer.findMostActiveUsers(actions);
        List<String> expected = List.of("Pasha", "Dima", "Ilya", "Maks", "Sergey", "Kolya", "Anton", "Rinat", "Igor",
                "Nikita");

        assertEquals(expected, result);
    }

    @Test
    public void testFindMostPopularTopic() {
        List<String> result = activityAnalyzer.findMostPopularTopic(actions);
        List<String> expected = List.of("#1", "#2", "#3", "#4", "#5");

        assertEquals(expected, result);
    }

    @Test
    public void testFindMostActiveCommentator() {
        List<String> result = activityAnalyzer.findMostActiveCommentator(actions);
        List<String> expected = List.of("Dima", "Ilya", "Igor");

        assertEquals(expected, result);
    }

    @Test
    public void testCalculatePercentOfEachActions() {
        Map<ActionType, Double> result = activityAnalyzer.calculatePercentOfEachActions(actions);
        Map<ActionType, Double> expected = Map.of(ActionType.COMMENT, 50.0, ActionType.POST, 50.0);

        assertEquals(expected, result);
    }
}