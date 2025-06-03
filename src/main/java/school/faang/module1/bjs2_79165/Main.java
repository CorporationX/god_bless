package school.faang.module1.bjs2_79165;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Alexey", 30, Set.of("Reading", "Swimming", "Running")),
                new User(2, "Dmitry", 20, Set.of("Gaming", "Swimming")),
                new User(3, "Alana", 22, Set.of("Cooking", "Reading")),
                new User(4, "Ivan", 30, Set.of("Soccer", "Running")),
                new User(5, "Aslan", 23, Set.of("Photography", "Traveling", "Soccer"))
        );
        Set<String> targetHobbies = Set.of("Running", "Reading", "Traveling");
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetHobbies);
        hobbyLovers.forEach((user, hobby) ->
                System.out.println(user + " - first matched hobby: " + hobby)
        );
    }
}
