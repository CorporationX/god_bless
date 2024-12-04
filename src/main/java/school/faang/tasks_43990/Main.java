package school.faang.tasks_43990;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Meerim", 19, Set.of("HobbyHorsing", "Quadrobing", "Funfiki")),
                new User(2, "Bagyshan", 23, Set.of("HobbyHorsing", "Quadrobing", "Funfiki")),
                new User(3, "Erik", 23, Set.of("Cybersport", "Sport"))
        );

        List<Set<String>> hobbyGroups = List.of(
                Set.of("Hypnodance", "HobbyHorsing"),
                Set.of("Quadrobing", "Cybersport"),
                Set.of("Funfiki", "Sport")
        );

        for (Set<String> hobbies : hobbyGroups) {
            System.out.println("Looking for hobbies: " + hobbies);

            Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

            hobbyLovers.forEach((user, hobby) ->
                    System.out.println("Name: " + user.getName() + ", Hobby: " + hobby)
            );
        }
    }
}