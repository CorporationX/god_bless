package school.faang.activity_analysis;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        HashMap<String, Integer> usernamesAndActivityCount = new HashMap<>();
        actions.forEach(userAction -> {
            String username = userAction.name();

            if (usernamesAndActivityCount.containsKey(username)) {
                int activities = usernamesAndActivityCount.get(username);
                usernamesAndActivityCount.put(username, activities + 1);

            } else {
                usernamesAndActivityCount.put(username, 1);
            }
        });
        return getTop(usernamesAndActivityCount, 10);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        HashMap<String, Integer> hashtagsCount = new HashMap<>();
        actions.stream()
                .filter(action -> action.content().contains("#"))
                .flatMap(action -> Arrays.stream(action.content().split(" ")))
                .filter(word -> word.startsWith("#"))
                .forEach(hashtag -> {
                    if (!hashtagsCount.containsKey(hashtag)) {
                        hashtagsCount.put(hashtag, 0);
                    }
                    hashtagsCount.put(hashtag, hashtagsCount.get(hashtag) + 1);
                });
        return getTop(hashtagsCount, 5);
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate currentDate = LocalDate.of(2024, 10, 21);
        LocalDate monthAgo = currentDate.minusDays(30);
        List<UserAction> thisMonthActions =
                actions.stream().filter(action -> action.localDate().isAfter(monthAgo)).toList();
        HashMap<String, Integer> commentsCount = new HashMap<>();
        thisMonthActions.stream()
                .filter(userAction -> userAction.actionType() == ActionType.COMMENT).forEach(userAction -> {

                    if (!commentsCount.containsKey(userAction.name())) {
                        commentsCount.put(userAction.name(), 0);
                    }
                    commentsCount.put(userAction.name(), commentsCount.get(userAction.name()) + 1);
                });
        return getTop(commentsCount, 3);
    }

    public static HashMap<String, Double> actionTypePercentages(List<UserAction> actions) {
        int allActionCount = actions.size();
        HashMap<String, Double> result = new HashMap<>();

        for (ActionType type : ActionType.values()) {
            Double typeCount = (double) actions.stream().filter(action -> action.actionType() == type).count();
            result.put(type.name(), calculatePercentage(typeCount, allActionCount));
        }
        return result;
    }

    private static double calculatePercentage(double number, double oneHundredNumber) {
        return number / (oneHundredNumber / 100);
    }

    private static List<String> getTop(HashMap<String, Integer> map, int height) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(height).map(Map.Entry::getKey).toList();
    }
}
