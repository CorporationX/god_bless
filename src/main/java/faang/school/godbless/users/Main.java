package faang.school.godbless.users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities = new HashSet<>(Arrays.asList("eat", "sleep", "kite surfing"));

        List<User> users = Arrays.asList(
                new User(1, "Tom", 15, new HashSet<>(Arrays.asList("yoga", "run"))),
                new User(2, "Jon", 11, new HashSet<>(Arrays.asList("velo", "kite surfing"))),
                new User(3, "Ann", 23, new HashSet<>(Arrays.asList("travel", "moto"))),
                new User(4, "Liza", 12, new HashSet<>(Arrays.asList("eat", "PC games"))),
                new User(5, "Pol", 17, new HashSet<>(Arrays.asList("board game", "PC games")))
        );

        Map<User, String> usersActivity = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> en : usersActivity.entrySet()) {
            System.out.println("User " + en.getKey().getName() + " has activity " + en.getValue());
        }
    }
}
