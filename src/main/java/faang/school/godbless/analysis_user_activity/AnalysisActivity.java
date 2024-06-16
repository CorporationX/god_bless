package faang.school.godbless.analysis_user_activity;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalysisActivity {

    public static void main(String[] args) {
        List<UserAction> userActions =
                List.of(new UserAction(1, Action.POST, LocalDate.now(), "#blog My day"),
                        new UserAction(2, Action.COMMENT, LocalDate.now(), "commented a post"),
                        new UserAction(2, Action.COMMENT, LocalDate.now(), "commented a post second time"),
                        new UserAction(2, Action.COMMENT, LocalDate.now(), "commented a post third time"),
                        new UserAction(2, Action.COMMENT, LocalDate.now(), "commented a post fourth time"),
                        new UserAction(1, Action.COMMENT, LocalDate.now(), "answered to comment"),
                        new UserAction(3, Action.COMMENT, LocalDate.now(), "User 3 comment"),
                        new UserAction(3, Action.SHARE, LocalDate.now(), "Shared user 1's post"),
                        new UserAction(3, Action.COMMENT, LocalDate.now(), "User 3 comment"),
                        new UserAction(3, Action.COMMENT, LocalDate.now(), "User 3 comment"),
                        new UserAction(4, Action.POST, LocalDate.now(), "#blog bought some useful stuff"),
                        new UserAction(4, Action.SHARE, LocalDate.now(), "shared user 1's post"),
                        new UserAction(4, Action.LIKE, LocalDate.now(), "like"),
                        new UserAction(5, Action.POST, LocalDate.now(), "#CS2 just achieved 10k elo"),
                        new UserAction(5, Action.POST, LocalDate.now(), "#CS2 someone wants to play with me?"),
                        new UserAction(5, Action.LIKE, LocalDate.now(), "Liked user 4's post"),
                        new UserAction(6, Action.POST, LocalDate.now(), "#blog finally, holidays!!!"),
                        new UserAction(7, Action.POST, LocalDate.now(), "#cook cooking napoleon today, don't miss my news!!"));

        System.out.println(top10UsersByActivities(userActions));
        System.out.println(top5Topics(userActions));
        System.out.println(top3UsersByCommentsLastMonth(userActions));
        System.out.println(actionsPercent(userActions));
    }

    // Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты)
    public static List<Integer> top10UsersByActivities(@NonNull List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    // Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях. Хэштег — слово, начинающееся с символа #).
    public static List<String> top5Topics(@NonNull List<UserAction> userActions) {
        Map<String, Long> hashtags = userActions.stream()
                .filter(userAction -> userAction.getActionType() == Action.POST || userAction.getActionType() == Action.COMMENT)
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s")))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

    }

    // Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц.
    public static List<Integer> top3UsersByCommentsLastMonth(@NonNull List<UserAction> userActions) {
        Map<Integer, Long> users = userActions.stream()
                .filter(userAction -> userAction.getActionType() == Action.COMMENT &&                  // в условии проверяется тип действия,
                        userAction.getActionDate().getYear() == LocalDate.now().getYear()              // соответствия нынешнему году,
                        && !(LocalDate.now().getMonth().getValue() - userAction.getActionDate().getMonth().getValue() > 1)) // и разницу между нынешним месяцем и месяцем действия
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }

    // Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий.
    public static Map<Action, Double> actionsPercent(@NonNull List<UserAction> userActions) {
        Map<Action, Long> actionsByType = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Double sum = userActions.stream()
                .mapToDouble(userAction -> 1)
                .sum();

        return actionsByType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / sum));
    }
}