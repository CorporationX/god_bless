package school.faang.BJS2_35422_UsersActivityAnalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", "like", LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", "share", LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", "post", LocalDate.of(2024, 9, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", "like", LocalDate.of(2024, 9, 6), ""),
                new UserAction(3, "Charlie", "post", LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", "comment", LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", "like", LocalDate.of(2024, 9, 9), ""),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", "post", LocalDate.of(2024, 9, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 9, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", "like", LocalDate.of(2024, 9, 13), ""),
                new UserAction(4, "Dave", "share", LocalDate.of(2024, 9, 14), ""),
                new UserAction(2, "Bob", "post", LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", "share", LocalDate.of(2024, 9, 16), ""),
                new UserAction(5, "Eve", "comment", LocalDate.of(2024, 9, 17), "#update looks great!"),
                new UserAction(3, "Charlie", "like", LocalDate.of(2024, 9, 18), ""),
                new UserAction(4, "Dave", "comment", LocalDate.of(2024, 9, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", "share", LocalDate.of(2024, 9, 20), ""),
                new UserAction(6, "Frank", "post", LocalDate.of(2024, 9, 21), "Just joined the platform!"),
                new UserAction(6, "Frank", "comment", LocalDate.of(2024, 9, 22), "Learning a lot here!"),
                new UserAction(7, "Grace", "comment", LocalDate.of(2024, 9, 22), "Interesting #update!"),
                new UserAction(7, "Grace", "like", LocalDate.of(2024, 9, 23), ""),
                new UserAction(8, "Hank", "like", LocalDate.of(2024, 9, 23), ""),
                new UserAction(8, "Hank", "post", LocalDate.of(2024, 9, 24), "#Java is amazing!"),
                new UserAction(9, "Ivy", "share", LocalDate.of(2024, 9, 24), ""),
                new UserAction(9, "Ivy", "comment", LocalDate.of(2024, 9, 25), "Loved the #update!"),
                new UserAction(10, "Jake", "post", LocalDate.of(2024, 9, 25), "#Java is awesome!"),
                new UserAction(10, "Jake", "like", LocalDate.of(2024, 9, 26), ""),
                new UserAction(11, "Kevin", "like", LocalDate.of(2024, 9, 26), ""),
                new UserAction(11, "Kevin", "post", LocalDate.of(2024, 9, 27), "Exploring the platform!"),
                new UserAction(12, "Laura", "comment", LocalDate.of(2024, 9, 27), "Excited to be here!"),
                new UserAction(12, "Laura", "share", LocalDate.of(2024, 9, 28), ""),
                new UserAction(13, "Mike", "post", LocalDate.of(2024, 9, 28), "Loving the new #feature!"),
                new UserAction(13, "Mike", "like", LocalDate.of(2024, 9, 29), ""),
                new UserAction(14, "Nina", "share", LocalDate.of(2024, 9, 29), ""),
                new UserAction(14, "Nina", "comment", LocalDate.of(2024, 9, 30), "Great insights in the #update!"),
                new UserAction(15, "Oscar", "like", LocalDate.of(2024, 9, 30), ""),
                new UserAction(15, "Oscar", "post", LocalDate.of(2024, 10, 1), "#update is rolling out!"),
                new UserAction(16, "Paul", "comment", LocalDate.of(2024, 10, 1), "#update is amazing!"),
                new UserAction(16, "Paul", "like", LocalDate.of(2024, 10, 2), ""),
                new UserAction(17, "Quinn", "share", LocalDate.of(2024, 10, 2), ""),
                new UserAction(17, "Quinn", "post", LocalDate.of(2024, 10, 3), "Looking forward to learning more!"),
                new UserAction(18, "Rachel", "like", LocalDate.of(2024, 10, 3), ""),
                new UserAction(18, "Rachel", "comment", LocalDate.of(2024, 10, 4), "Great feature!"),
                new UserAction(19, "Steve", "post", LocalDate.of(2024, 10, 4), "Just published a new #blogpost."),
                new UserAction(19, "Steve", "like", LocalDate.of(2024, 10, 5), ""),
                new UserAction(20, "Tina", "comment", LocalDate.of(2024, 10, 5), "#Java for the win!"),
                new UserAction(20, "Tina", "share", LocalDate.of(2024, 10, 6), ""),
                new UserAction(21, "Uma", "like", LocalDate.of(2024, 10, 6), ""),
                new UserAction(21, "Uma", "post", LocalDate.of(2024, 10, 7), "Exploring new features."),
                new UserAction(22, "Victor", "share", LocalDate.of(2024, 10, 7), ""),
                new UserAction(22, "Victor", "like", LocalDate.of(2024, 10, 8), ""),
                new UserAction(23, "Wendy", "post", LocalDate.of(2024, 10, 8), "Excited about the upcoming #conference."),
                new UserAction(23, "Wendy", "comment", LocalDate.of(2024, 10, 9), "#conference was inspiring!"),
                new UserAction(24, "Xander", "comment", LocalDate.of(2024, 10, 9), "Loved the discussion on #conference."),
                new UserAction(24, "Xander", "share", LocalDate.of(2024, 10, 10), ""),
                new UserAction(25, "Yvonne", "like", LocalDate.of(2024, 10, 10), ""),
                new UserAction(25, "Yvonne", "post", LocalDate.of(2024, 10, 11), "Interesting topics at the #conference!"),
                new UserAction(26, "Zara", "share", LocalDate.of(2024, 10, 11), ""),
                new UserAction(26, "Zara", "like", LocalDate.of(2024, 10, 12), "")
        );

        System.out.println("Top Active Users:");
        List<String> topActiveUsers = UserActionAnalyzer.topActiveUsers(actions);
        System.out.println(topActiveUsers);

        System.out.println("\nTop Popular Hashtags:");
        List<String> topPopularHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        System.out.println(topPopularHashtags);

        System.out.println("\nTop Commenters Last Month:");
        List<String> topCommentersLastMonth = UserActionAnalyzer.topCommentersLastMonth(actions);
        System.out.println(topCommentersLastMonth);

        System.out.println("\nAction Type Percentages:");
        Map<String, Double> actionTypePercentages = UserActionAnalyzer.actionTypePercentages(actions);
        actionTypePercentages.forEach((actionType, percentage) ->
                System.out.println(actionType + ": " + String.format("%.3f",percentage) + "%")
        );
    }
}
