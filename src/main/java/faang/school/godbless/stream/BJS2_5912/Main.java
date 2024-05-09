package faang.school.godbless.stream.BJS2_5912;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();

        UserAction vladAction1 = new UserAction(2, "Vlad", ActionType.POST, LocalDate.of(2023, 4, 1), "My name is Vlad #world");
        UserAction vladAction2 = new UserAction(2, "Vlad", ActionType.COMMENT, LocalDate.of(2023, 4, 5), "This is #fun");
        UserAction ivanAction1 = new UserAction(1, "Ivan", ActionType.POST, LocalDate.of(2023, 3, 10), "hello world");
        UserAction ivanAction2 = new UserAction(1, "Ivan", ActionType.COMMENT, LocalDate.of(2023, 3, 11), "I like this #world");
        UserAction ivanAction3 = new UserAction(1, "Ivan", ActionType.POST, LocalDate.of(2023, 3, 12), "New Post from Ivan #world");
        UserAction lenaAction1 = new UserAction(3, "Lena", ActionType.LIKE, LocalDate.of(2023, 4, 8), "");

        userActions.add(vladAction1);
        userActions.add(vladAction2);
        userActions.add(lenaAction1);
        userActions.add(ivanAction1);
        userActions.add(ivanAction2);
        userActions.add(ivanAction3);

        System.out.println("top10Users = " + top10Users(userActions));
        printTop5Tags(userActions);
        findTop3UsersWithComments(userActions);
        calculateActionPercent(userActions);
    }

    public static HashMap<Integer, Long> top10Users(List<UserAction> userActions) {
        return userActions.stream()
                .collect(
                        Collectors.groupingBy(UserAction::getId, Collectors.counting())
                )
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, HashMap::new
                        )
                );

    }

    public static void printTop5Tags(List<UserAction> userActions) {
        System.out.println("Find TOP-5 topics");
        userActions.stream()
                .map(UserAction::getContent)
                .filter(string -> string.contains("#"))
                .flatMap(string -> Arrays.stream(string.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public static void findTop3UsersWithComments(List<UserAction> userActions) {
        System.out.println("Top 3 users with the most comments in last month");
        userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().getMonth().equals(LocalDate.now().getMonth()))
                .collect(
                        Collectors.groupingBy(UserAction::getId, Collectors.counting())
                )
                .entrySet()
                .stream().sorted(
                        Map.Entry.comparingByValue(Comparator.reverseOrder())
                )
                .limit(10)
                .collect(
                        Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new)
                )
                .forEach(
                        (key, value) -> userActions.stream()
                        .filter(ua -> ua.getId() == key)
                        .limit(1)
                        .forEach(user -> System.out.println(user.getName()))
                );
    }

    public static void calculateActionPercent(List<UserAction> userActions) {
        System.out.println("Percent by Actions:");
        userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .forEach(
                        (key, value) -> System.out.println(key + " : " + value * 100 / userActions.size() + "%")
                );
    }
}
