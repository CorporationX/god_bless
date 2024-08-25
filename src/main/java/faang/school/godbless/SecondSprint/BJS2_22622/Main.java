package faang.school.godbless.SecondSprint.BJS2_22622;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        User mary = new User("Mary");
        User john = new User("John");

        List<UserAction> list = new ArrayList<>();

        list.add(new UserAction(mary, "some comment #peace", "f"));
        list.add(new UserAction(john, "some #action #peace #sayHello", "Comment"));
        list.add(new UserAction(mary, "some comment #peace", "Post"));
        list.add(new UserAction(john, "we need better world #peace", "Post"));

        System.out.println(getPercentageByContent(list));
    }

    public static List<String> top10ActiveUsers(List<UserAction> userActions) {
        Map<String, Long> actionsByUser = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return getTop(actionsByUser, 10);
    }

    public static List<String> top5DiscussionsTopic(List<UserAction> userActions) {
        Map<String, Long> content = userActions.stream()
                .flatMap(k -> Arrays.stream(k.getContent().split(" ")))
                .filter(k -> k.startsWith("#"))
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        return getTop(content, 5);
    }

    public static List<String> top3UsersByComment(List<UserAction> userActions) {
        Map<String, Long> commentByUser = userActions.stream()
                .filter(k -> k.getActionType().equals("Comment"))
                .filter(k -> k.getActionDate().getMonth().equals(LocalDateTime.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return getTop(commentByUser, 3);
    }

    public static Map<String, Float> getPercentageByContent(List<UserAction> userActions) {
        Map<String, Long> actionsByUser = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionsByUser.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        k -> (float) k.getValue() / userActions.size() * 100));
    }

    public static <T> List<T> getTop(Map<T, Long> mapToRank, int rankSize) {
        List<T> result = mapToRank.entrySet().stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .limit(rankSize)
                .map(k -> k.getKey())
                .toList();

        return result;
    }
}
