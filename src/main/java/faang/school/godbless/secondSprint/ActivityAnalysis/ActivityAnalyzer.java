package faang.school.godbless.secondSprint.ActivityAnalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityAnalyzer {
    public List<String> findMostActiveUsers(List<UserAction> actions, int limit) {
        Map<String, Long> users = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return users.entrySet().stream()
                .sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey).toList();
    }

    public List<String> findMostPopularTopic(List<UserAction> actions, int limit) {
        Map<String, Long> hashtags = actions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey).toList();
    }

    public List<String> findMostActiveCommentator(List<UserAction> actions, int monthCount, int limit) {
        Map<String, Long> commentators = actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(monthCount)))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return commentators.entrySet().stream()
                .sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey).toList();
    }

    public Map<ActionType, Double> calculatePercentOfEachActions(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        Collectors.collectingAndThen(Collectors.counting(),
                                count -> (double) count / actions.size() * 100)));

    }
}
