package faang.school.godbless.ActivityAnalyzer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityAnalyzer {
    public Map<Integer, Long> mostActive(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, Long> mostPopularContent(List<UserAction> userActions) {
        return userActions.stream()
                .flatMap(e -> Arrays.stream(e.getContent().split(" ")).filter(word -> word.contains("#")))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<Integer, Long> mostCommentInLastMonth(List<UserAction> userActions) {
        return userActions.stream()
                .filter(action -> action.getActionDate().toEpochDay() > LocalDate.now().minusMonths(1).toEpochDay()
                        && action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<ActionType, String> pieOfActions(List<UserAction> userActions) {
        Map<ActionType, Long> groupedByActionType = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        Long allActionsCount = groupedByActionType.values().stream().reduce(0L, Long::sum);
        return groupedByActionType.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            double a = (((double) entry.getValue() / allActionsCount) * 100);
                            return decimalFormat.format(a).concat("%");
                        }));
    }
}
