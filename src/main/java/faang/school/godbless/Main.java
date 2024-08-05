package faang.school.godbless;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies1 = new HashSet<>(List.of("Reading", "Dancing", "Coding"));
        Set<String> hobbies2 = new HashSet<>(List.of("Painting", "Gaming", "Cooking"));
        Set<String> hobbies3 = new HashSet<>(List.of("Traveling", "Music", "Sports"));

        User user1 = new User(1, "Alex", 25, hobbies1);
        User user2 = new User(2, "Egor", 30, hobbies2);
        User user3 = new User(3, "Dima", 28, hobbies3);
        List<User> users = List.of(user1, user2, user3);

        Set<String> targetHobbies = new HashSet<>(List.of("Dancing", "Music", "Coding"));

        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, targetHobbies);
        for (User user : hobbyLovers.keySet()) {
            System.out.println(user + hobbyLovers.get(user));
        }
    }
}