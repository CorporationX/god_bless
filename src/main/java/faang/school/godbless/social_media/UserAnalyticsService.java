package faang.school.godbless.social_media;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserAnalyticsService {
    public static List<String> getTopActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).toList();

    }

    public static List<String> getTopTopics(List<UserAction> actions, int limit) {
        return actions.stream().collect(Collectors.groupingBy(action -> extractTopic(action.getContent())
                , Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).toList();
    }

    private static String extractTopic(String input) {
        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static List<String> getTopCommenters(List<UserAction> actions, int limit) {
        return actions.stream().filter(action -> Objects.equals(action.getActionType(), "comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).toList();
    }

    public static Map<String, Long> getActionsPercentage(List<UserAction> actions) {
        int count = actions.size();
        return actions.stream().collect(Collectors.groupingBy(UserAction::getActionType
                , Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() * 100 / count));
    }

}
