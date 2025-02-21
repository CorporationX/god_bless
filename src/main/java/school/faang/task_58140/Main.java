package school.faang.task_58140;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(
                        1, "Alice", ActionType.POST,
                        LocalDate.of(2024, 12, 1),
                        "Check out this amazing #newfeature!"
                ),
                new UserAction(
                        2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 2),
                        "I totally agree with #newfeature."
                ),
                new UserAction(
                        1, "Alice", ActionType.LIKE,
                        LocalDate.of(2024, 12, 3),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2024, 12, 4),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.POST,
                        LocalDate.of(2024, 12, 5),
                        "#Java is awesome!"
                ),
                new UserAction(
                        2, "Bob", ActionType.LIKE,
                        LocalDate.of(2024, 12, 6),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.POST,
                        LocalDate.of(2024, 12, 7),
                        "Check out this cool #project"
                ),
                new UserAction(
                        1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 8),
                        "Thanks for sharing #project!"
                ),
                new UserAction(
                        4, "Dave", ActionType.LIKE,
                        LocalDate.of(2024, 12, 9),
                        ""
                ),
                new UserAction(
                        2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 1),
                        "#Java is everywhere."
                ),
                new UserAction(
                        5, "Eve", ActionType.POST,
                        LocalDate.of(2024, 12, 11),
                        "Loving the new #feature release!"
                ),
                new UserAction(
                        3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 12),
                        "#Java is indeed awesome."
                ),
                new UserAction(
                        5, "Eve", ActionType.LIKE,
                        LocalDate.of(2024, 12, 13),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.SHARE,
                        LocalDate.of(2024, 12, 14),
                        ""
                ),
                new UserAction(
                        2, "Bob", ActionType.POST,
                        LocalDate.of(2024, 12, 15),
                        "Introducing a new #update to the system."
                ),
                new UserAction(
                        1, "Alice", ActionType.SHARE,
                        LocalDate.of(2024, 12, 16),
                        ""
                ),
                new UserAction(
                        5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 17),
                        "#update looks great!"
                ),
                new UserAction(
                        3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2024, 12, 18),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 19),
                        "Really liking the new #feature."
                ),
                new UserAction(
                        2, "Bob", ActionType.SHARE,
                        LocalDate.of(2024, 12, 20),
                        ""
                ),
                new UserAction(
                        1, "Alice", ActionType.POST,
                        LocalDate.of(2024, 12, 21),
                        "Excited for the upcoming #conference!"
                ),
                new UserAction(
                        3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 22),
                        "I'll be at the #conference too!"
                ),
                new UserAction(
                        5, "Eve", ActionType.LIKE,
                        LocalDate.of(2024, 12, 23),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.POST,
                        LocalDate.of(2024, 12, 24),
                        "Had a great time at the #conference."
                ),
                new UserAction(
                        2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 25),
                        "#conference was a blast!"
                ),
                new UserAction(
                        1, "Alice", ActionType.LIKE,
                        LocalDate.of(2024, 12, 26),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2024, 12, 27),
                        ""
                ),
                new UserAction(
                        5, "Eve", ActionType.POST,
                        LocalDate.of(2024, 12, 28),
                        "The new #update is rolling out today."
                ),
                new UserAction(
                        4, "Dave", ActionType.LIKE,
                        LocalDate.of(2024, 12, 29),
                        ""
                ),
                new UserAction(
                        1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2024, 12, 30),
                        "Excited to try out the new #update!"
                ),
                new UserAction(
                        2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 1, 19),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 20),
                        "The #update has some great features."
                ),
                new UserAction(
                        5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 1, 23),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 1, 24),
                        ""
                ),
                new UserAction(
                        1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 1, 25),
                        "Loving the new #update so far."
                ),
                new UserAction(
                        2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 1, 26),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 1, 27),
                        "Here's my review of the new #update."
                ),
                new UserAction(
                        5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 28),
                        "Your #review was helpful!"
                ),
                new UserAction(
                        4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 1, 29),
                        ""
                ),
                new UserAction(
                        1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 1, 30),
                        ""
                ),
                new UserAction(
                        3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 31),
                        "Sharing my thoughts on the #update."
                ),
                new UserAction(
                        5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 2, 12),
                        "What a great #feature this update brings!"
                ),
                new UserAction(
                        2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 2, 13),
                        ""
                ),
                new UserAction(
                        4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 14),
                        "#feature works really well."
                ),
                new UserAction(
                        1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 2, 15),
                        "The #feature saved me a lot of time."
                ),
                new UserAction(
                        3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 2, 16),
                        ""
                ),
                new UserAction(
                        5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 2, 17),
                        ""
                ),
                new UserAction(
                        2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 2, 18),
                        "Can't wait for the next #update."
                ),
                new UserAction(
                        4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 2, 19),
                        ""
                )
        );


        List<String> top3Users = UserActionAnalyzer.topActiveUsers(actions, 3);
        List<String> top3Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 3);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-3 активных пользователей: " + top3Users);
        System.out.println("Топ-3 популярных хэштегов: " + top3Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
