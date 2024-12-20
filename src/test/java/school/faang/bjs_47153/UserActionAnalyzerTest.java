package school.faang.bjs_47153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class UserActionAnalyzerTest {

    private final List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 1), "Check out this amazing #review #newfeature!"),
            new UserAction(2, "Bob", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 3), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 9, 4), ""),
            new UserAction(4, "Dave", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 5), "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 6), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 7), "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 9), ""),
            new UserAction(2, "Bob", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 10), "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 11), "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 12), "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 13), ""),
            new UserAction(4, "Dave", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 9, 14), ""),
            new UserAction(2, "Bob", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 9, 16), ""),
            new UserAction(5, "Eve", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 17), "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 18), ""),
            new UserAction(4, "Dave", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 19), "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 9, 20), ""),
            new UserAction(1, "Alice", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 23), ""),
            new UserAction(4, "Dave", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 24), "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 25), "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 26), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 9, 27), ""),
            new UserAction(5, "Eve", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 9, 28), "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 9, 29), ""),
            new UserAction(1, "Alice", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 9, 30), "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 12, 1), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 12, 2), "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 12, 3), ""),
            new UserAction(4, "Dave", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 12, 4), ""),
            new UserAction(1, "Alice", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 12, 5), "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 12, 6), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 12, 7), "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 12, 8), "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 12, 9), ""),
            new UserAction(1, "Alice", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 12, 10), ""),
            new UserAction(3, "Charlie", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 12, 11), "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 12, 12), "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 12, 13), ""),
            new UserAction(4, "Dave", ActionType.valueOf("comment".toUpperCase()),
                    LocalDate.of(2024, 11, 14), "#feature works really well."),
            new UserAction(1, "Alice", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 11, 15), "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.valueOf("like".toUpperCase()),
                    LocalDate.of(2024, 11, 16), ""),
            new UserAction(5, "Eve", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 11, 17), ""),
            new UserAction(2, "Bob", ActionType.valueOf("post".toUpperCase()),
                    LocalDate.of(2024, 11, 18), "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.valueOf("share".toUpperCase()),
                    LocalDate.of(2024, 11, 19), "")
    );

    @Test
    void topActiveUsers() {
        List<String> actual = UserActionAnalyzer.topActiveUsers(actions);
        List<String> expected = new ArrayList<>(Arrays.asList("Alice", "Bob", "Dave", "Charlie", "Eve"));
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void topHashtags() {
        List<String> actual = UserActionAnalyzer.topHashtags(actions);
        List<String> expected = new ArrayList<>(Arrays.asList("#review", "#newfeature", "#project", "#Java",
                "#conference"));
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void topCommentersLastMonth() {
        List<String> actual = UserActionAnalyzer.topCommentersLastMonth(actions);
        List<String> expected = Arrays.asList("Eve", "Charlie");
        Assertions.assertTrue(actual.containsAll(expected));
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void actionTypePercentages() {
        Map<String, Double> actual = UserActionAnalyzer.actionTypePercentages(actions);
        Map<String, Double> expected = Map.of("LIKE", 26.53061224489796, "POST", 26.53061224489796,
                "SHARE", 20.408163265306122, "COMMENT", 26.53061224489796);
        Assertions.assertEquals(expected, actual);
    }
}