package school.faang.sprint_2.task_47143;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name))
                .values()
                .stream()
                .sorted((userActions1, userActions2) ->
                        Integer.compare(userActions2.size(), userActions1.size()))
                .limit(10)
                .map(sortedUserActions -> sortedUserActions.get(0).name())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("#\\w+");
        return userActions.stream()
                .filter(action -> action.actionType() == ActionType.POST
                        || action.actionType() == ActionType.COMMENT)
                .map(UserAction::content)
                .flatMap(string -> pattern.matcher(string).results())
                .map(MatchResult::group)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> Long.compare(s2.getValue(), s1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate monthBefore = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.actionType() == ActionType.COMMENT)
                .filter(action -> action.actionDate().isAfter(monthBefore))
                .collect(Collectors.groupingBy(UserAction::name))
                .values()
                .stream()
                .sorted((userActions1, userActions2) ->
                        Integer.compare(userActions2.size(), userActions1.size()))
                .limit(3)
                .map(userActions1 -> userActions1.get(0).name())
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        Function<Map.Entry<ActionType, List<UserAction>>, Double> percentageCalculator =
                entry -> new BigDecimal(entry.getValue().size())
                        .divide(new BigDecimal(userActions.size()), 4, RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100))
                        .doubleValue();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        percentageCalculator));
    }
}
