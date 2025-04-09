package school.faang.bjs2_68069;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<String> activities = Set.of("Yoga", "Fishing", "Cooking", "Baking");
        Set<String> activities2 = Set.of("Fishing", "Swimming");
        Set<String> activities3 = Set.of("Hunting", "Cycling");

        User user = new User(1, "Olga", 29, activities);
        User user2 = new User(2, "Alex", 56, activities2);
        User user3 = new User(3, "Monika", 20, activities3);

        List<User> users = List.of(user, user2, user3);
        Set<String> mainActivities = Set.of("Yoga", "Hunting", "Singing");

        User.findHobbyLovers(users, mainActivities).forEach((key, activity) -> log.info("{} - {}", key, activity));
    }
}
