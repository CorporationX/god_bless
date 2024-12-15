package school.faang.task_44090;

import java.util.*;

import static school.faang.task_44090.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Alice", 25, new HashSet<>(Arrays.asList("reading", "swimming", "coding")));
        User user2 = new User(2L, "Bob", 30, new HashSet<>(Arrays.asList("cycling", "hiking", "painting")));
        User user3 = new User(3L, "Charlie", 22, new HashSet<>(Arrays.asList("gaming", "coding", "dancing")));
        User user4 = new User(4L, "Diana", 28, new HashSet<>(Arrays.asList("swimming", "yoga", "photography")));

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Set<String> targetHobbies = new HashSet<>(Arrays.asList("coding", "swimming", "gaming"));


        Map<User, String> hobbyLovers = findHobbyLovers(users, targetHobbies);

        // Вывод результатов
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves " + entry.getValue());
        }
    }
}
