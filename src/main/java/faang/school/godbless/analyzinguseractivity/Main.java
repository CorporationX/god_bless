package faang.school.godbless.analyzinguseractivity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction("1", "Alice", ActionType.POST, LocalDateTime.now().minusDays(2), "Check out this new blog! #tech"),
                new UserAction("2", "Bob", ActionType.COMMENT, LocalDateTime.now().minusDays(1), "I love this! #amazing"),
                new UserAction("3", "Charlie", ActionType.LIKE, LocalDateTime.now().minusDays(3), ""),
                new UserAction("1", "Alice", ActionType.COMMENT, LocalDateTime.now().minusDays(5), "Interesting thoughts! #tech"),
                new UserAction("4", "Dave", ActionType.SHARE, LocalDateTime.now().minusDays(7), ""),
                new UserAction("2", "Bob", ActionType.POST, LocalDateTime.now().minusDays(10), "New post on my blog! #life"),
                new UserAction("5", "Eve", ActionType.POST, LocalDateTime.now().minusDays(2), "I love hiking! #nature"),
                new UserAction("1", "Alice", ActionType.LIKE, LocalDateTime.now().minusDays(12), ""),
                new UserAction("2", "Bob", ActionType.SHARE, LocalDateTime.now().minusDays(14), ""),
                new UserAction("3", "Charlie", ActionType.POST, LocalDateTime.now().minusDays(16), "My thoughts on the latest news #politics")
        );

        System.out.println("Top 10 Active Users:");
        System.out.println(SocialNetworkAnalyzer.getTop10ActiveUsers(actions));

        System.out.println("Top 5 Popular Topics:");
        System.out.println(SocialNetworkAnalyzer.getTop5PopularTopics(actions));

        System.out.println("Top 3 Commenters Last Month:");
        System.out.println(SocialNetworkAnalyzer.getTop3CommentersLastMonth(actions));

        System.out.println("Action Type Percentages:");
        Map<ActionType, Double> actionTypePercentages = SocialNetworkAnalyzer.getActionTypePercentage(actions);
        actionTypePercentages.forEach((type, percentage) ->
                System.out.println(type + ": " + String.format("%.2f", percentage) + "%"));
    }
}