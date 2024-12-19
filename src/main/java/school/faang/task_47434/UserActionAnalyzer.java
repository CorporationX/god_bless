package school.faang.task_47434;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> userActivityCount = new HashMap<>();

        for (UserAction action : actions) {
            userActivityCount.put(
                    action.getName(),
                    userActivityCount.getOrDefault(action.getName(), 0L) + 1
            );
        }

        return userActivityCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> hashtagCount = new HashMap<>();

        for (UserAction action : actions) {
            if ((action.getActionType().equals("post") || action.getActionType().equals("comment"))
                    && action.getContent() != null) {
                String[] words = action.getContent().split("\\s+");
                for (String word : words) {
                    if (word.startsWith("#")) {
                        hashtagCount.put(word, hashtagCount.getOrDefault(word, 0L) + 1);
                    }
                }
            }
        }

        return hashtagCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> commenterCount = new HashMap<>();

        for (UserAction action : actions) {
            if (action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonthAgo)) {
                commenterCount.put(action.getName(), commenterCount.getOrDefault(action.getName(), 0L) + 1);
            }
        }

        return commenterCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> actionCounts = new HashMap<>();
        long totalActions = actions.size();

        for (UserAction action : actions) {
            actionCounts.put(action.getActionType(),
                    actionCounts.getOrDefault(action.getActionType(), 0L) + 1);
        }

        Map<String, Double> percentages = new HashMap<>();
        for (Map.Entry<String, Long> entry : actionCounts.entrySet()) {
            percentages.put(entry.getKey(), (entry.getValue() * 100.0) / totalActions);
        }

        return percentages;
    }

}
