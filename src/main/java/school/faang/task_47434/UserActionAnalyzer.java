package school.faang.task_47434;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final int TOP_USERS_LIMIT = 10;
    private static final int TOP_HASHTAGS_LIMIT = 5;
    private static final int TOP_COMMENTERS_LIMIT = 3;

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
                .limit(TOP_USERS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> hashtagCount = new HashMap<>();

        for (UserAction action : actions) {
            if ((action.getActionType().equals(ActionType.POST) || action.getActionType().equals(ActionType.COMMENT))
                    && action.getContent() != null) {
                String[] words = action.getContent().split(WHITESPACE_REGEX);
                for (String word : words) {
                    if (word.startsWith("#")) {
                        hashtagCount.put(word, hashtagCount.getOrDefault(word, 0L) + 1);
                    }
                }
            }
        }

        return hashtagCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(TOP_HASHTAGS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> commenterCount = new HashMap<>();

        for (UserAction action : actions) {
            if (action.getActionType().equals(ActionType.COMMENT) && action.getActionDate().isAfter(oneMonthAgo)) {
                commenterCount.put(action.getName(), commenterCount.getOrDefault(action.getName(), 0L) + 1);
            }
        }

        return commenterCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(TOP_COMMENTERS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> actionCounts = new HashMap<>();
        long totalActions = actions.size();

        for (UserAction action : actions) {
            String actionType = action.getActionType().getType();
            actionCounts.put(actionType, actionCounts.getOrDefault(actionType, 0L) + 1);
        }

        Map<String, Double> percentages = new HashMap<>();
        for (Map.Entry<String, Long> entry : actionCounts.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / totalActions;
            percentages.put(entry.getKey(), Math.round(percentage * 10.0) / 10.0);
        }

        return percentages;
    }



}
