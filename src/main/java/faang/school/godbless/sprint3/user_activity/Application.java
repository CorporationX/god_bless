package faang.school.godbless.sprint3.user_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public List<Integer> getTopTenPopularUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopFivePopularHashTags(List<UserAction> actions) {
        return actions.stream()
                .filter(
                        action -> action.getActionType().equals(ActionType.COMMENT)
                        || action.getActionType().equals(ActionType.POST)
                )
                .flatMap(
                        action -> Arrays.stream(action.getContent().split(" "))
                        .filter(word -> word.startsWith("#"))
                )
                // Не смог понять какую еще функцию применить для группировки
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> getTopThreeUserWitMostComments(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> getAveragePercentageForAction(List<UserAction> actions) {
        // Что-то не смог полностью через стрим организовать метод
        Map<ActionType, Long> actionMap = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Map<ActionType, Double> result = new HashMap<>();

        for (Map.Entry<ActionType, Long> entry : actionMap.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue() / actions.size() * 100);
        }
        return result;
    }
}
