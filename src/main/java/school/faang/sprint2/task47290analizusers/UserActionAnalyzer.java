package school.faang.sprint2.task47290analizusers;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, List<UserAction>> countUsersActive = actions.stream()
                .collect(Collectors.groupingBy(
                        userAction -> userAction.getName()
                ));
        return countUsersActive.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().size(),
                        Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Integer> topTopics = actions.stream()
                .filter(userAction -> userAction.getContent().startsWith("#"))
                .collect(Collectors.groupingBy(
                        action -> action.getContent(),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ));
        return topTopics.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue(), Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionDate().getMonth()
                        == LocalDate.now().minusMonths(1).getMonth())
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().size(),
                        Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Double> actionPercentages = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> ((count.doubleValue() / actions.size()) * 100)
                        )
                ));
        return actionPercentages;

    }
}
