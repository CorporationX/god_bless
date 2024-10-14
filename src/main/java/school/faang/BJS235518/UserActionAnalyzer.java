package school.faang.BJS235518;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Integer> userActionCountMap = new HashMap<>();
        actions.forEach(action ->
                userActionCountMap.put(action.getName(), userActionCountMap.getOrDefault(action.getName(), 0) + 1));

        return userActionCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // Сортировка по количеству действий в порядке убывания
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> discussions) {
        Map<String, Integer> hashtagCountMap = new HashMap<>();
        discussions.forEach(action -> {
            String content = action.getContent();
            String[] words = content.split("\\s+");
            Arrays.stream(words)
                    .filter(word -> word.startsWith("#"))
                    .forEach(word -> {
                        String hashtag = word.substring(1);
                        hashtagCountMap.put(hashtag, hashtagCountMap.getOrDefault(hashtag, 0) + 1);
                    });
        });

        return hashtagCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, Integer> commentCountMap = new HashMap<>();
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        actions.forEach(action -> {
            if (action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonthAgo)) {
                String userName = action.getName();
                commentCountMap.put(userName, commentCountMap.getOrDefault(userName, 0) + 1);
            }
        });

        return commentCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map <String, Double> actionTypePercentages(List<UserAction> actions) {
        int postCount = 0;
        int commentCount = 0;
        int likeCount = 0;
        int shareCount = 0;

        for (UserAction action : actions) {
            switch (action.getActionType()) {
                case "post":
                    postCount++;
                    break;
                case "comment":
                    commentCount++;
                    break;
                case "like":
                    likeCount++;
                    break;
                case "share":
                    shareCount++;
                    break;
            }
        }
        int totalActions = postCount + commentCount + likeCount + shareCount;
        Map<String, Double> percentages = new HashMap<>();

        if (totalActions > 0) {
            percentages.put("post", (double) postCount / totalActions * 100);
            percentages.put("comment", (double) commentCount / totalActions * 100);
            percentages.put("like", (double) likeCount / totalActions * 100);
            percentages.put("share", (double) shareCount / totalActions * 100);
        }
        return percentages;
    }
}
