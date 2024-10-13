package school.faang.useranalitics;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class UserActionAnalyzer {

    public List<Integer> getTopActiveUsers(List<UserAction> actions) {
        Objects.requireNonNull(actions, "Actions cannot be null");

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopPopularHashtags(List<UserAction> actions) {
        Objects.requireNonNull(actions, "Actions cannot be null");

        return actions.stream()
                .filter(action ->
                        action.getActionType() == UserAction.ActionType.POST ||
                        action.getActionType() == UserAction.ActionType.COMMENT
                )
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> getTopCommentersLastMonth(List<UserAction> actions) {
        Objects.requireNonNull(actions, "Actions cannot be null");

        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType() == UserAction.ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> getActionTypePercentages(List<UserAction> actions) {
        Objects.requireNonNull(actions, "Actions cannot be null");

        double actionsCount = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().name(), entry -> entry.getValue() / actionsCount * 100
                ));
    }
}
