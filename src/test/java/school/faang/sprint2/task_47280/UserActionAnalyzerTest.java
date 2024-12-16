package school.faang.sprint2.task_47280;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.sprint2.task_47280.ActionType.COMMENT;
import static school.faang.sprint2.task_47280.ActionType.LIKE;
import static school.faang.sprint2.task_47280.ActionType.POST;
import static school.faang.sprint2.task_47280.ActionType.SHARE;

public class UserActionAnalyzerTest {
    private final List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 1), "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 12, 2), "I totally agree with #newfeature."),
            new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 12, 3), ""),
            new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 12, 4), ""),
            new UserAction(4, "Dave", POST, LocalDate.of(2024, 12, 5), "#Java is awesome!"),
            new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 12, 6), ""),
            new UserAction(3, "Charlie", POST, LocalDate.of(2024, 12, 7), "Check out this cool #project"),
            new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 12, 8), "Thanks for sharing #project!"),
            new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 12, 12), ""),
            new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 12, 12), "#Java is everywhere."),
            new UserAction(5, "Eve", POST, LocalDate.of(2024, 12, 11), "Loving the new #feature release!"),
            new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 12, 12), "#Java is indeed awesome."),
            new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 12, 13), ""),
            new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 12, 14), ""),
            new UserAction(2, "Bob", POST, LocalDate.of(2024, 12, 15), "Introducing a new #update to the system."),
            new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 12, 16), ""),
            new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 12, 17), "#update looks great!"),
            new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 12, 18), ""),
            new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 12, 19), "Really liking the new #feature."),
            new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 12, 20), ""),
            new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 21), "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 12, 22), "I'll be at the #conference too!"),
            new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 12, 23), ""),
            new UserAction(4, "Dave", POST, LocalDate.of(2024, 12, 24), "Had a great time at the #conference."),
            new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 12, 25), "#conference was a blast!"),
            new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 12, 26), ""),
            new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 12, 27), ""),
            new UserAction(5, "Eve", POST, LocalDate.of(2024, 12, 28), "The new #update is rolling out today."),
            new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 12, 29), ""),
            new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 12, 30), "Excited to try out the new #update!"),
            new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 12, 1), ""),
            new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 12, 2), "The #update has some great features."),
            new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 12, 3), ""),
            new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 12, 4), ""),
            new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 5), "Loving the new #update so far."),
            new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 12, 6), ""),
            new UserAction(3, "Charlie", POST, LocalDate.of(2024, 12, 7), "Here's my review of the new #update."),
            new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 12, 8), "Your #review was helpful!"),
            new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 12, 12), ""),
            new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 12, 12), ""),
            new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 12, 11), "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", POST, LocalDate.of(2024, 12, 12), "What a great #feature this update brings!"),
            new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 12, 13), ""),
            new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 12, 14), "#feature works really well."),
            new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 15), "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 12, 16), ""),
            new UserAction(5, "Eve", SHARE, LocalDate.of(2024, 12, 17), ""),
            new UserAction(2, "Bob", POST, LocalDate.of(2024, 12, 18), "Can't wait for the next #update."),
            new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 12, 19), "")
    );

    @Test
    public void testFindTopActiveUsers() {
        Set<String> mostActiveUser = Set.of("Alice", "Bob", "Charlie", "Dave", "Eve");

        assertTrue(mostActiveUser.containsAll(UserActionAnalyzer.findTopActiveUsers(actions)));
    }

    @Test
    public void testTopPopularHashtags() {
        Set<String> popularHashtag = Set.of("#CONFERENCE", "#FEATURE", "#JAVA", "#NEWFEATURE", "#UPDATE");

        assertTrue(popularHashtag.containsAll(UserActionAnalyzer.topPopularHashtags(actions)));
    }

    @Test
    public void testTopCommentersForTheLastMonth() {
        Set<String> topCommenter = Set.of("Charlie", "Bob", "Alice");

        assertTrue(topCommenter.containsAll(UserActionAnalyzer.topCommentersForTheLastMonth(actions)));
    }

    @Test
    public void testActionTypePercentages() {
        Map<String, Double> actionPercentage = new HashMap<>();
        actionPercentage.put(LIKE.name(), 26.53);
        actionPercentage.put(POST.name(), 26.53);
        actionPercentage.put(SHARE.name(), 20.41);
        actionPercentage.put(COMMENT.name(), 26.53);

        assertEquals(actionPercentage, UserActionAnalyzer.actionTypePercentages(actions));
    }
}
