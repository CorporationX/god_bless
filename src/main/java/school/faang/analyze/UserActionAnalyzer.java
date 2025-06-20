package school.faang.analyze;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topOfUserActivitiesByLimit(List<UserAction> userActionList, int limit) {
        return userActionList.stream().collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topTagsByLimit(List<UserAction> userActionList, int limit) {
        return userActionList.stream()
                .flatMap(userAction ->
                        Arrays.stream(userAction.getContent().split("\\s+"))
                                .map(content -> content.replaceAll("^[^#\\w]+|\\W+$", ""))
                                .filter(content -> content.startsWith("#") && content.length() > 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActionList, int limit) {
        return userActionList.stream()
                .filter(userAction -> userAction.getActionDate().isBefore(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        double total = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(userAction ->
                        userAction.getActionType().toString(), Collectors.collectingAndThen(
                        Collectors.counting(), count -> total == 0 ? 0.0 : count * 100 / total)
                ));
    }

}
