package school.faang.analysisOfUserActivity;

import school.faang.analysisOfUserActivity.repositorys.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
  public static List<User> topActiveUsers(List<UserAction> userActions,int numbersOfTop, UserRepository repository) {
    Map<Integer, List<UserAction>> groupUserActions = userActions.stream()
        .collect(Collectors.groupingBy(UserAction::getUserId));

    return groupUserActions.entrySet().stream()
        .sorted((entry1, entry2) -> entry1.getValue().size() - entry2.getValue().size())
        .limit(numbersOfTop)
        .map(entry -> repository.findUserById(entry.getKey()).orElse(null))
        .toList();
  }

  public static List<String> topPopularHashtags(List<UserAction> userActions, int numbersOfTop) {
    Pattern pattern = Pattern.compile("#\\w+");

    Map<String, Long> hashtagCounts = userActions.stream()
        .flatMap(action -> {
          Matcher matcher = pattern.matcher(action.getContent());
          return matcher.results().map(MatchResult::group);
        }).collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()));

    return hashtagCounts.entrySet().stream()
        .sorted((entry1, entry2) -> Math.toIntExact(entry1.getValue() - entry2.getValue()))
        .limit(numbersOfTop)
        .map(Map.Entry::getKey)
        .toList();
  }

  public static List<User> topCommentersLastMonth(List<UserAction> actions, int numbersOfTop, UserRepository repository) {
    Map<UserAction, Long> groupActions = actions.stream()
        .filter(action -> ("comment".equals(action.getActionType())
            && (action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))))
        .collect(Collectors.groupingBy(action -> action, Collectors.counting()));

    return groupActions.entrySet().stream()
        .sorted((entry1, entry2) -> Math.toIntExact(entry1.getValue() - entry2.getValue()))
        .limit(numbersOfTop)
        .map(entry -> repository.findUserById(entry.getKey().getUserId()).orElse(null))
        .toList();
  }

  public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
    DecimalFormat df = new DecimalFormat("#.##");

    return actions.stream()
        .collect(Collectors.groupingBy(
            UserAction::getActionType,
            Collectors.counting()
        ))
        .entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            entry -> BigDecimal.valueOf(entry.getValue() / (double) actions.size())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue()
        ));
  }
}
