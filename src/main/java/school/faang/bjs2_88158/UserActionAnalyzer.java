package school.faang.bjs2_88158;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> String.format("%s:%s", action.getUserId(), action.getUserName()),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(n)
                .map(entry -> entry.getKey().split(":")[1])
                .collect(Collectors.toList());

    }

    public static List<String> topHashtags(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        || action.getActionType() == ActionType.POST)
                .map(UserAction::getContent)
                .filter(Objects::nonNull)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentatorsLastMonth(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        action -> String.format("%s:%s", action.getUserId(), action.getUserName()),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> entry.getKey().split(":")[1])
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {

        long total = actions.stream()
                .filter(Objects::nonNull)
                .count();

        if (total == 0) {
            return Collections.emptyMap();
        }

        return actions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (count * 100.0) / total
                        )
                ));
    }
}
