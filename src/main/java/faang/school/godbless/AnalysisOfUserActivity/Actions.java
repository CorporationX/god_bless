package faang.school.godbless.AnalysisOfUserActivity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Actions {

    public static List<Integer> find10MostActivityUsers(List<UserAction> list) {
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()));

        return map.entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Александр", ActionType.POST, LocalDate.of(2023, 1, 30), "#java"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.SHARE, LocalDate.of(2023, 5, 30), "#go"),
                new UserAction(1, "Александр", ActionType.POST, LocalDate.of(2023, 4, 30), "#stream"),
                new UserAction(2, "Михаил", ActionType.POST, LocalDate.of(2023, 3, 30), "#java"),
                new UserAction(2, "Михаил", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#javascript"),
                new UserAction(2, "Михаил", ActionType.LIKE, LocalDate.of(2023, 6, 10), "#javascript"),
                new UserAction(2, "Михаил", ActionType.SHARE, LocalDate.of(2023, 6, 15), "#java"),
                new UserAction(3, "Максим", ActionType.POST, LocalDate.of(2023, 6, 15), "#python"),
                new UserAction(4, "Лев", ActionType.POST, LocalDate.of(2023, 6, 15), "#summer"),
                new UserAction(4, "Лев", ActionType.COMMENT, LocalDate.of(2023, 6, 19), "#java"),
                new UserAction(4, "Лев", ActionType.COMMENT, LocalDate.of(2023, 5, 27), "#stream"),
                new UserAction(4, "Лев", ActionType.POST, LocalDate.of(2023, 5, 5), "#spring"),
                new UserAction(5, "Марк", ActionType.COMMENT, LocalDate.of(2023, 6, 10), "#java"),
                new UserAction(6, "Артем", ActionType.POST, LocalDate.of(2023, 5, 30), "#spring"),
                new UserAction(7, "Иван", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#spring"),
                new UserAction(8, "Матвей", ActionType.POST, LocalDate.of(2023, 5, 27), "#java"),
                new UserAction(9, "Дмитрий", ActionType.COMMENT, LocalDate.of(2023, 6, 6), "#python"),
                new UserAction(10, "Даниил", ActionType.POST, LocalDate.of(2023, 6, 10), "#java"),
                new UserAction(11, "София", ActionType.COMMENT, LocalDate.of(2023, 6, 5), "#go"),
                new UserAction(12, "Мария", ActionType.POST, LocalDate.of(2023, 6, 14), "#java"),
                new UserAction(13, "Анна", ActionType.COMMENT, LocalDate.of(2023, 6, 18), "#javascript"),
                new UserAction(14, "Алиса", ActionType.POST, LocalDate.of(2023, 6, 10), "#job"),
                new UserAction(15, "Виктория", ActionType.COMMENT, LocalDate.of(2023, 6, 15), "#java"),
                new UserAction(15, "Виктория", ActionType.POST, LocalDate.of(2023, 5, 30), "#go"),
                new UserAction(16, "Ева", ActionType.COMMENT, LocalDate.of(2023, 6, 11), "#stream"),
                new UserAction(16, "Ева", ActionType.POST, LocalDate.of(2023, 5, 22), "#spring"),
                new UserAction(17, "Полина", ActionType.COMMENT, LocalDate.of(2023, 6, 15), "#go"),
                new UserAction(17, "Полина", ActionType.POST, LocalDate.of(2023, 6, 17), "#job"),
                new UserAction(18, "Александра", ActionType.COMMENT, LocalDate.of(2023, 6, 11), "#job"),
                new UserAction(18, "Александра", ActionType.POST, LocalDate.of(2023, 6, 5), "#java"),
                new UserAction(19, "Василиса", ActionType.COMMENT, LocalDate.of(2023, 1, 30), "#python"),
                new UserAction(19, "Василиса", ActionType.POST, LocalDate.of(2023, 6, 11), "#spring"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#python"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#python"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.POST, LocalDate.of(2023, 6, 11), "#javascript")
        );
        System.out.println(find10MostActivityUsers(userActions));
        System.out.println(findTop5HashTags(userActions));
        System.out.println(findTop3UsersByComments(userActions));
        System.out.println(getActionsPercentage(userActions));
    }

    public static List<String> findTop5HashTags(List<UserAction> list) {

        Stream<UserAction> userActionStream = list.stream()
                .filter(userAction -> userAction.actionType()
                        .equals(ActionType.COMMENT) || userAction.actionType()
                        .equals(ActionType.POST));

        return userActionStream
                .collect(Collectors.groupingBy(UserAction::content, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Integer> findTop3UsersByComments(List<UserAction> list) {
        Stream<UserAction> userActionStream = list.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.date().isAfter(LocalDate.now().minusMonths(1)));

        return userActionStream
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> getActionsPercentage(List<UserAction> list) {
        Map<ActionType, Long> collect = list.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        int sum = collect.values().stream().mapToInt(Math::toIntExact).sum();

        return collect
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, percent -> (double) percent.getValue() / sum));
    }
}
