package faang.school.godbless.user_collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities = Set.of("eat", "sleep", "kite surfing");

        List<User> users = Arrays.asList(
                new User(1, "Tom", 15, Set.of("yoga", "run")),
                new User(2, "Jon", 11, Set.of("velo", "kite surfing")),
                new User(3, "Ann", 23, Set.of("travel", "moto")),
                new User(4, "Liza", 12, Set.of("eat", "PC games")),
                new User(5, "Pol", 17, Set.of("board game", "PC games"))
        );

        Map<User, String> usersActivities = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> en : usersActivities.entrySet()) {
            System.out.println("User " + en.getKey().getName() + " has activity " + en.getValue());
        }
    }
}
