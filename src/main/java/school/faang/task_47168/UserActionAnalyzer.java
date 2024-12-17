package school.faang.task_47168;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    public List<String> getTopActiveUsers(List<UserAction> actions, int limit) {
        return getTopItems(actions, UserAction::getName, limit);
    }

    public List<String> getTopHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .flatMap(action -> extractHashtags(action.getContent()).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(tag -> 1)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    private List<String> getTopItems(List<UserAction> actions, Function<UserAction, String> classifier, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(classifier, Collectors.summingInt(e -> 1)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    private Set<String> extractHashtags(String content) {
        return HASHTAG_PATTERN.matcher(content)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toSet());
    }

    public List<String> getActionsWithinLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1).minusDays(1);
        return actions.stream()
                .filter(action -> !action.getDate().isBefore(oneMonthAgo))
                .map(UserAction::getName)
                .distinct()
                .toList();
    }
}