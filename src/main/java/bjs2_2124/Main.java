package bjs2_2124;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Pavel", Set.of("run", "jump", "swim", "drive")),
                new User(1, "Sergey", Set.of("fire", "eat", "drink", "hard drink")),
                new User(1, "Oleg", Set.of("work", "jump", "fly", "voyage"))
        );
        Set<String> activities = Set.of("jump", "bark");

        Map<User, String> usersActivity = User.findHobbyLovers(users, activities);
        usersActivity.forEach((k, v) -> System.out.println(k.getName() + ":" + v));
    }
}
