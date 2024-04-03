package faang.school.godbless.usersCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Oleg", 21, Set.of("Football", "Coding", "Travel")));
        users.add(new User(1, "Ruslan", 22, Set.of("Football", "Coding", "Fitness")));
        users.add(new User(1, "Yarik", 21, Set.of("Gaming", "Coding", "Reading")));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of("Football", "Coding", "Gaming"));

        hobbyLovers.entrySet().forEach(System.out::println);
    }
}
