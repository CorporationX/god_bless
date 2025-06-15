package school.faang.activityanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> getTopNUsers(List<UserAction> userActions, int n) {
        Map<Integer, Long> usersMap = userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId, Collectors.counting()
                ));

        return sortedUsers(userActions, n, usersMap);
    }

    public static List<String> mostPopularHashtags(List<UserAction> userActions, int n) {
        return userActions.stream()
                .filter(action -> action.getActionType() == ActionType.POST || action.getActionType() == ActionType.COMMENT)
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .map(word -> word.replaceAll("\\p{Punct}+$", ""))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> mostActiveUsers(List<UserAction> userActions, int n) {
        Map<Integer, Long> usersMap = userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> {
                    LocalDate timestamp = action.getActionDate();
                    return timestamp.getYear() == 2024 && timestamp.getMonthValue() == 10;
                })
                .collect(Collectors.groupingBy(
                        UserAction::getId, Collectors.counting()
                ));

        return sortedUsers(userActions, n, usersMap);

    }

    private static List<String> sortedUsers(List<UserAction> userActions, int n, Map<Integer, Long> usersMap) {
        Map<Integer, String> idToName = userActions.stream()
                .collect(Collectors.toMap(UserAction::getId, UserAction::getName, (a, b) -> a));

        return usersMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> idToName.get(entry.getKey()))
                .toList();
    }

    public static Map<ActionType, Double> calculatePercent(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions.size()
                ));
    }
}
