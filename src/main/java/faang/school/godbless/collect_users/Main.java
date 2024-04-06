package faang.school.godbless.collect_users;

import java.util.*;

import static faang.school.godbless.collect_users.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = new HashSet<>();
        hobbies.add("Guitar");
        hobbies.add("Piano");

        User user1 = new User(1, "Tom", 25, new HashSet<>(Arrays.asList("Guitar", "Horror")));
        User user2 = new User(2, "Brad", 30, new HashSet<>(Arrays.asList("Swim", "Dance")));
        User user3 = new User(3, "Ann", 22, new HashSet<>(Arrays.asList("Piano", "Draw")));

        List<User> users = Arrays.asList(user1, user2, user3);

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " likes " + entry.getValue());
        }
    }
}
