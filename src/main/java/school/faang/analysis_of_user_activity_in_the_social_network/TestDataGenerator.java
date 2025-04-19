package school.faang.analysis_of_user_activity_in_the_social_network;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestDataGenerator {
    static List<UserAction> generateTestData() {
        return Arrays.asList(
                new UserAction(1, "Alice", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 3), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 4), ""),
                new UserAction(4, "Dave", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 6), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 4), ""),
                new UserAction(2, "Bob", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 13), ""),
                new UserAction(4, "Dave", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 14), ""),
                new UserAction(2, "Bob", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 16), ""),
                new UserAction(5, "Eve", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 17), "#update looks great!"),
                new UserAction(3, "Charlie", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 18), ""),
                new UserAction(4, "Dave", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 14), "Really liking the new #feature."),
                new UserAction(2, "Bob", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 20), ""),
                new UserAction(1, "Alice", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 23), ""),
                new UserAction(4, "Dave", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 26), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 27), ""),
                new UserAction(5, "Eve", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 24), ""),
                new UserAction(1, "Alice", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 1), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 2), "The #update has some great features."),
                new UserAction(5, "Eve", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 3), ""),
                new UserAction(4, "Dave", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 4), ""),
                new UserAction(1, "Alice", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 6), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 9), ""),
                new UserAction(1, "Alice", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 10), ""),
                new UserAction(3, "Charlie", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 12), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 13), ""),
                new UserAction(4, "Dave", UserAction.ActionType.COMMENT, LocalDate.of(
                        2025, 3, 14), "#feature works really well."),
                new UserAction(1, "Alice", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", UserAction.ActionType.LIKE, LocalDate.of(
                        2025, 3, 16), ""),
                new UserAction(5, "Eve", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 17), ""),
                new UserAction(2, "Bob", UserAction.ActionType.POST, LocalDate.of(
                        2025, 3, 18), "Can't wait for the next #update."),
                new UserAction(4, "Dave", UserAction.ActionType.SHARE, LocalDate.of(
                        2025, 3, 19), "")
        );
    }
}
