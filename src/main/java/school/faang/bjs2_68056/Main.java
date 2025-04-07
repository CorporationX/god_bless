package school.faang.bjs2_68056;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<String> activities1 = Set.of("Reading", "Swimming");
        Set<String> activities2 = Set.of("Cycling", "Swimming");
        Set<String> activities3 = Set.of("Singing", "Cycling");
        Set<String> activities4 = Collections.emptySet();

        User user1 = new User(1, "Alice", 25, activities1);
        User user2 = new User(2, "Bob", 30, activities2);
        User user3 = new User(3, "Charlie", 35, activities3);
        User user4 = new User(4, "Ann", 33, activities4);

        List<User> users = List.of(user1, user2, user3, user4);
        Set<String> searchedActivities = Set.of("Reading", "Swimming");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, searchedActivities);
        hobbyLovers.forEach((user, activity) -> log.info("{} loves {}", user, activity));
    }
}
