package school.faang.sprint2.task_47280;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static school.faang.sprint2.task_47280.ActionType.COMMENT;
import static school.faang.sprint2.task_47280.ActionType.POST;

public class UserActionAnalyzer {
    public static final int MAX_ACTIVE_USERS = 10;
    public static final int MAX_POPULAR_TOPICS = 5;
    public static final int MAX_ACTIVE_COMMENTERS = 3;

    public static List<String> findTopActiveUsers(List<UserAction> userActions) {

        Map<String, Long> numOfActionsByUserName = userActions.stream().collect(Collectors.groupingBy(
                UserAction::name, Collectors.counting())
        );
        return numOfActionsByUserName.entrySet().stream().sorted(
                (entry1, entry2) -> {
                    int countActionsComparison = Long.compare(entry2.getValue(), entry1.getValue());
                    if (countActionsComparison == 0) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return countActionsComparison;
                }
        ).map(Map.Entry::getKey).limit(MAX_ACTIVE_USERS).collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("(#\\w+\\b)(?!;)");

        List<String> allHashtags = userActions.stream().filter(action -> Set.of(POST, COMMENT)
                        .contains(action.actionType())).map(UserAction::content)
                        .flatMap(content -> pattern.matcher(content).results()).map(MatchResult::group)
                        .map(String::toUpperCase).toList();

        Map<String, Long> numOfOccurrencesByHashtag = allHashtags.stream().collect(Collectors.groupingBy(
                        s -> s, Collectors.counting()
                ));

        return numOfOccurrencesByHashtag.entrySet().stream().sorted(
                (entry1, entry2) -> {
                    int countComparison = Long.compare(entry2.getValue(), entry1.getValue());
                    if (countComparison == 0) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return countComparison;
                }
        ).map(Map.Entry::getKey).limit(MAX_POPULAR_TOPICS).collect(Collectors.toList());
    }

    public static List<String> topCommentersForTheLastMonth(List<UserAction> userActions) {

        Map<String, Long> numOfCommentsByUser = userActions.stream().filter(action -> action.actionType()
                .equals(COMMENT)).filter(action -> action.actionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return numOfCommentsByUser.entrySet().stream().sorted(
                (entry1, entry2) -> {
                    int countActionsComparison = Long.compare(entry2.getValue(), entry1.getValue());
                    if (countActionsComparison == 0) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return countActionsComparison;
                }
        ).limit(MAX_ACTIVE_COMMENTERS).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(
                UserAction::actionType, Collectors.counting())
        ).entrySet().stream().collect(Collectors.toMap(
                entry -> entry.getKey().name(),
                entry -> Math.round((entry.getValue().doubleValue() / userActions.size()) * 10000) / 100.0)
        );
    }
}
