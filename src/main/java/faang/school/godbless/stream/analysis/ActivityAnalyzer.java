package faang.school.godbless.stream.analysis;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public record ActivityAnalyzer() {

    public List<String> findTopTenActiveUsers(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("Actions cannot be null");
        }
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::userId, Collectors.counting())) // группируем по юзерам сколько у кого действий было
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // сортируем количество действий в порядке убывания
                .limit(10)
                .map(Map.Entry::getKey) // преобразовываем в список идентификаторов юзеров
                .toList();
    }

    public List<String> findTopFiveHotTopicsInPostsAndComments(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("Actions cannot be null");
        }
        Pattern pattern = Pattern.compile("#\\w+");
        Map<String, Long> hashtagsCounted = userActions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.POST) ||
                        userAction.actionType().equals(ActionType.COMMENT))
                .flatMap(userAction -> {
                    var matcher = pattern.matcher(userAction.content()); // расплющиваем стрим до строк и вычленяем хэштеги
                    Set<String> hashtags = new HashSet<>();
                    while (matcher.find()) {
                        hashtags.add(matcher.group());
                    }
                    return hashtags.stream();
                })
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting())); // формируем маппинг хэштегов с их количеством
        return hashtagsCounted.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // сортируем в порядке убывания количества вхождений хэштега
                .limit(5)
                .map(Map.Entry::getKey) // вовзращаем только самые популярные хэштеги
                .toList();
    }

    public List<String> findTopThreeCommentAuthorsLastMonth(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("Actions cannot be null");
        }
        var oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT)) // отфильтровываем все кроме комментов
                .filter(userAction -> userAction.actionDate().toLocalDate().isAfter(oneMonthAgo)) // оставляем только данные последнего месяца
                .collect(Collectors.groupingBy(UserAction::userId, Collectors.counting())) // группируем по юзерам у кого сколько комментов
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // сортируем количество комментов в порядке убывания
                .limit(3)
                .map(Map.Entry::getKey) // преобразовываем в список идентификаторов юзеров
                .toList();
    }

    public Map<ActionType, Double> findPercentageOfActionTypes(List<UserAction> userActions) {
        if (userActions == null) {
            throw new IllegalArgumentException("Actions cannot be null");
        }
        var totalNumberOfActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting())) // группируем по типам и считаем их количество
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (e.getValue() * 100.0) / totalNumberOfActions)); // просчитываем процент для каждого типа
    }
}
