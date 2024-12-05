package school.faang.bjs243987;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Artur", 37, 1, Set.of("Running", "Programming", "Walking", "Travelling")));
        users.add(new User("Adam", 22, 2, Set.of("Swimming", "Gaming", "Party")));
        users.add(new User("Alan", 22, 3, Set.of("Sleeping", "Fighting")));
        users.add(new User("Liuda", 30, 4, Set.of("Cooking", "Reading", "Traveling")));

        Set<String> hobbies = new HashSet<>(Set.of("Running", "Programming", "Walking", "Travelling", "Swimming",
                "Gaming", "Party", "Cycling", "Cooking", "Reading"));

        Map<User, String> findHobby = User.findHobbyLovers(users, hobbies);

        findHobby.forEach((user, hobby) -> {
            System.out.println(user.getName() + " " + hobby);
        });
    }
}