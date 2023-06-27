package faang.school.godbless.analysisOfUserActivity;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class analysisOfActivity {
    public List<Integer> top10ActiveUsers(List<User> listOfUsers) {
        Map<Integer, List<User>> map = listOfUsers.stream()
                .collect(Collectors.groupingBy(User::getId));

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<User>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .map(Map.Entry::getKey).limit(10).toList();


    }

    public List<String> top5MostPopularTopics(List<User> users) {
        Map<String, Long> nameTopicAndCount = users.stream()
                .flatMap(a -> Arrays.stream(a.getContent().split("\\a")))
                .filter(c -> c.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return nameTopicAndCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> top3UsersLeftMostComments(List<User> users) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monthAgo = now.minusMonths(1);
        Map<String, List<User>> userAndCountComments = users.stream()
                .filter(user -> user.getActionType().equals(actionType.COMMENT))
                .filter(user -> user.getActionDate().isAfter(LocalDateTime.from(now)))
                .collect(Collectors.groupingBy(User::getName));

        return userAndCountComments.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().size()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

    }

    public List<String> percentageOfActions (List<User> users) { // сколько процентов людей исп. тот или иной тип активности
        int countOfUsers = users.size();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        Map<actionType, List<User>> typeAndUser = users.stream()
                .collect(Collectors.groupingBy(User::getActionType));
        return typeAndUser.entrySet().stream()
                .map(u -> {
                    actionType actionType = u.getKey();
                    List<User> listWhoUsedThatTypeOfAction = u.getValue();
                    double percentage = (double) listWhoUsedThatTypeOfAction.size() / countOfUsers * 100;
                    return actionType +  ": " + decimalFormat.format(percentage) + "%";
                }).collect(Collectors.toList());
    }
}
