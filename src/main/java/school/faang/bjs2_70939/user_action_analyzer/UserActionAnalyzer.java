package school.faang.bjs2_70939.user_action_analyzer;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> userActions, int limit) {
        Map<String, Long> groupingUsersMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingUsersMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions, int limit) {
        Map<String, Long> groupingHashtagsMap = userActions.stream()
                .filter(act -> !(act.getContent().isBlank()))
                .map(UserAction::getContent)
                .flatMap(str -> Arrays.stream(str.split("[\\s\\p{Punct}&&[^#]]+")))
                .filter(word -> !word.isBlank())
                .filter(word -> word.startsWith(String.valueOf('#')))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        return groupingHashtagsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions, int limit) {
        Map<String, Long> groupingCommentersMap = userActions.stream()
                .filter(act -> act.getActionType().equals(ActionType.COMMENT))
                .filter(act -> act.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingCommentersMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static  Map<ActionType, Double> actionTypePercentage(List<UserAction> userActions) {
        int actionCount = userActions.size();
        Map<ActionType, Long> groupingActionsWithCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        log.info("groupingActionsWithCount = {}, actionCount = {}", groupingActionsWithCount, actionCount);
        return groupingActionsWithCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.round((double) entry.getValue() * 100 / actionCount * 10) / 10.0));
    }
}
