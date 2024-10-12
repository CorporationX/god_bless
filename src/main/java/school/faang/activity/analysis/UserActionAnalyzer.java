package school.faang.activity.analysis;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, List<UserAction>> userToAction = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName));
        return topBy(userToAction, 10,
                (entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        String regex = "#\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Long> numOfMentions = actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> {
                    Stream.Builder<String> streamBuilder = Stream.builder();
                    Matcher matcher = pattern.matcher(content);
                    while (matcher.find()) {
                        streamBuilder.add(matcher.group());
                    }
                    return streamBuilder.build();
                })
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));
        return topBy(numOfMentions, 5,
                (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, List<UserAction>> userToComments = actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(
                        UserAction::getUserName));
        return topBy(userToComments, 3,
                (entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> typeActionToCount = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ));
        long sumActions = typeActionToCount.values().stream()
                .mapToLong(Long::longValue)
                .sum();
        return typeActionToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 1.0 / sumActions
                ));
    }

    private static <K, V> List<K> topBy(Map<K, V> numOfMentions, int topSize,
                                        Comparator<Map.Entry<K, V>> comparator) {
        return numOfMentions.entrySet().stream()
                .sorted(comparator)
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }
}
