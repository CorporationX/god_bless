package school.faang.sprint2.analysisuseractivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {

        return actions.stream()
                .filter(action -> action.getContent() != null && action.getActionType().equals(ActionType.POST) || action.getActionType().equals(ActionType.COMMENT))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionDate().isAfter(oneMonth) || action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        if (totalActions == 0) {
            return Map.of();
        }
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))  // Группировка по типу действия
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> String.valueOf(entry.getKey()), entry -> (entry.getValue() * 100.0) / totalActions)  // Вычисление процента
                );
    }
}