package school.faang.bjs2_81134;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topN) {
        return actions.stream()
                .map(action -> Arrays.stream(action.getContent().split(" ")).toList())
                .flatMap(Collection::stream)
                .filter(str -> str.matches("#[A-Za-z]+"))
                .collect(groupingBy(s -> s, counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        return actions.stream()
                .filter(s -> s.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName, counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        int totalActionCount = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(s -> s.getActionType().toString(), counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        s -> {
                            double v = 100 * (double) s.getValue() / totalActionCount;
                            BigDecimal value = new BigDecimal(Double.toString(v));
                            return value.setScale(2, RoundingMode.HALF_UP).doubleValue();
                        }));
    }

}
