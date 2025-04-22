package bjs2_70896;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 3, 29).atStartOfDay(), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 2, 2).atStartOfDay(), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 2, 3).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 2, 4).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 2, 5).atStartOfDay(), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 2, 6).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 2, 7).atStartOfDay(), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 2, 8).atStartOfDay(), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 2, 2).atStartOfDay(), ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 2, 3).atStartOfDay(), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 2, 11).atStartOfDay(), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 2, 12).atStartOfDay(), "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 2, 13).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 2, 14).atStartOfDay(), ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 2, 15).atStartOfDay(), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 2, 16).atStartOfDay(), ""),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 2, 17).atStartOfDay(), "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 2, 18).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 2, 12).atStartOfDay(), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 3, 25).atStartOfDay(), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 2, 21).atStartOfDay(), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 2, 22).atStartOfDay(), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 2, 23).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 2, 24).atStartOfDay(), "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 3, 27).atStartOfDay(), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 2, 26).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 2, 27).atStartOfDay(), ""),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 2, 28).atStartOfDay(), "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 2, 22).atStartOfDay(), ""),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 2, 27).atStartOfDay(), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 3, 1).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 3, 2).atStartOfDay(), "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 3, 22).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 3, 4).atStartOfDay(), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 3, 5).atStartOfDay(), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 3, 23).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 3, 7).atStartOfDay(), "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 3, 26).atStartOfDay(), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 3, 9).atStartOfDay(), ""),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 3, 10).atStartOfDay(), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 3, 30).atStartOfDay(), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 3, 25).atStartOfDay(), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 3, 13).atStartOfDay(), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 3, 14).atStartOfDay(), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 3, 26).atStartOfDay(), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 3, 16).atStartOfDay(), ""),
                new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2025, 3, 17).atStartOfDay(), ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 3, 27).atStartOfDay(), "Can't wait for the next #update."),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 3, 28).atStartOfDay(), "")
        );

        List<String> top3Users = UserActionAnalyzer.topActiveUsers(actions, 3);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularTopicsForDiscussion(actions, 5);
        List<String> top3Commenters= UserActionAnalyzer.topUsersWhoHaveWrittenTheMostInThePastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateThePercentageForEachOfAction(actions);

        System.out.println("Топ-3 активных пользователей: " + top3Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
