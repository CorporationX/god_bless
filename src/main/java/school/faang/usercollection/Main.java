package school.faang.usercollection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User(1, "Andrey", 44, new HashSet<>(List.of("coding", "work"))),
            new User(2, "Timon", 24, new HashSet<>(List.of("coding", "work", "eat"))),
            new User(3, "Boris", 40, new HashSet<>(List.of("drink", "work"))),
            new User(4, "Fedor", 34, new HashSet<>(List.of("wolk", "work", "travel"))));
        Set<String> hobbies = new HashSet(List.of("eat", "travel"));
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }

    }
}
