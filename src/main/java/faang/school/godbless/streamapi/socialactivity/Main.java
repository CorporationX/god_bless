package faang.school.godbless.streamapi.socialactivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.println();

        actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> LocalDateTime.now().getDayOfYear() - a.getActionDate().getDayOfYear() <= 30 &&
                        a.getActionDate().getYear() == LocalDateTime.now().getYear())
                .forEach(System.out::println);

        var typePercentage = getPercentageForActionType(actions);

        System.out.println();

        typePercentage.forEach((k, v) -> System.out.printf("%s : %.2f%%%n", k, v));
    }

    public static List<Integer> getTopActiveUsers(List<UserAction> actions, int topSize) {
        var userActions = getActionsCountByUserId(actions);

        return userActions.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(topSize)
                .toList();
    }

    public static List<String> getTopThemes(List<UserAction> actions, int topSize) {
        var themesActions = getActionsCountOnThemes(actions);

        return themesActions.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> getTopCommentatorsOfMonth(List<UserAction> actions, int topSize) {
        var userComments = getCommentsCountByUserId(actions);

        return userComments.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getPercentageForActionType(List<UserAction> actions) {
        var actionsByType = getActionsCountByType(actions);

        return actionsByType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() * 100.0 / actions.size()));
    }

    private static Map<Integer, Long> getActionsCountByUserId(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
    }

    private static Map<String, Long> getActionsCountOnThemes(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT || a.getActionType() == ActionType.POST)
                .flatMap(a -> Arrays.stream(a.getContent().split("[\\W&&[^#]]+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    private static Map<Integer, Long> getCommentsCountByUserId(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
    }

    private static Map<ActionType, Long> getActionsCountByType(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
    }

    private static List<String> getUsers() {
        return List.of("Petya", "Sasha", "Katya", "Vitya", "Klara",
                "Anya", "Vlad", "Mark", "Yulia", "Vika",
                "Pasha", "Sonya", "Roma", "Sveta", "Ilya",
                "Oleg", "Vera", "Dima", "Lyuda");
    }

    private static List<UserAction> getActions(List<String> users) {
        var rand = new Random();
        var actionTypes = ActionType.values();

        var hashtags = List.of("#freedom", "#love", "#instagram", "#fashion", "#art",
                "#photography", "#beauty", "#nature", "#picoftheday", "#travel",
                "#happy", "#style", "#trending", "#repost", "#summer",
                "#food", "#selfie", "#animals", "#makeup", "#model",
                "#amazing", "#lifestyle", "#design", "#sunset", "#nofilter",
                "#beach", "#handmade", "#sun", "#gym");

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
            actions.add(new UserAction(users.indexOf(user), user, actionType, actionTime, context));
        }

        return actions;
    }

    private static LocalDateTime getActionTime(Random rand) {
        return LocalDateTime.now().minusSeconds(rand.nextInt(60 * 24 * 60 * 60));
    }

}
