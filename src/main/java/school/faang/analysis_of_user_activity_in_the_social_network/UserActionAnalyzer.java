package school.faang.analysis_of_user_activity_in_the_social_network;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class UserActionAnalyzer {
    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    private static <T> List<T> getTopN(Map<T, Long> counts, int n) {
        return counts.entrySet().stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        if (actions == null || n <= 0) {
            return Collections.emptyList();
        }

        try {
            return getTopN(actions.stream()
                    .collect(Collectors.groupingBy(
                            UserAction::getName,
                            Collectors.counting()
                    )), n);
        } catch (Exception e) {
            log.error("Error calculating top active users", e);
            return Collections.emptyList();
        }
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        if (actions == null || n <= 0) {
            return Collections.emptyList();
        }

        try {
            Map<String, Long> hashtagCounts = actions.stream()
                    .filter(action -> action.getContent() != null)
                    .flatMap(action -> {
                        Matcher matcher = HASHTAG_PATTERN.matcher(action.getContent());
                        List<String> hashtags = new ArrayList<>();
                        while (matcher.find()) {
                            hashtags.add(matcher.group().toLowerCase());
                        }
                        return hashtags.stream();
                    })
                    .collect(Collectors.groupingBy(
                            hashtag -> hashtag,
                            Collectors.counting()
                    ));

            return getTopN(hashtagCounts, n);
        } catch (Exception e) {
            log.error("Error calculating popular hashtags", e);
            return Collections.emptyList();
        }
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        if (actions == null || n <= 0) {
            return Collections.emptyList();
        }

        try {
            YearMonth lastMonth = YearMonth.from(LocalDate.now().minusMonths(1));
            LocalDate start = lastMonth.atDay(1);
            LocalDate end = lastMonth.atEndOfMonth();

            Map<String, Long> commentCounts = actions.stream()
                    .filter(action -> action.getActionType() == UserAction.ActionType.COMMENT)
                    .filter(action -> !action.getActionDate().isBefore(start))
                    .filter(action -> !action.getActionDate().isAfter(end))
                    .collect(Collectors.groupingBy(
                            UserAction::getName,
                            Collectors.counting()
                    ));

            return getTopN(commentCounts, n);
        } catch (Exception e) {
            log.error("Error calculating top commenters from last month", e);
            return Collections.emptyList();
        }
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            return Collections.emptyMap();
        }

        try {
            double total = actions.size();
            return actions.stream()
                    .collect(Collectors.groupingBy(
                            action -> action.getActionType().name(),
                            LinkedHashMap::new,
                            Collectors.collectingAndThen(
                                    Collectors.counting(),
                                    count -> Math.round((count / total) * 100 * 10) / 10.0
                            )));
        } catch (Exception e) {
            log.error("Error calculating action type percentages", e);
            return Collections.emptyMap();
        }
    }
}