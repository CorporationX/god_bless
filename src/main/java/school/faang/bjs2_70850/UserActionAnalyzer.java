package school.faang.bjs2_70850;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions, int count) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int count) {
        return actions.stream()
                .filter(action -> action.actionType() == ActionType.POST || action.actionType() == ActionType.COMMENT)
                .flatMap(action -> Arrays.stream(action.content().split(" ")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();

    }

    public List<String> topCommentersLastMonth(List<UserAction> actions, int count) {
        return actions.stream()
                .filter(action -> action.actionType() == ActionType.COMMENT)
                .filter(action -> action.actionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(action -> action.getKey().toString(),
                        entry -> (entry.getValue() * 100.0) / actions.size()));
    }
}