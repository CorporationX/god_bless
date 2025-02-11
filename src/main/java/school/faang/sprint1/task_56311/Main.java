package school.faang.sprint1.task_56311;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Set<String> hobbies = new HashSet<>(Arrays.asList("reading", "driving"));
        try {
            User user1 = new User(1, "Andrey", 18, new HashSet<>(Arrays.asList(
                    "reading", "driving")));
            User user2 = new User(2, "Anton", 25, new HashSet<>(Arrays.asList(
                    "swimming", "driving")));
            User user3 = new User(3, "Aleksey", 33, new HashSet<>(Arrays.asList(
                    "running", "painting")));
            User user4 = new User(4, "Alah", 44, new HashSet<>(Arrays.asList(
                    "singing", "reading")));
            users.addAll(Arrays.asList(user1, user2, user3, user4));
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake " + e.getMessage());
        }

        Map<User, String> result = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println("User " + entry.getKey().getName() + " like " + entry.getValue());
        }
    }
}
