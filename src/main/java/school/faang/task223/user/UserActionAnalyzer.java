package school.faang.task223.user;


import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> returnTop10Users(List<UserAction> list) {
        Map<String, Integer> topUser = list.stream()
                .collect(Collectors.toMap(
                        UserAction::getName,
                        userAction -> 1,
                        (userAction, userAction2) -> userAction + 1));

        return topUser.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topHashtags(List<UserAction> list) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");

        Map<String, Integer> topHashtags = list.stream()
                .filter(userAction -> userAction.getContent().contains("#")).
                collect(Collectors.toMap(
                        userAction -> {
                            int tagPlace = userAction.getContent().indexOf('#');
                            Matcher matcher = pattern.matcher(userAction.getContent().substring(tagPlace + 1));
                            int endOfTeg = userAction.getContent().length() - 1;
                            if (matcher.find()) {
                                endOfTeg = matcher.start() + tagPlace + 1;
                            }
                            return userAction.getContent().substring(tagPlace, endOfTeg);
                        },
                        userAction -> 1,
                        (userAction1, userAction2) -> userAction1 + 1));

        return topHashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommenter(List<UserAction> list) {
        Map<String, Integer> topCommenters = list.stream()
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .collect(Collectors.toMap(
                        UserAction::getName,
                        userAction -> 1,
                        (userAction1, userAction2) -> userAction1 + 1));

        return topCommenters.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> list) {
        int size = list.size();
        return list.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / size));
    }
}
