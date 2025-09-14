package school.faang.bjs2_88300;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int number) {
        return actions.stream()
                .collect(groupingByConcurrent(UserAction::getUserName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .map(Entry::getKey)
                .limit(number)
                .toList();

    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int number) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Pattern.compile("#\\w+")
                        .matcher(content)
                        .results()
                        .map(MatchResult::group)
                        .map(hashtag -> hashtag.replaceAll("[^a-zA-Z0-9_#]", "")))
                .collect(groupingByConcurrent(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .map(Entry::getKey)
                .limit(number)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int number) {
        LocalDate agoMonth = LocalDate.now().minusMonths(number);
        return actions.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.COMMENT)
                        && user.getActionDate().isAfter(agoMonth))
                .collect(groupingByConcurrent(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.<String, Long>comparingByValue().reversed())
                .map(Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        int totalActions = actions.size();
        return actions.stream()
                .collect(groupingByConcurrent(user -> String.valueOf(user.getActionType()),
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, value -> ((value.getValue() * 100.0) / totalActions)));
    }
}
