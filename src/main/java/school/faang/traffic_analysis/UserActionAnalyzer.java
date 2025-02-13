package school.faang.traffic_analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
class Item {
    int num;
    public Status status;
}

@Getter
@AllArgsConstructor
enum Status {

    ACTIVE, INACTIVE, PENDING
}

public class UserActionAnalyzer {

    /*
    1. Топ-N самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
    Метод должен возвращать список из n пользователей, которые совершили наибольшее количество действий.

    2. Топ-N наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях).
    Метод должен возвращать список из n самых популярных хэштегов (слова, начинающиеся с символа #).

    3. Топ-N пользователей, которые оставили наибольшее количество комментариев в последний месяц.
    Метод должен возвращать n пользователей, которые оставили больше всего комментариев за последний месяц.

    4. Вычислить процент для каждого типа действий (посты, комментарии, лайки и репосты).
    Метод должен возвращать процентное соотношение каждого типа действия среди всех действий.
    */

    public static List<String> topActiveUsers(@NonNull List<UserAction> actionList, int userAmount) {

        /*Map<ActionType, List<UserAction>> map = actionList.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting());*/

        Map<Enum, List<UserAction>> map = actionList.stream()
                .collect(Collectors.groupingBy(UserAction::actionType)); //Collectors.counting()));

        List<Item> items = Arrays.asList(
                new Item(10, Status.ACTIVE),
                new Item(11, Status.INACTIVE),
                new Item(12, Status.ACTIVE),
                new Item(13, Status.PENDING),
                new Item(14, Status.INACTIVE)
        );

        Map<Status, Long> countByStatus = items.stream()
                .collect(Collectors.groupingBy(Item::getStatus, Collectors.counting()));

        System.out.println("Count: " + countByStatus);

        var sortedUsers = actionList.stream()
                .sorted(Comparator.comparing(UserAction::actionType)) // Сортируем по полю type
                .collect(Collectors.toList());

        /*actionList.stream()
                .sorted(Comparator.comparing(UserAction::actionType)) // Сортируем по полю type
                .forEach(user -> System.out.printf("Name: %-10s | Type: %s%n", user.getName(), user.getType()));

        typeCount.forEach((type, count) ->
                        System.out.printf("%s: %d%n", type, count)*/
        //actionList.stream().collect(Collectors.toMap(UserAction::name, UserAction::actionType));

//                actionList.stream()
//                .filter(user -> typesToFilter.contains(user.actionType()))
//                .collect(Collectors.toList());
//        actionList.stream().flatMap(user -> Arrays.stream(ActionType.values())
//                .filter(e -> e.name().equals(user.actionType()))).toList();

        return List.of();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actionList, int userAmount) {

        return List.of();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actionList, int userAmount) {

        return List.of();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actionList) {

        return new HashMap<>();
    }

    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {

        //List<UserAction> actions;

        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 9, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 9, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 9, 9), ""));

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top-10 the most active users: " + top10Users);
        System.out.println("Top-10 the most popular hashtags: " + top5Hashtags);
        System.out.println("Top-3 comments for the last month: " + top3Commenters);
        System.out.println("Percentage of actions by type: " + actionPercentages);
    }
}
