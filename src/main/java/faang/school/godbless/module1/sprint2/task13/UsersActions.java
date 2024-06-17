package faang.school.godbless.module1.sprint2.task13;

import static faang.school.godbless.module1.sprint2.task13.ActionType.COMMENT;
import static faang.school.godbless.module1.sprint2.task13.ActionType.POST;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersActions {
    private int id;
    private String name;
    private List<Action> action;


    public static void topTenActivityUser(List<UsersActions> usersActionsList) {
        usersActionsList.stream()
                .sorted((userFirst, userSecond) -> Integer.compare(userSecond.getAction().size(), userFirst.getAction().size()))
                .limit(10)
                .forEach(usersActions -> System.out.println(usersActions.getName() + " " + usersActions.getAction().size()));
    }

    public static void topFiveShames(List<UsersActions> usersActionsList) {
        Pattern pattern = Pattern.compile("#\\w+");
        Map<String, Integer> hashtags = usersActionsList.stream()
                .flatMap(actions -> actions.getAction().stream()
                        .filter(action -> action.getActionType().equals(COMMENT)
                                || action.getActionType().equals(POST))
                        .filter(content -> content.getContent().matches(String.valueOf(pattern)))
                        .flatMap(action -> Arrays.stream(action.getContent().split(" "))
                                .filter(hashtag -> hashtag.matches(String.valueOf(pattern)))))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        hashtags.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static void topThreeUsersByCommentInMonth(List<UsersActions> usersActionsList) {
        LocalDateTime monthBefore = LocalDateTime.now().minusDays(31);
        usersActionsList.stream()
                .map(userAction -> {
                    List<Action> filteredActions = userAction.getAction().stream()
                            .filter(action -> action.getActionType().equals(COMMENT))
                            .filter(action -> action.getActionCreateAt().isAfter(monthBefore))
                            .toList();
                    return new UsersActions(userAction.getId(), userAction.getName(), filteredActions);
                })
                .sorted((userFirst, userSecond) -> Integer.compare(userSecond.getAction().size(), userFirst.getAction().size()))
                .limit(3)
                .forEach(userAction -> System.out.println(userAction.getName() + " " + userAction.getAction().size()));
    }

    public static void percentsOfActivities(List<UsersActions> usersActionsList){
        Map<ActionType,Integer> actionTypeIntegerMap = usersActionsList.stream()
                .flatMap(actions -> actions.getAction().stream())
                .collect(Collectors.groupingBy(Action::getActionType,Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        int result = actionTypeIntegerMap.values().stream()
                .mapToInt(value -> value)
                .sum();
        actionTypeIntegerMap.forEach((key, value) -> System.out.println(key + " " + ((double) value / result * 100) + " %"));

    }



}
