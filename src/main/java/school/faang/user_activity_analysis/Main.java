package school.faang.user_activity_analysis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new UserAction(1, "Alice", ActionType.POST,
                LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"));
        actions.add(new UserAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."));
        actions.add(new UserAction(1, "Alice", ActionType.LIKE,
                LocalDate.of(2024, 9, 3), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.SHARE,
                LocalDate.of(2024, 9, 4), ""));
        actions.add(new UserAction(4, "Dave", ActionType.POST,
                LocalDate.of(2024, 9, 5), "#Java is awesome!"));
        actions.add(new UserAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2024, 9, 6), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.POST,
                LocalDate.of(2024, 9, 7), "Check out this cool #project"));
        actions.add(new UserAction(1, "Alice", ActionType.COMMENT,
                LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"));
        actions.add(new UserAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2024, 9, 9), ""));
        actions.add(new UserAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2024, 9, 10), "#Java is everywhere."));
        actions.add(new UserAction(5, "Eve", ActionType.POST,
                LocalDate.of(2024, 9, 11), "Loving the new #feature release!"));
        actions.add(new UserAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2024, 9, 12), "#Java is indeed awesome."));
        actions.add(new UserAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2024, 9, 13), ""));
        actions.add(new UserAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2024, 9, 14), ""));
        actions.add(new UserAction(2, "Bob", ActionType.POST,
                LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."));
        actions.add(new UserAction(1, "Alice", ActionType.SHARE,
                LocalDate.of(2024, 9, 16), ""));
        actions.add(new UserAction(5, "Eve", ActionType.COMMENT,
                LocalDate.of(2024, 9, 17), "#update looks great!"));
        actions.add(new UserAction(3, "Charlie", ActionType.LIKE,
                LocalDate.of(2024, 9, 18), ""));
        actions.add(new UserAction(4, "Dave", ActionType.COMMENT,
                LocalDate.of(2024, 9, 19), "Really liking the new #feature."));
        actions.add(new UserAction(2, "Bob", ActionType.SHARE,
                LocalDate.of(2024, 9, 20), ""));
        actions.add(new UserAction(1, "Alice", ActionType.POST,
                LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"));
        actions.add(new UserAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"));
        actions.add(new UserAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2024, 9, 23), ""));
        actions.add(new UserAction(4, "Dave", ActionType.POST,
                LocalDate.of(2024, 9, 24), "Had a great time at the #conference."));
        actions.add(new UserAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2024, 9, 25), "#conference was a blast!"));
        actions.add(new UserAction(1, "Alice", ActionType.LIKE,
                LocalDate.of(2024, 9, 26), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.SHARE,
                LocalDate.of(2024, 9, 27), ""));
        actions.add(new UserAction(5, "Eve", ActionType.POST,
                LocalDate.of(2024, 9, 28), "The new #update is rolling out today."));
        actions.add(new UserAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2024, 9, 29), ""));
        actions.add(new UserAction(1, "Alice", ActionType.COMMENT,
                LocalDate.of(2024, 9, 30), "Excited to try out the new #update!"));
        actions.add(new UserAction(2, "Bob", ActionType.SHARE,
                LocalDate.of(2024, 10, 1), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2024, 10, 2), "The #update has some great features."));
        actions.add(new UserAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2024, 10, 3), ""));
        actions.add(new UserAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2024, 10, 4), ""));
        actions.add(new UserAction(1, "Alice", ActionType.POST,
                LocalDate.of(2024, 10, 5), "Loving the new #update so far."));
        actions.add(new UserAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2024, 10, 6), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.POST,
                LocalDate.of(2024, 10, 7), "Here's my review of the new #update."));
        actions.add(new UserAction(5, "Eve", ActionType.COMMENT,
                LocalDate.of(2024, 10, 8), "Your #review was helpful!"));
        actions.add(new UserAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2024, 10, 9), ""));
        actions.add(new UserAction(1, "Alice", ActionType.SHARE,
                LocalDate.of(2024, 10, 10), ""));
        actions.add(new UserAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2024, 10, 11), "Sharing my thoughts on the #update."));
        actions.add(new UserAction(5, "Eve", ActionType.POST,
                LocalDate.of(2024, 10, 12), "What a great #feature this update brings!"));
        actions.add(new UserAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2024, 10, 13), ""));
        actions.add(new UserAction(4, "Dave", ActionType.COMMENT,
                LocalDate.of(2024, 10, 14), "#feature works really well."));
        actions.add(new UserAction(1, "Alice", ActionType.POST,
                LocalDate.of(2024, 10, 15), "The #feature saved me a lot of time."));
        actions.add(new UserAction(3, "Charlie", ActionType.LIKE,
                LocalDate.of(2024, 10, 16), ""));
        actions.add(new UserAction(5, "Eve", ActionType.SHARE,
                LocalDate.of(2024, 10, 17), ""));
        actions.add(new UserAction(2, "Bob", ActionType.POST,
                LocalDate.of(2024, 10, 18), "Can't wait for the next #update."));
        actions.add(new UserAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2024, 10, 19), ""));

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Comments = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        final Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        out.println("Топ-10 активных пользователей: " + top10Users);
        out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        out.println("Топ-3 комментаторов за последний месяц: " + top3Comments);
        out.println("Процент действий по типам:");
        actionPercentages.forEach((actionType, percentage) ->
                out.printf("%s: %.2f%%%n", actionType, percentage));
    }
}