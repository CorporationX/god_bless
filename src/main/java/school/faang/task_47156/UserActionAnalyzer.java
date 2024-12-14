package school.faang.task_47156;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final String HASHTAG_REGEX = "#\\w+";

    public static List<String> getTopActiveUsers(@NonNull List<UserAction> actions, long topCount) {
        Map<String, Long> userActionsByUser = actions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));

        return userActionsByUser.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopPopularHashtags(@NonNull List<UserAction> actions, long topCount) {
        final Pattern hashtagPattern = Pattern.compile(HASHTAG_REGEX);

        Map<String, Long> hashtagMentionsMap = actions.stream()
                .filter(action -> action != null
                        && (action.actionType().equals(ActionType.POST)
                        || action.actionType().equals(ActionType.COMMENT)))
                .flatMap(action -> {
                    Matcher matcher = hashtagPattern.matcher(action.content());
                    return matcher.results().map(MatchResult::group);
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagMentionsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(@NonNull List<UserAction> actions, long topCount) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        Map<String, Long> numberOfCommentsByUserLastMonth = actions.stream()
                .filter(action -> action != null
                        && action.actionType().equals(ActionType.COMMENT)
                        && action.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));

        return numberOfCommentsByUserLastMonth.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionTypePercentages(@NonNull List<UserAction> actions) {
        long totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }

}