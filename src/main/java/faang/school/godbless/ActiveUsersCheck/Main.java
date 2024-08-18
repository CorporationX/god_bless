package faang.school.godbless.ActiveUsersCheck;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction("1", "Alice", "post", "2024-08-01", "Hello World!"),
                new UserAction("2", "Bob", "comment", "2024-01-01", "Nice post!"),
                new UserAction("1", "Alice", "like", "2024-01-01", ""),
                new UserAction("3", "Charlie", "share", "2024-01-01", "Check this out!"),
                new UserAction("2", "Bob", "post", "2024-02-01", "My first post!"),
                new UserAction("1", "Alice", "comment", "2024-01-01", "Thanks!"),
                new UserAction("3", "Charlie", "like", "2024-07-01", ""),
                new UserAction("2", "Bob", "share", "2024-01-01", "Interesting!"),
                new UserAction("1", "Alice", "post", "2024-01-01", "Another post!"),
                new UserAction("3", "Charlie", "comment", "2024-03-01", "Great!"),
                new UserAction("2", "Bob", "like", "2024-04-01", ""),
                new UserAction("1", "Alice", "share", "2024-01-01", "Check this out!"),
                new UserAction("3", "Charlie", "post", "2024-01-01", "New post!"),
                new UserAction("2", "Bob", "comment", "2024-01-01", "Nice!"),
                new UserAction("1", "Alice", "like", "2024-08-01", "")
        );

        List<Map.Entry<String, Long>> top10ActiveUsers = getTop10ActiveUsers(userActions);
        top10ActiveUsers.forEach(entry -> System.out.println("User ID: " + entry.getKey() + ", Action Count: " + entry.getValue()));

        Map<String, Long> topicCounts = countTopics(userActions);
        topicCounts.forEach((topic, count) -> System.out.println("Topic: " + topic + ", Count: " + count));

        List<Map.Entry<String, Long>> top3Commenters = getTop3CommentersLastMonth(userActions);
        top3Commenters.forEach(entry -> System.out.println("User ID: " + entry.getKey() + ", Comment Count: " + entry.getValue()));

        Map<String, Double> actionPercentages = UserAction.calculateActionPercentages(userActions);
        actionPercentages.forEach((actionType, percentage) -> System.out.println("Action Type: " + actionType + ", Percentage: " + percentage + "%"));
    }

    public static List<Map.Entry<String, Long>> getTop10ActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> countTopics(List<UserAction> actions) {
        return actions.stream()
                .flatMap(action -> action.getTopics().stream())
                .filter(topic -> !topic.isEmpty())
                .collect(Collectors.groupingBy(topic -> topic, Collectors.counting()));
    }

    public static List<Map.Entry<String, Long>> getTop3CommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return actions.stream()
                .filter(action -> "comment".equals(action.getActionType()) && LocalDate.parse(action.getActionDate(), formatter).isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
}