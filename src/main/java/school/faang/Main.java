package school.faang;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Alice", 25, Set.of("reading", "gaming", "hiking"));
        User u2 = new User(2, "Bob", 30, Set.of("cooking", "swimming"));
        User u3 = new User(3, "Charlie", 22, Set.of("swimming", "cycling"));

        List<User> userList = List.of(u1, u2, u3);
        Set<String> target = Set.of("gaming", "cooking");

        Map<User, String> hobbyLovers = User.findHobbyLovers(userList, target);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.printf("%s loves: %s", entry.getKey(), entry.getValue());
        }
=======
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("До разворота: " + Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println("После разворота: " + Arrays.toString(nums));
    }
}
