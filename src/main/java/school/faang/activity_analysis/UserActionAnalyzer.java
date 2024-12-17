package school.faang.activity_analysis;

import java.time.LocalDate;
import java.util.*;

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

        actions.forEach(userAction -> {
            String content = userAction.content();

            getHashtags(content).forEach(hashtag -> {
                if (!hashtagsCount.containsKey(hashtag)) {
                    hashtagsCount.put(hashtag, 0);
                }
                hashtagsCount.put(hashtag, hashtagsCount.get(hashtag) + 1);
            });
        });
        return getTop(hashtagsCount, 5);
    }

    private static List<String> getHashtags(String content) {
        List<String> hashTags = new ArrayList<>();
        StringBuilder contentBuilder = new StringBuilder(content);

        while (contentBuilder.indexOf("#") != -1) {
            int startIndex = content.indexOf("#");
            int endIndex = startIndex + 1;

            while (endIndex < content.length() && Character.isLetterOrDigit(content.charAt(endIndex))) {
                endIndex++;
            }
            String hashtag = content.substring(startIndex, endIndex);
            contentBuilder.delete(startIndex, endIndex);
            hashTags.add(hashtag);
        }
        return hashTags;
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
        List<Map.Entry<String, Integer>> sortedEntries = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();
        List<String> result = new ArrayList<>();
        if (sortedEntries.size() < height) {
            height = sortedEntries.size();
        }
        for (int i = 0; i < height; i++) {
            result.add(sortedEntries.get(i).getKey());
        }
        return result;
    }
}
