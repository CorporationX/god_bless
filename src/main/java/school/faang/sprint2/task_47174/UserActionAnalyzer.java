package school.faang.sprint2.task_47174;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter((action) -> action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT)
                .flatMap(action -> Arrays.stream(action.getText().split(" ")))
                .filter((text) -> text.startsWith("#") && text.length() > 1)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter((action) -> action.getActionType() == ActionType.COMMENT
                        && action.getDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        int actionsNumber = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        (entry) -> (entry.getValue() * 100.0) / actionsNumber
                ));
    }
}
