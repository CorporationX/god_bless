package user.activity;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var users = getUsers();
        var actions = getActions(users);
        var topActivityUsers = getTopActiveUsers(actions, 10);
        topActivityUsers.forEach(System.out::println);
        System.out.println();
        var userActions = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));
        userActions.forEach((key, value) -> System.out.println(key + " " + value.size()));
        System.out.println();
        var topThemes = getTopThemes(actions, 5);
        topThemes.forEach(System.out::println);
        System.out.println();
        var topCommentators = getTopCommentatorsOfMonth(actions, 3);
        topCommentators.forEach(System.out::println);
        LocalDateTime now = LocalDateTime.now();
        System.out.println();
        actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> now.getDayOfYear() - a.getActionDate().getDayOfYear() <= 30 &&
                        a.getActionDate().getYear() == now.getYear())
                .forEach(System.out::println);
        var typePercentage = getPercentageForActionType(actions);
        System.out.println();
        typePercentage.forEach((k, v) -> System.out.printf("%s : %.2f%%%n", k, v));
    }

    public static List<Integer> getTopActiveUsers(@NonNull List<UserAction> actions, int topSize) {
        Map<Integer, Long> userActions = getActionsCountByUserId(actions);
        return userActions.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<Integer, Long> e) -> e.getValue()).reversed())
                .map(Map.Entry::getKey)
                .limit(topSize)
                .toList();
    }

    public static List<String> getTopThemes(@NonNull List<UserAction> actions, int topSize) {
        Map<String, Long> themesActions = getActionsCountOnThemes(actions);
        return themesActions.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<String, Long> e) -> e.getValue()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> getTopCommentatorsOfMonth(@NonNull List<UserAction> actions, int topSize) {
        Map<Integer, Long> userComments = getCommentsCountByUserId(actions);
        return userComments.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<Integer, Long> e) -> e.getValue()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getPercentageForActionType(@NonNull List<UserAction> actions) {
        Map<ActionType, Long> actionsByType = getActionsCountByType(actions);
        return actionsByType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() * 100.0 / actions.size()));
    }

    private static Map<Integer, Long> getActionsCountByUserId(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
    }

    private static Map<String, Long> getActionsCountOnThemes(@NonNull List<UserAction> actions) {
        return actions.stream().
                filter(a -> a.getActionType() == ActionType.COMMENT || a.getActionType() == ActionType.POST)
                .flatMap(a -> Arrays.stream(a.getContent().split("[\\W&&[^#]]+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    private static Map<Integer, Long> getCommentsCountByUserId(@NonNull List<UserAction> actions) {
        LocalDateTime nowMinusMonth = LocalDateTime.now().minusMonths(1);
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().isAfter(nowMinusMonth))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
    }

    private static Map<ActionType, Long> getActionsCountByType(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
    }

    private static List<String> getUsers() {

        return List.of("Petya", "Sasha", "Katya", "Vitya", "Klara",
                "Anya", "Vlad", "Mark", "Ron", "Yulia",
                "Vika", "Pasha", "Lesha", "Serega", "Maks",
                "Sonya", "Roma", "Sveta", "Ilya", "Vanya",
                "Oleg", "Vera", "Dima", "Lyuda", "Filipp");
    }

    private static List<UserAction> getActions(@NonNull List<String> users) {
        var rand = new Random();
        var actionTypes = ActionType.values();
        var hashtags = List.of("#freedom", "#love", "#instagood", "#instagram", "#fashion",
                "#photooftheday", "#art", "#photography", "#beautiful", "#nature",
                "#picoftheday", "#travel", "#happy", "#follow", "#style",
                "#tbt", "#trending", "#instadaily", "#like4like", "#repost",
                "#summer", "#food", "#beauty", "#selfie", "#me",
                "#dog", "#makeup", "#reels", "#model", "#follow4follow",
                "#amazing", "#lifestyle", "#design", "#sunset", "#nofilter",
                "#beach", "#handmade", "#foodporn", "#sun", "#gym");
        String text = "Awesome post or comment or whatever, very cool!";
        var actions = new ArrayList<UserAction>();
        for (int i = 0; i < 100; i++) {
            String context = "";

            var actionType = actionTypes[rand.nextInt(actionTypes.length)];
            if (actionType == ActionType.POST || actionType == ActionType.COMMENT) {
                var actionHashtags = hashtags.stream()
                        .filter(ht -> rand.nextInt(100) < 20)
                        .collect(Collectors.joining(" "));
                context = text + " " + actionHashtags;
            }
            var user = users.get(rand.nextInt(users.size()));
            var actionTime = getActionTime(rand);
            actions.add(new UserAction(users.indexOf(user), user,
                    actionType, actionTime, context));
        }

        return actions;
    }

    private static LocalDateTime getActionTime(@NonNull Random rand) {
        return LocalDateTime.now().minusSeconds(rand.nextInt(60 * 24 * 60 * 60));
    }
}
