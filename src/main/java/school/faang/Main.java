package school.faang;

import school.faang.user.User;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Football", "Chess", "Reading"))),
                new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Gaming", "Cooking"))),
                new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("Football", "Swimming"))),
                new User(4, "David", 28, new HashSet<>(Arrays.asList("Painting", "Reading")))
        );
        Set<String> activities = new HashSet<>(Arrays.asList("Reading", "Gaming"));

        Map<User, String> result = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }
}