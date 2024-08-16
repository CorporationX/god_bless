package faang.school.godbless.task.lambda.analitics.of.users.activity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActivityManager {
    private static final int MOST_ACTIVE_USERS_LIMIT = 10;
    private static final int DISCUSSIONS_TOPICS_LIMIT = 5;
    private static final int USERS_LEFT_COMMENTS_LIMIT = 3;

    public Map<Long, String> topTenMostActiveUsers(List<UserAction> userActions) {
        Map<Long, String> idAndUsername = getAllIdAndUsername(userActions);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                .limit(MOST_ACTIVE_USERS_LIMIT)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> idAndUsername.get(entry.getKey())
                ));
    }

    public List<String> topFiveDiscussionTopics(List<UserAction> userActions) {
        Pattern HASH_TAG_PATTERN = Pattern.compile("#(\\w+)");
        return userActions.stream()
                .flatMap(action -> {
                    Matcher mat = HASH_TAG_PATTERN.matcher(action.getContent());
                    return Stream.generate(() -> {
                        if (mat.find()) {
                            return mat.group(1);
                        } else {
                            return null;
                        }
                    }).takeWhile(Objects::nonNull);
                })
                .collect(Collectors.groupingBy(
                        topic -> topic,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                .limit(DISCUSSIONS_TOPICS_LIMIT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Long, String> topThreeUsersLeftMostComments(List<UserAction> userActions) {
        Map<Long, String> idAndUsername = getAllIdAndUsername(userActions);
        return userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT) &&
                        action.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                .limit(USERS_LEFT_COMMENTS_LIMIT)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> idAndUsername.get(entry.getKey())));
    }

    public Map<ActionType, Double> calculatePercentsOfActivity(List<UserAction> userActions) {
        double commonActivity = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() / commonActivity) * 100));
    }

    private Map<Long, String> getAllIdAndUsername(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.toMap(UserAction::getId, UserAction::getName, (k1, k2) -> k1));
    }
}
