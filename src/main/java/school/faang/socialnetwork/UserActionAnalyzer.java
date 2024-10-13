package school.faang.socialnetwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        Map<String, Long> userActivityCount = userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return userActivityCount
                .entrySet()
                .stream()
                .sorted((value1, value2) -> Long.compare(value2.getValue(), value1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");
        Map<String, Long> hashTagCount = userActions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.POST)
                        || userAction.actionType().equals(ActionType.COMMENT))
                .flatMap(userAction -> extractHashtags(userAction.content(), hashtagPattern).stream())
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()));

        return hashTagCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> extractHashtags(String content, Pattern hashtagPattern) {
        List<String> hashtags = new ArrayList<>();
        Matcher matcher = hashtagPattern.matcher(content);
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }


    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        Map<String, Long> userComments = userActions
                .stream()
                .filter(userAction ->
                        userAction.actionDate().isAfter(LocalDate.now().minusDays(30)))
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return userComments.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        Map<ActionType, Long> actionCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionCount
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                        entry -> Math.round(((entry.getValue() * 100.0) / userActions.size()) * 100.0) / 100.0));
    }
}
