package user.activity;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var users = getUsers();
        Map<Integer, User> usersId = new HashMap<>();
        users.forEach(user -> usersId.put(user.getUserId(), user));
        var actions = getActions(users);
        //actions.forEach(System.out::println);
        System.out.println();
        var topActivityUsers = getTopActiveUsers(actions, 10);
        topActivityUsers.stream()
                .map(usersId::get)
                .forEach(System.out::println);
        System.out.println();
        var userActions = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));
        userActions.forEach((key, value) -> System.out.println(key + " " + value.size()));
        System.out.println();
        var topThemes = getTopThemes(actions, 5);
        topThemes.forEach(System.out::println);
        System.out.println();
        var topCommentators = getTopCommentatorsOfMonth(actions, 3);
        topCommentators.stream()
                .map(usersId::get)
                .forEach(System.out::println);
        LocalDateTime now = LocalDateTime.now();
        System.out.println();
        actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().getMonthValue() == now.getMonthValue() &&
                        a.getActionDate().getYear() == now.getYear())
                .forEach(System.out::println);
        var typePercentage = getPercentageForActionType(actions);
        System.out.println();
        typePercentage.forEach((k, v) -> System.out.printf("%s : %.2f%%%n", k, v));
    }

    public static List<Integer> getTopActiveUsers(@NonNull List<UserAction> actions, int topSize) {
        var userActions = getUserActions(actions);
        return userActions.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<Integer, List<UserAction>> e) -> e.getValue().size()).reversed())
                .map(Map.Entry::getKey)
                .limit(topSize)
                .toList();
    }

    public static List<String> getTopThemes(@NonNull List<UserAction> actions, int topSize) {
        var themesActions = getThemesActions(actions);
        return themesActions.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<String, List<UserAction>> e) -> e.getValue().size()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> getTopCommentatorsOfMonth(@NonNull List<UserAction> actions, int topSize) {
        var userComments = getUserComments(actions);
        return userComments.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Map.Entry<Integer, List<UserAction>> e) -> e.getValue().size()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getPercentageForActionType(@NonNull List<UserAction> actions) {
        var actionsByType = getActionsByType(actions);
        return actionsByType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size() * 1.0 / actions.size() * 100));
    }

    private static Map<Integer, List<UserAction>> getUserActions(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));
    }

    private static Map<String, List<UserAction>> getThemesActions(@NonNull List<UserAction> actions) {
        Map<String, List<UserAction>> themesActions = new HashMap<>();
        actions.stream().
                filter(a -> a.getActionType() == ActionType.COMMENT || a.getActionType() == ActionType.POST)
                .forEach(a -> Arrays.stream(a.getContent().split("[\\W&&[^#]]+"))
                        .filter(word -> word.startsWith("#"))
                        .forEach(ht -> themesActions.computeIfAbsent(ht, k -> new ArrayList<>()).add(a)));
        return themesActions;
    }

    private static Map<Integer, List<UserAction>> getUserComments(@NonNull List<UserAction> actions) {
        LocalDateTime now = LocalDateTime.now();
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().getMonthValue() == now.getMonthValue() &&
                        a.getActionDate().getYear() == now.getYear())
                .collect(Collectors.groupingBy(UserAction::getUserId));
    }

    private static Map<ActionType, List<UserAction>> getActionsByType(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));
    }

    private static List<User> getUsers() {
        var names = List.of("Petya", "Sasha", "Katya", "Vitya", "Klara",
                "Anya", "Vlad", "Mark", "Ron", "Yulia",
                "Vika", "Pasha", "Lesha", "Serega", "Maks",
                "Sonya", "Roma", "Sveta", "Ilya", "Vanya",
                "Oleg", "Vera", "Dima", "Lyuda", "Filipp");
        List<User> users = new ArrayList<>();
        names.forEach(name -> users.add(new User(name)));
        return users;
    }

    private static List<UserAction> getActions(@NonNull List<User> users) {
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
            actions.add(new UserAction(user.getUserId(), user.getUserName(),
                    actionType, actionTime, context));
        }

        return actions;
    }

    private static LocalDateTime getActionTime(@NonNull Random rand) {
        return LocalDateTime.now().minusSeconds(rand.nextInt(60 * 24 * 60 * 60));
    }
}
