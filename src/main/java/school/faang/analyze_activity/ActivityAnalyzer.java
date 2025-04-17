package school.faang.analyze_activity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ActivityAnalyzer {
    private static final Pattern tagPattern = Pattern.compile("#(\\w+)");

    public static List<String> topUsersByActions(List<UserAction> actions, int topToReturn) {
        return actions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong((Map.Entry<UserAction, Long> list) -> list.getValue()).reversed())
                .limit(topToReturn)
                .map(entry -> entry.getKey().getName())
                .toList();
    }

    public static List<String> topHashTags(List<UserAction> actions, int topToReturn) {
        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT)
                .filter(action -> !action.getContent().isBlank())
                .flatMap(action -> tagPattern.matcher(action.getContent())
                        .results()
                        .map(match -> match.group(1)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .map(Map.Entry::getKey)
                .limit(topToReturn)
                .toList();
    }


    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topToReturn) {
        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong((Map.Entry<UserAction, Long> list) -> list.getValue()).reversed())
                .limit(topToReturn)
                .map(entry -> entry.getKey().getName())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(action -> action.getKey().toString(),
                        action -> action.getValue() / (double) actions.size()));
    }
}