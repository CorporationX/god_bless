package BJS2_4350;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
            new User(1, "Ilya", 20, Set.of("football", "hockey", "basketball")),
            new User(2, "Oleg", 25, Set.of("hockey")),
            new User(3, "Misha", 22, Set.of("basketball", "swimming", "football")),
            new User(4, "Artem", 22, Set.of())
        );

        System.out.println(User.findHobbyLovers(users, Set.of("swimming", "hockey", "football")));
    }
}
