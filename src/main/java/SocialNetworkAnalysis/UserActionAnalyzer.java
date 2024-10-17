package SocialNetworkAnalysis;

import java.util.*;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<UserAction> topActiveUsers(List<UserAction> userActions) {
        Map<UserAction, Integer> actions = new HashMap<>();

        userActions.forEach(action -> {
            if (actions.containsKey(action)) {
                actions.put(action, actions.get(action) + 1);
            } else {
                actions.put(action, 1);
            }
        });

        return actions.entrySet().stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().toLowerCase().equals("comment") ||
                        action.getActionType().toLowerCase().equals("post"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\\\\\\\\\\\\\\\s+")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()))
                .entrySet().stream()
                .sorted((map1, map2) -> map1.getValue() > map2.getValue() ? -1 : 1)
                .limit(5)
                .map(hashtagMap -> hashtagMap.getKey())
                .toList();



    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().toLowerCase().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((map1, map2) -> map1.getValue() > map2.getValue() ? -1 : 1)
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        int actionSize = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        actionKey -> actionKey.getKey(),
                        actionValue -> Math.round((actionValue.getValue() * 100.0) / actionSize * 100.0) / 100.0
                ));
    }
}
