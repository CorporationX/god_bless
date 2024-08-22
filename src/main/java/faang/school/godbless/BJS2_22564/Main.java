package faang.school.godbless.BJS2_22564;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(0, "John", LocalDateTime.now(), "some content #lifestyle", ActionType.POST),
                new UserAction(1, "Markus", LocalDateTime.now(), "Some content #travel", ActionType.POST),
                new UserAction(0, "John", LocalDateTime.now(), "Some content5 #work", ActionType.POST),
                new UserAction(0, "John", LocalDateTime.now(), "Some content #bussiness", ActionType.POST),
                new UserAction(2, "Jack", LocalDateTime.now(), "Some content #sport", ActionType.POST),
                new UserAction(2, "Jack", LocalDateTime.now(), "Some content #sport", ActionType.COMMENT),
                new UserAction(6, "Jack", LocalDateTime.now(), "Some content #bussiness", ActionType.POST),
                new UserAction(7, "Jack", LocalDateTime.now(), "Some content5 #work", ActionType.POST),
                new UserAction(8, "Jack", LocalDateTime.now(), "Some content #vacations", ActionType.POST),
                new UserAction(8, "Jack", LocalDateTime.now(), "Some content #theatre", ActionType.POST),
                new UserAction(9, "Jack", LocalDateTime.now(), "Some content #sport", ActionType.COMMENT),
                new UserAction(10, "Jack", LocalDateTime.now(), "Some content #bussiness", ActionType.POST),
                new UserAction(10, "Jack", LocalDateTime.now(), "Some content #sport", ActionType.POST),
                new UserAction(11, "Jack", LocalDateTime.now(), "Some content #bussiness", ActionType.POST),
                new UserAction(12, "Jack", LocalDateTime.now(), "some content #lifestyle", ActionType.COMMENT),
                new UserAction(13, "Jack", LocalDateTime.now(), "some content ", ActionType.POST),
                new UserAction(14, "Jack", LocalDateTime.now(), "some content #lifestyle", ActionType.POST),
                new UserAction(14, "Jack", LocalDateTime.now(), "Some content5", ActionType.POST),


                new UserAction(1, "Markus", LocalDateTime.now(), "Some content6", ActionType.COMMENT),
                new UserAction(2, "Jack", LocalDateTime.now(), "Some content7", ActionType.LIKE),
                new UserAction(1, "Markus", LocalDateTime.now(), "Some content8", ActionType.COMMENT),
                new UserAction(0, "John", LocalDateTime.now(), "Some content8", ActionType.SHARE),
                new UserAction(5, "John", LocalDateTime.now(), "Some content8", ActionType.LIKE)
        );
        for (String s : findTop10ActivityUsers(userActions,10)) {
            System.out.println(s);
        }
        System.out.println("Find top topics");
        System.out.println(findTopTopics(userActions,5));
        System.out.println("Top users by comments: ");
        System.out.println(findTop3UsersByComments(userActions,3));
        System.out.println("Percents:");
        System.out.println(typesByPercents(userActions));
    }

    public static Map<ActionType, Double> typesByPercents(List<UserAction> userActions) {
        Map<ActionType, Long> map = userActions.stream()
                .map(UserAction::getActionType)
                .collect(Collectors.groupingBy(actionType -> actionType, Collectors.counting()));

        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> convertToPercents(entry.getValue(), userActions.size())));
    }

    public static double convertToPercents(long count, int allActionsCount) {
        return (double) Math.round(((double) count * 100 / allActionsCount) * 100.0) / 100;
    }

    public static List<String> findTop3UsersByComments(List<UserAction> userActions, int topSize) {
        Map<Long, Long> userIdCommentsCount = userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        Stream<Map.Entry<Long, Long>> sortedStream = userIdCommentsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topSize);

        return sortedStream
                .flatMap(entry -> userActions.stream()
                        .filter(userAction -> userAction.getUserId() == entry.getKey())
                        .map(userAction -> "(" + userAction.getUserName() + ", id: " + userAction.getUserId() + ")" + " - " + entry.getValue())
                )
                .distinct()
                .limit(3)
                .toList();
    }

    public static List<String> findTop10ActivityUsers(List<UserAction> userActions, int topSize) {
        Map<Long, Long> userIdCountMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        Stream<Map.Entry<Long, Long>> sortedStream = userIdCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topSize);

        return sortedStream
                .flatMap(entry -> userActions.stream()
                        .filter(userAction -> userAction.getUserId() == entry.getKey())
                        .map(userAction -> "[" + userAction.getUserName() + ", id: " + userAction.getUserId() + "]" + " - " + entry.getValue())
                )
                .distinct()
                .toList();
    }

    public static Map<String, Long> findTopTopics(List<UserAction> userActions, int topSize) {
        Map<String, Long> resMap = userActions.stream()
                .map(UserAction::getContent)
                .filter(str -> str.contains("#"))
                .map(str -> {
                    int indexStart = str.indexOf("#");
                    int indexEnd = str.indexOf(" ", indexStart);
                    if (indexEnd < 0) {
                        indexEnd = str.length();
                    }
                    return str.substring(indexStart, indexEnd);
                })
                .collect(Collectors.groupingBy(hashStr -> hashStr, Collectors.counting()));

        Stream<Map.Entry<String, Long>> sortedStream = resMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topSize);
        return sortedStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
