package school.faang.task_47208;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, String actionType) {
        return actions.stream()
                .filter(x -> x.getActionType().equals(actionType))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(x -> x.getContent() != " " && x.getContent() != null)
                .flatMap(x -> Arrays.stream(x.getContent().split("[ ,.;!]+")))
                .filter(x -> x.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate lastMonthActivity = actions.stream()
                .map(UserAction::getActionDate)
                .max(Comparator.comparing(LocalDate::getMonthValue))
                .get();

        return actions.stream()
                .filter(x -> x.getActionType().equals("comment"))
                .filter(x -> x.getActionDate().getMonthValue() > lastMonthActivity.getMonthValue() - 1)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> action) {
        long sizeActionType = action.size();

        return action.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, x -> (x.getValue() * 100.0 / sizeActionType)));
    }
}
