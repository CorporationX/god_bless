package school.faang.analysuseractivsocialnet;

// Main.java
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 9,
                        1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9,
                        2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", "like", LocalDate.of(2024, 9,
                        3), ""),
                new UserAction(3, "Charlie", "share", LocalDate.of(2024, 9,
                        4), ""),
                new UserAction(4, "Dave", "post", LocalDate.of(2024, 9,
                        5), "#Java is awesome!"),
                new UserAction(2, "Bob", "like", LocalDate.of(2024, 9,
                        6), ""),
                new UserAction(3, "Charlie", "post", LocalDate.of(2024, 9,
                        7), "Check out this cool #project"),
                new UserAction(1, "Alice", "comment", LocalDate.of(2024, 9,
                        8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", "like", LocalDate.of(2024, 9,
                        9), ""),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9,
                        10), "#Java is everywhere.")
        );

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top-10 Active Users: " + topUsers);
        System.out.println("Top-5 Popular Hashtags: " + topHashtags);
        System.out.println("Top-3 Commenters Last Month: " + topCommenters);
        System.out.println("Action Type Percentages: " + actionPercentages);
    }
}
