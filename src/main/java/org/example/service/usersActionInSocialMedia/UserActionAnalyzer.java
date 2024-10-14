package org.example.service.usersActionInSocialMedia;

import org.example.model.usersActionInSocialMedia.UserAction;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> getTenMoreActiveUsersName(List<UserAction> userActions) {
        Map<String, Long> numberOfUsersAction = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return numberOfUsersAction.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopFivePopularHashTags(List<UserAction> userActions) {
        Map<String, Long> hashTags = userActions.stream()
                .filter(userAction -> userAction.getContent().contains("#") && "comment".equals(userAction.getActionType()))
                .map(action -> getWordStartsWithHashTag(action.getContent()))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return hashTags.entrySet().stream()
                .sorted((hasTag1, hasTag2) -> Math.toIntExact(hasTag2.getValue() - hasTag1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static String getWordStartsWithHashTag(String content) {
        return Pattern.compile("#\\w++")
                .matcher(content)
                .results()
                .limit(1)
                .map(MatchResult::group)
                .collect(Collectors.joining());
    }

    public static List<String> getTopThreeCommentersOfTheMonth(List<UserAction> actions) {
        int year = LocalDate.now().getYear();
        Month currentMonth = LocalDate.now().getMonth();
        int currentDay = LocalDate.now().getDayOfMonth();

        Map<String, Long> userActionsLastMonth = actions.stream()
                .filter(action -> action.getActionDate().isAfter(LocalDate.of(year, currentMonth, currentDay)) && "comment".equals(action.getActionType()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActionsLastMonth.entrySet().stream()
                .sorted((user1, user2) -> Math.toIntExact(user2.getValue() - user1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> getActionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .peek(key -> key.setValue(key.getValue() * 100 / actions.size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
