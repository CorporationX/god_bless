package faang.school.godbless.bjs2_22552;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static faang.school.godbless.bjs2_22552.ActionType.COMMENT;
import static faang.school.godbless.bjs2_22552.ActionType.POST;

public class Main {
    public static List<Integer> getTopMostActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopMostPopularTopics(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType() == POST || action.getActionType() == COMMENT)
                .map(UserAction::getContent)
                .flatMap(content -> {
                    Matcher matcher = Pattern.compile("#[^#\\s]+").matcher(content);
                    ArrayList<String> matches = new ArrayList<>();
                    while (matcher.find()) {
                        matches.add(matcher.group());
                    }
                    return matches.stream();
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> getTopUsersWithComments(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusDays(31)))
                .filter(action -> action.getActionType() == COMMENT)
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionsPercentage(List<UserAction> actions) {
        var size = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / size
                ));
    }
}
