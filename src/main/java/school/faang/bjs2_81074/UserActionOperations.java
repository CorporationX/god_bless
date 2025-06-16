package school.faang.bjs2_81074;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class UserActionOperations {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> countUsersAction = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return countUsersAction.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> actions, int n) {
        Map<String, Long> countHashTag = actions.stream()
                .filter(action -> action.getContent() != null && ActionType.POST.equals(action.getActions())
                        || ActionType.COMMENT.equals(action.getActions()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return countHashTag.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentUsers(List<UserAction> actions, int n) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> countTopCommentUsers = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActions())
                        && action.getActionDate().isAfter(oneMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return countTopCommentUsers.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        Map<ActionType, Long> countActionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActions, Collectors.counting()));
        return countActionType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions));
    }
}
