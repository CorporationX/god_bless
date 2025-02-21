package school.faang.activity.analysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    public static List<String> topActiveUser(List<UserAction> actions, int topN) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topN) {
        return actions.stream()
                .filter(action -> action.getContent() != null && (action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT))
                .flatMap(action -> HASHTAG_PATTERN.matcher(action.getContent())
                        .results().map(matchResult -> matchResult.group()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        LocalDate now = LocalDate.now();
        LocalDate startOfLastMonth = now.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfLastMonth = startOfLastMonth.withDayOfMonth(startOfLastMonth.lengthOfMonth());

        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT && !action.getActionDate()
                        .isBefore(startOfLastMonth) && !action.getActionDate().isAfter(endOfLastMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
