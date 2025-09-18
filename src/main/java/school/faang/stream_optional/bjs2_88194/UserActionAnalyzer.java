package school.faang.stream_optional.bjs2_88194;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserActionAnalyzer {

    public static List<String> getTopActiveUsers(List<UserAction> actions, int limit) {
        final Map<String, Integer> userNameMap = new HashMap<>();

        actions.forEach(action ->
                userNameMap.put(
                        action.getUserName(),
                        (userNameMap.get(action.getUserName()) == null
                                ? 0
                                : userNameMap.get(action.getUserName())) + 1
                ));

        return sortMapAndReturnList(userNameMap, limit);
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int limit) {
        final Map<String, Integer> hashTagMap = new HashMap<>();

        actions.stream()
                .filter(action -> action.getContent().contains("#"))
                .forEach(action -> {
                    final Pattern pattern = Pattern.compile("#[\\w]+(?=[\\s\\p{Punct}]|$)");
                    final Matcher matcher = pattern.matcher(action.getContent());

                    final List<String> hashTags = new ArrayList<>();

                    while (matcher.find()) {
                        hashTags.add(matcher.group().substring(1));
                    }

                    for (String hashTag : hashTags) {
                        hashTagMap.put(
                                hashTag,
                                (hashTagMap.get(hashTag) == null ? 0 : hashTagMap.get(hashTag)) + 1
                        );
                    }
                });

        return sortMapAndReturnList(hashTagMap, limit);
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int limit) {
        final Map<String, Integer> userNameMap = new HashMap<>();

        actions.stream()
                .filter(action -> action.getContent() != null && !action.getContent().isBlank())
                .forEach(action ->
                        userNameMap.put(
                                action.getUserName(),
                                (userNameMap.get(action.getUserName()) == null
                                        ? 0
                                        : userNameMap.get(action.getUserName())) + 1
                        ));

        return sortMapAndReturnList(userNameMap, limit);
    }

    public static Map<String, Double> getActionTypePercentages(List<UserAction> actions) {
        final Map<String, Double> actionTypeWithPercentagesMap = new HashMap<>();
        final Map<String, Integer> actionTypeWithTotalQuantityMap = new HashMap<>();

        actions.stream()
                .filter(action -> action.getActionType() != null)
                .forEach(action ->
                        actionTypeWithTotalQuantityMap.put(action.getActionType().name(),
                                (actionTypeWithTotalQuantityMap
                                        .get(action.getActionType().name()) == null
                                        ? 0
                                        : actionTypeWithTotalQuantityMap.get(action.getActionType().name())) + 1
                        ));

        actionTypeWithTotalQuantityMap.forEach((key, value) -> actionTypeWithPercentagesMap.put(
                key,
                (double) value / actions.size() * 100
        ));

        return actionTypeWithPercentagesMap;
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