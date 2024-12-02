package school.faang.task_43949;

import school.faang.task_43949.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "Alice", 25, new HashSet<>(Arrays.asList("Running", "Swimming")));
        User user2 = new User(2L, "Bob", 30, new HashSet<>(Arrays.asList("Swimming", "Cycling")));
        User user3 = new User(3L, "Charlie", 28, new HashSet<>(Arrays.asList("Running", "Chess")));
        User user4 = new User(4L, "Diana", 22, new HashSet<>(Arrays.asList("Chess", "Yoga")));

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Set<String> activities = new HashSet<>(Arrays.asList("Running", "Chess"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        System.out.println("Users who share the hobbies:");
        hobbyLovers.forEach((user, activity) ->
                System.out.println("User: " + user.getName() + ", Activity: " + activity));
    }
}