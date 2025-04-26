package school.faang.analysisuser;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class UserActionAnalyzer {
    private static final Pattern HASHTAG = Pattern.compile("#\\w+");

    public Map<String, Long> gropingByName(List<UserAction> users) {
        return users.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
    }

    public List<String> toActiveUser(List<UserAction> users, int top) {
        return gropingByName(users).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> users, int top) {
        List<String> hashtags = users.stream()
                .filter(action -> action.actionDate() != null)
                .filter(action -> ActionType.COMMENT.equals(action.actionType())
                        || ActionType.POST.equals(action.actionType()))
                .flatMap(action -> HASHTAG.matcher(action.content()).results())
                .map(MatchResult::group)
                .toList();

        log.info("Список хештегов {}", hashtags);

        Map<String, Long> tagFrequency = hashtags.stream()
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        log.info("Мапа количества хештегов {}", tagFrequency);

        return tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<ActionType, Double> calculateActionPercentages(List<UserAction> users) {
        long allAction = users.size();

        Map<ActionType, Long> actionTypeToCount = users.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ((double) entry.getValue() * 100 / allAction)));
    }

    public void printActionPercentages(Map<ActionType, Double> activityShare) {
        activityShare.forEach((key, value) -> System.out.printf("Доля %sов: %.2f%%\n", key, value));

    }
}