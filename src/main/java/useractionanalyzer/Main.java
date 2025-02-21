package useractionanalyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2024, 9, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2024, 9, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2024, 9, 9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2024, 9, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2024, 9, 11), "Loving the new #feature release!")
        );

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions, 3);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions, 3);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-3 активных пользователей: " + topUsers);
        System.out.println("Топ-3 популярных хэштегов: " + topHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процентное соотношение действий: " + actionPercentages);
    }
}

