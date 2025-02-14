package school.faang;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final String WORD_SEPARATOR_REGEX = "\\\\s+";

    public static List<String> getTopActiveUsers(List<UserAction> actions, int topN) {
        validateActions(actions);
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopHashtags(List<UserAction> actions, int topN) {
        validateActions(actions);
        Map<String, Long> hashtagsCount = actions.stream()
                .filter(action -> action.getContent() != null
                        && (action.getActionType().equals(ActionType.POST)
                        || action.getActionType().equals(ActionType.COMMENT)))
                .flatMap(action -> Arrays.stream(action.getContent().split(WORD_SEPARATOR_REGEX)))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int topN) {
        validateActions(actions);
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> commentsCount = actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return commentsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> getActionTypePercentages(List<UserAction> actions) {
        validateActions(actions);
        return actions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType().name(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions.size()
                ));
    }

    private static void validateActions(List<UserAction> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("The actions list can't be null");
        }
        for (UserAction action : actions) {
            if (action == null) {
                throw new IllegalArgumentException("The UserAction in list can't be null");
            }
        }
    }
}
