package school.faang.sprint_2.task_47307;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void topPopularHashtags(List<UserAction> actions) {

    }

    public static void topCommentersLastMonth(List<UserAction> actions) {

    }

    public static void actionTypePercentages(List<UserAction> actions) {

    }

}
