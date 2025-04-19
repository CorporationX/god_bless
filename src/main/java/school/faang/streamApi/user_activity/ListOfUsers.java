package school.faang.streamApi.user_activity;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ListOfUsers {
    @Getter
    private static final List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 3, 1),
                    "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 3, 2),
                    "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 3, 3),
                    ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 3, 4),
                    ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 3, 5),
                    "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 3, 6),
                    ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 3, 7),
                    "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 3, 8),
                    "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 3, 9),
                    ""),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 3, 10),
                    "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 3, 11),
                    "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 3, 12),
                    "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 3, 13),
                    ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 3, 14),
                    ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 3, 15),
                    "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 3, 16),
                    ""),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 3, 17),
                    "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 3, 18),
                    ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 3, 19),
                    "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 3, 20),
                    ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 3, 21),
                    "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 3, 22),
                    "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 3, 23),
                    ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 3, 24),
                    "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 3, 25),
                    "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 3, 26),
                    ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 3, 27),
                    ""),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 3, 28),
                    "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 3, 29),
                    ""),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 3, 30),
                    "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 4, 1),
                    ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 4, 2),
                    "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 4, 3),
                    ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 4, 4),
                    ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 4, 5),
                    "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 4, 6),
                    ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 4, 7),
                    "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 4, 8),
                    "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 4, 9),
                    ""),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 4, 10),
                    ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 4, 11),
                    "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 4, 12),
                    "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 4, 13),
                    ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 4, 14),
                    "#feature works really well."),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 4, 15),
                    "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 4, 16),
                    ""),
            new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2025, 4, 17),
                    ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 4, 18),
                    "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 4, 19),
                    "")
    );
}
