package school.faang.bjs2_68055;

import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User(1, "Miras", 25, Set.of("reading", "running", "yoga")),
                new User(2, "Ivan", 30, Set.of("chess", "yoga")),
                new User(3, "Max", 22, Set.of("painting", "swimming")));
        Set<String> hobbies = Set.of("yoga", "swimming");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves: " + entry.getValue());
        }
    }
}