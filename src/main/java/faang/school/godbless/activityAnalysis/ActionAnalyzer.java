package faang.school.godbless.activityAnalysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionAnalyzer {
    public List<Integer> topTenActiveUsers (List<UserAction> userActions) {
        return userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topFivePopularThemes (List<UserAction> userActions) {
        return userActions
                .stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .collect(Collectors.groupingBy(content -> content.replace("#", ""), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> topThreeCommenters (List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> getActionTypePercentage (List<UserAction> userActions) {
        return userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() / userActions.size() * 100
                ));
    }
}
