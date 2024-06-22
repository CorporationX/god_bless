package faang.school.godbless.analysisOfUserActivity;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions =
                List.of(new UserAction(1, "user", ActionType.POST, LocalDate.now(), "#blog My day"),
                        new UserAction(2, "user", ActionType.LIKE, LocalDate.now(), "commented a post"),
                        new UserAction(2, "user", ActionType.SHARE, LocalDate.now(), "commented a post second time"),
                        new UserAction(2, "user1", ActionType.POST, LocalDate.now(), "commented a post third time"),
                        new UserAction(2, "user1", ActionType.LIKE, LocalDate.now(), "commented a post fourth time"),
                        new UserAction(1, "user2", ActionType.SHARE, LocalDate.now(), "answered to comment"),
                        new UserAction(3, "user2", ActionType.POST, LocalDate.now(), "User 3 comment"),
                        new UserAction(3, "user2", ActionType.LIKE, LocalDate.now(), "Shared user 1's post"),
                        new UserAction(3, "user2", ActionType.SHARE, LocalDate.now(), "User 3 comment"),
                        new UserAction(3, "user3", ActionType.POST, LocalDate.now(), "User 3 comment"),
                        new UserAction(4, "user40", ActionType.LIKE, LocalDate.now(), "#blog bought some useful stuff"),
                        new UserAction(4, "user5", ActionType.SHARE, LocalDate.now(), "shared user 1's post"),
                        new UserAction(4, "user6", ActionType.POST, LocalDate.now(), "like"),
                        new UserAction(5, "user7", ActionType.COMMENT, LocalDate.now(), "#CS2 just achieved 10k elo"),
                        new UserAction(5, "user8", ActionType.POST, LocalDate.now(), "#CS2 someone wants to play with me?"),
                        new UserAction(5, "user9", ActionType.LIKE, LocalDate.now(), "Liked user 4's post"),
                        new UserAction(6, "user10", ActionType.POST, LocalDate.now(), "#blog finally, holidays!!!"),
                        new UserAction(7, "user11", ActionType.POST, LocalDate.now(), "#cook cooking napoleon today, don't miss my news!!"));


        System.out.println("Top 10: " + activeUsers(userActions, 10));
        System.out.println("Top 3: " + findTopThemes(userActions, 3));
        System.out.println("Top 3 many comment: " + findTopComment(userActions, 3));
        System.out.println("Top 3 many comment: " + percentAction(userActions));
    }

    public static List<Integer> activeUsers(List<UserAction> userActions, int limit) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopThemes(List<UserAction> userActions, int limit) {
        Map<String, Long> hashtagAndCountMap = userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT
                        || userAction.getActionType() == ActionType.POST)
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("[ .,!?/:]")))
                .filter(string -> string.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));

        return hashtagAndCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findTopComment(List<UserAction> userActions, int limit) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static HashMap<Action, Double> percentAction(List<UserAction> userActions) {
        int sizeOfList = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .map(Map.Entry::getKey,
                        entry -> (100.0 * entry.getValue() / sizeOfList)); //как тут получить?
    }
}
