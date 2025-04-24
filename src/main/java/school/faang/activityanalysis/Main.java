package school.faang.activityanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 4, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 3, 30), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 4, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2024, 9, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2024, 9, 13), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2024, 9, 14), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2024, 9, 16), ""),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 4, 17), "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2024, 9, 18), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2024, 9, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2024, 9, 20), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2024, 9, 23), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 4, 24), "Had a great time at the #conference.")
        );

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);

    }
}
