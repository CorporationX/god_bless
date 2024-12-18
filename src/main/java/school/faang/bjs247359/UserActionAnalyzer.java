package school.faang.bjs247359;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .map(UserAction::getName)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .map(UserAction::getContent)
                .filter(word -> !word.contains("' '"))
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> topCommentsLastMonth(List<UserAction> userActions) {
        return userActions.stream()
                .filter(action -> action.getActionType().contains("comment"))
                .filter(action -> !action.getActionDate().isBefore(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(userAction -> userAction.getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        long allAction = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(userAction -> userAction.getActionType(),
                        Collectors.collectingAndThen(Collectors.counting(), count -> (count * 100.0) / allAction)));
    }
}
