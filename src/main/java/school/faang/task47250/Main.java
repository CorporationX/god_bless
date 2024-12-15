package school.faang.task47250;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static school.faang.task47250.ActionType.*;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = generateData();

        UserActionAnalyzer.topActiveUsers(actions).forEach(System.out::println);
        System.out.println();
        UserActionAnalyzer.topCommentersLastMonth(actions).forEach(System.out::println);
        System.out.println();
        UserActionAnalyzer.topPopularHashtags(actions).forEach(System.out::println);
        System.out.println();
        UserActionAnalyzer.actionTypePercentages(actions)
                .forEach((key, value) -> System.out.println(key.getName() + " " + value));
    }

    private static List<UserAction> generateData() {
        return Arrays.asList(
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 9, 3),
                        ""),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 9, 4),
                        ""),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 9, 5),
                        "#Java is awesome!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 9, 6),
                        ""),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 9, 7),
                        "Check out this cool #project"),
                new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 9, 8),
                        "Thanks for sharing #project!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 9, 9),
                        ""),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 10),
                        "#Java is everywhere."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 9, 12),
                        "#Java is indeed awesome."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 9, 13),
                        ""),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 9, 14),
                        ""),
                new UserAction(2, "Bob", POST, LocalDate.of(2024, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 9, 16),
                        ""),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 9, 17),
                        "#update looks great!"),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 9, 18),
                        ""),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 9, 19),
                        "Really liking the new #feature."),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 9, 20),
                        ""),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 9, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 9, 22),
                        "I'll be at the #conference too!"),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 9, 23),
                        ""),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 9, 24),
                        "Had a great time at the #conference."),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 25),
                        "#conference was a blast!"),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 9, 26),
                        ""),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 9, 27),
                        ""),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 9, 28),
                        "The new #update is rolling out today."),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 9, 29),
                        ""),
                new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 9, 30),
                        "Excited to try out the new #update!"),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 10, 1),
                        ""),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 10, 2),
                        "The #update has some great features."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 10, 3),
                        ""),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 10, 4),
                        ""),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 10, 5),
                        "Loving the new #update so far."),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 10, 6),
                        ""),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 10, 7),
                        "Here's my review of the new #update."),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 10, 8),
                        "Your #review was helpful!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 10, 9),
                        ""),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 10, 10),
                        ""),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 10, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 10, 12),
                        "What a great #feature this update brings!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 10, 13),
                        ""),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 10, 14),
                        "#feature works really well."),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 10, 15),
                        "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 10, 16),
                        ""),
                new UserAction(5, "Eve", SHARE, LocalDate.of(2024, 10, 17),
                        ""),
                new UserAction(2, "Bob", POST, LocalDate.of(2024, 10, 18),
                        "Can't wait for the next #update."),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 10, 19),
                        "")
        );
    }
}