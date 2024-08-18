package faang.school.godbless.BJS2_22563;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final int ACTIVE_USERS_LIMIT = 10;
    private static final int POPULAR_TOPICS_LIMIT = 5;
    private static final int MOST_COMMENTED_USERS_LIMIT = 3;

    public static void main(String[] args) {
        List<UserAction> userActions = List.of(new UserAction(new User(1, "Richard"), ActionType.POST, LocalDateTime.now(), "Some Post"),
                new UserAction(new User(1, "Richard"), ActionType.COMMENT, LocalDateTime.now(), "#LedyGaga"),
                new UserAction(new User(1, "Richard"), ActionType.COMMENT, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(1, "Richard"), ActionType.SHARE, LocalDateTime.now(), "#LedyGaga"),
                new UserAction(new User(2, "Mike"), ActionType.COMMENT, LocalDateTime.now(), "#LedyGaga"),
                new UserAction(new User(2, "Mike"), ActionType.COMMENT, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(2, "Mike"), ActionType.COMMENT, LocalDateTime.now(), "#LedyGaga"),
                new UserAction(new User(3, "Austin"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(3, "Austin"), ActionType.COMMENT, LocalDateTime.now(), "#Miracle"),
                new UserAction(new User(3, "Austin"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(4, "Oliver"), ActionType.SHARE, LocalDateTime.now(), "#Miracle"),
                new UserAction(new User(4, "Oliver"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(5, "Harry"), ActionType.SHARE, LocalDateTime.now(), "#Miracle"),
                new UserAction(new User(5, "Harry"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(6, "Oscar"), ActionType.SHARE, LocalDateTime.now(), "#Dubai"),
                new UserAction(new User(7, "Olivia"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(7, "Olivia"), ActionType.SHARE, LocalDateTime.now(), "#Dubai"),
                new UserAction(new User(8, "Amelia"), ActionType.COMMENT, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(8, "Amelia"), ActionType.COMMENT, LocalDateTime.now(), "#Dubai"),
                new UserAction(new User(8, "Amelia"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(9, "Ivy"), ActionType.SHARE, LocalDateTime.now(), "#Vacation"),
                new UserAction(new User(9, "Ivy"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(10, "Freya"), ActionType.SHARE, LocalDateTime.now(), "#Vacation"),
                new UserAction(new User(10, "Freya"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(11, "Henry"), ActionType.SHARE, LocalDateTime.now(), "#Sport"),
                new UserAction(new User(12, "Mia"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(12, "Mia"), ActionType.SHARE, LocalDateTime.now(), "#Sport"),
                new UserAction(new User(12, "Mia"), ActionType.LIKE, LocalDateTime.now(), "Some LIKE"),
                new UserAction(new User(11, "Henry"), ActionType.SHARE, LocalDateTime.now(), "#Some Share"));

        System.out.println(mostActiveUsersAction(userActions, ACTIVE_USERS_LIMIT));

        System.out.println(mostPopularTopics(userActions, POPULAR_TOPICS_LIMIT));

        System.out.println(mostCommentedUsersInMonth(userActions, MOST_COMMENTED_USERS_LIMIT));

        System.out.println(percentageOfActions(userActions));
    }

    public static List<User> mostActiveUsersAction(List<UserAction> userActions, int limit) {
        checkEmpty(userActions, limit);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> mostPopularTopics(List<UserAction> userActions, int limit) {
        checkEmpty(userActions, limit);
        return userActions.stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .map(content -> List.of(content.split(" ")))
                .flatMap(words -> words.stream()
                        .filter(word -> word.startsWith("#")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<User> mostCommentedUsersInMonth(List<UserAction> userActions, int limit) {
        checkEmpty(userActions, limit);
        LocalDateTime firstDatOfMonth = LocalDateTime.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(firstDatOfMonth) || action.getActionDate().isEqual(firstDatOfMonth))
                .collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> percentageOfActions(List<UserAction> userActions) {
        checkEmpty(userActions, 1);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / userActions.size()));
    }


    private static void checkEmpty(List<UserAction> list, int limit) {
        if (list == null || list.isEmpty() || limit <= 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
    }

}
