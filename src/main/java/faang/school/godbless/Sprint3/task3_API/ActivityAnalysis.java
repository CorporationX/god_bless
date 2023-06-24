package faang.school.godbless.Sprint3.task3_API;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityAnalysis {
    public List<Integer> searchTopTenMostActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey).toList();
    }

    public List<String> searchTopFiveTopics(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT) ||
                        userAction.getActionType().equals(ActionType.POST))
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s")))
                .filter(hashtag -> hashtag.contains("#"))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public List<Integer> searchTopThreeCommentatorsLastMonth(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public Map<ActionType, Double> calculatePercentUserActions(List<UserAction> userActions) {
        Map<ActionType, Long> countAction = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Map<ActionType, Double> percentUserActions = new HashMap<>();

        for (var entry : countAction.entrySet()) {
            percentUserActions.put(entry.getKey(), (double) entry.getValue() / userActions.size() * 100);
        }
        return percentUserActions;
    }
}