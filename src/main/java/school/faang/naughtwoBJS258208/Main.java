package school.faang.naughtwoBJS258208;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = createListUserAction();

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top 10 Active Users: " + top10Users);
        System.out.println("Top 5 Popular Hashtags: " + top5Hashtags);
        System.out.println("Top 3 commentators for the last month: " + top3Commenters);
        System.out.println("Percentage of actions by type: " + actionPercentages);
    }

    private static List<UserAction> createListUserAction() {
        return Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 1, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 1, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 1, 4), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 1, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 1, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 1, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 1, 9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 1, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 1, 13), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 1, 14), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 1, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 1, 16), ""),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 17), "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 1, 18), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 1, 20), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 1, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 1, 23), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 1, 24),
                        "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 1, 26), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 1, 27), ""),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 1, 28),
                        "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 1, 29), ""),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 30),
                        "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 2, 1), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 2), "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 2, 3), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 2, 4), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 2, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 2, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 2, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 2, 9), ""),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 2, 10), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 2, 12),
                        "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 2, 13), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 14), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 2, 15),
                        "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 2, 16), ""),
                new UserAction(5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 2, 17), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 2, 18), "Can't wait for the next #update."),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 2, 19), "")
        );
    }
}
