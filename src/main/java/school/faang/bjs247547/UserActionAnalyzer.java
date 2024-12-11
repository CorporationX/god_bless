package school.faang.bjs247547;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static school.faang.bjs247547.ActionType.COMMENT;
import static school.faang.bjs247547.ActionType.POST;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(el -> el.getActionType() != null
                        && (el.getActionType() == POST || el.getActionType() == COMMENT))
                .flatMap(el -> Arrays.stream(el.getContent().split("\\s+")))
                .filter(el -> el.startsWith("#"))
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(el -> el.getActionType() == COMMENT
                        && el.getActionDate().isAfter(LocalDate.now().minusMonths(1))
                        && el.getActionDate().isBefore(LocalDate.now()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        el -> el.getKey().name(),
                        el -> (double) (el.getValue() * 100) / actions.size()
                ));
    }

}
