package faang.school.godbless.socialMedia;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ActionManager {

    public static void main(String[] args) {
        List<UserAction> userActions = Arrays.asList(
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 8, 10), "Loving #Java programming!"),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 8, 15), "Great post! #Java"),
                new UserAction(3, "Charlie", "like", LocalDate.of(2024, 8, 5), "Another #content"),
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 8, 12), "More #content"),
                new UserAction(1, "Alice", "comment", LocalDate.of(2024, 8, 20), "#Java #is awesome"),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 7, 25), "Previous comment #Java"),
                new UserAction(3, "Charlie", "share", LocalDate.of(2024, 8, 1), "Sharing #content"),
                new UserAction(4, "Dave", "post", LocalDate.of(2024, 8, 1), "#Hello #World")
        );

        System.out.println("Top 10 Most Active Users:");
        findTop10MostActiveUsers(userActions).forEach(entry ->
                System.out.println("id " + entry.getKey() + ": " + entry.getValue())
        );

        System.out.println("\nTop 5 Popular Hashtags:");
        findTop5PopularHashtags(userActions).forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue())
        );

        System.out.println("\nTop 3 Users with Most Comments Last Month:");
        findTop3UsersWithMostCommentsAtMonth(userActions).forEach(entry ->
                System.out.println("id " + entry.getKey() + ": " + entry.getValue())
        );

        System.out.println("\nPercentage of Action Types:");
        countPercentageOfUsersActionTypes(userActions).forEach((key, value) ->
                System.out.println(key + ": " + value + "%")
        );
    }


    public static List<Map.Entry<Integer, Long>> findTop10MostActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<String, Long>> findTop5PopularHashtags(List<UserAction> userActions) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");

        return userActions.stream()
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word -> hashtagPattern.matcher(word).matches())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<Integer, Long>> findTop3UsersWithMostCommentsAtMonth(List<UserAction> userActions) {
        Month atMounth = LocalDate.now().getMonth();
        System.out.println(atMounth);

        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment") && userAction.getActionDate().getMonth() == atMounth)
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    public static Map<String, Double> countPercentageOfUsersActionTypes(List<UserAction> userActions) {
        long totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
