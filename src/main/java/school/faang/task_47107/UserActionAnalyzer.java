package school.faang.task_47107;

import school.faang.task_47107.exception.CheckException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions) {
        checkActions(actions);
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        checkActions(actions);
        return actions.stream()
                .filter(action -> action.getContent() != null
                        && !action.getContent().isEmpty()
                        && List.of("post", "comment").contains(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())  // Сортировка по частоте
                .limit(5)
                .map(Map.Entry::getKey).toList();

    }

    public List<String> topCommentersLastMonth(List<UserAction> actions) {
        checkActions(actions);

        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action ->
                        action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        checkActions(actions);
        int actionsSize = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / actionsSize));
    }

    private void checkActions(List<UserAction> actions) {
        if (actions == null) {
            throw new CheckException("actions");
        }
    }
}
