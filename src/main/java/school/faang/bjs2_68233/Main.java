package school.faang.bjs2_68233;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_68233.model.User;

import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(0, "Vladislav", 28, Set.of("tennis", "computer", "programming")),
                new User(1, "Anton", 54, Set.of("cooking")),
                new User(2, "Valentina", 19, Set.of("cooking", "programming")),
                new User(3, "Maria", 26, Set.of("beauty"))
        );

        log.info("Hobby lovers users - {}", User.findHobbyLovers(users, Set.of("programming", "cooking")));
    }
}