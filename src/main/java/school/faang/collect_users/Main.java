package school.faang.collect_users;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("riding", "hiking", "playing", "swimming");
        List<User> users = List.of(
                new User(1, "John", 22, Set.of("swimming", "playing")),
                new User(2, "Jane", 23, Set.of("swimming", "hiking")),
                new User(3, "Bob", 24, Set.of("racing")));

        System.out.println(User.findHobbyLovers(users, hobbies));
    }
}
