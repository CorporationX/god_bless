package bjs2_70896;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int amount) {
        Map<String, Long> groupedByUserId = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupedByUserId.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(amount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularTopicsForDiscussion(List<UserAction> actions, int amount) {
        Pattern pattern = Pattern.compile("#[a-zA-Zа-яА-ЯёЁ]+");

        Map<String, Long> groupedByHashTag = actions.stream()
                .filter(act -> ActionType.POST.equals(act.getType()) || ActionType.COMMENT.equals(act.getType()))
                .flatMap(s -> {
                    Matcher matcher = pattern.matcher(s.getContent());
                    return matcher.results().map(MatchResult::group);
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return groupedByHashTag.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topUsersWhoHaveWrittenTheMostInThePastMonth(List<UserAction> actions, int amount) {
        LocalDateTime oneMonthAgo = LocalDate.now().minusMonths(1).atStartOfDay();
        Map<String, Long> groupedByUserId = actions.stream()
                .filter(act -> ActionType.COMMENT.equals(act.getType()) && act.getActionDate().isAfter((oneMonthAgo)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupedByUserId.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(amount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateThePercentageForEachOfAction(List<UserAction> actions) {
        long totalNumberOfActions = actions.size();
        Map <ActionType, Long> groupedByActionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getType, Collectors.counting()));
        return groupedByActionType.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.00) / totalNumberOfActions
                ));
    }
}
