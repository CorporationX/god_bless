package faang.school.godbless;

import faang.school.godbless.Notification.Notification;

import java.time.LocalDate;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new UserAction(1, "Alice", "post", LocalDate.of(2024, 7, 20), "Check out my new blog post! #blog #writing"));
        actions.add(new UserAction(2, "Bob", "comment", LocalDate.of(2024, 8, 15), "Great post, Alice! #inspiration"));
        actions.add(new UserAction(3, "Alice", "like", LocalDate.of(2024, 8, 18), ""));
        actions.add(new UserAction(4, "Charlie", "post", LocalDate.of(2024, 8, 10), "Just finished a great book #reading #books"));
        actions.add(new UserAction(5, "Alice", "share", LocalDate.of(2024, 8, 12), ""));
        SocialNetworkAnalytics analytics = new SocialNetworkAnalytics();

        List<String> topUsers = analytics.findTop10ActiveUsers(actions);
        System.out.println("Top 10 Active Users: " + topUsers);

        List<String> topTopics = analytics.findTop5PopularTopics(actions);
        System.out.println("Top 5 Popular Topics: " + topTopics);

        List<String> topCommenters = analytics.findTop3CommentersLastMonth(actions);
        System.out.println("Top 3 Commenters Last Month: " + topCommenters);

        Map<String, Double> actionTypePercentages = analytics.calculateActionTypePercentages(actions);
        System.out.println("Action Type Percentages: " + actionTypePercentages);
    }
}
