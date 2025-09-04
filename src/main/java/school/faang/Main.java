package school.faang;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", 25, 1, Set.of("football", "music"));
        User user2 = new User("Maria", 30, 2, Set.of("reading", "music"));
        User user3 = new User("Ivan", 22, 3, Set.of("gaming", "chess"));

        List<User> users = List.of(user1, user2, user3);

        List<String> activities = List.of("music");

        Map<String, String> lovers = User.findHobbyLovers(users, activities);

        System.out.println(lovers);
    }
}

