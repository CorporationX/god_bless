package faang.school.godbless;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");
        List<User> users = new ArrayList<>();
        Set<String> activity1 = Set.of("Drawing", "Dancing", "Music", "Sport");
        User user1 = new User("Ivan", 14, activity1);
        Set<String> activity2 = Set.of("Dancing", "Music", "Drawing", "Sport");
        User user2 = new User("Sergey", 20, activity2);
        Set<String> activity3 = Set.of("Sport", "Drawing", "Dancing", "Music");
        User user3 = new User("Artem", 35, activity3);
        Set<String> activity4 = Set.of("Learning foreign languages", "Blogging");
        User user4 = new User("Mathew", 23, activity4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<User, String> spisUser = User.findHobbyLovers(users, activity2);
    }
}
