package school.faang.BJS2_58013;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {

    public static List<String> topActiveUsers(List<UserAction> users, int topUsers) {
        Map<String, Long> collect = users.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return collect.entrySet().stream()
                .sorted((value1, value2) -> Long.compare(value2.getValue(), value1.getValue()))
                .limit(topUsers)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularDiscussionTopics(List<UserAction> users, int topTopics) {
        return users.stream()
                .filter(user -> user.getContent() != null
                        && (ActionType.POST.equals(user.getType()) || ActionType.COMMENT.equals(user.getType())))
                .flatMap(content -> Arrays.stream(Objects.requireNonNull(content.getContent()).split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(hashtag -> hashtag.replaceAll("\\p{Punct}$", ""))
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topTopics)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentsLastMonth(List<UserAction> users, int topUsers) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        return users.stream()
                .filter(user -> user.getActionDate().getMonth().equals(lastMonth.getMonth())
                        && user.getActionDate().getYear() == lastMonth.getYear())
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topUsers)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> calculatePercentageEachType(List<UserAction> users) {
        int countContent = users.size();
        if (countContent == 0) {
            return Collections.emptyMap();
        }

        return users.stream()
                .collect(Collectors.groupingBy(user -> user.getType().name(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> (double) (v.getValue() * 100) / countContent
                ));
    }
}
