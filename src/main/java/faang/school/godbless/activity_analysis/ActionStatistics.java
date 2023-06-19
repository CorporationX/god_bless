package faang.school.godbless.activity_analysis;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ActionStatistics {

    public List<Integer> getTop10ActiveUsers(List<UserAction> list){
        Map<Integer, List<UserAction>> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));

        return map.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public List<String> getTop5Hashtags(List<UserAction> list){
        Map<String, Long> hashtagMap = list.stream()
                .flatMap(userAction ->
                        Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(hashtag -> hashtag.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> getTop3Commenters(List<UserAction> list){
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime start = now.minusMonths(1);
        Instant startInstant = start.toInstant();
        Map<Integer, List<UserAction>> map = list.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(Instant.from(start)))
                .collect(Collectors.groupingBy(UserAction::getUserId));

        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> - entry.getValue().size()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public List<String> getActionPercentage(List<UserAction> list){
        int userActionNumber = list.size();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        Map<ActionType, List<UserAction>> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));
        return map.entrySet().stream()
                .map(entry -> {
                    ActionType actionType = entry.getKey();
                    List<UserAction> userActions = entry.getValue();
                    double percentage = (double) userActions.size() / userActionNumber * 100;
                    return actionType + ": " + decimalFormat.format(percentage) + "%";
                })
                .collect(Collectors.toList());
    }
}
