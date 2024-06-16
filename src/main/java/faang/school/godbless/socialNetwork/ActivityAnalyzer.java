package faang.school.godbless.socialNetwork;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.NonNull;

/**
 * @author Evgenii Malkov
 */
public class ActivityAnalyzer {
  public static List<String> getMostActivityUsers(@NonNull List<UserAction> actions, @NonNull ActionType actionType, int limit) {
    return actions.stream()
        .filter((act) -> act.getActionType().equals(actionType))
        .collect(Collectors.groupingBy(UserAction::getUsername, Collectors.counting()))
        .entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        .map(Map.Entry::getKey)
        .limit(limit)
        .collect(Collectors.toList());
  }

  public static List<String> getMostDiscussedThemes(@NonNull List<UserAction> actions, List<ActionType> types, int limit) {
    Pattern pattern = Pattern.compile("#\\w+");
    return actions.stream()
        .filter((act) -> types.contains(act.getActionType()))
        .map(UserAction::getContent)
        .flatMap((row) -> {
          Matcher matcher = pattern.matcher(row);
          List<String> hashtags = new ArrayList<>();
          while (matcher.find()) {
            hashtags.add(matcher.group().substring(1));
          }
          return hashtags.stream();
        })
        .collect(Collectors.groupingBy((tag) -> tag, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(limit)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  public static List<String> getMostActiveUsersInCommentsOnLastMonth(@NonNull List<UserAction> actions, int limit) {
    return actions
        .stream()
        .filter((act) -> LocalDateTime.now().minusMonths(1L).isBefore(act.getActionDate()))
        .filter((act) -> act.getActionType().equals(ActionType.COMMENT))
        .collect(Collectors.groupingBy(UserAction::getUsername, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .limit(limit)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  public static Map<ActionType, Double> countPercentActionType(@NonNull List<UserAction> actions) {
    return actions.stream()
        .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
        .entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey, (type) -> (double) ((type.getValue() * 100) / actions.size())));
  }
}
