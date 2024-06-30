package faang.school.godbless.user_activity;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record UserAction(String id, String name, ActionType actionType, Date actionDate, String content){

    public static List<String> topUsers(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(UserAction::id)).entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size())).limit(10).map(Map.Entry::getKey).toList();
    }

    public static List<String> topTopics(List<UserAction> userActions) {
        Map<String, Integer> topics = new HashMap<>();
        Pattern pattern = Pattern.compile("#(\\w+)");
        userActions.stream().forEach(action -> {
            Matcher matcher = pattern.matcher(action.content);
            while (matcher.find()) {
                String topic = matcher.group(1);
                topics.put(topic, topics.getOrDefault(topic, 0) + 1);
            }
        });

        return topics.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(5).map(Map.Entry::getKey).toList();
    }

    public static List<String> topCommenters(List<UserAction> userActions) {
//        is there a way to reverse it?
//        Comparator.comparingInt(e -> e.getValue().size())
        return userActions.stream().filter(action -> action.actionType == ActionType.COMMENT).collect(Collectors.groupingBy(UserAction::id)).entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size())).limit(3).map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> activityPortion(List<UserAction> userActions) {
        int totalActions = userActions.size();
        return  userActions.stream().collect(Collectors.groupingBy(UserAction::actionType)).entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().size() / (double) totalActions * 100
        ));
    }
}
