package school.faang.bjs2_70955;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionService {

    private UserActionService() {
    }

    private static <K, R> List<R> processUserActions(
            List<UserAction> userActions,
            Function<UserAction, K> groupKey,
            Predicate<UserAction> filter,
            Comparator<Map.Entry<K, Long>> sorter,
            Function<Map.Entry<K, Long>, R> mapper,
            int limit
    ) {
        return userActions.stream()
                .filter(filter) // Применяем фильтр
                .collect(Collectors.groupingBy(
                        groupKey, // Группируем по ключу
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(sorter) // Сортируем по заданному компаратору
                .limit(limit > 0 ? limit : Long.MAX_VALUE) // Ограничиваем количество, если указан лимит
                .map(mapper) // Преобразуем данные с помощью маппера
                .toList();
    }

    public static List<String> getTopUsers(List<UserAction> userActions, int count) {
        return processUserActions(
                userActions,
                UserAction::getName,
                action -> true,
                Map.Entry.<String, Long>comparingByValue().reversed(),
                Map.Entry::getKey,
                count
        );
    }

    public static List<String> getTopHashtags(List<UserAction> userActions, int count) {
        return processUserActions(
                userActions,
                action ->
                        Pattern.compile("#[A-Za-z0-9-_]+")
                                .matcher(action.getComment())
                                .results()
                                .map(x -> x.group(0))
                                .toList()
                                .get(0),
                action -> action.getComment().contains("#"),
                Map.Entry.<String, Long>comparingByValue().reversed(),
                Map.Entry::getKey,
                count
        );
    }

    public static List<String> getTopUsersByCommentsLastMonth(List<UserAction> userActions) {
        return processUserActions(
                userActions,
                UserAction::getName,
                action -> !action.getComment().isEmpty(),
                Map.Entry.<String, Long>comparingByValue().reversed(),
                Map.Entry::getKey,
                -1
        );
    }

    public static List<Map<ActionType, Long>> getActionTypePercentage(List<UserAction> userActions) {
        return processUserActions(
                userActions,
                UserAction::getActionType,
                action -> true,
                (a, b) -> 0,
                x -> Map.of(
                        x.getKey(),
                        x.setValue(x.getValue() * 100 / userActions.size())),
                -1
        );
    }
}
