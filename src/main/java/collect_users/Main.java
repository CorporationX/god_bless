package collect_users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vlad", 25, new HashSet<>(List.of("reading", "programming"))));
        users.add(new User(2, "Kolya", 30, new HashSet<>(List.of("painting", "gaming"))));
        users.add(new User(3, "Vitalik", 22, new HashSet<>(List.of("swimming", "cooking"))));
        users.add(new User(4, "Natasha", 28, new HashSet<>(List.of("reading", "gaming"))));

        Set<String> activities = new HashSet<>(List.of("gaming", "programming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        printResult(hobbyLovers);
    }

    private static void printResult(Map<User, String> hobbyLovers) {
        for (var entry : hobbyLovers.entrySet()) {
            User user = entry.getKey();
            String hobby = entry.getValue();
            System.out.println(user.getName() + " loves " + hobby);
        }
    }
}
