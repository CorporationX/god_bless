package faang.school.godbless;

import faang.school.godbless.david.User;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Arrays.asList("music", "sport"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("game", "art"));
        User user1 = new User(1, "Bob", 25, activities1);
        User user2 = new User(2, "Diana", 29, activities2);

        List<User> users = Arrays.asList(user1, user2);

        Set<String> activities = new HashSet<>(Arrays.asList("music", "sport"));

        Map<User, String> hobby = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobby.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}