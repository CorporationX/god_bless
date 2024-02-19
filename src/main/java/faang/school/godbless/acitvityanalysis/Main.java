package faang.school.godbless.acitvityanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<UserAction> userActions = Arrays.asList(
                new UserAction(1, "Greg", "post", "This is a #topic post", LocalDate.now()),
                new UserAction(1, "Greg", "post", "This is a #topic post", LocalDate.now()),
                new UserAction(1, "Greg", "post", "This is a #topic post", LocalDate.now()),
                new UserAction(1, "Greg", "post", "This is a #topic post", LocalDate.now()),
                new UserAction(1, "Greg", "post", "This is a #topic post", LocalDate.now()),
                new UserAction(3, "Anna", "post", "Another #topic post", LocalDate.now()),
                new UserAction(4, "Alice", "post", "Just a regular #lol post #random", LocalDate.now().minusDays(2)),
                new UserAction(2, "Charlie", "comment", "Great content! #random", LocalDate.now().minusDays(1)),
                new UserAction(2, "Charlie", "comment", "Great content! #random", LocalDate.now().minusDays(1)),
                new UserAction(2, "Charlie", "comment", "Great content! #random", LocalDate.now().minusDays(1)),
                new UserAction(2, "Charlie", "comment", "Great content! #random", LocalDate.now().minusDays(1)),
                new UserAction(2, "Charlie", "comment", "Great content! #random", LocalDate.now().minusDays(1)),
                new UserAction(7, "Eva", "comment", "Interesting! #random", LocalDate.now().minusMonths(1)),
                new UserAction(1, "Hank", "comment", "Nice #random topic!", LocalDate.now().minusDays(4)),
                new UserAction(10, "Karen", "post", "Another #random post", LocalDate.now().minusDays(8)),
                new UserAction(10, "Karen", "like", "Another #random post", LocalDate.now().minusDays(8)),
                new UserAction(14, "Liam", "post", "Yet another post", LocalDate.now().minusDays(10)),
                new UserAction(2, "Ryan", "comment", "Well done!", LocalDate.now().minusDays(12)),
                new UserAction(16, "Noah", "comment", "Post for testing #kek", LocalDate.now().minusMonths(1)),
                new UserAction(16, "Noah", "comment", "Post for testing #kek", LocalDate.now().minusMonths(1)),
                new UserAction(16, "Noah", "comment", "Post for testing #kek", LocalDate.now().minusMonths(1)),
                new UserAction(2, "Ryan", "comment", "Great job!", LocalDate.now().minusDays(18)),
                new UserAction(18, "Parker", "post", "Just a post", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post #lmao", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post #lmao", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post #soup", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post", LocalDate.now().minusDays(20)),
                new UserAction(18, "Parker", "post", "Just a post", LocalDate.now().minusDays(20)),
                new UserAction(20, "Ryan", "post", "Final post", LocalDate.now().minusDays(25))
        );

        System.out.println("Top users by activity: " + getTopUsersByActivity(userActions));
        System.out.println("Top topics: " + getTopTopics(userActions));
        System.out.println("Top commentators: " + getTopCommentators(userActions));
        System.out.println("Group activity percent: " + groupActivityPercent(userActions));
    }

    public static List<String> getTopUsersByActivity(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .map(entry -> entry.getKey().toString())
                .toList();
    }

    public static List<String> getTopTopics(List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<String> getTopCommentators(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().getMonth().equals(LocalDate.now().minusMonths(1).getMonth()))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .map(entry -> entry.getKey().toString())
                .toList();
    }

    public static Map<String, Long> groupActivityPercent(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100) / actions.size()));
    }
}