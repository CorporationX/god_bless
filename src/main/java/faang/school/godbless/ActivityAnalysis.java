package faang.school.godbless;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityAnalysis {
    public static List<Integer> findTopTenActiveUsers(List<UserAction> userActionList){
        validateList(userActionList);
        return userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int) (s2.getValue() - s1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopFiveHashTag(List<UserAction> userActionList){
        validateList(userActionList);
        return userActionList.stream()
                .filter(obj -> obj.getActionType().equals(ActionType.POST) || obj.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int) (s2.getValue() - s1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findTopThreeUserComments(List<UserAction> userActionList){
        LocalDate timeX = LocalDate.of(2023, 6, 28).minusMonths(1);
        return userActionList.stream()
                .filter(obj -> obj.getActionType().equals(ActionType.COMMENT))
                .filter(obj -> obj.getActionDate().isAfter(timeX))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int)(s2.getValue() - s1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> findPercentActionsTypes(List<UserAction> userActionList){
        Map<ActionType, Long> actions = userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        int sum = actions.values().stream().
                mapToInt(Math::toIntExact).
                sum();

        return actions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().doubleValue() / sum * 100));
    }

    public static void validateList(List<UserAction> userActions){
        if (userActions.isEmpty() || userActions == null){
            throw new IllegalArgumentException("Empty List!");
        }
    }
}
