package faang.school.godbless.done.collectusers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Set<String> activities = new LinkedHashSet<>(Arrays.asList("hockey", "football", "skiing", "baseball", "basketball"));

        users.add(new User(1, "Jack", 23, new HashSet<>(Arrays.asList("valleyball", "baseball"))));
        users.add(new User(1, "John", 33, new HashSet<>(Arrays.asList("football", "baseball"))));
        users.add(new User(1, "Black", 42, new HashSet<>(Arrays.asList("baseball", "hockey"))));
        users.add(new User(1, "Invoker", 38, new HashSet<>(Arrays.asList("jumping", "hockey"))));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry hobbyLover : hobbyLovers.entrySet()) {
            User username = (User) hobbyLover.getKey();
            System.out.println(username.getName() + ": " + hobbyLover.getValue() + ";");
        }
    }
}
