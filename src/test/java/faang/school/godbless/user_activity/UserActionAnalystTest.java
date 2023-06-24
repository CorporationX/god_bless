package faang.school.godbless.user_activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActionAnalystTest {

    private List<UserAction> userActions;
    private UserActionAnalyst actionAnalyst;

    @BeforeEach
    void setUp() {
        actionAnalyst = new UserActionAnalyst();

        userActions = List.of(new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 6, 24, 0, 0), "#1"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 3, 30, 0, 0), "#1"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 6, 14, 0, 0), "blabla #5 blablabal"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 5, 24, 0, 0), "#2"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 6, 3, 0, 0), "#4"),
                new UserAction(10, "Grigory", ActionType.SHARE, LocalDateTime.of(2023, 1, 23, 0, 0), "#8"),
                new UserAction(10, "Grigory", ActionType.LIKE, LocalDateTime.of(2023, 6, 6, 0, 0), "#7"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2022, 6, 16, 0, 0), "#1"),
                new UserAction(10, "Grigory", ActionType.COMMENT, LocalDateTime.of(2023, 5, 3, 0, 0), "#5"),
                new UserAction(10, "Grigory", ActionType.LIKE, LocalDateTime.of(2023, 2, 15, 0, 0), "blblasdbv #1"),
                new UserAction(2, "John", ActionType.COMMENT, LocalDateTime.of(2023, 5, 29, 0, 0), "#2"),
                new UserAction(2, "Alice", ActionType.COMMENT, LocalDateTime.of(2023, 3, 29, 0, 0), "#5"),
                new UserAction(2, "Alice", ActionType.LIKE, LocalDateTime.of(2023, 4, 30, 0, 0), "#2 blablabla \n blabla"),
                new UserAction(2, "Alice", ActionType.COMMENT, LocalDateTime.of(2023, 3, 26, 0, 0), "#3"),
                new UserAction(3, "Alice", ActionType.COMMENT, LocalDateTime.of(2023, 6, 1, 0, 0), "#3"),
                new UserAction(3, "John", ActionType.COMMENT, LocalDateTime.of(2023, 5, 5, 0, 0), "#3"),
                new UserAction(3, "John", ActionType.COMMENT, LocalDateTime.of(2023, 5, 22, 0, 0), "#6"),
                new UserAction(4, "Nick", ActionType.SHARE, LocalDateTime.of(2023, 1, 23, 0, 0), "#8"),
                new UserAction(4, "Nick", ActionType.COMMENT, LocalDateTime.of(2023, 6, 7, 0, 0), "#4"),
                new UserAction(5, "Julia", ActionType.COMMENT, LocalDateTime.of(2023, 5, 29, 0, 0), "#3"),
                new UserAction(5, "Julia", ActionType.COMMENT, LocalDateTime.of(2023, 6, 11, 0, 0), "#3"),
                new UserAction(6, "Carl", ActionType.LIKE, LocalDateTime.of(2023, 6, 3, 0, 0), "#3"),
                new UserAction(7, "Mike", ActionType.COMMENT, LocalDateTime.of(2023, 4, 3, 0, 0), "#2"),
                new UserAction(8, "Peter", ActionType.COMMENT, LocalDateTime.of(2023, 5, 3, 0, 0), "#5"),
                new UserAction(9, "Monica", ActionType.COMMENT, LocalDateTime.of(2023, 5, 3, 0, 0), "#7"),
                new UserAction(11, "Tomas", ActionType.LIKE, LocalDateTime.of(2023, 6, 3, 0, 0), "#1"),
                new UserAction(12, "Filip", ActionType.COMMENT, LocalDateTime.of(2023, 2, 3, 0, 0), "#2"),
                new UserAction(16, "Alexander", ActionType.COMMENT, LocalDateTime.of(2023, 4, 3, 0, 0), "#1"),
                new UserAction(13, "Mark", ActionType.LIKE, LocalDateTime.of(2023, 3, 3, 0, 0), "#1"),
                new UserAction(14, "Derek", ActionType.COMMENT, LocalDateTime.of(2023, 6, 3, 0, 0), "#5"),
                new UserAction(15, "Jose", ActionType.COMMENT, LocalDateTime.of(2023, 6, 3, 0, 0), "#3"),
                new UserAction(1, "Jenifer", ActionType.COMMENT, LocalDateTime.of(2023, 6, 3, 0, 0), "#4"));
    }

    @Test
    void testFindTop10ActiveUsers() {
        List<Integer> actualOutput = actionAnalyst.findTop10ActiveUsers(userActions);
        List<Integer> expectedOutput = List.of(10, 2, 3, 4, 5, 1, 6, 7, 8, 9);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFindTop5PopularTopics(){
        List<String> actualOutput = actionAnalyst.findTop5PopularTopics(userActions);
        List<String> expectedOutput = List.of("#3","#1","#5","#2","#4");

        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testFindTop3UsersWithMostCommentsLastMonth(){
        List<Integer> actualOutput = actionAnalyst.findTop3UsersWithMostCommentsLastMonth(userActions);
        List<Integer> expectedOutput = List.of(10,5,1);

        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testCalculateActionTypePercentages(){
        Map<String,Double> actualOutput = actionAnalyst.calculateActionTypePercentages(userActions);
        Map<String, Double> expectedOutput = Map.of("like", 18.75, "share", 6.25, "comment",75.0);

        assertEquals(expectedOutput,actualOutput);
    }


}

