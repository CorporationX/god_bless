package school.faang.useraction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 3),
                        ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9, 4),
                        ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 9, 5),
                        "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 2, 6),
                        ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 9, 7),
                        "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 2, 8),
                        "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 9, 9),
                        ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 2, 10),
                        "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 9, 13),
                        ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 9, 14),
                        ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2024, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2024, 9, 16),
                        ""),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2024, 9, 17),
                        "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2024, 9, 18),
                        "")
        );

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        System.out.printf("Топ-10 активных пользователей: %s%n", top10Users);
        System.out.printf("Топ-5 популярных хэштегов: %s%n", top5Hashtags);
        System.out.printf("Топ-3 комментаторов за последний месяц: %s%n", top3Commenters);
        System.out.printf("Процент действий по типам: %s%n",  actionPercentages);
    }
}