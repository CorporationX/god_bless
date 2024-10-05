package school.faang.colect_users_BJS2_31603;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice Johnson", 28
                , new HashSet<>(Set.of("Running", "Reading", "Traveling", "Painting")));
        User user2 = new User(2, "Bob Smith", 35, new HashSet<>(Set.of("Cycling", "Running")));
        User user3 = new User(3, "Charlie Brown", 22, new HashSet<>());
        User user4 = new User(4, "Diana Wilson", 30
                , new HashSet<>(Set.of("Yoga", "Programming", "Painting", "Cycling", "Music")));

        Set<String> activities = new HashSet<>(Set.of("Running", "Traveling", "Gaming", "Cycling", "Music"));
        List<User> users = new ArrayList<>(List.of(user1, user2, user3, user4));

        user1.printHobbyLovers(user1.findHobbyLovers(users, activities));
    }
}
