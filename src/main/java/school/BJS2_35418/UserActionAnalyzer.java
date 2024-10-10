package school.BJS2_35418;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> listOfUsersAction) {
        Map<Integer, List<UserAction>> mapWithUserAction = listOfUsersAction.stream().collect(Collectors.groupingBy(user -> user.getId()));
        return mapWithUserAction.entrySet().stream().sorted((x1, x2) -> x2.getValue().size() - x1.getValue().size()).flatMap(x -> x.getValue().stream())
                .map(x -> x.getName()).distinct().limit(10).collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> listOfUsersAction) {
        List<String> test = listOfUsersAction.stream().map(UserAction::getContent).filter(content -> content.contains("#")).toList();
        Map<String, List<String>> mapWithHashtags = test.stream().collect(Collectors.groupingBy(x -> {
                    int index1 = x.indexOf("#");
                    Pattern patern = Pattern.compile("[ .!,]|$");
                    Matcher matcher = patern.matcher(x.substring(index1 + 1));
                    int index2 = matcher.find() ? index1 + 1 + matcher.start() : -1;
                    return x.substring(index1, index2);
                })
        );
        return mapWithHashtags.entrySet().stream().sorted((x1, x2) -> x2.getValue().size() - x1.getValue().size()).
                map(Map.Entry::getKey).distinct().limit(5).collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> listOfUsersAction) {
        int max = 0;
        for (UserAction s : listOfUsersAction) {
            if (s.getActionDate().getMonthValue() > max) {
                max = s.getActionDate().getMonthValue();
            }
        }
        int finalMax = max;
        Map<Integer, List<UserAction>> mapWithUsersComments = listOfUsersAction.stream()
                .filter(x -> !x.getContent().isEmpty()).filter(x -> x.getActionDate()
                        .getMonthValue() >= finalMax).collect(Collectors.groupingBy(UserAction::getId));
        return mapWithUsersComments.entrySet().stream().sorted((x1, x2) -> x2.getValue().size() - x1.getValue().size()).flatMap(x -> x.getValue().stream())
                .map(UserAction::getName).distinct().limit(3).collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> listOfUsersAction) {
        int countMaxOfType = listOfUsersAction.size();
        Map<String, List<UserAction>> mapOfType = listOfUsersAction.stream().collect(Collectors.groupingBy(UserAction::getActionType));
        return mapOfType.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, x -> (double) Math.round((float) x.getValue().size() / countMaxOfType * 100)));
    }
}