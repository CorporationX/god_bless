package school.faang.task47300;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry;
import static school.faang.task47300.ActionType.COMMENT;
import static school.faang.task47300.ActionType.POST;

public class UserActionAnalyzer {

    private static final String REGEX_REMOVING_PUNCTUATION = "[\\s,.!;]";

    public static List<String> top10ActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Entry::getKey)
                .collect(Collectors.toList());

    }

    public static List<String> top5Hashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getActionType() == POST || action.getActionType() == COMMENT)
                .flatMap(action -> Arrays.stream(action.getContent().split(REGEX_REMOVING_PUNCTUATION)))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Entry::getKey)
                .collect(Collectors.toList());

    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType() == COMMENT
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Entry::getKey)
                .collect(Collectors.toList());

    }

    public static Map<ActionType, Double> actionTypePersentages(List<UserAction> actions) {
        long totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));


    }
}
