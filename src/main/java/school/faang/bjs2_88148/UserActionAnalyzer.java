package school.faang.bjs2_88148;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<Integer> topActiveUsers(List<UserAction> userActions, int count) {
        return getTopN(userActions, UserAction::getUserId, count);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int count) {
        Pattern pattern = Pattern.compile("#\\w+");

        return actions.stream()
                .filter(action -> !action.getContent().isBlank()
                        && action.getActionType().equals(ActionType.COMMENT)
                        || action.getActionType().equals(ActionType.POST))
                .flatMap(action -> pattern.matcher(action.getContent()).results())
                .map(MatchResult::group)
                .collect(Collectors.groupingBy(
                        hashtag -> hashtag,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> topCommentersLastMonth(List<UserAction> actions, int count) {
        LocalDate maxDate = actions.stream()
                .map(UserAction::getActionDate)
                .max(LocalDate::compareTo)
                .orElseThrow();

        YearMonth lastYearMonth = YearMonth.from(maxDate);

        List<UserAction> filteredActions = actions.stream()
                .filter(action -> YearMonth.from(action.getActionDate()).equals(lastYearMonth)
                        && action.getActionType() == ActionType.COMMENT)
                .toList();

        return getTopN(filteredActions, UserAction::getUserId, count);
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        int countActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double percent = (entry.getValue() * 100.0) / countActions;
                            return Math.round(percent * 100.0) / 100.0;
                        }
                ));
    }

    private static <T> List<T> getTopN(List<UserAction> actions,
                                       Function<UserAction, T> keyMapper,
                                       int count) {
        return actions.stream()
                .collect(Collectors.groupingBy(keyMapper, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }
}
