package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();

        var user = new User(
                UUID.randomUUID(),
                "Alex",
                10,
                new HashSet<>(Arrays.asList("Hockey", "Swimming", "Football")));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Ivan",
                10,
                new HashSet<>(Arrays.asList("Swimming", "Football")));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Pavel",
                10,
                new HashSet<>(Arrays.asList("Diving", "Skating")));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Alexey",
                10,
                new HashSet<>(List.of()));
        users.add(user);

        user = new User(
                UUID.randomUUID(),
                "Masha",
                10,
                new HashSet<>(Arrays.asList("Hockey", "Swimming", "Football", "Diving", "Skating")));
        users.add(user);

        var hobbiesToFind = new HashSet<>(Arrays.asList(new String[]{"Hockey", "Swimming", "Skiing"}));
        var userHobbies = User.findHobbyLovers(users, hobbiesToFind);

        System.out.printf(
                "Пользователи, у которых есть хотя бы одно хобби из: %s%n",
                String.join(", ", hobbiesToFind));
        for (Map.Entry<User, String> kvp : userHobbies.entrySet()) {
            System.out.printf("%s: %s%n", kvp.getKey().name(), kvp.getValue());
        }
    }
}
