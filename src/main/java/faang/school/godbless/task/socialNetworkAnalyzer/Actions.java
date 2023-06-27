package faang.school.godbless.task.socialNetworkAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Actions {

    record UserAction(int userId, String username, ActionType action, LocalDate actionDate, String content) { }

    public static List<String> getTop10ActiveUserName(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::username, Collectors.counting()))
                .entrySet().stream()
                .sorted((user1ActionCount, user2ActionCount) -> user2ActionCount.getValue().compareTo(user1ActionCount.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop5Topics(List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::content)
                .flatMap(content -> {
                    Pattern hashTagPattern = Pattern.compile("#(\\S+)");
                    Matcher matcher = hashTagPattern.matcher(content);
                    List<String> hashtags = new ArrayList<>();
                    while (matcher.find()) {
                        hashtags.add(matcher.group(1));
                    }
                    return hashtags.stream();
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted((user1ActionCount, user2ActionCount) -> user2ActionCount.getValue().compareTo(user1ActionCount.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop3UserCommentators(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.action.equals(ActionType.COMMENT))
                .filter(action -> (action.actionDate.getMonth().equals(LocalDate.now().getMonth()) && action.actionDate.getYear() == LocalDate.now().getYear()))
                .collect(Collectors.groupingBy(UserAction::username, Collectors.counting()))
                .entrySet().stream()
                .sorted((user1ActionCount, user2ActionCount) -> user2ActionCount.getValue().compareTo(user1ActionCount.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Long> getActionPercentage(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::action, Collectors.counting()))
                .entrySet().stream()
                .peek(es -> es.setValue(es.getValue() * 100 / actions.size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        List<UserAction> actions = List.of(
                new UserAction(1, "Marsel", ActionType.LIKE, LocalDate.of(2022, 6, 21), "Котики зевают #коты"),
                new UserAction(2, "Alyosha", ActionType.LIKE, LocalDate.of(2023, 6, 20), "Криштиану Рунальду забил гол #футбол"),
                new UserAction(3, "Masha", ActionType.LIKE, LocalDate.of(2023, 6, 20), "Мем про котов #коты"),
                new UserAction(2, "Alyosha", ActionType.COMMENT, LocalDate.of(2023, 5, 5), "Месси пьет пиво в кальянной #футбол #пиво #кальян"),
                new UserAction(3, "Masha", ActionType.POST, LocalDate.of(2023, 3, 15), "Я киваю головой под ХамалиНавали #кальян"),
                new UserAction(3, "Masha", ActionType.COMMENT, LocalDate.of(2023, 4, 20), "Факторизация RSA по Шору на 50 кубитном квантовом компьютере #кванты"),
                new UserAction(1, "Marsel", ActionType.SHARE, LocalDate.of(2023, 6, 7), "Наливаем бесплатное пиво #пиво"),
                new UserAction(2, "Alyosha", ActionType.LIKE, LocalDate.of(2023, 6, 7), "Наливаем бесплатное пиво #пиво"),
                new UserAction(3, "Masha", ActionType.LIKE, LocalDate.of(2023, 6, 7), "Наливаем бесплатное пиво #пиво"),
                new UserAction(3, "Masha", ActionType.SHARE, LocalDate.of(2023, 6, 7), "Наливаем бесплатное пиво #пиво"),
                new UserAction(3, "Masha", ActionType.POST, LocalDate.of(2023, 6, 8), "Налили бесплатно пиво #пиво"),
                new UserAction(2, "Alyosha", ActionType.COMMENT, LocalDate.of(2023, 6, 8), "Налили бесплатно пиво #пиво"),
                new UserAction(2, "Alyosha", ActionType.LIKE, LocalDate.of(2023, 6, 20), "Коты лакают бесплатное пиво #коты #пиво")
        );

        System.out.println(getTop10ActiveUserName(actions));

        System.out.println(getTop5Topics(actions));

        System.out.println(getTop3UserCommentators(actions));

        System.out.println(getActionPercentage(actions));

    }
}
