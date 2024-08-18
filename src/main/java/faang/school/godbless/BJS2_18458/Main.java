package faang.school.godbless.BJS2_18458;

import java.util.*;

public class Main {
        public static void main(String[] args) {

            List<User> users = Arrays.asList(
                    new User(1, "Suragan", 30, new HashSet<>(Arrays.asList("Reading", "Swimming", "Coding"))),
                    new User(2, "Aziza", 25, new HashSet<>(Arrays.asList("Cycling", "Coding", "Cooking"))),
                    new User(3, "Rinat", 35, new HashSet<>(Arrays.asList("Reading", "Gaming", "Cooking"))),
                    new User(4, "Arman", 28, new HashSet<>(Arrays.asList("Dancing", "Swimming", "Hiking")))
            );

            Set<String> targetHobbies = new HashSet<>(Arrays.asList("Coding", "Swimming"));

            Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetHobbies);

            hobbyLovers.forEach((user, hobby) ->
                    System.out.println("User: " + user.getName() + " loves " + hobby)
            );
        }
}
