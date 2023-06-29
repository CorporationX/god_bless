package faang.school.godbless.analysisActivity;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class SocialNetworkAnalyzer {
    public static List<UserAction> findTop10MostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActionCounts = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return userActionCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> userActions.stream()
                        .filter(action -> action.getUserId() == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static List<String> findTop5PopularTopics(List<UserAction> userActions) {
        Map<String, Long> hashtagCounts = userActions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().toLowerCase().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return hashtagCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<UserAction> findTop3UsersWithMostCommentsLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        Map<Integer, Long> userCommentCounts = userActions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return userCommentCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> userActions.stream()
                        .filter(action -> action.getUserId() == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> calculateActionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();

        Map<String, Long> actionTypesCounts = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Map<String, Double> actionTypePercentages = new HashMap<>();
        actionTypesCounts.forEach((actionType, count) -> {
            double percentage = (count * 100.0) / totalActions;
            actionTypePercentages.put(actionType, percentage);
        });

        return actionTypePercentages;
    }


    public static void main(String[] args) {

        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new UserAction(1, "Ivan", "post", LocalDate.of(2023, Month.JUNE, 1), "Hello #world"));
        userActions.add(new UserAction(2, "Alisa", "post", LocalDate.of(2023, Month.JUNE, 2), "Look this #photo"));
        userActions.add(new UserAction(1, "Ivan", "comment", LocalDate.of(2023, Month.JUNE, 3), "Cool picture!"));
        userActions.add(new UserAction(3, "Oleg", "like", LocalDate.of(2023, Month.JUNE, 4), ""));
        userActions.add(new UserAction(2, "Alisa", "comment", LocalDate.of(2023, Month.JUNE, 5), "Thanks! #nature"));
        userActions.add(new UserAction(3, "Oleg", "comment", LocalDate.of(2023, Month.JUNE, 6), "Great shot!"));
        userActions.add(new UserAction(2, "Alisa", "share", LocalDate.of(2023, Month.JUNE, 7), ""));
        userActions.add(new UserAction(1, "Ivan", "comment", LocalDate.of(2023, Month.JUNE, 8), "Amazing! #photo"));


        List<UserAction> top10ActiveUsers = findTop10MostActiveUsers(userActions);
        List<String> top5PopularTopics = findTop5PopularTopics(userActions);
        List<UserAction> top3UsersWithMostComments = findTop3UsersWithMostCommentsLastMonth(userActions);
        Map<String, Double> actionTypesPercentages = calculateActionTypePercentages(userActions);


        System.out.println("Top 10 Most Active Users:");
        for (UserAction userAction : top10ActiveUsers) {
            System.out.println("User ID: " + userAction.getUserId());
            System.out.println("User Name: " + userAction.getUserName());
            System.out.println("Action Type: " + userAction.getActionType());
            System.out.println("Action Date: " + userAction.getActionDate());
            System.out.println("Content: " + userAction.getContent());
            System.out.println("-".repeat(20));
        }

        System.out.println("Top 5 Popular Topics:");
        for (String topic : top5PopularTopics) {
            System.out.println("Topic: " + topic);
        }

        System.out.println("\nTop 3 Users with Most Comments Last Month:");
        for (UserAction userAction : top3UsersWithMostComments) {
            System.out.println("User ID: " + userAction.getUserId());
            System.out.println("User Name: " + userAction.getUserName());
            System.out.println("Action Type: " + userAction.getActionType());
            System.out.println("Action Date: " + userAction.getActionDate());
            System.out.println("Content: " + userAction.getContent());
            System.out.println("-".repeat(20));
        }

        System.out.println("Action Type Percentages:");
        actionTypesPercentages.forEach((actionType, percentage) -> {
            System.out.println(actionType + ": " + percentage + "%");
        });
    }

}
