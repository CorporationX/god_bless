package school.faang.usercollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Misha", 18, Set.of("Chess", "Football", "Skating", "Shopping"));
        User user2 = new User("Oleg", 19, Set.of("Football", "Reading", "Travelling", "Shopping"));
        User user3 = new User("Dima", 20, Set.of("Shopping", "Games", "Singing"));

        List<User> users = List.of(user1, user2, user3);
        Set<String> hobbies = Set.of("Reading", "Shopping");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " enjoys " + entry.getValue());
        }
    }
}
