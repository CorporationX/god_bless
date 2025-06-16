package school.faang.bjs2_81019;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topN) {
        Pattern pattern = Pattern.compile("\\\\s+");
        var beginningCharacter = '#';
        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action ->
                        action.getContent() != null
                                && ActionType.POST.equals(action.getActionType())
                                || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(pattern.split(action.getContent())))
                .filter(word -> word.startsWith(String.valueOf(beginningCharacter)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action ->
                        ActionType.COMMENT.equals(action.getActionType())
                                && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        double totalPercentage = 100.0;
        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        (entry.getValue() * totalPercentage) / totalActions));
    }
}
