package school.faang.collections_stream_api_optional.bjs2_88122;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int limit) {
        Map<String, Long> usersToActionsCount = userActions.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(UserAction::userName, counting()));

        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int limit) {

        Map<String, Long> hashtagToCount = userActions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.content() != null
                        && (List.of(ActionType.COMMENT, ActionType.POST).contains(action.actionType())))
                .flatMap(action -> Arrays.stream(action.content().split("\\\\\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int limit) {

        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentsCount = userActions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.actionType())
                        && action.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));

        return userNameToCommentsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> userActions) {
        int countActions = userActions.size();
        return userActions.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(UserAction::actionType))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        item -> item.getValue().size() * 100 / (double) countActions));
    }
}