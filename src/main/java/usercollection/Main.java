package usercollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User alice = new User(1, "Alice", 25, Set.of("Reading", "Swimming", "Gaming"));
        User bob = new User(2, "Bob", 30, Set.of("Cooking", "Gaming", "Cycling"));
        User carol = new User(3, "Carol", 22, Set.of("Dancing", "Singing"));

        List<User> users = List.of(alice, bob, carol);
        Set<String> hobbiesToSearch = Set.of("Gaming", "Singing");

        Map<User, String> result = alice.findHobbyLovers(users, hobbiesToSearch);

        result.forEach((user, hobby) -> System.out.println(user + " loves " + hobby));
    }
}
