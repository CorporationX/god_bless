package faang.school.godbless.colletction_users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Set<String> strings = new HashSet<>();
        strings.add("running");
        strings.add("walking");
        User user = new User(0, "VASYA", 18, Set.of("running"));
        User user1 = new User(1, "jk", 43, Set.of("running", "football"));
        User user2 = new User(2, "Petya", 21, Set.of("going to fridge", "going to sofa"));
        users.add(user);
        users.add(user1);
        users.add(user2);
        System.out.println(User.findHobbyLovers(users, strings));

    }
}
