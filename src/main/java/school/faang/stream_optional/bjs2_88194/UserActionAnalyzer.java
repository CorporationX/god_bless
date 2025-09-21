package school.faang.stream_optional.bjs2_88194;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> getTopActiveUsers(List<UserAction> actions, int limit) {
        final Map<String, Integer> userNameMap = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::userName,
                        Collectors.summingInt(i -> 1)
                ));

        return sortMapAndReturnList(userNameMap, limit);
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int limit) {
        Map<String, Integer> hashTagMap = actions.stream()
                .filter(action -> action.content() != null
                        && (ActionType.POST.equals(action.actionType())
                        || ActionType.COMMENT.equals(action.actionType())))
                .flatMap(action -> Arrays.stream(action.content().split("\\\\\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));
        return sortMapAndReturnList(hashTagMap, limit);
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int limit) {
        final Map<String, Integer> userNameMap =

                actions.stream()
                        .filter(action -> action.content() != null && !action.content().isBlank()
                                && action.actionDate().getMonth().getValue() == LocalDate.now().getMonth().getValue())
                        .collect(Collectors.groupingBy(UserAction::userName, Collectors.summingInt(i -> 1)));

        return sortMapAndReturnList(userNameMap, limit);
    }

    public static Map<ActionType, Double> getActionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Long> actionTypesToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        return actionTypesToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() / actions.size() * 100
                ));
    }

    private static List<String> sortMapAndReturnList(Map<String, Integer> mapToSort, int limitToReturn) {
        return mapToSort.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limitToReturn)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}