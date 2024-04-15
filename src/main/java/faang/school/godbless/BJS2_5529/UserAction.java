package faang.school.godbless.BJS2_5529;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String userName;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;

    public static List<Integer> getTopTenActiveUsers(List<UserAction> userActions) {

        return userActions.stream().
                collect(Collectors.groupingBy(UserAction::getId, Collectors.counting())). // группируем и подсчитываем пользователей по активностям
                        entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()) // сортируем их по возрастанию действий и переворачиваем массив
                .limit(10).map(Map.Entry::getKey).toList(); // обрезаем до топ 10 пользователей по активности
    }

    // хотел вернуть из метода List<String> с комментами, но что-то не выходит, можно подсказочку?😇
    public static List<UserAction> getTopFivePopularThemes(List<UserAction> userActions) {
        return userActions.stream().flatMap(
                        x -> Stream.concat(
                                userActions.stream().filter(post -> post.getActionType().equals(ActionType.POST)),
                                userActions.stream().filter(comment -> comment.getActionType().equals(ActionType.COMMENT)))
                ).filter(commentAndPost -> commentAndPost.getContent().matches("#.*")).
                collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting())).entrySet().stream().
                sorted(Map.Entry.<UserAction, Long>comparingByValue().reversed()).limit(5).map(Map.Entry::getKey).toList();
    }

    public static List<Integer> getTopThreeUsersByPostingComments(List<UserAction> userActions) {
        return userActions.stream().filter(user -> user.getActionType().equals(ActionType.COMMENT)).
                collect(Collectors.groupingBy(UserAction::getId, Collectors.counting())).entrySet().stream().
                sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> getAnalyseActivities(List<UserAction> userActions) {

        return userActions.stream().
                collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting())).entrySet().stream().
                collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.floor((double) entry.getValue() * 100 / userActions.size())
                ));


    }
}
