package faang.school.godbless.secondsprint.socialnetwork;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> getTopActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.getId() + "-" + action.getName(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> {
                    String[] parts = entry.getKey().split("-", 2);
                    return parts[1] + " (id:" + parts[0] + ")";
                })
                .collect(Collectors.toList());
    }

    public static List<String> getTopHashtags(List<UserAction> actions) {
        return actions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions) {
        LocalDateTime overLastMonth = LocalDateTime.now().minusMonths(1);

        return actions.stream()
                .filter(action -> "comment".equals(action.getActionType()))
                .filter(action -> !action.getActionDate().isBefore(overLastMonth))
                .collect(Collectors.groupingBy(
                        action -> action.getId() + "-" + action.getName(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> {
                    String[] parts = entry.getKey().split("-", 2);
                    return parts[1] + " (id:" + parts[0] + ")";
                })
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getActionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
