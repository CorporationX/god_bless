package school.faang.bjs247340;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserActionAnalyzer {
    public static List<String> top10MostActiveUsers(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            log.warn("top10MostActiveUsers: No actions provided for processing.");
            return Collections.emptyList();
        }
        log.info("top10MostActiveUsers: Calculating top 10 most active users.");
        List<String> result = actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        log.info("top10MostActiveUsers: Result - {}", result);
        return result;
    }

    public static List<String> top5PopularHashtags(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            log.warn("top5PopularHashtags: No actions provided for processing.");
            return Collections.emptyList();
        }
        log.info("top5PopularHashtags: Calculating top 5 popular hashtags.");
        List<String> result = actions.stream()
                .filter(action -> action.content() != null && (action.actionType().equals("post")
                        || action.actionType().equals("comment")))
                .flatMap(action -> Arrays.stream(action.content().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
        log.info("top5PopularHashtags: Result - {}", result);
        return result;
    }

    public static List<String> top3CommentersLastMonth(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            log.warn("top3CommentersLastMonth: No actions provided for processing.");
            return Collections.emptyList();
        }
        LocalDate threeMonthAgo = LocalDate.now().minusMonths(4);
        List<String> result = actions.stream()
                .filter(action -> action.content() != null && (action.actionType().equals("comment"))
                        && (action.actionDate().isAfter(threeMonthAgo)))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
        log.info("top3CommentersLastMonth: Result - {}", result);
        return result;
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            log.warn("actionTypePercentages: No actions provided for processing.");
            return Collections.emptyMap();
        }
        log.info("actionTypePercentages: Calculating action type percentages.");
        long totalActions = actions.size();
        Map<String, Double> result = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.00) / totalActions
                ));
        log.info("actionTypePercentages: Result - {}", result);
        return result;
    }
}
