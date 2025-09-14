package school.faang.bjs2_89501;

import school.faang.bjs2_85520.User;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int count) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int count) {
        Pattern regex = Pattern.compile("#.$");
        return actions.stream()
                .filter(action -> action.getContent().isBlank()
                        && action.getContent() != null
                        && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> regex.matcher(action.getContent()).results())
                .map(MatchResult::group)
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(count)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int count) {
        LocalDate maxDate = actions.stream()
                .map(UserAction::getActionDate)
                .max(LocalDate::compareTo)
                .orElseThrow();
        YearMonth lastYearMonth = YearMonth.from(maxDate);
        return actions.stream()
                .filter(action -> YearMonth.from(action.getActionDate()).equals(lastYearMonth)
                        && action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        int countSize = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double decimal = (entry.getValue() * 100.0) / countSize;
                            return Math.round(decimal * 100.0) / 100.0;
                        }
                ));

    }
}
