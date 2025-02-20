package school.faang.useractivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> findTopActiveUsers(List<UserAction> userActions, int countActivities) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= countActivities)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findPopularHashtags(List<UserAction> userActions, int countHashtags) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.POST
                        || userAction.getActionType() == ActionType.COMMENT)
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(hashTag -> hashTag, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= countHashtags)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopCommentersLastMonth(List<UserAction> userActions, int countComments) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .filter(userAction -> !userAction.getActionDate()
                                .isBefore(LocalDate.now()
                                        .minusMonths(1))).count() >= countComments)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> calculateActionTypePercentages(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().name(),
                        entry -> BigDecimal.valueOf(entry.getValue().size() / (double) userActions.size() * 100)
                                .setScale(2, RoundingMode.HALF_UP)
                                .doubleValue()));
    }
}
