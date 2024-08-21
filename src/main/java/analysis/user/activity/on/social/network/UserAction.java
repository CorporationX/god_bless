package analysis.user.activity.on.social.network;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@AllArgsConstructor
@Getter
public class UserAction {
    private final static int LIMIT_10 = 10;
    private final static int LIMIT_5 = 5;
    private final static int LIMIT_3 = 3;
    private final static double PERCENTAGE_MULTIPLIER = 100.0;

    private final long userId;
    private final ActionType actionType;
    private final LocalDateTime actionDate;
    private final String content;

    public static List<Long> getTop10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
            .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(LIMIT_10)
            .map(Map.Entry::getKey)
            .toList();
    }

    public static List<String> getTop5Topic(List<UserAction> userActions) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");
        List<ActionType> filteredTypes = Arrays.asList(ActionType.COMMENT, ActionType.COMMENT);

        Map<String, Long> hashtagCounts = userActions.stream()
                .filter((userAction) -> filteredTypes.contains(userAction.getActionType()))
                .flatMap(action -> {
                    Matcher matcher = hashtagPattern.matcher(action.getContent());
                    List<String> hashtags = new ArrayList<>();

                    while (matcher.find()) {
                        hashtags.add(matcher.group());
                    }

                    return hashtags.stream();
                })
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()));

        return hashtagCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(LIMIT_5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Long> getTop3ActiveCommentators(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().getMonth().equals(LocalDateTime.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LIMIT_3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getPercentActionsByType(List<UserAction> userActions) {
        int totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> (entry.getValue() * PERCENTAGE_MULTIPLIER) / totalActions
                ));
    }
}
