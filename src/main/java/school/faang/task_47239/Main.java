package school.faang.task_47239;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", "post",
                        LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", "comment",
                        LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", "like",
                        LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", "share",
                        LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", "post",
                        LocalDate.of(2024, 9, 5), "#Java is awesome!")
        );

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top 10 most active users: " + topUsers);
        System.out.println("Top 5 most popular hashtags: " + topHashtags);
        System.out.println("Top 3 commenters in the last month: " + topCommenters);
        System.out.println("Percentage of actions by type: " + actionPercentages);
    }
}