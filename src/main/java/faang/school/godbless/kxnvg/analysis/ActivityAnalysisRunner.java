package faang.school.godbless.kxnvg.analysis;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static faang.school.godbless.kxnvg.analysis.ActionType.*;

public class ActivityAnalysisRunner {

    public static List<Integer> searchTop10MostActiveUsers(List<UserAction> userActions) {
        return userActions.stream().collect(
                Collectors.groupingBy(UserAction::getId, Collectors.counting())
                )
                .entrySet().stream()
                .sorted(Collections.reverseOrder())
                .limit(10)
                .map(Map.Entry::getKey).collect(Collectors.toList());

    }

    public static List<String> searchTop5MostPopularTopics(List<UserAction> userActions) {
        return userActions.stream().filter(action -> action.getActionType().equals(COMMENT) || action.getActionType().equals(POST))
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder())
                .limit(5)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<Integer> searchTop3UsersWithLargestNumberOfComments(List<UserAction> userActions) {
        LocalDateTime filterTime = LocalDateTime.now().minusMonths(1);

        return userActions.stream().filter(action -> action.getActionType().equals(COMMENT))
                .filter(action -> action.getActionDate().isAfter(filterTime))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static Map<ActionType, Double> calculatePercentageOfActions(List<UserAction> userActions) {
        Map<ActionType, Long> sortedActionTypesMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        int totalUserActions = userActions.size();

        return sortedActionTypesMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> Double.valueOf(entry.getValue() / totalUserActions * 100)));
    }
}
