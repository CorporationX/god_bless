package faang.school.godbless.user;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

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
  }

  public List<String> getTopUsers(int topUsersCount) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime start = now.minusMonths(1);

    Map<String, List<UserAction>> userIdToActivities = userActions.stream()
        .filter((userAction -> userAction.getActionType() == ActionType.COMMENT))
        .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.from(start)))
        .collect(Collectors.groupingBy(UserAction::getUserId));

    return userIdToActivities.entrySet()
        .stream()
        .sorted(Map.Entry.<String, List<UserAction>>comparingByValue(
                Comparator.comparingInt(List::size))
            .reversed()
        )
        .limit(topUsersCount)
        .map(Map.Entry::getKey)
        .toList();
  }

  public  Map<ActionType, Float> getActivityPercentage() {
    Map<ActionType, Integer> mapActionTypeToCount = userActions.stream()
        .collect(Collectors.groupingBy(UserAction::getActionType, summingInt(x -> 1)));

    int totalActivitiesCount = mapActionTypeToCount.values().stream().reduce(0, Integer::sum);
    Map<ActionType, Float> mapActivitiesToPercentage = new HashMap<>();

    for (ActionType actionType : ActionType.values()) {
      if (!mapActionTypeToCount.containsKey(actionType)) continue;
      mapActivitiesToPercentage.put(actionType, ((float) mapActionTypeToCount.get(actionType) * 100 / totalActivitiesCount));
    }

    return mapActivitiesToPercentage;
  }
}
