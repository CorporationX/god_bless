package faang.school.godbless.social.network.activity.analyze;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActivityService {
    private static final int NUMBER_OF_TOP_ACTIVE_USERS = 10;
    private static final int NUMBER_OF_TOP_POPULAR_HASHTAG = 5;
    private static final int NUMBER_OF_TOP_ACTIVE_COMMENTATORS = 3;

    public static List<Integer> findTopTenActiveUsers(List<UserAction> userActions) {

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(NUMBER_OF_TOP_ACTIVE_USERS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopFiveHashTag(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.POST
                        || userAction.getActionType() == ActionType.COMMENT)
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s+"))
                        .filter(word -> word.startsWith("#"))
                        .map(String::toLowerCase))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(NUMBER_OF_TOP_POPULAR_HASHTAG)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findTopThreeCommentatorsLastMonth(List<UserAction> userActions) {

        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(NUMBER_OF_TOP_ACTIVE_COMMENTATORS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Integer> calculatePercents(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, entry -> (int) ((entry.getValue() * 100.0) / userActions.size())));
    }
}
