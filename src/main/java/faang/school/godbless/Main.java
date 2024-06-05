package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1, "A", 1, Set.of("A","B"));
        User user2 = new User(2, "B", 1, Set.of("H","L"));
        User user3 = new User(3, "C", 1, Set.of("L", "p"));

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("J");
        set.add("H");

        System.out.println(user1.findHobbyLovers(users, set));


    }
}
