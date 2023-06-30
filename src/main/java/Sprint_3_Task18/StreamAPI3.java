package Sprint_3_Task18;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class StreamAPI3 {

    public static List<Integer> FindTheTop10MostActiveUsers(List<UserAction> userActions) {
        //        Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
        //        Отдельный метод класса.
        return userActions.stream()
                .collect((Collectors.groupingBy(UserAction::getId, Collectors.counting())))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<String> Top5MostPopularUsers(List<UserAction> userActions) {
//        Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях.
//        Хэштег — слово, начинающееся с символа #).Отдельный метод класса.
        return userActions.stream()
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> FindTop3UserByComment(List<UserAction> userActions) {
//        Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц.
//        Отдельный метод класса.
        return userActions.stream()
                .filter(userAction -> userAction.getActionDate().getMonthValue() == LocalDate.now().getMonthValue()
                        && userAction.getActionDate().getYear() == LocalDate.now().getYear()
                        && userAction.getActionType().equals(ActionType.comment))
                .collect(Collectors.toMap(UserAction::getName, userAction -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Map.Entry<ActionType, Integer>> CalculatePercentageOfActions(List<UserAction> userActions) {
//        Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий.
//        Отдельный метод класса.
        return userActions.stream()
                .collect((Collectors.groupingBy(UserAction::getActionType, Collectors.counting())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue() * 100 / userActions.size()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();
    }

    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Inna", ActionType.post, LocalDate.of(2020, 1, 1), "#HelloInna"),
                new UserAction(1, "Inna", ActionType.comment, LocalDate.of(2023, 5, 6), "#HelloInna"),
                new UserAction(1, "Inna", ActionType.comment, LocalDate.now(), "#HelloInna"),
                new UserAction(2, "Andrew", ActionType.comment, LocalDate.of(2022, 6, 4), "Hello Andrew"),
                new UserAction(3, "Vlad", ActionType.like, LocalDate.of(2022, 6, 4), "Hello Vlad"),
                new UserAction(4, "Robert", ActionType.share, LocalDate.of(2022, 6, 4), "Hello Robert"),
                new UserAction(5, "Anna", ActionType.post, LocalDate.of(2023, 6, 4), "#HelloAnna"),
                new UserAction(6, "Sofia", ActionType.comment, LocalDate.of(2023, 6, 4), "Hello Sofia"),
                new UserAction(7, "Nikita", ActionType.like, LocalDate.of(2023, 6, 4), "#HelloNikita"),
                new UserAction(7, "Nikita", ActionType.comment, LocalDate.of(2023, 6, 4), "#HelloNikita"),
                new UserAction(7, "Nikita", ActionType.comment, LocalDate.now(), "Hello Nikita"),
                new UserAction(8, "Zlata", ActionType.share, LocalDate.now(), "#HelloZlata"),
                new UserAction(8, "Zlata", ActionType.comment, LocalDate.now(), "#HelloZlata"),
                new UserAction(9, "Maria", ActionType.post, LocalDate.now(), "Hello Maria"),
                new UserAction(9, "Maria", ActionType.post, LocalDate.now(), "#Hello Maria"),
                new UserAction(9, "Maria", ActionType.post, LocalDate.now(), "#HelloMaria"),
                new UserAction(10, "Maksim", ActionType.comment, LocalDate.now(), "Hello Maksim"),
                new UserAction(11, "Mark", ActionType.like, LocalDate.now(), "Hello Mark"),
                new UserAction(12, "Bob", ActionType.share, LocalDate.now(), "Hello Bob")
        );
        System.out.println(StreamAPI3.FindTheTop10MostActiveUsers(userActions));
        System.out.println(StreamAPI3.Top5MostPopularUsers(userActions));
        System.out.println(StreamAPI3.FindTop3UserByComment(userActions));
        System.out.println(StreamAPI3.CalculatePercentageOfActions(userActions));
    }
}
