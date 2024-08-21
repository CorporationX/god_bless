package faang.school.godbless.BJS222743;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SocialMediaAnalytics {

    public List<String> findTop10ActiveUsers(List<UserAction> actions) {
        Map<Long, String> userIdToNameMap = getUserIdToNameMap(actions);

        return actions.stream()
                // думал тут писать через юзернейм // но кажется нужно через юзерАйди // что лучше?
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                // потому что тут будет только цифры и не понятно
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(10)
//                .map(Map.Entry::getKey)
                .map(entry -> userIdToNameMap.get(entry.getKey()) + " (" + entry.getValue() + " actions)")
                .collect(Collectors.toList());
    }

    public List<String> findTop5PopularTopics(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> a.getActionType().equals("post") || a.getActionType().equals("comment"))
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> findTop3CommentersLastMonth(List<UserAction> actions) {
        Map<Long, String> userIdToNameMap = getUserIdToNameMap(actions);

        LocalDate now = LocalDate.now();
        LocalDate startOfLastMonth = now.minusMonths(1).withDayOfMonth(1);

        return actions.stream()
                .filter(a -> a.getActionType().equals("comment"))
                .filter(a -> !a.getActionDate().isBefore(startOfLastMonth))

                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))

                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(3)

                // TODO List
                .map(entry -> userIdToNameMap.get(entry.getKey()) + " (" + entry.getValue() + " comments")
                .collect(Collectors.toList());
    }

    public Map<String, Double> calculateActionTypePercentage(List<UserAction> actions) {
        // Проверка на null или деление на ноль нужен?
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actions.size() * 100));
    }

    private Map<Long, String> getUserIdToNameMap(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.toMap(UserAction::getUserId, UserAction::getUsername, (name1, name2) -> name1));
    }

}
