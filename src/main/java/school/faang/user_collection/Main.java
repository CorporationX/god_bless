package school.faang.user_collection;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {
        User user1 = new User(1, "user1", 25, Set.of("A", "B"));
        User user2 = new User(2, "user2", 30, Set.of("E", "D"));
        User user3 = new User(3, "user3", 3, Set.of("F"));

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> targetActivities = Set.of("A", "D", "E");

        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, targetActivities);
        log.info("Найденные любители активностей:");
        hobbyLovers.forEach((user, activity) ->
                log.info("{} (возраст {}) - активность: {}",
                        user.getName(), user.getAge(), activity));


        if (hobbyLovers.containsKey(user1) && hobbyLovers.get(user1).equals("A")) {
            log.info("user1 найден с активностью 'A'");
        } else {
            log.error("ОШИБКА user1");
        }

        if (hobbyLovers.containsKey(user2)
                && hobbyLovers.get(user2).equals("D")
                || hobbyLovers.get(user2).equals("E")) {
            log.info("user2 найден с активностью 'D' или 'E'");
        } else {
            log.error("ОШИБКА user2");
        }

        if (!hobbyLovers.containsKey(user3)) {
            log.info("user3 не найден");
        } else {
            log.error("ОШИБКА user3");
        }
    }
}
