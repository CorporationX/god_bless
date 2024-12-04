package school.faang.moduleone.task_43504;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "User1", 23, Set.of("Activity1", "Activity2", "Activity3"));
        User user2 = new User(2, "User2", 24, Set.of("Activity4", "Activity5", "Activity6"));
        User user3 = new User(3, "User3", 25, Set.of("Activity7", "Activity8", "Activity9"));

        List<User> users = List.of(user1, user2, user3);

        Set<String> activities = Set.of("Activity1", "Activity5", "Activity2", "Activity10");

        System.out.println(User.findHobbyLovers(users, activities));
    }
}
