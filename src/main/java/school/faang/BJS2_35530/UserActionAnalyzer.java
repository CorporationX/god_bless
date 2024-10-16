package school.faang.BJS2_35530;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
            .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(10)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
            .filter(action -> Set.of("post", "comment").contains(action.getActionType()))
            .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
            .filter(word -> word.startsWith("#"))
            .map(word -> word.replaceAll("[^#\\w]", ""))
            .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(5)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);

        return actions.stream()
            .filter(action -> action.getActionType().equals("comment") && action.getActionDate().isAfter(lastMonth))
            .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
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
