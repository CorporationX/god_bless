package faang.school.godbless.sprint3.streamAPI.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public static List<Integer> findTopTenUserAction(List<UserAction> userActions) {
        validation(userActions);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findTopFiveContent(List<UserAction> userActions) {
        return userActions.stream()
                .filter(x -> x.getActionType().equals(ActionType.POST) || x.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Integer> findTopThreeUserComment(List<UserAction> userActions) {
        LocalDate timeX = LocalDate.of(2023, 6, 20).minusMonths(1);
        return userActions.stream()
                .filter(x -> x.getActionType().equals(ActionType.COMMENT))
                .filter(x -> x.getActionDate().isAfter(timeX))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> calculatePercentageActionsType(List<UserAction> userActions) {
        Map<ActionType, Long> actions = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        int sum = actions.values().stream().
                mapToInt(Math::toIntExact).
                sum();

        return actions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().doubleValue() / sum * 100));
    }

    private static void validation(List<UserAction> userActions) {
        if (userActions == null || userActions.isEmpty()) {
            throw new IllegalArgumentException("Список null!");
        }
    }
}

