package faang.school.godbless.javacore.collectusers;

import java.util.*;

public class CollectUsersApp {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Cycling", "Chess"))),
                new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Hiking", "Chess", "Running"))),
                new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("Swimming", "Running", "Photography"))),
                new User(4, "David", 40, new HashSet<>(Arrays.asList("Cooking", "Photography", "Painting"))),
                new User(5, "Eva", 22, new HashSet<>(Arrays.asList("Gaming", "Painting", "Hiking"))),
                new User(6, "Frank", 28, new HashSet<>(Arrays.asList("Reading", "Hiking", "Swimming"))),
                new User(7, "Grace", 31, new HashSet<>(Arrays.asList("Chess", "Swimming", "Cooking"))),
                new User(8, "Hannah", 26, new HashSet<>(Arrays.asList("Running", "Cooking", "Gaming"))),
                new User(9, "Ivan", 33, new HashSet<>(Arrays.asList("Photography", "Gaming", "Reading"))),
                new User(10, "Julia", 29, new HashSet<>(Arrays.asList("Painting", "Reading", "Cycling")))
        );
        Set<String> activities = Set.of("Gaming", "Swimming", "Cooking");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);
        System.out.println(activities);
        hobbyLovers.forEach((user, activity) -> System.out.printf("User = %s\nActivity = %s\n\n", user.toString(), activity));
    }

}
