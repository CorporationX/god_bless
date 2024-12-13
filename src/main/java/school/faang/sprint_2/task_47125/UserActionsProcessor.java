package school.faang.sprint_2.task_47125;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionsProcessor {
    public List<Integer> topMostActiveUsers(List<UserAction> actions, int limit) {
        return returnMostCountEntryInDescendingOrder(actions, limit, UserAction::getId);
    }

    public List<String> topMostActiveHashtags(List<UserAction> actions, int limit) {
        var mostOftenWordsWithHashtags = actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("[^\\w]", ""))
                .toList();
        return returnMostCountEntryInDescendingOrder(mostOftenWordsWithHashtags, limit, Function.identity());
    }

    public List<Integer> topActiveCommentatorsInMonth(List<UserAction> actions, int limit) {
        var currentMonth = YearMonth.from(LocalDate.now());
        var activeCommentatorsFromMonth = actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> currentMonth.equals(YearMonth.from(action.getActionDate())))
                .map(UserAction::getId)
                .toList();
        return returnMostCountEntryInDescendingOrder(activeCommentatorsFromMonth, limit, Function.identity());
    }

    public Map<String, Integer> processPercentForActionType(List<UserAction> actions) {
        float actionsSize = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) (entry.getValue().floatValue() / actionsSize * 100)
                ));
    }

    private <T, R> List<T> returnMostCountEntryInDescendingOrder(
            List<R> list, int limit, Function<R, T> groupingFunction) {
        return list.stream()
                .collect(Collectors.groupingBy(groupingFunction, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Math.toIntExact(b.getValue() - a.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
