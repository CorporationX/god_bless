package BJS2_4350;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User(1, "Ilya", 20, Set.of("football", "hockey", "basketball")));
        users.add(new User(2, "Oleg", 25, Set.of("hockey")));
        users.add(new User(3, "Misha", 22, Set.of("basketball", "swimming", "football")));
        users.add(new User(4, "Artem", 22, Set.of()));

        System.out.println(User.findHobbyLovers(users, Set.of("swimming", "hockey", "football")));
    }
}
