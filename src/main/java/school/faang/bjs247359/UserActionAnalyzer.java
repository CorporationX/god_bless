package school.faang.bjs247359;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("User action can not be null");
        }
        return userActions.stream()
                .map(UserAction::getName)
                .collect(Collectors.groupingBy(name ->
                        Optional.ofNullable(name).orElse("Unknown"), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(10)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("User action can not be null");
        }
        return userActions.stream()
                .map(UserAction::getContent)
                .filter(word -> word != null && !word.contains("' '"))
                .collect(Collectors.groupingBy(hashtag ->
                        Optional.ofNullable(hashtag).orElse("Unknown content"), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> topCommentsLastMonth(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("User action can not be null");
        }
        return userActions.stream()
                .filter(action -> action.getActionType() != null
                        && action.getActionType().contains("comment"))
                .filter(action -> action.getActionDate() != null
                        && !action.getActionDate().isBefore(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(userAction ->
                        Optional.ofNullable(userAction.getName()).orElse("Unknown"), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("User action can not be null");
        }
        long allAction = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(userAction ->
                                Optional.ofNullable(userAction.getActionType()).orElse("Unknown"),
                        Collectors.collectingAndThen(Collectors.counting(), count -> (count * 100.0) / allAction)));
    }
}
