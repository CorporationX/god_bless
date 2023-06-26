package faang.school.godbless;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SocialNetworkAnalyzer {
    public List<UserAction> getTop10ActiveUsers(List<UserAction> userActions) {
        Map<String, Long> userActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return userActionsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(entry -> userActions.stream()
                        .filter(action -> action.getId().equals(entry.getKey()))
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toList());
    }

    public List<String> getTop5PopularTopics(List<UserAction> userActions) {
        Map<String, Long> topicCount = userActions.stream().filter(action -> action.getContent().contains("#"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return topicCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<UserAction> getTop3UsersWithMostCommentsLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minus(Period.ofMonths(1));
        Map<String, Long> userCommentCount = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(oneMonthAgo.atStartOfDay()))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return userCommentCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> userActions.stream()
                        .filter(action -> action.getId().equals(entry.getKey()))
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toList());
    }

    public Map<ActionType, Double> getActionTypePercentages(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypesCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        long totalActions = actionTypesCount.values().stream().mapToLong(Long::longValue).sum();
        return actionTypesCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() / (double) totalActions)
                ));

    }
}
