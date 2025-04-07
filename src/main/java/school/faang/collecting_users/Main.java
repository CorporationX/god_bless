package school.faang.collecting_users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.collecting_users.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {

        Set<String> hobbies1 = Set.of("reading", "swimming", "cycling");
        Set<String> hobbies2 = Set.of("painting", "swimming");
        Set<String> hobbies3 = Set.of("coding", "traveling");

        User user1 = new User(1, "Alice", 25, hobbies1);
        User user2 = new User(2, "Bob", 30, hobbies2);
        User user3 = new User(3, "Charlie", 22, hobbies3);

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> activities = new HashSet<>(Arrays.asList("swimming", "coding"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " is interested in " + entry.getValue());
        }
    }
}