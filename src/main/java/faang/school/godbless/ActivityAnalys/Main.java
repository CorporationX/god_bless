package faang.school.godbless.ActivityAnalys;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UserAction action1 = new UserAction(1, "User1", ActionType.COMMENT, LocalDateTime.now(), "#Content1");
        UserAction action2 = new UserAction(2, "User2", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#Content2");
        UserAction action3 = new UserAction(3, "User3", ActionType.COMMENT, LocalDateTime.now(), "#Content1");
        UserAction action4 = new UserAction(3, "User3", ActionType.POST, LocalDateTime.now(), "#Content4");
        UserAction action5 = new UserAction(4, "User4", ActionType.SHARE, LocalDateTime.now().minusMonths(2), "#Content2");
        UserAction action6 = new UserAction(1, "User1", ActionType.COMMENT, LocalDateTime.now(), "#Content1 #Content2");
        UserAction action7 = new UserAction(2, "User2", ActionType.LIKE, LocalDateTime.now(), "#Content2");
        UserAction action8 = new UserAction(4, "User4", ActionType.SHARE, LocalDateTime.now().minusMonths(2), "#Content2");
        UserAction action9 = new UserAction(1, "User1", ActionType.COMMENT, LocalDateTime.now(), "#Content1 #Content2");
        UserAction action10 = new UserAction(2, "User2", ActionType.LIKE, LocalDateTime.now(), "#Content2");
        List<UserAction> actions = List.of(action1,action2,action3,action4,action5,action6,action7,action8,action9,action10);

        System.out.println("getTenMostActiveUsers: ");
        List<Integer> l1 = getTenMostActiveUsers(actions);
        l1.forEach(out -> System.out.println("----" + out));

        System.out.println("getFiveMostPopularThemes: ");
        List<String> l2 = getFiveMostPopularThemes(actions);
        l2.forEach(out -> System.out.println("----" + out));

        System.out.println("getThreeUsersWithMostComments: ");
        List<Integer> l3 = getThreeUsersWithMostComments(actions);
        l3.forEach(out -> System.out.println("----" + out));

        System.out.println("getActionsPercents: ");
        Map<ActionType, Double> m1 = getActionsPercents(actions);
        m1.forEach((key, val) -> System.out.println("----" + key + " -> " + val));
    }

    private static List<Integer> getTenMostActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<String> getFiveMostPopularThemes(List<UserAction> actions) {
        return actions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<Integer> getThreeUsersWithMostComments(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().getMonth().equals(LocalDateTime.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Map<ActionType, Double> getActionsPercents(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actions.size() * 100));
    }
}
