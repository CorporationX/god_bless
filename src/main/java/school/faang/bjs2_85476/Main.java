package school.faang.bjs2_85476;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Ronald", 26, new HashSet<>(Arrays.asList("football", "chess")));
        User u2 = new User(2, "Jesse", 45, new HashSet<>(Arrays.asList("painting", "swimming")));
        User u3 = new User(3, "Anastasia", 20, new HashSet<>(Arrays.asList("programming", "dances")));

        List<User> users = Arrays.asList(u1, u2, u3);
        Set<String> activities = new HashSet<>(Arrays.asList("football", "swimming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves " + entry.getValue());
        }
    }
}
