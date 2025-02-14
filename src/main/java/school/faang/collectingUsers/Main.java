package school.faang.collectingUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Nick", 15, Set.of("reading", "swimming")),
                new User(2, "Nina", 20, Set.of("running")),
                new User(3, "Paul", 18, Set.of("studying", "working"))
        );

        Set<String> hobbies = Set.of("studying", "reading");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " likes " + entry.getValue());
        }
    }
}
