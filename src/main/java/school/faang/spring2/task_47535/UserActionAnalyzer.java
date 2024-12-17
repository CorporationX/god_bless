package school.faang.spring2.task_47535;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> collect = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return collect.entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                .limit(10).map(Map.Entry::getKey).toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getContent() != null
                        && action.getActionType().equals("post")
                        || action.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(e -> e.startsWith("#"))
                .map(e -> {
                    char lastSymbol = e.charAt(e.length() - 1);
                    if (!(lastSymbol >= 'a' && lastSymbol <= 'z')) {
                        e = e.substring(0, e.length() - 1);
                    }
                    return e;
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> top3CommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType().equals("comment")
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> calculateActionPercentages(List<UserAction> actions) {
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
