package task_BJS2_58091;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        Map<String, Long> map = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        Map<String, Long> words = actions.stream()
                .filter(userAction -> userAction.getContent() != null)
                .filter(userAction -> ActionType.POST.equals(userAction.getActionType())
                        || ActionType.COMMENT.equals(userAction.getActionType()))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return words.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}

