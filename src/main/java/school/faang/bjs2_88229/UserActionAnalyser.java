package school.faang.bjs2_88229;

import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class UserActionAnalyser {

    public List<String> topActiveUsers(List<UserAction> actions, int count) {
        Map<String, Long> actionsByUser = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return  actionsByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topUsableHashtags(List<UserAction> actions, int count) {
        Map<String, Long> hashtagCount = actions.stream()
                .filter(action -> action.getContent() != null && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topCommenters(List<UserAction> actions, int count) {
        LocalDate monthAgo = LocalDate.now().minusMonths(1);

        Map<String, Long> commentsByUser = actions.stream()
                .filter(userAction -> ActionType.COMMENT.equals(userAction.getActionType())
                        && userAction.getActionDate().isAfter(monthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return commentsByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> calculatePercentagesOfAction(List<UserAction> actions) {
        long numbersOfAction = actions.size();

        Map<ActionType, Long> actionTypeCount =  actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> ((entry.getValue() * 100.0) / numbersOfAction)
                ));
    }
}