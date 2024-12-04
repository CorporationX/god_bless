package school.faang.task_43998;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(1, "mike", 25, Set.of("skiing", "fishing", "video games"));
        var user2 = new User(2, "john", 20, Set.of("base jumping", "diving", "football"));
        var user3 = new User(3, "luke", 30, Set.of("skating", "hockey", "travelling"));
        var users = List.of(user1, user2, user3);

        var searchedActivities = Set.of("fishing", "diving", "football");

        System.out.println(User.findHobbyLovers(users, searchedActivities));
    }

}
