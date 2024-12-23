package useractiv;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        final int num = 10;
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        final int mag = 5;

        return actions.stream()
                .filter(action -> action.content() != null && action.actionType().equals("post")
                        || action.actionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.content().split("\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(mag)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        final int soft = 3;

        return actions.stream()
                .filter(action -> action.actionType().equals("comment")
                        && action.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(soft)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        final double number = 100.0;
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.actionType().name(),
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue().doubleValue() * number) / totalActions
                ));
    }
}
