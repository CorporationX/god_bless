package school.faang.collect_users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var hobbies = new HashSet<>(Arrays.asList("Soccer", "Gym", "Swimming"));
        var users = List.of(
                new User(1, "Antony", 23, Set.of("Art", "Piano", "Gym")),
                new User(2, "Johny", 25, Set.of("Diving", "Guitar"))
        );
        System.out.println(User.findHobbyLovers(users, hobbies));
    }
}
