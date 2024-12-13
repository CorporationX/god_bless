package school.faang.bjs_47153;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, Integer> users = new HashMap<>();

        actions.forEach(action -> {
            users.computeIfAbsent(action.getUserId(), k -> 0);
            users.compute(action.getUserId(), (k, count) -> count + 1);

        });

        return users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .map(id -> getUserNameById(actions, id))
                .toList();
    }

    private static String getUserNameById(List<UserAction> actions, Integer userId) {
        return actions.stream()
                .filter(action -> userId.equals(action.getUserId()))
                .findAny()
                .orElseThrow().getUserName();
    }

    public static List<String> topHashtags(List<UserAction> actions) {
        Map<String, Integer> hashTags = new HashMap<>();

        actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                        || action.getActionType().equals(ActionType.POST))
                .forEach(action -> addHashtags(action, hashTags));

        return hashTags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static void addHashtags(UserAction action, Map<String, Integer> hashTags) {
        getHashtags(action.getContent()).forEach(hashtag -> {
            hashTags.computeIfAbsent(hashtag, k -> 0);
            hashTags.compute(hashtag, (k, count) -> count + 1);
        });
    }

    private static List<String> getHashtags(String string) {
        return Arrays.stream(string.replaceAll("[,.!]?", "").split(" "))
                .filter(s -> s.startsWith("#"))
                .toList();
    }
}
