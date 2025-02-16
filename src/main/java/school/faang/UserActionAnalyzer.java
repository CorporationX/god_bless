package school.faang;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static void main(String[] args) {
        UserActionAnalyzer analyzer = new UserActionAnalyzer();
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", UserAction.ActionType.POST,
                        LocalDate.of(2025, 2, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", UserAction.ActionType.COMMENT,
                        LocalDate.of(2025, 2, 2), "I totally agree with #newfeature."));

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        System.out.println("Топ 10 активных юзеров: " + top10Users);

        List<String> top5users = UserActionAnalyzer.topThemes(actions, 5);
        System.out.println("Топ 5 популярных хештегов: " + top5users);

        List<String> top3Commenters = UserActionAnalyzer.topCommenters(actions, 3);
        System.out.println("Топ 3 комментаторов: " + top3Commenters);

        Map<UserAction.ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);
        System.out.println("Проценты действий: " + actionPercentages);
    }

    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topThemes(List<UserAction> actions, int topN) {
        Map<String, Long> usersToThemesCount = actions.stream()
                .filter(action -> action.getContent() != null) // фильтрация
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return usersToThemesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommenters(List<UserAction> actions, int topN) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> usersToTopCommenters = actions.stream()
                .filter(action -> action.getActionType() == UserAction.ActionType.COMMENT
                        && action.getDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToTopCommenters.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<UserAction.ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        Map<UserAction.ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                        .collect(Collectors.toMap(
                        Map.Entry::getKey,
                            entry -> entry.getValue() * 100.0 / totalActions));
    }
}
