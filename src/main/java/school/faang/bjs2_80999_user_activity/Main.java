package school.faang.bjs2_80999_user_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    @SuppressWarnings("checkstyle:LineLength")
    private static final List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 5, 1), "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 5, 2), "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 5, 3), ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 5, 4), ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 5, 5), "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 5, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 5, 7), "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 5, 8), "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 5, 9), ""),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 5, 10), "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 5, 11), "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 5, 12), "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 5, 13), ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 5, 14), ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 5, 15), "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 5, 16), ""),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 5, 17), "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 5, 18), ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 5, 19), "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 5, 20), ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 5, 21), "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 5, 22), "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 5, 23), ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 5, 24), "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 5, 25), "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 5, 26), ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 5, 27), ""),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 5, 28), "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 5, 29), ""),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 5, 30), "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 6, 1), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 6, 2), "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 6, 3), ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 6, 4), ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 6, 5), "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 6, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 6, 7), "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 6, 8), "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 6, 9), ""),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 6, 10), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 6, 11), "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 6, 12), "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 6, 13), ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 6, 14), "#feature works really well."),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 6, 15), "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 6, 16), ""),
            new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2025, 6, 17), ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 6, 18), "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 6, 19), "")
    );

    public static void main(String[] args) {
        // Получение результатов
        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        // Вывод результатов
        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
