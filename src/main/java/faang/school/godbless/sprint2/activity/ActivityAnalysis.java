package faang.school.godbless.sprint2.activity;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ActivityAnalysis {
    public List<Integer> findTop10ActiveUsers(List<User> list) {
        Map<Integer, List<User>> groupUser = list.stream()
                .collect(Collectors.groupingBy(User::getId));

        return groupUser.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<User>>comparingByValue(Comparator.comparingInt(List::size))
                        .reversed()).map(Map.Entry::getKey).limit(10).toList();
    }

    public List<String> findTop5Theme(List<User> list) {
        Map<String, Long> sortByHashtag = list.stream()
                .flatMap(a -> Arrays.stream(a.getContent()
                        .split("\\a+"))).filter(f -> f.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return sortByHashtag.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> findTop3Commenters(List<User> list) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMonths(3);
        Map<Integer, List<User>> map = list.stream()
                .filter(user -> user.getActionType().equals(actionType.COMMENT))
                .filter(user -> user.getActionDate().isAfter(LocalDateTime.from(start)))
                .collect(Collectors.groupingBy(User::getId));

        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public List<String> findActionPercentage(List<User> list) {
        int userActionNumber = list.size();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        Map<actionType, List<User>> actionTypeMap = list.stream()
                .collect(Collectors.groupingBy(User::getActionType));
        return actionTypeMap.entrySet().stream()
                .map(f -> {
                    actionType actionType = f.getKey();
                    List<User> userActions = f.getValue();
                    double percentage = (double) userActions.size() / userActionNumber * 100;
                    return actionType + ": " + decimalFormat.format(percentage) + "%";
                }).collect(toList());
    }
}
