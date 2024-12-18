package school.faang.sprint_2.task_47125;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActionsProcessorTest {
    List<UserAction> actions = UserActionData.data;
    private UserActionsProcessor userActionsProcessor = new UserActionsProcessor();

    @Test
    void testMostActiveUsersBaseCase() {
        var expect = List.of(1, 2, 3, 4, 5);

        var actual = userActionsProcessor.topMostActiveUsers(actions, 10);

        assertEquals(expect, actual);
    }

    @Test
    void testMostActiveUsersEmptyList() {
        var expect = List.of();

        var actual = userActionsProcessor.topMostActiveUsers(new ArrayList<>(), 10);

        assertEquals(expect, actual);
    }

    @Test
    void testMostActiveHashtagsBaseCase() {
        var expect = List.of("update", "feature", "conference");

        var actual = userActionsProcessor.topMostActiveHashtags(actions, 3);

        assertEquals(expect, actual);
    }

    @Test
    void testMostActiveHashtagsEmpty() {
        var expect = List.of();

        var actual = userActionsProcessor.topMostActiveHashtags(List.of(), 3);

        assertEquals(expect, actual);
    }

    @Test
    void testTopActiveCommentatorsInMonthBaseCase() {
        var expect = List.of(2, 3, 1);

        var actual = userActionsProcessor.topActiveCommentatorsInMonth(actions, 3);

        assertEquals(expect, actual);
    }

    @Test
    void testTopActiveCommentatorsInMonthEmpty() {
        var expect = List.of();

        var actual = userActionsProcessor.topActiveCommentatorsInMonth(List.of(), 3);

        assertEquals(expect, actual);
    }

    @Test
    void testProcessPercentForActionTypeBaseCase() {
        var expect = new HashMap<ActionType, Integer>();
        expect.put(ActionType.POST, 26);
        expect.put(ActionType.LIKE, 26);
        expect.put(ActionType.SHARE, 20);
        expect.put(ActionType.COMMENT, 26);

        var actual = userActionsProcessor.processPercentForActionType(actions);

        assertEquals(expect, actual);
    }
}
