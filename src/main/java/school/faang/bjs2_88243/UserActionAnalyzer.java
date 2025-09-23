package school.faang.bjs2_88243;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Pattern hashtagPattern = Pattern.compile("#([\\p{L}\\d_]+)");

        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> action.getContent() != null
                        && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType())) // Отбираем посты и комменты
                .flatMap(action -> {
                    assert action.getContent() != null;
                    return hashtagPattern.matcher(action.getContent()).results() //отбираем хэштеги
                            .map(MatchResult::group);
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 100.0 / totalActions
                ));
    }
}
