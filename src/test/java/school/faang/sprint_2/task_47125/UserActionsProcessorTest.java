package school.faang.sprint_2.task_47125;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActionsProcessorTest {
    LocalDate stub = LocalDate.of(2024, 12, 1);
    List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.POST, stub, "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", ActionType.COMMENT, stub, "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.LIKE, stub, ""),
            new UserAction(3, "Charlie", ActionType.SHARE, stub, ""),
            new UserAction(4, "Dave", ActionType.POST, stub, "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.LIKE, stub, ""),
            new UserAction(3, "Charlie", ActionType.POST, stub, "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.COMMENT, stub, "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.LIKE, stub, ""),
            new UserAction(2, "Bob", ActionType.COMMENT, stub, "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.POST, stub, "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, stub, "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.LIKE, stub, ""),
            new UserAction(4, "Dave", ActionType.SHARE, stub, ""),
            new UserAction(2, "Bob", ActionType.POST, stub, "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.SHARE, stub, ""),
            new UserAction(5, "Eve", ActionType.COMMENT, stub, "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.LIKE, stub, ""),
            new UserAction(4, "Dave", ActionType.COMMENT, stub, "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.SHARE, stub, ""),
            new UserAction(1, "Alice", ActionType.POST, stub, "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, stub, "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.LIKE, stub, ""),
            new UserAction(4, "Dave", ActionType.POST, stub, "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.COMMENT, stub, "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.LIKE, stub, ""),
            new UserAction(3, "Charlie", ActionType.SHARE, stub, ""),
            new UserAction(5, "Eve", ActionType.POST, stub, "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.LIKE, stub, ""),
            new UserAction(1, "Alice", ActionType.COMMENT, stub, "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.SHARE, stub, ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, stub, "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.LIKE, stub, ""),
            new UserAction(4, "Dave", ActionType.SHARE, stub, ""),
            new UserAction(1, "Alice", ActionType.POST, stub, "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.LIKE, stub, ""),
            new UserAction(3, "Charlie", ActionType.POST, stub, "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.COMMENT, stub, "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.LIKE, stub, ""),
            new UserAction(1, "Alice", ActionType.SHARE, stub, ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, stub, "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.POST, stub, "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.LIKE, stub, ""),
            new UserAction(4, "Dave", ActionType.COMMENT, stub, "#feature works really well."),
            new UserAction(1, "Alice", ActionType.POST, stub, "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.LIKE, stub, ""),
            new UserAction(5, "Eve", ActionType.SHARE, stub, ""),
            new UserAction(2, "Bob", ActionType.POST, stub, "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.SHARE, stub, "")
    );
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
