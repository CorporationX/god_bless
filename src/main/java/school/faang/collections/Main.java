package school.faang.collections;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "John", 30, Set.of("run", "swim")),
                new User(2, "Jane", 25, Set.of("walk", "swim")),
                new User(3, "Bob", 35, Set.of("run", "walk")),
                new User(3, "Diego", 35, Set.of( "walk","playFotball","playBasketball"))
        );

        Set<String> activityUsers = Set.of("playBasketball","playFotball");

        User user = new User(1, "John", 30, activityUsers);

        System.out.println(user.findHobbyLovers(users,activityUsers));

    }
}
