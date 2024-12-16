package school.faang.bjs247099;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

@UtilityClass
public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.content() != null
                        && action.actionType().equals("post") || action.actionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.content().split("\\\\\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.actionType().equals("comment")
                        && action.actionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(user -> user.name(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        e -> Math.round(e.getValue() * 100.0 / actions.size()) / 100.0
                ));
    }
}