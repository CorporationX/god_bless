package school.faang.task_57966;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        Map<String, Long> users = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int top) {
        Map<String, Long> hashtags = actions.stream()
                .filter(action -> action.getContent() != null && ActionType.POST.equals(action.getActionType()) || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }
//    public List<String> topCommentersLastMonth () {
//
//    }
//    public actionTypePercentages
}
