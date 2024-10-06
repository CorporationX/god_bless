package school.faang.main_code_collect_users;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Arrays.asList("Reading", "Swimming"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("Running", "Swimming"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("Fishing", "Cooking"));
        Set<String> activities4 = new HashSet<>(Arrays.asList("Reading", "Fishing"));

        User user1 = new User("Alice", 1, 25, activities1);
        User user2 = new User("Bob", 2, 30, activities2);
        User user3 = new User("Charlie", 3, 35, activities3);
        User user4 = new User("Diana", 4, 28, activities4);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Set<String> searchActivities = new HashSet<>(Arrays.asList("Reading", "Swimming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, searchActivities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}