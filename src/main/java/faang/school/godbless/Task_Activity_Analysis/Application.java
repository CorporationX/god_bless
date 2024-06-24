package faang.school.godbless.Task_Activity_Analysis;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Application {

    public static List<Integer> findTheMostActiveUsers(List<UserAction> userActions, int numberOfTopUsers) {
        Map<Integer, Integer> namesAndActions = new HashMap<>();
        userActions.forEach(x -> {
            int numberOfActions = (int) userActions.stream().filter(y -> y.getId() == x.getId()).count();
            namesAndActions.put(x.getId(), numberOfActions);
        });
        return namesAndActions.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(numberOfTopUsers)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> findPopularTopics(List<UserAction> userActions, int numberOfTopics) {
        Map<String, Integer> hashtagStats = new HashMap<>();
        List<String> hashtags = userActions.stream().map(UserAction::getContent).
                filter(x -> x.startsWith("#")).toList();
        hashtags.forEach(x -> {
            int quantity = (int) hashtags.stream().filter(y -> y.equals(x)).count();
            hashtagStats.put(x, quantity);
        });
        return hashtagStats.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                limit(numberOfTopics).map(Map.Entry::getKey).toList();
    }

    public static List<Integer> getTopCommentators(List<UserAction> actions, int topN, int lastMonths) {
        LocalDate startDate = LocalDate.now().minusMonths(lastMonths);
        Map<Integer, Long> commentatorCount = actions.stream()
                .filter(action -> action.getActionType().equals(UserAction.ActionType.comment))
                .filter(action -> action.getActionDate().isAfter(startDate))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));
        return commentatorCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<UserAction.ActionType, Double> getStructure(List<UserAction> actions) {
        Map<UserAction.ActionType, Long> actionsCount = actions.stream().
                collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        long totalCount = actionsCount.values().stream().mapToLong(Long::longValue).sum();
        return actionsCount.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey, e->(double) e.getValue() / totalCount * 100));
    }

}
