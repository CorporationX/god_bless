package school.faang.BJS2_35422_UsersActivityAnalysis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> usersActions) {
        return usersActions.stream()
                .collect(Collectors.groupingBy(action -> Pair.of(action.getId(), action.getName()), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Pair<Integer, String>, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> entry.getKey().getRight())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> usersActions) {
        return usersActions.stream()
                .flatMap(action -> findHashtags(action.getContent()).stream()) // на случай, если в строке несколько #
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> usersActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return usersActions.stream()
                .filter(action -> LocalDate.now().isAfter(oneMonthAgo))
                .filter(action -> "comment".equalsIgnoreCase(action.getActionType()))
                .collect(Collectors.groupingBy(action -> Pair.of(action.getId(), action.getName()), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Pair<Integer, String>, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> entry.getKey().getRight())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> usersActions) {
        int totalActions = usersActions.size();
        if (totalActions == 0) {
            return Collections.emptyMap();
        }

        return usersActions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType().toLowerCase(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }

    private static List<String> findHashtags(String inputString) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(inputString);
        List<String> hashtags = new ArrayList<>();
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }
}
