package bjs288112;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.now().minusDays(2), "#fun #java"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(10), "#java rocks"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.now().minusDays(15), "#fun"),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.now().minusDays(5), null),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.now().minusDays(20), "#coding #fun"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.now().minusDays(1), null)
        );

        UserActionAnalyzer analyzer = new UserActionAnalyzer();

        List<String> top10Users = analyzer.findTheMostActiveUsers(actions, 10);

        List<String> top5Hashtags = UserActionAnalyzer.findTopTopics(actions, 5);

        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);

        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        System.out.println("Top 10 active users: " + top10Users);
        System.out.println("Топ-5 popular hashtag: " + top5Hashtags);
        System.out.println("Топ-3 commentators last month: " + top3Commenters);
        System.out.println("Percent of actions per type: " + actionPercentages);
    }
}
