package school.faang.bjs2_58285;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> topActiveUsers(@NonNull List<UserAction> actions, int limit) {
        Map<String, Long> usersToActionsCount = actions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        Map<String, Long> wordCount = actions
                .stream()
                .filter(action -> action.getContent() != null)
                .flatMap(action -> Arrays.stream(action.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> comment = actions
                .stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isAfter(oneMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return comment
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long quantityAction = actions.size();
        Map<ActionType, Long> actionTypeCount = actions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / quantityAction));
    }
}
