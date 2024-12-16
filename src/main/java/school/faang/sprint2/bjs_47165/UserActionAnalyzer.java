package school.faang.sprint2.bjs_47165;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topLimit) {
        if (topLimit <= 0) {
            throw new IllegalArgumentException("Parameter for top user's must be greater than 0. ");
        }
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topLimit) {
        if (topLimit <= 0) {
            throw new IllegalArgumentException("Parameter for top user's must be greater than 0. ");
        }
        return actions.stream()
                .filter(action -> (action.actionType().equals("post") || action.actionType().equals("comment")))
                .map(UserAction::content)
                .flatMap(message -> Arrays.stream(message.split("[\\s;:,.!?]+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topLimit) {
        if (topLimit <= 0) {
            throw new IllegalArgumentException("Parameter for top user's must be greater than 0. ");
        }
        LocalDate timePeriod = LocalDate.now().minusMonths(4);
        return actions.stream()
                .filter(action -> action.actionType().equals("comment")
                                  && action.actionDate().isAfter(timePeriod))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions.size()));
    }
}
