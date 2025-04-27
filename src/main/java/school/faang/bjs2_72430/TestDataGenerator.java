package school.faang.bjs2_72430;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestDataGenerator {
    public static List<UserAction> generateActions() {
        return Arrays.asList(
                new UserAction(new User(1L, "Alice"), ActionType.POST, LocalDate.of(2025, 3, 1), "Check out this amazing #newfeature!"),
                new UserAction(new User(2L, "Bob"), ActionType.COMMENT, LocalDate.of(2025, 3, 2), "I totally agree with #newfeature."),
                new UserAction(new User(3L, "Charlie"), ActionType.LIKE, LocalDate.of(2025, 3, 3), ""),
                new UserAction(new User(4L, "Dave"), ActionType.SHARE, LocalDate.of(2025, 3, 4), ""),
                new UserAction(new User(5L, "Eve"), ActionType.POST, LocalDate.of(2025, 3, 5), "#Java is awesome!"),
                new UserAction(new User(6L, "Frank"), ActionType.LIKE, LocalDate.of(2025, 3, 6), ""),
                new UserAction(new User(7L, "Grace"), ActionType.POST, LocalDate.of(2025, 3, 7), "Check out this cool #project"),
                new UserAction(new User(8L, "Henry"), ActionType.COMMENT, LocalDate.of(2025, 3, 8), "Thanks for sharing #project!"),
                new UserAction(new User(3L, "Ivy"), ActionType.LIKE, LocalDate.of(2025, 3, 3), ""),
                new UserAction(new User(10L, "Jack"), ActionType.COMMENT, LocalDate.of(2025, 3, 4), "#Java is everywhere."),

                new UserAction(new User(11L, "Kate"), ActionType.POST, LocalDate.of(2025, 4, 1), "Loving the new #feature release!"),
                new UserAction(new User(12L, "Leo"), ActionType.COMMENT, LocalDate.of(2025, 4, 2), "#feature is amazing!"),
                new UserAction(new User(13L, "Mia"), ActionType.LIKE, LocalDate.of(2025, 4, 3), ""),
                new UserAction(new User(14L, "Noah"), ActionType.SHARE, LocalDate.of(2025, 4, 4), ""),
                new UserAction(new User(15L, "Olivia"), ActionType.POST, LocalDate.of(2025, 4, 5), "Introducing a new #update to the system."),

                new UserAction(new User(1L, "Alice"), ActionType.COMMENT, LocalDate.of(2025, 4, 6), "First comment #update"),
                new UserAction(new User(1L, "Alice"), ActionType.COMMENT, LocalDate.of(2025, 4, 7), "Second comment #update"),
                new UserAction(new User(1L, "Alice"), ActionType.COMMENT, LocalDate.of(2025, 4, 8), "Third comment #update"),
                new UserAction(new User(2L, "Bob"), ActionType.COMMENT, LocalDate.of(2025, 4, 3), "Bob's first comment #feature"),
                new UserAction(new User(2L, "Bob"), ActionType.COMMENT, LocalDate.of(2025, 4, 4), "Bob's second comment #feature"),
                new UserAction(new User(3L, "Charlie"), ActionType.COMMENT, LocalDate.of(2025, 4, 2), "Charlie's comment #java"),
                new UserAction(new User(4L, "Dave"), ActionType.COMMENT, LocalDate.of(2025, 4, 12), "Dave's comment #project"),
                new UserAction(new User(5L, "Eve"), ActionType.COMMENT, LocalDate.of(2025, 4, 13), "Eve's comment #new"),

                new UserAction(new User(1L, "Alice"), ActionType.POST, LocalDate.of(2025, 2, 1), "New month, new post #november"),
                new UserAction(new User(2L, "Bob"), ActionType.COMMENT, LocalDate.of(2025, 2, 2), "Comment in november #newmonth"),
                new UserAction(new User(3L, "Charlie"), ActionType.LIKE, LocalDate.of(2025, 2, 3), ""),
                new UserAction(new User(4L, "Dave"), ActionType.SHARE, LocalDate.of(2025, 2, 4), ""),
                new UserAction(new User(5L, "Eve"), ActionType.POST, LocalDate.of(2025, 2, 5), "Another post #latest"),

                new UserAction(new User(6L, "Frank"), ActionType.POST, LocalDate.of(2025, 4, 14), "#java #java #java repeated hashtags"),
                new UserAction(new User(7L, "Grace"), ActionType.POST, LocalDate.of(2025, 4, 15), "#feature is my favorite #feature"),
                new UserAction(new User(8L, "Henry"), ActionType.POST, LocalDate.of(2025, 4, 16), "#unique unique hashtag"),
                new UserAction(new User(3L, "Ivy"), ActionType.POST, LocalDate.of(2025, 4, 17), "#project #project #project #project"),

                new UserAction(new User(10L, "Jack"), ActionType.LIKE, LocalDate.of(2025, 4, 18), ""),
                new UserAction(new User(11L, "Kate"), ActionType.SHARE, LocalDate.of(2025, 4, 13), ""),
                new UserAction(new User(12L, "Leo"), ActionType.LIKE, LocalDate.of(2025, 4, 20), ""),
                new UserAction(new User(13L, "Mia"), ActionType.SHARE, LocalDate.of(2025, 4, 21), ""),
                new UserAction(new User(14L, "Noah"), ActionType.LIKE, LocalDate.of(2025, 4, 22), ""),
                new UserAction(new User(15L, "Olivia"), ActionType.SHARE, LocalDate.of(2025, 4, 23), "")
        );
    }
}
