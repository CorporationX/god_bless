package school.faang.traffic_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {

        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 2, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 2, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 2, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 2, 4), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 2, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 2, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 2, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 1, 8), "#newfeature Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 2, 9), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 1, 13), "#project!"),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 2, 9), "#project!"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 2, 8), "#newfeature Thanks for sharing #project!"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 2, 8), "#newfeature Thanks for sharing #project!"));

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top-10 the most active users: " + top10Users);
        System.out.println("Top-10 the most popular hashtags: " + top5Hashtags);
        System.out.println("Top-3 comments for the last month: " + top3Commenters);
        System.out.println("Percentage of actions by type: " + actionPercentages);
    }
}
