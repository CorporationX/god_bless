package faang.school.godbless.UserAnalysis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Integer> findTopTenUsersIdByActivities(List<UserAction> userActions) { // возвращает отсортированный список id юзеров
        List<Map.Entry<Integer, Integer>> idActionCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream().toList();
        return idActionCount.stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue())
                .map(Map.Entry::getKey).limit(10).toList();
    }

    public static List<String> topFiveHashTags(List<UserAction> userActions) { // // возвращает отсортированный список хештегов по кол-ву упоминаний
        List<UserAction> postsAndComments = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment") || userAction.getActionType().equals("post"))
                .toList();

        List<String> hashTags = findHashTags(postsAndComments);

        List<Map.Entry<String, Integer>> hashTagsCount = hashTags.stream()
                .collect(Collectors.groupingBy(string -> string, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream().toList();

        return hashTagsCount.stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue())
                .map(Map.Entry::getKey).limit(5).toList();

    }

    private static List<String> findHashTags(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("#[a-zA-Z0-9_-]+");
        List<String> result = new ArrayList<>();

        userActions.forEach(userAction -> {
            Matcher matcher = pattern.matcher(userAction.getContent());
            while (matcher.find()) {
                result.add(matcher.group());
            }
        });

        return result;
    }

    public static List<Integer> lastMonthTopThreeCommentators(List<UserAction> userActions) {
        List<UserAction> commentators = userActions.stream()
                .filter(userAction -> userAction.getActionDate().getMonth() == LocalDateTime.now().getMonth())
                .filter(userAction -> userAction.getActionType().equals("comment")).toList();

        List<Map.Entry<Integer, Integer>> countedCommentators = commentators.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream().toList();

        return countedCommentators.stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue()).map(Map.Entry::getKey).
                limit(3).toList();
    }

    public static Map<String, Double> actionsPercentRatio(List<UserAction> userActions) {
        double totalUsersActionsCount = userActions.size();

        return userActions.stream().collect(Collectors
                .groupingBy(UserAction::getActionType,
                        Collectors.collectingAndThen(Collectors.counting(), count -> Math.round(count / totalUsersActionsCount * 100.0) / 100.0)));
    }
}
