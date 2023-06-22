package faang.school.godbless.user;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsersStatistics {
  private List<UserAction> userActions;

  public UsersStatistics(List<UserAction> userActions) {
    this.userActions = userActions;
  }

  public List<String> getMostActiveUsers(int usersCount) {
    // Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
    Map<String, List<UserAction>> map = userActions.stream()
        .collect(Collectors.groupingBy(UserAction::getUserId));

    return map.entrySet()
        .stream()
        .sorted(Map.Entry.<String, List<UserAction>>comparingByValue(
                Comparator.comparingInt(List::size))
            .reversed()
        )
        .map(Map.Entry::getKey)
        .limit(usersCount)
        .toList();
  }

  public List<String> getPopularTopics(int topicAmount) {
    // Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях.

    Map<String, Long> hashtagMap = userActions
        .stream()
        .filter((userAction -> userAction.getActionType() == ActionType.POST || userAction.getActionType() == ActionType.COMMENT))
        .flatMap((userAction) -> Arrays.stream(userAction.getContent().split(" ")))
        .filter(word -> word.startsWith("#"))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    return hashtagMap
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .map(Map.Entry::getKey)
        .limit(topicAmount)
        .toList();

    // 1. У нас есть ActionType COMMENT и POST
    // 2. Найти все возможные hashtag в контенте
    // 3. сгруппировать их по кол-ву, хештег->кол-во
    // 4. Отсортировать
    // 5. Взять последние N


  }

  public void getTopUsers() {
    //  Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц. Отдельный метод класса.
  }

  public void getActivityPercantage() {
    //   Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий. Отдельный метод класса.
  }
}
