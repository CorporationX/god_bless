package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();

        User user = new User(
                UUID.randomUUID(),
                "Alex",
                10,
                Set.of("Hockey", "Swimming", "Football"));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Ivan",
                10,
                Set.of("Swimming", "Football"));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Pavel",
                10,
                Set.of("Diving", "Skating"));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Alexey",
                10,
                Set.of());
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Masha",
                10,
                Set.of("Hockey", "Swimming", "Football", "Diving", "Skating"));
        users.add(user);

        Set<String> hobbiesToFind = Set.of("Hockey", "Swimming", "Skiing");
        HashMap<User, String> userHobbies = User.findHobbyLovers(users, hobbiesToFind);

        System.out.printf(
                "Пользователи, у которых есть хотя бы одно хобби из: %s%n",
                String.join(", ", hobbiesToFind));
        for (Map.Entry<User, String> kvp : userHobbies.entrySet()) {
            System.out.printf("%s: %s%n", kvp.getKey().name(), kvp.getValue());
        }
    }
}
