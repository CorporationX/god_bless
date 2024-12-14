package school.faang.task_47181;

import school.faang.task_47181.model.ActionType;
import school.faang.task_47181.model.UserAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> actions) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");

        return actions.stream()
                .filter(action -> !action.getContent().isBlank())
                .flatMap(action -> {
                    Matcher matcher = hashtagPattern.matcher(action.getContent());
                    List<String> hashtags = new ArrayList<>();
                    while (matcher.find()) {
                        hashtags.add(matcher.group());
                    }
                    return hashtags.stream();
                })
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minusMonths(1).minusDays(1);

        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        Map<ActionType, Long> groupedActions = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return groupedActions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) (entry.getValue() * 100) / actions.size()
                ));
    }
}
