package school.faang.analayzer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserActionAnalyzer {

    private static final BiFunction<Map<String, Integer>, UserAction, Map<String, Integer>> USER_ACTION_COUNTER =
            (map, userAction) -> {
                int count = map.getOrDefault(userAction.name(), 0);
                map.put(userAction.name(), count + 1);
                return map;
            };

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#(\\w+)");

    private static final BiFunction<Map<String, Integer>, UserAction, Map<String, Integer>> HASHTAG_COUNTER =
            (map, userAction) -> {
                Matcher matcher = HASHTAG_PATTERN.matcher(userAction.content());
                String hashtag = matcher.find() ? matcher.group() : "";
                int count = map.getOrDefault(hashtag, 0);
                map.put(hashtag, count + 1);
                return map;
            };

    private static final BiFunction<Map<String, Integer>, UserAction, Map<String, Integer>> ACTION_TYPE_COUNTER =
            (map, userAction) -> {
                int count = map.getOrDefault(userAction.actionType().name(), 0);
                map.put(userAction.actionType().name(), count + 1);
                return map;
            };

    private static final BinaryOperator<Map<String, Integer>> COMBINER =
            (totalMap, intermidiateMap) -> {
                totalMap.putAll(intermidiateMap);
                return totalMap;
            };

    private static final Comparator<Map.Entry<String, Integer>> MAP_BY_VALUE_REVERSED_COMPARATOR =
            Map.Entry
                    .comparingByValue(Comparator.comparingInt(Integer::intValue).reversed());

    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .reduce(new HashMap<>(),
                        USER_ACTION_COUNTER,
                        COMBINER)
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(userAction -> userAction.content().contains("#"))
                .reduce(new HashMap<>(),
                        HASHTAG_COUNTER,
                        COMBINER)
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT))
                .reduce(new HashMap<>(),
                        USER_ACTION_COUNTER,
                        COMBINER)
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static Map<String, String> actionTypePercentages(List<UserAction> actions) {
        Map<String, String> result = new HashMap<>();
        actions.stream()
                .reduce(new HashMap<>(),
                        ACTION_TYPE_COUNTER,
                        COMBINER)
                .forEach((key, value) ->
                        result.put(key, "%.1f %%".formatted(Double.valueOf(value) / actions.size() * 100)));
        return result;
    }
}