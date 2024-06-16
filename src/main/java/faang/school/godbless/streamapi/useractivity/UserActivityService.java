package faang.school.godbless.streamapi.useractivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserActivityService {

    private static final int DEFAULT_MOST_ACTIVE_USERS_LIMIT = 10;
    private static final int DEFAULT_MOST_POPULAR_SUBJECT_LIMIT = 5;

    public static void main(String[] args) {
        String s = "Lorem ipsum  dolor sit\namet";

        String[] split1 = s.split("[ \n]+");
        System.out.println(Arrays.toString(split1));
        System.out.println(split1.length);
    }

    // Найти топ-N самых активных пользователей
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

    // Получаем мапу где key - userId, value - количество выполненных действий пользователем
    // (посты, комментарии, лайки и репосты)
    private Map<Integer, Integer> getUserIdToActionsNumberMap(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.summingInt(x -> 1)));
    }
}
