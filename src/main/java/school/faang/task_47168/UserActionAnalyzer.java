package school.faang.task_47168;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    public List<String> topActiveUsers(List<UserAction> actions) {
        return getTopItems(actions, UserAction::getName, 10);
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        return getTopItemsFlatMap(actions, action -> extractHashtags(action.getContent()));
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return getTopItems(
                actions.stream()
                        .filter(action -> action.getDate().isAfter(oneMonthAgo))
                        .toList(),
                UserAction::getName,
                3
        );
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return calculatePercentages(actions, action -> action.getActionType().name());
    }

    private List<String> getTopItemsFlatMap(List<UserAction> actions,
                                            Function<UserAction, List<String>> extractor) {
        return actions.stream()
                .flatMap(action -> extractor.apply(action).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private Map<String, Double> calculatePercentages(List<UserAction> actions,
                                                     Function<UserAction, String> classifier) {
        int totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(classifier, Collectors.summingDouble(e -> 1.0)))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() / totalActions) * 100
                ));
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

    private List<String> extractHashtags(String content) {
        List<String> hashtags = new ArrayList<>();
        Matcher matcher = HASHTAG_PATTERN.matcher(content);
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }
}