package school.faang.сollection__stream_api__optional.bjs2_88103;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> userActions, int limit) {
        Map<String, Long> usersToActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions, int limit) {
        Map<String, Long> hashtagToCount = userActions.stream()
                .filter(action ->
                        action.getContent() != null && (ActionType.POST.equals(action.getActionType())
                                || ActionType.COMMENT.equals(action.getActionType()))
                )
                .flatMap(action -> Arrays.stream(action.getContent().split(" +[^.!?]")))
                .filter(hashtag -> hashtag.startsWith("#"))
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions, int limit) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> usersToCommentCount = userActions.stream()
                .filter(action -> action.getContent() != null
                        && ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return usersToCommentCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();
        Map<ActionType, Long> actionPercentages = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionPercentages.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> entry.getValue() * 100 / totalActions));
    }
}
