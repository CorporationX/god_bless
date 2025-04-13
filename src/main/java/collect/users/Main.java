package collect.users;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final User user = new User(1, "Dan", 25, Set.of("Football", "Gamming", "Movies"));
        final User user1 = new User(2, "Anatolii", 35, Set.of("Gym", "Fishing", "Movies"));
        final User user2 = new User(3, "Vasiok", 26, Set.of("Fishing", "Sport"));
        final User user3 = new User(4, "Richard", 45, Set.of("Gambling", "Procrastination"));

        final Set<String> hobbies = Set.of("Football", "Gym", "Fishing");
        final List<User> users = List.of(user, user1, user2, user3);

        for (Map.Entry<User, String> userStringEntry : User.findHobbyLovers(users, hobbies).entrySet()) {
            System.out.printf("User: %s likes to prsctice %s %n", userStringEntry.getKey().getName(),
                    userStringEntry.getValue());
        }
    }
}
