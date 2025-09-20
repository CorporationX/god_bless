package school.faang.bjs2_88333;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int userCount) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(userCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int hashtagCount) {
        return actions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.POST
                        || userAction.getActionType() == ActionType.COMMENT)
                .map(UserAction::getContent)
                .flatMap(str -> Arrays.stream(str.split("\\s+")))
                .filter(str -> str.startsWith("#"))
                .map(str -> str.replaceAll("[!?.,;:]+$", ""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(hashtagCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int userCount) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(userCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        int totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue().doubleValue() / totalActions) * 100
                ));
    }
}
