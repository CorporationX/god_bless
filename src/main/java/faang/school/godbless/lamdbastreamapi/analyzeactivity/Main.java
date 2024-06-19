package faang.school.godbless.lamdbastreamapi.analyzeactivity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    public static List<User> getMostActiveUsers(List<UserAction> userActions) {
        Map<User, Long> userActionCount = userActions.stream()
                .collect(Collectors.groupingBy(userAction -> {
                        return new User(userAction.id(), userAction.name());
                    },
                    Collectors.counting()
                )
        );

        return userActionCount.entrySet().stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().compareTo(e1.getValue());
                })
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> getMostPopularTheme(List<UserAction> userActions) {
        Map<String, Long> hashtagCount =  userActions.stream()
                .filter(userAction -> {
                    return Objects.equals("post",userAction.actionType())
                            || Objects.equals("comment",userAction.actionType());
                })
                .flatMap(userAction -> {
                    return Stream.of(userAction.content().split(" ")).filter(string -> string.contains("#"));
                })
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));

        return hashtagCount.entrySet().stream()
                .sorted((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<User> getTopUsersCommentLastMonth(List<UserAction> userActions) {
        Map<User, Long> userCountComment = userActions.stream()
                .filter(userAction -> {
                    return LocalDate.now().minusMonths(1).isBefore(userAction.date())
                            && Objects.equals(userAction.actionType(),"comment");
                })
                .collect(Collectors.groupingBy(
                        userAction -> {
                            return new User(userAction.id(), userAction.name());
                        },
                        Collectors.counting()
                ));
        return userCountComment.entrySet().stream()
                .sorted((el1, el2) -> {
                    return el2.getValue().compareTo(el1.getValue());
                })
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }


    // Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий. Отдельный метод класса.
    public static Map<String, Double> getPersentAction(List<UserAction> userActions) {
        Map<String, Long> actionCount = userActions.stream()
                .map(UserAction::actionType)
                .collect(Collectors.groupingBy(actionType -> actionType, Collectors.counting()));

        Map<String, Double> result = new HashMap<>();
        Long totalCount = actionCount.values().stream().reduce(Long::sum).orElse(0L);
        actionCount.entrySet().stream()
                .peek(action -> {
                    result.put(action.getKey(), 100.0 * action.getValue() / totalCount);
                })
                .collect(Collectors.toSet());

        return result;
    }
}