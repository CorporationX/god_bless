package faang.school.godbless.bjs2_5177;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();

        UserAction dimaAction1 = new UserAction(2, "Dima", ActionType.POST, LocalDate.of(2024, 4, 1), "My name is Dima #world");
        UserAction dimaAction2 = new UserAction(2, "Dima", ActionType.COMMENT, LocalDate.of(2024, 4, 5), "This fact is not correct");
        UserAction lenaAction1 = new UserAction(3, "Lena", ActionType.LIKE, LocalDate.of(2024, 4, 8), "");
        UserAction vasyaAction1 = new UserAction(1, "Vasya", ActionType.POST, LocalDate.of(2024, 3, 10), "My name is Vasya #hello");
        UserAction vasyaAction2 = new UserAction(1, "Vasya", ActionType.COMMENT, LocalDate.of(2024, 3, 11), "I like this #world");
        UserAction vasyaAction3 = new UserAction(1, "Vasya", ActionType.POST, LocalDate.of(2024, 3, 12), "New Post from Vasya #world");

        userActions.add(dimaAction1);
        userActions.add(dimaAction2);
        userActions.add(lenaAction1);
        userActions.add(vasyaAction1);
        userActions.add(vasyaAction2);
        userActions.add(vasyaAction3);

        findTop10Users(userActions);
        findTop3UsersWithComments(userActions);
        calculateActionPercent(userActions);
        findTop5Topics(userActions);
    }


    public static void findTop10Users(List<UserAction> userActions) {
        System.out.println("Top 10 users");
        userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((key, value) -> userActions.stream()
                        .filter(ua -> ua.getUserId() == key)
                        .limit(1)
                        .forEach(user -> System.out.println(user.getUserName())));
    }

    public static void findTop5Topics(List<UserAction> userActions) {
        System.out.println("Find TOP-5 topics");
        userActions.stream()
                .map(UserAction::getContent)
                .flatMap(string -> Arrays.stream(string.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public static void findTop3UsersWithComments(List<UserAction> userActions) {
        System.out.println("Top 3 users with the most comments in last month");
        userActions.stream()
                .filter(ua -> ua.getActionType().equals(ActionType.COMMENT))
                .filter(ua -> ua.getActionDate().getMonth().equals(LocalDate.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((key, value) -> userActions.stream()
                        .filter(ua -> ua.getUserId() == key)
                        .limit(1)
                        .forEach(user -> System.out.println(user.getUserName())));
    }

    public static void calculateActionPercent(List<UserAction> userActions) {
        System.out.println("Percent by Actions:");
        userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value * 100 / userActions.size() + "%"));
    }
}
