package school.faang.bjs268064;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        User userArtur = new User("Artur", 37, Set.of("Programming", "Gaming", "Reading"));
        User userJakub = new User("Jakub", 32, Set.of("Programming", "Watching Movies", "Reading"));
        User userMichal = new User("Michal", 30, Set.of("Cooking", "Running", "Reading"));
        User userKamil = new User("Kamil", 35, Set.of("Diving", "Gaming"));

        List<User> users = List.of(userArtur, userJakub, userMichal, userKamil);

        Set<String> hobbies = Set.of("Programming", "Reading");

        Map<User, String> result = User.findHobbyLovers(users, hobbies);

        for (var entry : result.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}
