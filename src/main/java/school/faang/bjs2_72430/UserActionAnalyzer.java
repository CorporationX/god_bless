package school.faang.bjs2_72430;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final double PERCENT_COEFFICIENT = 100.0;
    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::user, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(entry -> entry.getKey().name())
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int n) {
        return actions.stream()
                .flatMap(action -> HASHTAG_PATTERN.matcher(action.content()).results()
                        .map(MatchResult::group))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(action -> action.actionType() == ActionType.COMMENT)
                .filter(action -> !action.actionDate().isBefore(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::user, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(entry -> entry.getKey().name())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.actionType().name(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * PERCENT_COEFFICIENT / totalActions
                ));
    }
}
