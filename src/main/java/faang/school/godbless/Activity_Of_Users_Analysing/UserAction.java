package faang.school.godbless.Activity_Of_Users_Analysing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class UserAction {
    private String name;
    private int id;
    private String actionType;
    private int actionDate;
    private String content;

    public void setActionType(String actionType) {
        if (!actionType.contains("post") || !actionType.contains("like") || !actionType.contains("share") || actionType.contains("comment")) {
            throw new IllegalArgumentException("Value must be like or post or share or comment");
        }
        this.actionType = actionType;
    }

    public static void findTop10Users(List<UserAction> userActionsList) {
        Map<String, Long> userActionsCount = userActionsList.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        List<String> top10Users = userActionsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(top10Users);
    }

    public static void findTop5Topics(List<UserAction> userActionList) {
        List<String> top5Topics = userActionList.stream()
                .filter(e1 -> e1.getActionType().contains("post") || e1.getActionType().contains("comment"))
                .flatMap(userAction -> {
                    Pattern pattern = Pattern.compile("#(\\w+)");
                    Matcher matcher = pattern.matcher(userAction.getContent());
                    List<String> hashtags = new ArrayList<>();
                    while (matcher.find()) {
                        hashtags.add(matcher.group(1));
                    }
                    return hashtags.stream();
                })
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(top5Topics);
    }

    public static void top3Users(List<UserAction> userActionList) {
        Map<String, Long> contentOfUsers = userActionList.stream().filter(userAction -> userAction.getActionType().contains("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        List<String> top3Users = contentOfUsers.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void percentOfActions(List<UserAction> userActionList) {
        Map<String, Long> actionsCount = userActionList.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long totalActions = userActionList.size();

        actionsCount.forEach((actionType, count) -> {
                    double percentage = count / totalActions * 100;
                    System.out.printf("Action type '%s' has %.2f%% of total actions%n", actionType, percentage);
                }
        );
    }
}
