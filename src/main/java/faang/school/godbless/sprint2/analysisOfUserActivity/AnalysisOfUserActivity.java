package faang.school.godbless.sprint2.analysisOfUserActivity;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AnalysisOfUserActivity {
    private List<UserAction> userActions;

    public List<User> topTenMostActiveUsers() {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUser,
                        Collectors.mapping(UserAction::getActionType, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<User, List<ActionType>>comparingByValue((a, b) -> Integer.compare(b.size(), a.size()))
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }


    public List<String> topicsForDiscussion() {
        return userActions.stream()
                .map(UserAction::getContent)
                .flatMap(string -> Arrays.stream(string.split(" "))
                        .filter(word -> word.startsWith("#")))
                .collect(Collectors.toMap(
                        hashtag -> hashtag,
                        hashtag -> 1, Integer::sum
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public List<User> topThreeMostActiveUsersByComments() {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT)
                        && userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .map(UserAction::getUser)
                .collect(Collectors.toMap(
                        user -> user,
                        user -> 1, Integer::sum
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<User, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public Map<ActionType, Double> percentOfEachActionType() {
        return userActions.stream()
                .map(UserAction::getActionType)
                .collect(Collectors.toMap(
                        actionType -> actionType,
                        actionType -> 1, Integer::sum
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) Math.round((double) entry.getValue() / userActions.size() * 10000) / 100
                ));
    }
}
