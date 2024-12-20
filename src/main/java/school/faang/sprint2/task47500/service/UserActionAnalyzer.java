package school.faang.sprint2.task47500.service;

import school.faang.sprint2.task47500.model.ActionType;
import school.faang.sprint2.task47500.model.UserAction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    private static final String WORD_REGEX = "[,.!\\s]+";
    private static final String HASHTAG_SIGN = "#";

    public static List<String> getTopActiveUsers(List<UserAction> userActions, int topSize) {

        Map<String, Long> mapGroupedByAction = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return mapGroupedByAction.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static List<String> getTopPopularHashtags(List<UserAction> userActions, int topSize) {

        Map<String, Long> mapGroupedByTag = userActions.stream()
                .filter(a -> a.getActionType().equals(ActionType.COMMENT) && !a.getContent().isEmpty())
                .flatMap(a -> Stream.of(a.getContent().split(WORD_REGEX)))
                .filter(w -> w.startsWith(HASHTAG_SIGN))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return mapGroupedByTag.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> userActions, int topSize) {

        Map<String, Long> mapGroupedByAction = userActions.stream()
                .filter(a -> (a.getActionType().equals(ActionType.COMMENT)
                        && a.getActionDate().isAfter(LocalDate.now().minusDays(365))))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return mapGroupedByAction.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(topSize)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        double userActionsQuantity = userActions.size();
        Map<ActionType, Long> mapGroupedByAction = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return mapGroupedByAction.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0 / userActionsQuantity))
                );
    }

}
