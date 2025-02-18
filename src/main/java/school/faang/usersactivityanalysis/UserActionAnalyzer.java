package school.faang.usersactivityanalysis;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> findTopActiveUsers(@NonNull List<UserAction> actions, int limit) {
        Map<String, Long> userActionCounter = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActionCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopPopularContent(@NonNull List<UserAction> actions, int limit) {
        Map<String, Long> contentCounter = actions.stream()
                .filter(action -> action.getContent() != null
                        && ActionType.COMMENT.equals(action.getActionType())
                        || ActionType.POST.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("[^#\\w]", ""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return contentCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findMaxUsersWithComment(@NonNull List<UserAction> actions, int limit) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> userActionCounter = actions.stream()
                .filter(action -> action.getActionType() != null
                        && ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isBefore(oneMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActionCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        long actionSize = actions.size();
        Map<ActionType, Long> actionTypePercentages = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypePercentages.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actionSize
                ));
    }

}
