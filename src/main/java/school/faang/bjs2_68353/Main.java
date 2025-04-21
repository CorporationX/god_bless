package school.faang.bjs2_68353;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class Main {
    public static void main(String [] args) {
        List<User> users = Arrays.asList(
                new User(
                        UUID.randomUUID(),
                        "Михаил",
                        28,
                        new HashSet<>(Set.of("Reading", "Review"))
                ),
                new User(
                        UUID.randomUUID(),
                        "Андрей",
                        33,
                        new HashSet<>(Set.of("Basketball", "Bulling", "Swimming"))
                ),
                new User(
                        UUID.randomUUID(),
                        "Виктория",
                        22,
                        new HashSet<>(Set.of("Review", "Basketball"))
                )
        );
        Set<String> activities = Set.of("Reading", "Review", "Basketball", "Bulling", "Swimming", "NotListedHobby");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);
        hobbyLovers.forEach((user, hobby) -> log.info("Пользователь {} предпочитает {}", user.name(), hobby));
    }
}