package school.faang.task_60379;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        Objects.requireNonNull(actions, "This object cant be null");
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topN) {
        Objects.requireNonNull(actions, "This object cant be null");
        Pattern hashtagPattern = Pattern.compile("#\\w+");

        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> hashtagPattern.matcher(content)
                        .results()
                        .map(MatchResult::group))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        Objects.requireNonNull(actions, "This object cant be null");
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action ->
                        ActionType.COMMENT.equals(action.getActionType())
                                && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Objects.requireNonNull(actions, "This object cant be null");
        long total = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(),
                        e -> (e.getValue() * 100.0) / total));
    }
}
