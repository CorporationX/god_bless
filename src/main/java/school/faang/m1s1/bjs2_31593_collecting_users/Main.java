package school.faang.m1s1.bjs2_31593_collecting_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User alice = new User(1, "Alice", 25, Set.of("football", "basketball", "triathlon"));

        List<User> userList = new ArrayList<>(List.of(
                new User(2, "Bob", 25, Set.of("triathlon", "hockey", "football")),
                new User(3, "Alice", 25, Set.of("hockey")),
                new User(4, "Alice", 25, Set.of("muay thai", "basketball"))
        ));

        System.out.println(alice.findHobbieLovers(userList, alice.getHobbies()));
    }
}
