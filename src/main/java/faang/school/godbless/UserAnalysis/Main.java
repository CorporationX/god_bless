package faang.school.godbless.UserAnalysis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Integer> findTopTenUsersIdByActivities(List<UserAction> userActions) { // выводит отсортированные id
        Map<Integer, Integer> idActionCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        List<Map.Entry<Integer, Integer>> entryIdActionCount = idActionCount
                .entrySet()
                .stream()
                .toList();

        return entryIdActionCount.stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> topFiveHashTags(List<UserAction> userActions) { // // выводит отсортированные хеш теги
        List<UserAction> postsAndComments = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment") || userAction.getActionType().equals("post"))
                .toList();

        List<String> hashTags = findHashTags(postsAndComments);

        Map<String, Integer> hashTagsCount = hashTags.stream()
                .collect(Collectors.groupingBy(string -> string, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        List<Map.Entry<String, Integer>> entriesHashTagsCount = hashTagsCount
                .entrySet()
                .stream()
                .toList();

        return entriesHashTagsCount.stream()
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

    public static List<Integer> lastMonthTopThreeCommentators(List<UserAction> userActions) { // выводит отсортированные идшники комментаторов
        List<UserAction> commentators = filterLastMonthComments(userActions);

        Map<Integer, Integer> countedCommentators = commentators.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        List<Map.Entry<Integer, Integer>> entriesCountedCommentators = countedCommentators
                .entrySet()
                .stream()
                .toList();

        return entriesCountedCommentators.stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue()).map(Map.Entry::getKey).
                limit(3).toList();
    }

    public static List<UserAction> filterLastMonthComments(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionDate().getMonth().minus(1) == LocalDateTime.now().getMonth().minus(1))
                .filter(userAction -> userAction.getActionType().equals("comment")).toList();
    }

    public static Map<String, Double> actionsPercentRatio(List<UserAction> userActions) {
        double totalUsersActionsCount = userActions.size();

        return userActions.stream()
                .collect(Collectors
                .groupingBy(UserAction::getActionType,
                        Collectors.collectingAndThen(Collectors.counting(), count -> Math.round(count / totalUsersActionsCount * 100.0) / 100.0)));
    }
}
