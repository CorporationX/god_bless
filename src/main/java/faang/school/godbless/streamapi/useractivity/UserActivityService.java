package faang.school.godbless.streamapi.useractivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserActivityService {

    private static final int DEFAULT_MOST_ACTIVE_USERS_LIMIT = 10;
    private static final int DEFAULT_MOST_POPULAR_SUBJECT_LIMIT = 5;
    private static final int DEFAULT_MOST_COMMENTING_USERS = 5;
    private static final int DEFAULT_DAYS_FOR_MOST_COMMENTING_USERS = 30;

    public static void main(String[] args) {
    }

    // Найти топ-N самых активных пользователей
    // Возвращаем Set из userId
    public Set<Integer> findMostActiveUser(List<UserAction> userActions, int limit) {
        return getUserIdToActionsNumberMap(userActions).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(limit)
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public Set<Integer> findMostActiveUser(List<UserAction> userActions) {
        return findMostActiveUser(userActions, DEFAULT_MOST_ACTIVE_USERS_LIMIT);
    }


    // Определить Топ-N наиболее популярных тем обсуждения
    public Set<String> findMostPopularDiscussionSubject(List<UserAction> userActions, int limit) {

        // --- Получаем мапу где key - хештег, value - количество упоминаний этого хештега
        Map<String, Integer> hashtagToMentionsNumber = userActions.stream()
                // оставляем в стриме только userAction с типами пост и коммент
                .filter(userAction -> userAction.getActionType().equals("post")
                        || userAction.getActionType().equals("comment"))
                // мапим стрим в хештеги
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("[ \n]+"))
                        .filter(s -> s.startsWith("#")))
                .collect(Collectors.groupingBy(x -> x, Collectors.summingInt(x -> 1)));

        return hashtagToMentionsNumber.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<String> findMostPopularDiscussionSubject(List<UserAction> userActions) {
        return findMostPopularDiscussionSubject(userActions, DEFAULT_MOST_POPULAR_SUBJECT_LIMIT);
    }

    // Найти Топ-N пользователей, которые оставили наибольшее количество комментариев в последнее время
    public Set<Integer> findMostCommentingUsersLastDays(List<UserAction> userActions,
                                                        long days, int limit) {
        Map<Integer, Integer> userIdToCommentsNumber = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .filter(userAction -> userAction.getActionDate().isAfter(
                        LocalDate.now().minusDays(days + 1)
                ))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.summingInt(x -> 1)));

        return userIdToCommentsNumber.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Integer> findMostCommentingUsersLastDays(List<UserAction> userActions) {
        return findMostCommentingUsersLastDays(userActions, DEFAULT_DAYS_FOR_MOST_COMMENTING_USERS,
                DEFAULT_MOST_COMMENTING_USERS);
    }

    // Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий
    public Map<String, Double> calculatePercentageForEachActionType(List<UserAction> userActions) {

        Map<String, Integer> actionTypeToActionsNumber = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.summingInt(x -> 1)));

        Integer totalActionsNumber = actionTypeToActionsNumber.entrySet().stream()
                .reduce(0, (x, entry) -> x + entry.getValue(), Integer::sum);

        return actionTypeToActionsNumber.entrySet().stream()
                .map(origEntry -> Map.entry(origEntry.getKey(),
                        ((double) origEntry.getValue()) / totalActionsNumber)
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    // Получаем мапу где key - userId, value - количество выполненных действий пользователем
    // (посты, комментарии, лайки и репосты)
    private Map<Integer, Integer> getUserIdToActionsNumberMap(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.summingInt(x -> 1)));
    }
}
