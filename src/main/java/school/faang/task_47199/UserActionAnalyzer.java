package school.faang.task_47199;

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
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("#\\w+");
        return userActions.stream()
                .map(UserAction::getContent)
                .flatMap(str -> pattern.matcher(str).results())
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
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(monthBefore))
                .collect(Collectors.groupingBy(UserAction::getName))
                .values()
                .stream()
                .sorted((userActions1, userActions2) ->
                        Integer.compare(userActions2.size(), userActions1.size()))
                .limit(3)
                .map(user -> user.get(0).getName())
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions));
    }
}
