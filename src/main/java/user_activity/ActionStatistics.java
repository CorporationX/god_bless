package user_activity;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ActionStatistics {

    public List<Integer> getTop10ActiveUsers(List<UserAction> list) {
        Map<Integer, List<UserAction>> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<UserAction>>comparingByValue(
                                Comparator.comparingInt(List::size))
                        .reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public List<String> getTop5Hashtags(List<UserAction> list) {
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

    public List<Integer> getTop3Commenters(List<UserAction> list) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(1);
        Map<Integer, List<UserAction>> map = list.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.from(start)))
                .collect(Collectors.groupingBy(UserAction::getUserId));

        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public Map<ActionType, Double> getActionPercentage(List<UserAction> list) {
        int userActionNumber = list.size();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        Map<ActionType, List<UserAction>> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));

        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<UserAction> userActions = entry.getValue();
                            double percentage = (double) userActions.size() / userActionNumber * 100;
                            return Double.parseDouble(decimalFormat.format(percentage));
                        }
                ));
    }
}