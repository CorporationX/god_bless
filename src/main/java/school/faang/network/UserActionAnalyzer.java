package school.faang.network;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {

    public List<String> userActivity(List<UserAction> userActions, int limitUser) {
        Map<String, Long> mapUser = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitUser)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> popularTopicDiscussion(List<UserAction> userActions, int limitComment) {
        String regex = "#\\w+";
        Pattern pattern = Pattern.compile(regex);
        return userActions.stream()
                .map(UserAction::getComment)
                .flatMap(comment -> {
                    Matcher matcher = pattern.matcher(comment);
                    List<String>hashtag = new ArrayList<>();
                    while (matcher.find()) {
                        hashtag.add(matcher.group());
                    }
                    return hashtag.stream();
                })
                .distinct()
                .limit(limitComment)
                .collect(Collectors.toList());
    }

    public List<String> maxComment(List<UserAction> userActions, int limitUser) {
        LocalDate date = LocalDate.now().minusMonths(1);
        Map<String, Long> mapUser = userActions.stream()
                .filter(type -> ActionType.COMMENT == (type.getType()) && type.getLocalDate().isAfter(date))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitUser)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> calculatePercentActionType(List<UserAction> actionList) {
        Map<ActionType, Long> percentActionType = actionList.stream()
                .collect(Collectors.groupingBy(UserAction::getType, Collectors.counting()));
        return percentActionType.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actionList.size()
                ));
    }

}
