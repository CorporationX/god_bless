package faang.school.godbless.social.network.activity.analyze;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivityService {

    public static List<UserAction> findTopTenActiveUsers(List<UserAction> userActions) {
        if (userActions.size() <= 10) {
            return userActions;
        }

        Map<Integer, UserAction> idActionMap = userActions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        userAction -> userAction,
                        (existing, replacement) -> existing
                ));

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> idActionMap.get(entry.getKey()))
                .toList();
    }

    public static List<String> findTopFiveHashTag(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.POST)
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s+"))
                        .filter(word -> word.startsWith("#"))
                        .map(String::toLowerCase))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<UserAction> findTopThreeCommentersLastMonth(List<UserAction> userActions) {
        if (userActions.size() <= 3) {
            return userActions;
        }

        Map<Integer, UserAction> idActionMap = userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .collect(Collectors.toMap(
                        UserAction::getId,
                        userAction -> userAction,
                        (existing, replacement) -> existing
                ));

        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> idActionMap.get(entry.getKey()))
                .toList();
    }

    public static Map<ActionType, Integer> calculatePercents(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, entry -> (int) ((entry.getValue() * 100.0) / userActions.size())));
    }
}
