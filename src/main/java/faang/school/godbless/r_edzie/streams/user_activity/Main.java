package faang.school.godbless.r_edzie.streams.user_activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();

        userActions.add(new UserAction(1, "user1", "post", "This is a #post"));
        userActions.add(new UserAction(2, "user3", "comment", "Nice #post"));
        userActions.add(new UserAction(3, "user3", "like", ""));
        userActions.add(new UserAction(4, "user1", "comment", "Great #post"));
        userActions.add(new UserAction(5, "user3", "share", ""));
        userActions.add(new UserAction(6, "user3", "post", "Another #post"));
        userActions.add(new UserAction(7, "user1", "comment", "Interesting #post"));
        userActions.add(new UserAction(8, "user2", "post", "Yet another #post"));
        userActions.add(new UserAction(9, "user3", "comment", "Nice post"));
        userActions.add(new UserAction(10, "user1", "like", ""));

        System.out.println(findTop10ActiveUsers(userActions));
    }

    public static List<String> findTop10ActiveUsers(List<UserAction> userActions) {
        return userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

