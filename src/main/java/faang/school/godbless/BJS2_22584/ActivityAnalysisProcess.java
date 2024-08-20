package faang.school.godbless.BJS2_22584;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ActivityAnalysisProcess {
    public static List<String> findTop10ActiveUsers(List<UserAction> userActions) {
        Map<Integer, String> usersById = userActions.stream()
                .collect(Collectors.toMap(UserAction::getId, UserAction::getName, (existing, replacement) -> existing));
        Map<Integer, Long> usersActivity = userActions.stream()
                .collect(groupingBy(UserAction::getId, counting()));
        return usersActivity.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(userActivity -> usersById.get(userActivity.getKey()))
                .toList();
    }

    public static List<String> findTop5PopularThemes(List<UserAction> userActions) {
        Map<String, Long> hashtagsFrequency = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post") ||
                        userAction.getActionType().equals("comment"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().replaceAll("[^a-zA-Z0-9#\\s]", "")
                        .split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(String::toLowerCase)
                .collect(groupingBy(Function.identity(), counting()));
        return hashtagsFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTop3CommentersLastMonth(List<UserAction> userActions) {
        Map<Integer, String> usersById = userActions.stream()
                .collect(Collectors.toMap(UserAction::getId, UserAction::getName, (existing, replacement) -> existing));
        Map<Integer, Long> usersCommentCounts =  userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment") &&
                        userAction.getActionDate().getMonthValue() == LocalDate.now().getMonthValue())
                .collect(groupingBy(UserAction::getId, counting()));
        return usersCommentCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(userCommentCount -> usersById.get(userCommentCount.getKey()))
                .toList();
    }

    public static Map<String, Double> countPercentOfActionTypes(List<UserAction> userActions) {
        Map<String, Long> actionTypeCounts = userActions.stream()
                .collect(groupingBy(UserAction::getActionType, counting()));
        return actionTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, amountOfActionType ->
                        (amountOfActionType.getValue() * 100.0) / userActions.size()));
    }
}
