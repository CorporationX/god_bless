package school.faang.collectingusers;

import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> users = initUsers();
        Set<String> activities = initActivities();
        Map<Long, String> hobbyLoversUsers = User.findHobbyLovers(users, activities);
        System.out.println(hobbyLoversUsers);
    }

    public static Set<User> initUsers() {
        return Set.of(new User(234L, "User1", 26, Set.of("sport")),
                new User(235L, "User2", 26, Set.of("sport", "musica")),
                new User(236L, "User2", 26, Set.of("travaling")),
                new User(237L, "User2", 26, Set.of("cooking", "dancing"))
        );
    }

    public static Set<String> initActivities() {
        return Set.of("reading", "sport", "cooking", "dancing");
    }
}
