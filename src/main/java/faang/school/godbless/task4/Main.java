package faang.school.godbless.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User(1, "Max", 26, Set.of("tenis", "voleball"));

        users.add(new User(1, "Dima", 23, Set.of("voleball", "football")));
        users.add(new User(1, "Danya", 21, Set.of("hockey")));
        users.add(new User(1, "German", 23, Set.of("tenis", "voleball")));
        users.add(new User(1, "Oleg", 23, Set.of("tenis", "football")));

        Map<User, String> hobbyLovers = user.findHobbyLovers(users, Set.of("tenis", "football"));
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}
