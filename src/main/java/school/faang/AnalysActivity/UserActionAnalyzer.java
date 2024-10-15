package school.faang.AnalysActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream().filter(u -> u.getContent().contains("#"))
                .collect(Collectors
                        .groupingBy(
                                n -> Arrays.stream(n.getContent().split("[^a-zA-Z#]+"))
                                        .filter(word -> word.startsWith("#"))
                                        .toList().get(0), Collectors.counting())
                )
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream().filter(a -> a.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        return actions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting())).
                entrySet().stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, entry -> ((entry.getValue() * 100.0) / totalActions)));
    }
}
