package faang.school.godbless.alexbulgakoff.javacore.collectusers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {

        Set<String> activityUser1 = Set.of("guitar", "football", "programming");
        Set<String> activityUser2 = Set.of("drawing", "skateboarding", "singing");
        Set<String> activityUser3 = Set.of("swimming", "running", "wrestling");
        Set<String> activityUser4 = Set.of("drawing");
        Set<String> activityUser5 = Set.of("wrestling");

        User user1 = new User(1L, "John", 23, activityUser1);
        User user2 = new User(2L, "Amanda", 18, activityUser2);
        User user3 = new User(3L, "Bob", 26, activityUser3);
        User user4 = new User(4L, "Alex", 28, activityUser4);
        User user5 = new User(5L, "Den", 31, activityUser5);

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        Set<String> activities =
                Set.of("programming", "swimming", "guitar", "drawing", "singing");

        System.out.println(User.findHobbyLovers(users, activities));
    }
}
