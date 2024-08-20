package faang.school.godbless.activityAnalysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionAnalyzer {
    public List<Integer> topTenActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> map = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topFivePopularThemes(List<UserAction> userActions) {
        Map<String, Long> map = userActions.stream()
                .map(UserAction::getContent)
                .filter(content -> content.startsWith("#"))
                .collect(Collectors.groupingBy(content -> content.replace("#", ""), Collectors.counting()));
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> topThreeCommenters(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<Integer, Long> map = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT) && userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> getActionTypePercentage(List<UserAction> userActions) {
        Map<ActionType, Long> map = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() / userActions.size() * 100
                ));
    }
}
