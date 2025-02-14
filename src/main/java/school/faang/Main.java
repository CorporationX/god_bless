package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();

        User user = new RandomUserBuilder(5, 10)
                .addName("Alex")
                .addHobbies("Hockey", "Swimming", "Football")
                .build();
        users.add(user);

        user = new RandomUserBuilder()
                .addName("Ivan")
                .addHobby("Swimming")
                .addHobby("Football")
                .build();
        users.add(user);

        user = new RandomUserBuilder(34, 60)
                .addName("Alex")
                .addHobbies("Diving", "Skating")
                .build();
        users.add(user);

        user = new RandomUserBuilder()
                .addName("Alexey")
                .build();
        users.add(user);

        user = new RandomUserBuilder(34, 60)
                .addName("Masha")
                .addHobbies("Hockey", "Swimming", "Football", "Diving", "Skating")
                .build();
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
